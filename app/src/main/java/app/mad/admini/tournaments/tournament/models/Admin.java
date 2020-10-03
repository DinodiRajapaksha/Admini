package app.mad.admini.tournaments.tournament.models;

public class Admin {

    private int AdminId;
    private String AdminUsername;
    private String AdminPassword;


    public Admin() {
    }

    public Admin(int adminId, String adminUsername, String adminPassword) {
        AdminId = adminId;
        AdminUsername = adminUsername;
        AdminPassword = adminPassword;
    }

    public Admin(String adminUsername, String adminPassword) {
        AdminUsername = adminUsername;
        AdminPassword = adminPassword;
    }

    public int getAdminId() {
        return AdminId;
    }

    public void setAdminId(int adminId) {
        AdminId = adminId;
    }

    public String getAdminUsername() {
        return AdminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        AdminUsername = adminUsername;
    }

    public String getAdminPassword() {
        return AdminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        AdminPassword = adminPassword;
    }
}


