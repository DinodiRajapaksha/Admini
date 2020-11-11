package app.mad.admini.tournaments.tournament.models;


import static app.mad.admini.tournaments.tournament.models.Tournament.getTid;

public class TeamLineUp {
    public static int co;

    private String playerOne;
    private String playerTwo;
    private String playerThree;
    private String playerFour;
    private String playerFive;
    private String playerSix;
    private String playerSeven;
    private String playerEight;
    private String playerNine;
    private String playerTen;
    private String playerEleven;

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    private String tid;

    public TeamLineUp(String tid,String playerOne, String playerTwo, String playerThree, String playerFour, String playerFive, String playerSix, String playerSeven, String playerEight, String playerNine, String playerTen, String playerEleven) {
        this.tid = tid;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.playerThree = playerThree;
        this.playerFour = playerFour;
        this.playerFive = playerFive;
        this.playerSix = playerSix;
        this.playerSeven = playerSeven;
        this.playerEight = playerEight;
        this.playerNine = playerNine;
        this.playerTen = playerTen;
        this.playerEleven = playerEleven;
    }

    public TeamLineUp() {

    }

    public String getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(String playerOne) {
        this.playerOne = playerOne;
    }

    public String getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(String playerTwo) {
        this.playerTwo = playerTwo;
    }

    public String getPlayerThree() {
        return playerThree;
    }

    public void setPlayerThree(String playerThree) {
        this.playerThree = playerThree;
    }

    public String getPlayerFour() {
        return playerFour;
    }

    public void setPlayerFour(String playerFour) {
        this.playerFour = playerFour;
    }

    public String getPlayerFive() {
        return playerFive;
    }

    public void setPlayerFive(String playerFive) {
        this.playerFive = playerFive;
    }

    public String getPlayerSix() {
        return playerSix;
    }

    public void setPlayerSix(String playerSix) {
        this.playerSix = playerSix;
    }

    public String getPlayerSeven() {
        return playerSeven;
    }

    public void setPlayerSeven(String playerSeven) {
        this.playerSeven = playerSeven;
    }

    public String getPlayerEight() {
        return playerEight;
    }

    public void setPlayerEight(String playerEight) {
        this.playerEight = playerEight;
    }

    public String getPlayerNine() {
        return playerNine;
    }

    public void setPlayerNine(String playerNine) {
        this.playerNine = playerNine;
    }

    public String getPlayerTen() {
        return playerTen;
    }

    public void setPlayerTen(String playerTen) {
        this.playerTen = playerTen;
    }

    public String getPlayerEleven() {
        return playerEleven;
    }

    public void setPlayerEleven(String playerEleven) {
        this.playerEleven = playerEleven;
    }

}

