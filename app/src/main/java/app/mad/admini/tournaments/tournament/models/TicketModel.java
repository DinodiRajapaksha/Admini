package app.mad.admini.tournaments.tournament.models;

public class TicketModel {
     private int tid,qty;
     private String tournamentName,matchID,stadiumName,blockType;
     private float unitPrice;
     private long stared,finished;

    public TicketModel(int tid, String tournamentName, String matchID, String stadiumName, String blockType, float unitPrice, int qty) {
        this.tid = tid;
        this.qty = qty;
        this.tournamentName = tournamentName;
        this.matchID = matchID;
        this.stadiumName = stadiumName;
        this.blockType = blockType;
        this.unitPrice = unitPrice;

    }

    public TicketModel(int qty, String tournamentName, String matchID, String stadiumName, String blockType, float unitPrice, long stared, long finished) {
        this.qty = qty;
        this.tournamentName = tournamentName;
        this.matchID = matchID;
        this.stadiumName = stadiumName;
        this.blockType = blockType;
        this.unitPrice = unitPrice;
        this.finished = finished;
        this.stared =stared;
    }

    public TicketModel() {
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getTournamentName() {
        return tournamentName;
    }

    public void setTournamentName(String tournamentName) {
        this.tournamentName = tournamentName;
    }

    public String getMatchID() {
        return matchID;
    }

    public void setMatchID(String matchID) {
        this.matchID = matchID;
    }

    public String getStadiumName() {
        return stadiumName;
    }

    public void setStadiumName(String stadiumName) {
        this.stadiumName = stadiumName;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public long getStared() {
        return stared;
    }

    public void setStared(long stared) {
        this.stared = stared;
    }

    public long getFinished() {
        return finished;
    }

    public void setFinished(long finished) {
        this.finished = finished;
    }
}
