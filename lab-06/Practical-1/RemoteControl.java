interface Switchable {

    void on();

    void off();

    boolean isOn();

    default void toggle() {
        if (isOn()) {
            off();
        } else {
            on();
        }
    }
}

class Fan implements Switchable {

    private boolean status = false;

    @Override
    public void on() {
        status = true;
        System.out.println("Fan is ON.");
    }

    @Override
    public void off() {
        status = false;
        System.out.println("Fan is OFF.");
    }

    @Override
    public boolean isOn() {
        return status;
    }
}

class Light implements Switchable {

    private boolean status = false;

    @Override
    public void on() {
        status = true;
        System.out.println("Light is ON.");
    }

    @Override
    public void off() {
        status = false;
        System.out.println("Light is OFF.");
    }

    @Override
    public boolean isOn() {
        return status;
    }
}

@FunctionalInterface
interface DevicePermission {

    boolean canSwitchOn(Switchable device, int hour);
}

public class RemoteControl {

    public static void main(String[] args) {

        Switchable[] devices = {
            new Fan(),
            new Light()
        };

        System.out.println("===== REMOTE CONTROL SYSTEM =====");

        for (Switchable device : devices) {
            device.toggle();
        }

        System.out.println("\nToggling devices again:");

        for (Switchable device : devices) {
            device.toggle();
        }

        System.out.println("\n===== DEVICE PERMISSION (ANONYMOUS CLASS) =====");

        DevicePermission permission = new DevicePermission() {

            @Override
            public boolean canSwitchOn(Switchable device, int hour) {

                if (device instanceof Fan) {
                    return hour >= 6 && hour <= 10;
                }

                if (device instanceof Light) {
                    return hour >= 18 && hour <= 22;
                }

                return false;
            }
        };

        Fan fan = new Fan();
        Light light = new Light();

        System.out.println("Fan at 8 AM: " +
                permission.canSwitchOn(fan, 8));

        System.out.println("Fan at 2 PM: " +
                permission.canSwitchOn(fan, 14));

        System.out.println("Light at 8 PM: " +
                permission.canSwitchOn(light, 20));

        System.out.println("\n===== DEVICE PERMISSION (LAMBDA EXPRESSION) =====");

        DevicePermission lambdaPermission = (device, hour) -> {

            if (device instanceof Fan) {
                return hour >= 6 && hour <= 10;
            }

            if (device instanceof Light) {
                return hour >= 18 && hour <= 22;
            }

            return false;
        };

        System.out.println("Fan at 8 AM: " +
                lambdaPermission.canSwitchOn(fan, 8));

        System.out.println("Fan at 2 PM: " +
                lambdaPermission.canSwitchOn(fan, 14));

        System.out.println("Light at 8 PM: " +
                lambdaPermission.canSwitchOn(light, 20));
                
    }
}