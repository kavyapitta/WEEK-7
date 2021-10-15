import java.util.ArrayList;
import java.util.List;

public class DataBase {

    private static DataBase database;

    private List<User> admins;
    private List<User> owners;
    private List<User> users;

    private List<Camera> cameras;
    private List<Sensor> sensors;

    private DataBase() {
        admins = new ArrayList<>();
        owners = new ArrayList<>();
        users = new ArrayList<>();
        cameras = new ArrayList<>();
        sensors = new ArrayList<>();

        User admin = new Admin("Admin");
        admin.setUsername("admin");
        admin.setPassword("admin");
    }

    public static DataBase getInstance() {
        if(database == null) {
            synchronized (DataBase.class) {
                if(database == null) {
                    database = new DataBase();
                }
            }
        }
        return database;
    }

    public boolean addOwner(User owner) {
        return owners.add(owner);
    }

    public boolean addUsers(User user) {
        return users.add(user);
    }

    public boolean addCamera(Camera camera) {
        return cameras.add(camera);
    }

    public boolean addSensor(Sensor sensor) {
        return sensors.add(sensor);
    }

    public boolean removeOwner(User owner) {
        return owners.remove(owner);
    }

    public boolean removeUsers(User user) {
        return users.remove(user);
    }

    public boolean removeCamera(Camera camera) {
        return cameras.remove(camera);
    }

    public boolean removeSensor(Sensor sensor) {
        return sensors.remove(sensor);
    }

    public boolean addAdmin(User admin) {
        return admins.add(admin);
    }

    public boolean removeAdmin(User admin) {
        return admins.remove(admin);
    }

    public User getAdmin(String username, String password) {
        for(User user: admins) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getOwner(String username, String password) {
        for(User user: owners) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String username, String password) {
        for(User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
