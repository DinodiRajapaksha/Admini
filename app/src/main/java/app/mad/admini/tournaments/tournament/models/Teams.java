package app.mad.admini.tournaments.tournament.models;

public class Teams {

    private int TeamId;
    private String TeamName;
    private String Category;
    private int BatsmenNo;
    private int BowlerNo;
    private int AllRounderNo;
    private int WKNo;

    public Teams(int teamId, String teamName, String category, int batsmenNo, int bowlerNo, int allRounderNo, int WKNo) {
        TeamId = teamId;
        TeamName = teamName;
        Category = category;
        BatsmenNo = batsmenNo;
        BowlerNo = bowlerNo;
        AllRounderNo = allRounderNo;
        this.WKNo = WKNo;
    }

    public Teams(String teamName, String category, int batsmenNo, int bowlerNo, int allRounderNo, int WKNo) {
        TeamName = teamName;
        Category = category;
        BatsmenNo = batsmenNo;
        BowlerNo = bowlerNo;
        AllRounderNo = allRounderNo;
        this.WKNo = WKNo;
    }

    public Teams() {
    }

    public int getTeamId() {
        return TeamId;
    }

    public void setTeamId(int teamId) {
        TeamId = teamId;
    }

    public String getTeamName() {
        return TeamName;
    }

    public void setTeamName(String teamName) {
        TeamName = teamName;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getBatsmenNo() {
        return BatsmenNo;
    }

    public void setBatsmenNo(int batsmenNo) {
        BatsmenNo = batsmenNo;
    }

    public int getBowlerNo() {
        return BowlerNo;
    }

    public void setBowlerNo(int bowlerNo) {
        BowlerNo = bowlerNo;
    }

    public int getAllRounderNo() {
        return AllRounderNo;
    }

    public void setAllRounderNo(int allRounderNo) {
        AllRounderNo = allRounderNo;
    }

    public int getWKNo() {
        return WKNo;
    }

    public void setWKNo(int WKNo) {
        this.WKNo = WKNo;
    }
}
