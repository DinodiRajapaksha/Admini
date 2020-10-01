package app.mad.admini.tournaments.tournament.models;

public class Tournament {
    private Integer tid;
    private String num;
    private String touName;
    private String touCountry;
    private String fromDate;
    private String toDate;
    private String touType;

    public String getTouType() {
        return touType;
    }

    public void setTouType(String touType) {
        this.touType = touType;
    }

    public Tournament(String touType) {
        this.touType = touType;
    }

    public Tournament(String touName, String num, String fromDate, String toDate, String touCountry, Integer tid, String touType) {
        this.touName = touName;
        this.touCountry = touCountry;
        this.num = num;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.tid = tid;
        this.touType = touType;
    }

    public Tournament(String touName, String num, String fromDate, String toDate, String touCountry, String touType) {
        this.touName = touName;
        this.touCountry = touCountry;
        this.num = num;
        this.fromDate = fromDate;
        this.toDate = toDate;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

}
