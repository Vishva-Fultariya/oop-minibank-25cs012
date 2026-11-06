
import java.lang.reflect.Method;

public class MiniTestRunner {

    public static void runTests(Object obj) {

        int count = 0;

        Method[] methods = obj.getClass().getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(Run.class)) {

                try {

                    method.invoke(obj);

                    count++;

                } catch (Exception e) {

                    System.out.println("Test execution failed: "
                            + method.getName());
                }
            }
        }

        System.out.println("\nTotal tests executed: " + count);
    }
}
