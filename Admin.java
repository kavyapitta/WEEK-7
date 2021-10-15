import java.util.Scanner;

public class Admin extends User {

    ObjectFactory factory;

    public Admin(String name, String username, String password) {
        super(name, username, password);

        factory = new UserFactory();
    }

    @Override
    public void handler(Scanner scanner) {
        while(true) {
            System.out.println();
            System.out.println("1. Add Sensor");
            System.out.println("2. Add Camera");
            System.out.println("3. Add Authorized User");
            System.out.println("4. Add Home Owner");
            System.out.println("5. Add Admin");
            System.out.println("6. Exit");
            System.out.println();

            boolean EXIT_FLAG = false;
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    addSensor(scanner);
                    break;
                case 2:
                    addCamera(scanner);
                    break;
                case 3:
                    addAuthorizedUser(scanner);
                    break;
                case 4:
                    addOwner(scanner);
                    break;
                case 5:
                    addAdmin(scanner);
                    break;
                case 6:
                    EXIT_FLAG = true;
                    break;
                default:
                    System.out.println("[Info] Invalid Choice!!");
                    break;
            }

            if(EXIT_FLAG) break;
        }
    }

    private String[] userInput(Scanner scanner) {
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("Enter Username : ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.println();
        String[] args = new String[3];
        args[0] = name; args[0] = username; args[0] = password;
        return args;
    }

    private void addAdmin(Scanner scanner) {
        String[] args = userInput(scanner);
        User admin = (User) factory.getObject("admin",args);
        if ( DataBase.getInstance().addAdmin(admin) ) {
            System.out.println("[SUCCESS] Admin Added !!");
        } else {
            System.out.println("[FAILED] Admin not Added !!");
        }
    }

    private void addOwner(Scanner scanner) {
        String[] args = userInput(scanner);
        User admin = (User) factory.getObject("owner",args);
        if ( DataBase.getInstance().addOwner(admin) ) {
            System.out.println("[SUCCESS] Owner Added !!");
        } else {
            System.out.println("[FAILED] Owner not Added !!");
        }
    }

    private void addAuthorizedUser(Scanner scanner) {
        String[] args = userInput(scanner);
        User user = (User) factory.getObject("users",args);
        if ( DataBase.getInstance().addUsers(user) ) {
            System.out.println("[SUCCESS] User Added !!");
        } else {
            System.out.println("[FAILED] Owner not Added !!");
        }
    }

    private void addCamera(Scanner scanner) {
    }

    private void addSensor(Scanner scanner) {
    }
}