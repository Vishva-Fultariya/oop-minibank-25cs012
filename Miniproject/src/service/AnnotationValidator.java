
package service;

import java.lang.reflect.Field;
import java.util.ArrayList;

import model.annotation.Positive;
import model.annotation.MaxLength;

public class AnnotationValidator {

    public static String[] validate(Object obj) {

        ArrayList<String> errors = new ArrayList<>();

        if (obj == null) {
            errors.add("Object must not be null.");
            return errors.toArray(new String[0]);
        }

        // Start with the object's class.
        Class<?> currentClass = obj.getClass();

        // Also inspect parent classes to validate inherited fields.
        while (currentClass != null && currentClass != Object.class) {

            Field[] fields = currentClass.getDeclaredFields();

            for (Field field : fields) {

                field.setAccessible(true);

                try {

                    Object value = field.get(obj);

                    // Check @Positive annotation
                    if (field.isAnnotationPresent(Positive.class)) {

                        Positive positive =
                                field.getAnnotation(Positive.class);

                        if (!(value instanceof Number)
                                || ((Number) value).doubleValue() <= 0) {

                            errors.add(
                                field.getName() + " "
                                + positive.message()
                            );
                        }
                    }

                    // Check @MaxLength annotation
                    if (field.isAnnotationPresent(MaxLength.class)) {

                        MaxLength maxLength =
                                field.getAnnotation(MaxLength.class);

                        if (value instanceof String) {

                            String text = (String) value;

                            if (text.length() > maxLength.value()) {

                                errors.add(
                                    field.getName()
                                    + " must not exceed "
                                    + maxLength.value()
                                    + " characters."
                                );
                            }
                        }
                    }

                } catch (IllegalAccessException e) {

                    errors.add(
                        "Unable to access field: " + field.getName()
                    );
                }
            }

            // Move to the parent class.
            currentClass = currentClass.getSuperclass();
        }

        return errors.toArray(new String[0]);
    }
}
