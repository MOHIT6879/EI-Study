class DatabaseConnection {
    private static DatabaseConnection instance;

    private DatabaseConnection() {
        // Private constructor to prevent instantiation
    }

    public static DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void connect() {
        System.out.println("Connected to database.");
    }
}

// Usage
public class SingletonPatternExample {
    public static void main(String[] args) {
        DatabaseConnection dbConnection1 = DatabaseConnection.getInstance();
        dbConnection1.connect(); // Connected to database

        DatabaseConnection dbConnection2 = DatabaseConnection.getInstance();
        System.out.println(dbConnection1 == dbConnection2); // True, same instance
    }
}
