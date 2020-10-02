package app.mad.admini.tournaments.tournament.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.tournaments.tournament.models.MatchModel;
import app.mad.admini.tournaments.tournament.models.MerchModel;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class DbHandlerS extends SQLiteOpenHelper {
    private static final int VERSION = 11;
    private static final String DB_NAME = "Howzaat";
    private static final String TABLE_NAME_1 = "Tickets";
    private static final String TABLE_NAME_MERCH = "Merch";
    private static final String TABLE_NAME_PLAYERPROFODI = "Player_ODI";
    private static final String TABLE_NAME_BASIC_MATCHES = "Basic_Matches";


    //column names for tickets table
    private static final String TID = "tID";
    private static final String TOURNAMENT_NAME = "tournamentName";
    private static final String MATCHID = "matchID";
    private static final String STADIUM_NAME = "stadiumName";
    private static final String BLOCK_TYPE = "blockType";
    private static final String UNIT_PRICE = "unitPrice";
    private static final String QTY = "qty";
    private static final String STARTED = "started";
    private static final String FINISHED = "finished";

    //column names for merch table
    private static final String MID = "mID";
    private static final String TOURNAMENT_NAME_MERCH = "Tournament_Name";
    private static final String MATCHID_MERCH = "MatchID";
    private static final String ITEM = "Item_Category";
    private static final String QTY_MERCH = "qty";
    private static final String ITEM_PRICE = "Unit_Price";
    private static final String IMAGE_MERCH = "Image";

    //columns for player Profile ODI
    private static final String PID = "pID";
    private static final String PROFILE_IMAGE = "prof_image";
    private static final String PNAME = "name";
    private static final String AGE = "age";
    private static final String TEAMS = "major_teams";
    private static final String ROLE = "role";
    private static final String BAT_MATCHES = "Tmatches";
    private static final String BAT_INNINGS = "Tinnings";
    private static final String NOTOUTS = "notouts";
    private static final String RUNS = "Truns";
    private static final String BF = "bf";
    private static final String HS = "hs";
    private static final String BAT_AVE = "Tave";
    private static final String BAT_SR = "Tsr";
    private static final String SFIFTY = "s50";
    private static final String SHUNDRED = "S100";
    private static final String BO_MATCHES = "Bmathces";
    private static final String BO_INNINGS = "Binnings";
    private static final String BO_BALLS = "Bballs";
    private static final String BO_RUNS = "bRuns";
    private static final String WKTS = "wickets";
    private static final String BBM = "bbm";
    private static final String BO_AVE = "bAve";
    private static final String ECON = "economy";
    private static final String SR = "Bsr";

    //column names for matches table
    private static final String BASIC_MATCHID = "MatchID";
    private static final String MATCH_TYPE = "MatchType";
    private static final String DATE = "Date";
    private static final String STADIUM = "Stadium";
    private static final String TEAM1 = "Team1";
    private static final String TEAM2 = "Team2";
    private static final String STATUS = "Status";


    public DbHandlerS(@Nullable Context context) {
        super(context, DB_NAME, null, VERSION);
    }

    //create tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        //create player profile ODI table
        String PLAYERODI_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME_PLAYERPROFODI + " " +
                "("
                + PID + " INTEGER PRIMARY KEY " + " AUTOINCREMENT,"
                + PROFILE_IMAGE + " BLOB,"
                + PNAME + " TEXT,"
                + AGE + " INTEGER,"
                + TEAMS + " TEXT,"
                + ROLE + " TEXT,"
                + BAT_MATCHES + " INTEGER,"
                + BAT_INNINGS + " INTEGER,"
                + NOTOUTS + " INTEGER,"
                + RUNS + " INTEGER,"
                + BF + " INTEGER,"
                + HS + " INTEGER,"
                + BAT_AVE + " FLOAT,"
                + BAT_SR + " FLOAT,"
                + SFIFTY + " FLOAT,"
                + SHUNDRED + " FLOAT,"
                + BO_MATCHES + " INTEGER,"
                + BO_INNINGS + " INTEGER,"
                + BO_BALLS + " INTEGER,"
                + BO_RUNS + " INTEGER,"
                + WKTS + " INTEGER,"
                + BBM + " INTEGER,"
                + BO_AVE + " FLOAT,"
                + ECON + " FLOAT,"
                + SR + " FLOAT"
                + ");";

        //create ticket table
        String TABLE_CREATE_QUERY = "CREATE TABLE " + TABLE_NAME_1 + " " +
                "("
                + TID + " INTEGER PRIMARY KEY " + " AUTOINCREMENT,"
                + TOURNAMENT_NAME + " TEXT,"
                + MATCHID + " TEXT,"
                + STADIUM_NAME + " TEXT,"
                + BLOCK_TYPE + " TEXT,"
                + UNIT_PRICE + " FLOAT,"
                + QTY + " INTEGER,"
                + STARTED + " TEXT,"
                + FINISHED + " TEXT,"
                + "FOREIGN KEY" + "(" + MATCHID + ")"
                + "REFERENCES " + TABLE_NAME_BASIC_MATCHES + "(" + BASIC_MATCHID + ")" +
                ");";

        //create merch table
        String MERCH_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME_MERCH + " " +
                "("
                + MID + " INTEGER PRIMARY KEY " + " AUTOINCREMENT,"
                + TOURNAMENT_NAME_MERCH + " TEXT,"
                + MATCHID_MERCH + " TEXT,"
                + ITEM + " TEXT,"
                + QTY_MERCH + " INTEGER,"
                + ITEM_PRICE + " FLOAT,"
                + IMAGE_MERCH + " BLOB" +
                ");";

        //create match table
        String MATCH_TABLE_CREATE = "CREATE TABLE " + TABLE_NAME_BASIC_MATCHES + " " +
                "("
                + BASIC_MATCHID + " INTEGER PRIMARY KEY " + " AUTOINCREMENT,"
                + MATCH_TYPE + " TEXT,"
                + DATE + " TEXT,"
                + STADIUM + " TEXT,"
                + TEAM1 + " TEXT,"
                + TEAM2 + " TEXT,"
                + STATUS + " TEXT" +
                ");";
        db.execSQL(MATCH_TABLE_CREATE);
        db.execSQL(PLAYERODI_TABLE_CREATE);
        db.execSQL(TABLE_CREATE_QUERY);
        db.execSQL(MERCH_TABLE_CREATE);

        db.execSQL("INSERT INTO Basic_Matches(MatchType,Date,Stadium,Team1,Team2,Status) VALUES('ODI','2020-10-04','PALL','India','SriLanka','Upcoming')");
        db.execSQL("INSERT INTO Basic_Matches(MatchType,Date,Stadium,Team1,Team2,Status) VALUES('ODI','2020-10-04','PALL','India','new zeland','Upcoming')");
        db.execSQL("INSERT INTO Basic_Matches(MatchType,Date,Stadium,Team1,Team2,Status) VALUES('ODI','2020-10-04','PALL','India','AUS','Ongoig')");


    }


    //insert ticket details
   public void addTickets(TicketModel tmodel) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TOURNAMENT_NAME, tmodel.getTournamentName());
        contentValues.put(MATCHID, tmodel.getMatchID());
        contentValues.put(STADIUM_NAME, tmodel.getStadiumName());
        contentValues.put(BLOCK_TYPE, tmodel.getBlockType());
        contentValues.put(UNIT_PRICE, tmodel.getUnitPrice());
        contentValues.put(QTY, tmodel.getQty());
        contentValues.put(STARTED, tmodel.getStared());
        contentValues.put(FINISHED, tmodel.getFinished());

        //save to table
        sqLiteDatabase.insert(TABLE_NAME_1, null, contentValues);
        //close database
        sqLiteDatabase.close();
    }

    //retrieve all tickets
    public List<TicketModel> getAllTickets() {
        List<TicketModel> tickets = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_1;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                //create new ticketmodel object
                TicketModel ticketModel = new TicketModel();
                //pass values to setters
                ticketModel.setTid(cursor.getInt(0));
                ticketModel.setTournamentName(cursor.getString(1));
                ticketModel.setMatchID(cursor.getString(2));
                ticketModel.setStadiumName(cursor.getString(3));
                ticketModel.setBlockType(cursor.getString(4));
                ticketModel.setUnitPrice(cursor.getFloat(5));
                ticketModel.setQty(cursor.getInt(6));


                tickets.add(ticketModel);
            } while (cursor.moveToNext());
        }
        return tickets;
    }

    //delete tickets
    public void deleteTickets(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME_1, TID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    //get single ticket
    public TicketModel getSingleTicket(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME_1, new String[]{TID, TOURNAMENT_NAME, MATCHID, STADIUM_NAME, BLOCK_TYPE, UNIT_PRICE, QTY},
                TID + "=?", new String[]{String.valueOf(id)}, null, null, null);

        TicketModel ticketModel;
        if (cursor != null) {
            cursor.moveToFirst();
            ticketModel = new TicketModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getFloat(5),
                    cursor.getInt(6)
            );
            return ticketModel;
        }
        return null;
    }

    //update ticket details
    public int updateTickets(TicketModel ticket) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TOURNAMENT_NAME, ticket.getTournamentName());
        contentValues.put(MATCHID, ticket.getMatchID());
        contentValues.put(STADIUM_NAME, ticket.getStadiumName());
        contentValues.put(BLOCK_TYPE, ticket.getBlockType());
        contentValues.put(UNIT_PRICE, ticket.getUnitPrice());
        contentValues.put(QTY, ticket.getQty());

        int status = db.update(TABLE_NAME_1, contentValues, TID + " =?"
                , new String[]{String.valueOf(ticket.getTid())});

        db.close();
        return status;

    }

    //Add new Merch
    public void addMerch(MerchModel merchModel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(TOURNAMENT_NAME_MERCH, merchModel.getTournamentNameMerch());
        contentValues.put(MATCHID_MERCH, merchModel.getMatchIDMerch());
        contentValues.put(ITEM, merchModel.getItemMerch());
        contentValues.put(QTY_MERCH, merchModel.getQtyMerch());
        contentValues.put(ITEM_PRICE, merchModel.getPriceMerch());
        contentValues.put(IMAGE_MERCH, merchModel.getMerchImage());

        //save to table
        db.insert(TABLE_NAME_MERCH, null, contentValues);
        //close database
        db.close();
    }

    //retrieve all merch
    public List<MerchModel> getAllMerch() {
        List<MerchModel> merch = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_MERCH;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                //create new merchmodel object
                MerchModel merchModel = new MerchModel();
                //pass values to setters
                merchModel.setMid(cursor.getInt(0));
                merchModel.setTournamentNameMerch(cursor.getString(1));
                merchModel.setMatchIDMerch(cursor.getString(2));
                merchModel.setItemMerch(cursor.getString(3));
                merchModel.setQtyMerch(cursor.getInt(4));
                merchModel.setPriceMerch(cursor.getFloat(5));
                merchModel.setMerchImage(cursor.getBlob(6));

                merch.add(merchModel);
            } while (cursor.moveToNext());
        }
        return merch;
    }

    //delete merch
    public void deleteMerch(int id) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME_MERCH, MID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    //get single merch
    public MerchModel getSingleMerch(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME_MERCH, new String[]{MID, TOURNAMENT_NAME_MERCH, MATCHID_MERCH, ITEM, QTY_MERCH, ITEM_PRICE, IMAGE_MERCH},
                MID + "=?", new String[]{String.valueOf(id)}, null, null, null);

        MerchModel merchModel;
        if (cursor != null) {
            cursor.moveToFirst();
            merchModel = new MerchModel(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getInt(4),
                    cursor.getFloat(5),
                    cursor.getBlob(6)
            );
            return merchModel;
        }
        return null;
    }

    //update merch details
    public int updateMerch(MerchModel merchModel) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(TOURNAMENT_NAME_MERCH, merchModel.getTournamentNameMerch());
        contentValues.put(MATCHID_MERCH, merchModel.getMatchIDMerch());
        contentValues.put(ITEM, merchModel.getItemMerch());
        contentValues.put(QTY_MERCH, merchModel.getQtyMerch());
        contentValues.put(ITEM_PRICE, merchModel.getPriceMerch());
        contentValues.put(IMAGE_MERCH, merchModel.getMerchImage());

        int status = db.update(TABLE_NAME_MERCH, contentValues, MID + " =?"
                , new String[]{String.valueOf(merchModel.getMid())});

        db.close();
        return status;

    }

    //Add new player odi
   /* public void addPlayerOdi(PlayerODIModel playermodel) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(PROFILE_IMAGE, playermodel.getProfimage());
        contentValues.put(PNAME, playermodel.getName());
        contentValues.put(AGE, playermodel.getAge());
        contentValues.put(TEAMS, playermodel.getTeams());
        contentValues.put(ROLE, playermodel.getRole());
        contentValues.put(BAT_MATCHES, playermodel.getTmatches());
        contentValues.put(BAT_INNINGS, playermodel.getTinnings());
        contentValues.put(NOTOUTS, playermodel.getNotout());
        contentValues.put(RUNS, playermodel.getTruns());
        contentValues.put(BF, playermodel.getBf());
        contentValues.put(HS, playermodel.getHs());
        contentValues.put(BAT_AVE, playermodel.getTaverage());
        contentValues.put(BAT_SR, playermodel.getTsr());
        contentValues.put(SFIFTY, playermodel.getS50());
        contentValues.put(SHUNDRED, playermodel.getS100());
        contentValues.put(BO_MATCHES, playermodel.getBmatches());
        contentValues.put(BO_INNINGS, playermodel.getBinnings());
        contentValues.put(BO_BALLS, playermodel.getBalls());
        contentValues.put(BO_RUNS, playermodel.getBruns());
        contentValues.put(WKTS, playermodel.getWkts());
        contentValues.put(BBM, playermodel.getBbm());
        contentValues.put(BO_AVE, playermodel.getBaverage());
        contentValues.put(ECON, playermodel.getEconomy());
        contentValues.put(SR, playermodel.getBsr());

        //save to table
        db.insert(TABLE_NAME_PLAYERPROFODI, null, contentValues);
        //close database
        db.close();
    }

    //retrieve all players
    public List<PlayerODIModel> getAllPlayers() {
        List<PlayerODIModel> player = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_PLAYERPROFODI;

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                //create new playermodel object
                PlayerODIModel playerODIModel = new PlayerODIModel();
                //pass values to setters
                playerODIModel.setPid(cursor.getInt(0));
                playerODIModel.setProfimage(cursor.getBlob(1));
                playerODIModel.setName(cursor.getString(2));
                playerODIModel.setAge(cursor.getInt(3));
                playerODIModel.setTeams(cursor.getString(4));
                playerODIModel.setRole(cursor.getString(5));
                playerODIModel.setTmatches(cursor.getInt(6));
                playerODIModel.setTinnings(cursor.getInt(7));
                playerODIModel.setNotout(cursor.getInt(8));
                playerODIModel.setTruns(cursor.getInt(9));
                playerODIModel.setBf(cursor.getInt(10));
                playerODIModel.setHs(cursor.getInt(11));
                playerODIModel.setTaverage(cursor.getFloat(12));
                playerODIModel.setTsr(cursor.getFloat(13));
                playerODIModel.setS50(cursor.getInt(14));
                playerODIModel.setS100(cursor.getInt(15));
                playerODIModel.setBmatches(cursor.getInt(16));
                playerODIModel.setBinnings(cursor.getInt(17));
                playerODIModel.setBalls(cursor.getInt(18));
                playerODIModel.setBruns(cursor.getInt(19));
                playerODIModel.setWkts(cursor.getInt(20));
                playerODIModel.setBbm(cursor.getInt(21));
                playerODIModel.setBaverage(cursor.getFloat(22));
                playerODIModel.setEconomy(cursor.getFloat(23));
                playerODIModel.setBsr(cursor.getFloat(24));

                player.add(playerODIModel);
            } while (cursor.moveToNext());
        }
        return player;
    }

    //delete players
    public void deletePlayer(int pid) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(TABLE_NAME_PLAYERPROFODI, PID + "=?", new String[]{String.valueOf(pid)});
        db.close();
    }

    //get single player
    public PlayerODIModel getSinglePlayer(int id) {
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME_PLAYERPROFODI, new String[]{PID, PROFILE_IMAGE, PNAME, AGE, TEAMS, ROLE, BAT_MATCHES, BAT_INNINGS, NOTOUTS, RUNS, BF,
                        HS, BAT_AVE, BAT_SR, SFIFTY, SHUNDRED, BO_MATCHES, BO_INNINGS, BO_BALLS, BO_RUNS, WKTS, BBM, BO_AVE, ECON, SR},
                PID + "=?", new String[]{String.valueOf(id)}, null, null, null);

        PlayerODIModel playerODIModel;
        if (cursor != null) {
            cursor.moveToFirst();
            playerODIModel = new PlayerODIModel(
                    cursor.getInt(0),
                    cursor.getBlob(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getInt(6),
                    cursor.getInt(7),
                    cursor.getInt(8),
                    cursor.getInt(9),
                    cursor.getInt(10),
                    cursor.getInt(11),
                    cursor.getFloat(12),
                    cursor.getFloat(13),
                    cursor.getInt(14),
                    cursor.getInt(15),
                    cursor.getInt(16),
                    cursor.getInt(17),
                    cursor.getInt(18),
                    cursor.getInt(19),
                    cursor.getInt(20),
                    cursor.getInt(21),
                    cursor.getFloat(22),
                    cursor.getFloat(23),
                    cursor.getFloat(24)
            );
            return playerODIModel;
        }
        return null;
    }

    //update player details
    public int updatePlayer(PlayerODIModel playermodel) {
        SQLiteDatabase db = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(PROFILE_IMAGE, playermodel.getProfimage());
        contentValues.put(PNAME, playermodel.getName());
        contentValues.put(AGE, playermodel.getAge());
        contentValues.put(TEAMS, playermodel.getTeams());
        contentValues.put(ROLE, playermodel.getRole());
        contentValues.put(BAT_MATCHES, playermodel.getTmatches());
        contentValues.put(BAT_INNINGS, playermodel.getTinnings());
        contentValues.put(NOTOUTS, playermodel.getNotout());
        contentValues.put(RUNS, playermodel.getTruns());
        contentValues.put(BF, playermodel.getBf());
        contentValues.put(HS, playermodel.getHs());
        contentValues.put(BAT_AVE, playermodel.getTaverage());
        contentValues.put(BAT_SR, playermodel.getTsr());
        contentValues.put(SFIFTY, playermodel.getS50());
        contentValues.put(SHUNDRED, playermodel.getS100());
        contentValues.put(BO_MATCHES, playermodel.getBmatches());
        contentValues.put(BO_INNINGS, playermodel.getBinnings());
        contentValues.put(BO_BALLS, playermodel.getBalls());
        contentValues.put(BO_RUNS, playermodel.getBruns());
        contentValues.put(WKTS, playermodel.getWkts());
        contentValues.put(BBM, playermodel.getBbm());
        contentValues.put(BO_AVE, playermodel.getBaverage());
        contentValues.put(ECON, playermodel.getEconomy());
        contentValues.put(SR, playermodel.getBsr());

        int status = db.update(TABLE_NAME_PLAYERPROFODI, contentValues, PID + " =?"
                , new String[]{String.valueOf(playermodel.getPid())});

        db.close();
        return status;

    }*/

    //retrieve upcoming matches
    public List<MatchModel> getUpcomingMatches() {
        List<MatchModel> matchModels = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME_BASIC_MATCHES + " WHERE Status = 'Upcoming'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                //create new ticketmodel object
                MatchModel matchModel = new MatchModel();
                //pass values to setters
                matchModel.setMathcID(cursor.getInt(0));
                matchModel.setMatchType(cursor.getString(1));
                matchModel.setDate(cursor.getString(2));
                matchModel.setStadium(cursor.getString(3));
                matchModel.setTeam1(cursor.getString(4));
                matchModel.setTeam2(cursor.getString(5));
                matchModel.setStatus(cursor.getString(6));


                matchModels.add(matchModel);
            } while (cursor.moveToNext());
        }
        return matchModels;
    }


    //retrieve all merch
    public List<TicketModel> getTTX() {
        List<TicketModel> tt = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        String query = "SELECT * FROM Tickets WHERE matchID +'= (' + 'SELECT MatchID FROM Basic_Matches WHERE MatchID'+ '=?' +')'";

        Cursor cursor = db.rawQuery(query, null);

        if (cursor.moveToFirst()) {
            do {
                //create new merchmodel object
                TicketModel ticketModel = new TicketModel();
                //pass values to setters
                ticketModel.setTid(cursor.getInt(0));
                ticketModel.setTournamentName(cursor.getString(1));
                ticketModel.setMatchID(cursor.getString(2));
                ticketModel.setStadiumName(cursor.getString(3));
                ticketModel.setBlockType(cursor.getString(4));
                ticketModel.setUnitPrice(cursor.getFloat(5));
                ticketModel.setQty(cursor.getInt(6));

                tt.add(ticketModel);
            } while (cursor.moveToNext());
        }
        return tt;
    }
   //calculations for tickets
   public void getNumberOfTickets(int id,String spinner1,String spinner2,int qty1,int qty2){
        SQLiteDatabase db = getReadableDatabase();
        String query = "UPDATE Tickets SET qty = qty -" +qty1+  " WHERE matchID =" +id+" AND blockType = " +"'" +spinner1+"'";
        String query2 = "UPDATE Tickets SET qty = qty -" +qty2+  " WHERE matchID =" +id+" AND blockType = " +"'" +spinner2+"'";
        db.execSQL(query);
        db.execSQL(query2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE_QUERY ="DROP TABLE IF EXISTS "+TABLE_NAME_1;
        String DROP_TABLE_MERCH_QUERY ="DROP TABLE IF EXISTS "+TABLE_NAME_MERCH;
        String DROP_TABLE_PLAYER_QUERY ="DROP TABLE IF EXISTS "+TABLE_NAME_PLAYERPROFODI;
        String DROP_TABLE_MATCH_QUERY = "DROP TABLE IF EXISTS "+TABLE_NAME_BASIC_MATCHES;
        //drop older table if exist
        db.execSQL(DROP_TABLE_PLAYER_QUERY);
        db.execSQL(DROP_TABLE_QUERY);
        db.execSQL(DROP_TABLE_MERCH_QUERY);
        db.execSQL(DROP_TABLE_MATCH_QUERY);
        //create tables again
        onCreate(db);

    }


}
