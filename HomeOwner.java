import java.util.Scanner;

public class HomeOwner extends User {

    public HomeOwner(String name, String username, String password) {
        super(name, username, password);
    }

    @Override
    public void handler(Scanner scanner) {
        while(true) {
            System.out .println();
            System.out.println("1. Display camera");
            System.out.println("2. Status camera");
            System.out.println("3. Status sensor");
            System.out.println("4. Replay camera");
            System.out.println("5. activate or deactivate camera");
            System.out.println("6. activate or deactivate sensor");
            System.out.println("7. Exit");
            System.out.println();

            boolean EXIT_FLAG = false;
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    display(scanner);
                    break;
                case 2:
                    statusCamera(scanner);
                    break;
                case 3:
                    statusSensor(scanner);
                    break;
                case 4:
                    replayCamera(scanner);
                    break;
                case 5:
                    changeStatusCamera(scanner);
                    break;
                case 6:
                    changeStatusSensor(scanner);
                    break;
                case 7:
                    EXIT_FLAG = true;
                    break;
                default:
                    System.out.println("[Info] Invalid Choice!!");
                    break;
            }

            if(EXIT_FLAG) break;
        }
    }

    private void changeStatusSensor(Scanner scanner) {
        // change status of given sensor
    }

    private void changeStatusCamera(Scanner scanner) {
        // change status of given camera
    }

    private void statusSensor(Scanner scanner) {
        // show status of all sensors
    }

    private void statusCamera(Scanner scanner) {
        // Show status of all cameras
    }

    private void replayCamera(Scanner scanner) {
        // Select recorded images or videos to play
    }

    private void display(Scanner scanner) {
        // Select camera to render
    }

}
