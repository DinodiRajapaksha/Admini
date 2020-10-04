package app.mad.admini.tournaments.tournament.models;

public class PlayerODIModel {
    private int pid,age,tmatches,tinnings,notout,truns,bf,hs,s50,s100,bmatches,binnings,balls,bruns,wkts,bbm;
    private String name,teams,role;
    private float taverage,tsr,baverage,economy,bsr;
    private byte[] profimage;

    public PlayerODIModel() {
    }

    public PlayerODIModel(int pid, float taverage, float tsr, float economy, int tinnings, float baverage, float bsr, int wkts, int bruns, int bf, int truns, int balls) {
        this.taverage = taverage;
        this.pid = pid;
        this.tsr = tsr;
        this.economy = economy;
        this.tinnings = tinnings;
        this.baverage = baverage;
        this.bsr =bsr;
        this.wkts = wkts;
        this.bruns = bruns;
        this.bf =bf;
        this.truns=truns;
        this.balls =balls;
    }

    public PlayerODIModel(int pid, byte[] profimage, String name, int age, String teams, String role, int tmatches, int tinnings, int notout, int truns, int bf, int hs, float taverage, float tsr,
                          int s50, int s100, int bmatches, int binnings, int balls, int bruns, int wkts, int bbm, float baverage, float economy, float bsr) {
        this.pid = pid;
        this.age = age;
        this.tmatches = tmatches;
        this.tinnings = tinnings;
        this.notout = notout;
        this.truns = truns;
        this.bf = bf;
        this.hs = hs;
        this.s50 = s50;
        this.s100 = s100;
        this.bmatches = bmatches;
        this.binnings = binnings;
        this.balls = balls;
        this.bruns = bruns;
        this.wkts = wkts;
        this.bbm = bbm;
        this.name = name;
        this.teams = teams;
        this.role = role;
        this.taverage = taverage;
        this.tsr = tsr;
        this.baverage = baverage;
        this.economy = economy;
        this.bsr = bsr;
        this.profimage = profimage;
    }
    public PlayerODIModel(int age, int tmatches, int tinnings, int notout, int truns, int bf, int hs, int s50, int s100,
                          int bmatches, int binnings, int balls, int bruns, int wkts, int bbm, String name, String teams,
                          String role, float taverage, float tsr, float baverage, float economy, float bsr, byte[] profimage) {
        this.age = age;
        this.tmatches = tmatches;
        this.tinnings = tinnings;
        this.notout = notout;
        this.truns = truns;
        this.bf = bf;
        this.hs = hs;
        this.s50 = s50;
        this.s100 = s100;
        this.bmatches = bmatches;
        this.binnings = binnings;
        this.balls = balls;
        this.bruns = bruns;
        this.wkts = wkts;
        this.bbm = bbm;
        this.name = name;
        this.teams = teams;
        this.role = role;
        this.taverage = taverage;
        this.tsr = tsr;
        this.baverage = baverage;
        this.economy = economy;
        this.bsr = bsr;
        this.profimage = profimage;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getTmatches() {
        return tmatches;
    }

    public void setTmatches(int tmatches) {
        this.tmatches = tmatches;
    }

    public int getTinnings() {
        return tinnings;
    }

    public void setTinnings(int tinnings) {
        this.tinnings = tinnings;
    }

    public int getNotout() {
        return notout;
    }

    public void setNotout(int notout) {
        this.notout = notout;
    }

    public int getTruns() {
        return truns;
    }

    public void setTruns(int truns) {
        this.truns = truns;
    }

    public int getBf() {
        return bf;
    }

    public void setBf(int bf) {
        this.bf = bf;
    }

    public int getHs() {
        return hs;
    }

    public void setHs(int hs) {
        this.hs = hs;
    }

    public int getS50() {
        return s50;
    }

    public void setS50(int s50) {
        this.s50 = s50;
    }

    public int getS100() {
        return s100;
    }

    public void setS100(int s100) {
        this.s100 = s100;
    }

    public int getBmatches() {
        return bmatches;
    }

    public void setBmatches(int bmatches) {
        this.bmatches = bmatches;
    }

    public int getBinnings() {
        return binnings;
    }

    public void setBinnings(int binnings) {
        this.binnings = binnings;
    }

    public int getBalls() {
        return balls;
    }

    public void setBalls(int balls) {
        this.balls = balls;
    }

    public int getBruns() {
        return bruns;
    }

    public void setBruns(int bruns) {
        this.bruns = bruns;
    }

    public int getWkts() {
        return wkts;
    }

    public void setWkts(int wkts) {
        this.wkts = wkts;
    }

    public int getBbm() {
        return bbm;
    }

    public void setBbm(int bbm) {
        this.bbm = bbm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeams() {
        return teams;
    }

    public void setTeams(String teams) {
        this.teams = teams;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public float getTaverage() {
        return taverage;
    }

    public void setTaverage(float taverage) {
        this.taverage = taverage;
    }

    public float getTsr() {
        return tsr;
    }

    public void setTsr(float tsr) {
        this.tsr = tsr;
    }

    public float getBaverage() {
        return baverage;
    }

    public void setBaverage(float baverage) {
        this.baverage = baverage;
    }

    public float getEconomy() {
        return economy;
    }

    public void setEconomy(float economy) {
        this.economy = economy;
    }

    public float getBsr() {
        return bsr;
    }

    public void setBsr(float bsr) {
        this.bsr = bsr;
    }

    public byte[] getProfimage() {
        return profimage;
    }

    public void setProfimage(byte[] profimage) {
        this.profimage = profimage;
    }
}
