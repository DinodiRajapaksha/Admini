package app.mad.admini.tournaments.tournament.models;

public class Stadium {

    private int stadiumID;
    private String stadiumName;
    private String country;
    private String location;
    private String seats;
    private String size;
    private String information;

    public Stadium() {
    }

    public Stadium(String stadiumName, String country, String location, String seats, String size, String information) {
        this.stadiumName = stadiumName;
        this.country = country;
        this.location = location;
        this.seats = seats;
        this.size = size;
        this.information = information;
    }

    public Stadium(int stadiumID, String stadiumName, String country, String location, String seats, String size, String information) {
        this.stadiumID = stadiumID;
        this.stadiumName = stadiumName;
        this.country = country;
        this.location = location;
        this.seats = seats;
        this.size = size;
        this.information = information;
    }

    public int getStadiumID() {
        return stadiumID;
    }

    public void setStadiumID(int stadiumID) {
        this.stadiumID = stadiumID;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
