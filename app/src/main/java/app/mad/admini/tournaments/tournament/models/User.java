package app.mad.admini.tournaments.tournament.models;

public class User {

    private int UserId;
    private String Username;
    private String email;
    private String country;
    private String password;

    public User(int userId, String username, String email, String country, String password) {
        UserId = userId;
        Username = username;
        this.email = email;
        this.country = country;
        this.password = password;
    }

    public User(String username, String email, String country, String password) {
        Username = username;
        this.email = email;
        this.country = country;
        this.password = password;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserId(int userId) {
        UserId = userId;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
