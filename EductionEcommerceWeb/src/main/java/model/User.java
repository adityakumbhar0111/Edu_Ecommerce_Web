package model;

public class User {
    private int id;
    private String email;
    private String passwordHash;
    private String fullname;

    public User() {}
    public User(int id, String email, String passwordHash, String fullname) {
        this.id = id; this.email = email; this.passwordHash = passwordHash; this.fullname = fullname;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPasswordHash() { return passwordHash; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public String getFullname() { return fullname; }
    public void setFullname(String fullname) { this.fullname = fullname; }
}
