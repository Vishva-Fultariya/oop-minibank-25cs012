
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ColumnMapper {

    public static ArrayList<String> populate(
            Object obj, String headerRow, String dataRow) {

        ArrayList<String> warnings = new ArrayList<>();

        String[] headers = headerRow.split(",", -1);
        String[] values = dataRow.split(",", -1);

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            if (field.isAnnotationPresent(Column.class)) {

                Column column = field.getAnnotation(Column.class);
                String columnName = column.name();

                int columnIndex = -1;

                for (int i = 0; i < headers.length; i++) {
                    if (headers[i].trim().equals(columnName)) {
                        columnIndex = i;
                        break;
                    }
                }

                if (columnIndex == -1) {
                    warnings.add("Missing column: " + columnName);
                    continue;
                }

                if (columnIndex >= values.length) {
                    warnings.add("Missing data for column: " + columnName);
                    continue;
                }

                try {
                    field.setAccessible(true);

                    String value = values[columnIndex].trim();

                    if (field.getType() == String.class) {
                        field.set(obj, value);
                    } 
                    else if (field.getType() == int.class) {
                        field.setInt(obj, Integer.parseInt(value));
                    }

                } catch (Exception e) {
                    warnings.add("Invalid value for column: " + columnName);
                }
            }
        }

        return warnings;
    }
}
