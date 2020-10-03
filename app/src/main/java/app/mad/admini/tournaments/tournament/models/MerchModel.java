package app.mad.admini.tournaments.tournament.models;

public class MerchModel {
    private int mid,qtyMerch;
    private String tournamentNameMerch,matchIDMerch,itemMerch;
    private float priceMerch;
    private byte[] merchImage;

    public MerchModel() {
    }

    public MerchModel(int mid, String tournamentNameMerch, String matchIDMerch, String itemMerch, int qtyMerch, float priceMerch, byte[] merchImage) {
        this.mid = mid;
        this.qtyMerch = qtyMerch;
        this.tournamentNameMerch = tournamentNameMerch;
        this.matchIDMerch = matchIDMerch;
        this.itemMerch = itemMerch;
        this.priceMerch = priceMerch;
        this.merchImage=merchImage;
    }

    public MerchModel(int mid, String tournamentNameMerch, String matchIDMerch, String itemMerch, int qtyMerch, float priceMerch) {
        this.mid = mid;
        this.qtyMerch = qtyMerch;
        this.tournamentNameMerch = tournamentNameMerch;
        this.matchIDMerch = matchIDMerch;
        this.itemMerch = itemMerch;
        this.priceMerch = priceMerch;
    }


    public MerchModel(String tournamentNameMerch, String matchIDMerch, String itemMerch, int qtyMerch, float priceMerch, byte[] merchImage) {
        this.qtyMerch = qtyMerch;
        this.tournamentNameMerch = tournamentNameMerch;
        this.matchIDMerch = matchIDMerch;
        this.itemMerch = itemMerch;
        this.priceMerch = priceMerch;
        this.merchImage = merchImage;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public int getQtyMerch() {
        return qtyMerch;
    }

    public void setQtyMerch(int qtyMerch) {
        this.qtyMerch = qtyMerch;
    }

    public String getTournamentNameMerch() {
        return tournamentNameMerch;
    }

    public void setTournamentNameMerch(String tournamentNameMerch) {
        this.tournamentNameMerch = tournamentNameMerch;
    }

    public String getMatchIDMerch() {
        return matchIDMerch;
    }

    public void setMatchIDMerch(String matchIDMerch) {
        this.matchIDMerch = matchIDMerch;
    }

    public String getItemMerch() {
        return itemMerch;
    }

    public void setItemMerch(String itemMerch) {
        this.itemMerch = itemMerch;
    }

    public float getPriceMerch() {
        return priceMerch;
    }

    public void setPriceMerch(float priceMerch) {
        this.priceMerch = priceMerch;
    }

    public byte[] getMerchImage() {
        return merchImage;
    }

    public void setMerchImage(byte[] merchImage) {
        this.merchImage = merchImage;
    }
}
