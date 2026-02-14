package config;

public class Session {
    private static Session instance;

    private int id;
    private String name;
    private String email;
    private String role;
    private String status;

    private Session() {}

    
    
    
    public static Session getInstance() {
        if (instance == null) {
            instance = new Session();
        }
        return instance;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getRole() { return role; }
    public String getStatus() { return status; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setRole(String role) { this.role = role; }
    public void setStatus(String status) { this.status = status; }

    public void clearSession() {
        id = 0;
        name = null;
        email = null;
        role = null;
        status = null;
    }
}