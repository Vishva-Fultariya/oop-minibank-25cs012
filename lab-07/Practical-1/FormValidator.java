
import java.lang.reflect.Field;
import java.util.ArrayList;

public class FormValidator {

    public static ArrayList<String> validate(Object obj) {

        ArrayList<String> errors = new ArrayList<>();

        Field[] fields = obj.getClass().getDeclaredFields();

        for (Field field : fields) {

            field.setAccessible(true);

            try {

                Object value = field.get(obj);

                if (field.isAnnotationPresent(NotBlank.class)) {

                    if (value == null || value.toString().isBlank()) {

                        errors.add(field.getName() + " must not be blank.");
                    }
                }

                if (field.isAnnotationPresent(MaxLength.class)) {

                    MaxLength annotation =
                            field.getAnnotation(MaxLength.class);

                    if (value != null &&
                            value.toString().length() > annotation.value()) {

                        errors.add(field.getName()
                                + " must not exceed "
                                + annotation.value()
                                + " characters.");
                    }
                }

            } catch (IllegalAccessException e) {

                errors.add("Unable to access field: " + field.getName());
            }
        }

        return errors;
    }
}
