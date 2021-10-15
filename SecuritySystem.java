import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class SecuritySystem {

    private ProducerManager producerManager;
    private DataBase database;

    public SecuritySystem() {
        this.database = DataBase.getInstance();
        this.producerManager = new ProducerManager();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=========== System =============");
            System.out.println();
            System.out.print("Enter Username : ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            System.out.println();
            User user = login(username, password);
            if(user == null) {
                System.out.println("[Error] You are not authorized");
                unauthorizedAccessDetect();
            } else {
                user.handler(scanner);
            }
            System.out.println();
            System.out.println("================================");
        }
    }

    private void unauthorizedAccessDetect() {
    }

    private User login(String username, String password) {

        // Check For Admins
        User user = this.database.getAdmin(username, password);
        if(user != null) return user;

        // Check for owners
        user = this.database.getOwner(username, password);
        if(user != null) return user;

        // Check for access users
        user = this.database.getUser(username, password);
        return user;
    }
}
