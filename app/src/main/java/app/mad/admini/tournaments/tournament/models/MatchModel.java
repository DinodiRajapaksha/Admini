package app.mad.admini.tournaments.tournament.models;

public class MatchModel {
    private int mathcID;
    private String matchType, date , stadium, team1, team2,status;

    public MatchModel() {
    }

    public MatchModel(int mathcID, String matchType, String date, String stadium, String team1, String team2, String status) {
        this.mathcID = mathcID;
        this.matchType = matchType;
        this.date = date;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
        this.status = status;
    }

    public MatchModel(String matchType, String date, String stadium, String team1, String team2, String status) {
        this.matchType = matchType;
        this.date = date;
        this.stadium = stadium;
        this.team1 = team1;
        this.team2 = team2;
        this.status = status;
    }

    public int getMathcID() {
        return mathcID;
    }

    public void setMathcID(int mathcID) {
        this.mathcID = mathcID;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTeam1() {
        return team1;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public String getTeam2() {
        return team2;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
