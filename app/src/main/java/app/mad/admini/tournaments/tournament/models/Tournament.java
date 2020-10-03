package app.mad.admini.tournaments.tournament.models;

public class Tournament {
    private String tid;
    private String num;
    private String touName;
    private String touType;
    private String touCountry;
    private String fromDate;
    private String toDate;
    private Integer teamOne;
    private Integer teamTwo;
    private Integer teamThree;
    private Integer teamFour;
    private Integer teamFive;
    private Integer teamSix;
    private Integer teamSeven;
    private Integer teamEight;

    public Tournament(String tid, String num, String touName, String touType,
                      String touCountry, String fromDate, String toDate,
                      Integer teamOne, Integer teamTwo, Integer teamThree,
                      Integer teamFour, Integer teamFive, Integer teamSix, Integer teamSeven, Integer teamEight) {
        this.tid = tid;
        this.num = num;
        this.touName = touName;
        this.touType = touType;
        this.touCountry = touCountry;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.teamOne = teamOne;
        this.teamTwo = teamTwo;
        this.teamThree = teamThree;
        this.teamFour = teamFour;
        this.teamFive = teamFive;
        this.teamSix = teamSix;
        this.teamSeven = teamSeven;
        this.teamEight = teamEight;
    }


    public Integer getTeamOne() {
        return teamOne;
    }

    public void setTeamOne(Integer teamOne) {
        this.teamOne = teamOne;
    }

    public Integer getTeamTwo() {
        return teamTwo;
    }

    public void setTeamTwo(Integer teamTwo) {
        this.teamTwo = teamTwo;
    }

    public Integer getTeamThree() {
        return teamThree;
    }

    public void setTeamThree(Integer teamThree) {
        this.teamThree = teamThree;
    }

    public Integer getTeamFour() {
        return teamFour;
    }

    public void setTeamFour(Integer teamFour) {
        this.teamFour = teamFour;
    }

    public Integer getTeamFive() {
        return teamFive;
    }

    public void setTeamFive(Integer teamFive) {
        this.teamFive = teamFive;
    }

    public Integer getTeamSix() {
        return teamSix;
    }

    public void setTeamSix(Integer teamSix) {
        this.teamSix = teamSix;
    }

    public Integer getTeamSeven() {
        return teamSeven;
    }

    public void setTeamSeven(Integer teamSeven) {
        this.teamSeven = teamSeven;
    }

    public Integer getTeamEight() {
        return teamEight;
    }

    public void setTeamEight(Integer teamEight) {
        this.teamEight = teamEight;
    }
    public String getTouType() {
        return touType;
    }

    public void setTouType(String touType) {
        this.touType = touType;
    }

    public Tournament(String touType) {
        this.touType = touType;
    }


    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getTouName() {
        return touName;
    }

    public void setTouName(String touName) {
        this.touName = touName;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTouCountry() {
        return touCountry;
    }

    public void setTouCountry(String touCountry) {
        this.touCountry = touCountry;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

}
