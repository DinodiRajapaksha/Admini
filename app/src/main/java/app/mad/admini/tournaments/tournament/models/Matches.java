package app.mad.admini.tournaments.tournament.models;

public class Matches {

    private String mid;
    private String matchType;
    private String matchdate;
    private String stadium;
    private String team01;
    private String team02;
    private String status;

    public Matches(String mid, String matchType, String matchdate, String stadium, String team01, String team02, String status) {
        this.mid = mid;
        this.matchType = matchType;
        this.matchdate = matchdate;
        this.stadium = stadium;
        this.team01 = team01;
        this.team02 = team02;
        this.status = status;
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }

    public String getMatchdate() {
        return matchdate;
    }

    public void setMatchdate(String matchdate) {
        this.matchdate = matchdate;
    }

    public String getStadium() {
        return stadium;
    }

    public void setStadium(String stadium) {
        this.stadium = stadium;
    }

    public String getTeam01() {
        return team01;
    }

    public void setTeam01(String team01) {
        this.team01 = team01;
    }

    public String getTeam02() {
        return team02;
    }

    public void setTeam02(String team02) {
        this.team02 = team02;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
