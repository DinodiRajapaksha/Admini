package app.mad.admini.tournaments.tournament.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.TeamLineUp;
import app.mad.admini.tournaments.tournament.models.Tournament;

import static app.mad.admini.tournaments.tournament.models.Tournament.getTid;

public class databaseHelper extends SQLiteOpenHelper {


    //tables
    private static final String TABLE_TOU = "tournaments";
    private static final String TABLE_MAT = "matches";
    private static final String TABLE_TID_MID = "tid_mid";
    private static final String TABLE_TLU = "teamLineUp";

    //common cols
    private static final String KEY_ID = "id";

    //table tournaments
    private static final String COL_TOU_NAME = "touName";
    private static final String COL_TOU_TYPE = "touType";
    private static final String COL_NUM = "num";
    private static final String COL_TOU_COUNTRY = "touCountry";
    private static final String COL_FROM_DATE = "fromDate";
    private static final String COL_TO_DATE = "toDate";
    private static final String COL_TO_TEAM_ONE = "teamOne";
    private static final String COL_TO_TEAM_TWO = "teamTwo";
    private static final String COL_TO_TEAM_THREE = "teamThree";
    private static final String COL_TO_TEAM_FOUR = "teamFour";
    private static final String COL_TO_TEAM_FIVE = "teamFive";
    private static final String COL_TO_TEAM_SIX = "teamSix";
    private static final String COL_TO_TEAM_SEVEN = "teamSeven";
    private static final String COL_TO_TEAM_EIGHT = "teamEight";

    //table matches
    private static final String COL_TOU_ID = "tid";
    private static final String COL_MATCH_ID = "mid";
    private static final String COL_MATCH_TYPE = "matchType";
    private static final String COL_MATCH_DATE = "matchdate";
    private static final String COL_STADIUM = "stadium";
    private static final String COL_STATUS = "status";
    private static final String COL_TEAM01 = "team01";
    private static final String COL_TEAM02 = "team02";


    //table tlu
    private static final String COL_TID = "tid";
    private static final String COL_PL1 = "playerOne";
    private static final String COL_PL2 = "playerTwo";
    private static final String COL_PL3 = "playerThree";
    private static final String COL_PL4 = "playerFour";
    private static final String COL_PL5 = "playerFive";
    private static final String COL_PL6 = "playerSix";
    private static final String COL_PL7 = "playerSeven";
    private static final String COL_PL8 = "playerEight";
    private static final String COL_PL9 = "playerNine";
    private static final String COL_PL10 = "playerTen";
    private static final String COL_PL11 = "playerEleven";






    private static final String CREATE_TABLE_TOU = "CREATE TABLE "
            + TABLE_TOU + "(" + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + COL_NUM + " INTEGER,"
            + COL_TOU_NAME + " TEXT,"
            + COL_TOU_TYPE + " TEXT,"
            + COL_TOU_COUNTRY + " TEXT,"
            + COL_FROM_DATE + " TEXT,"
            + COL_TO_DATE + " TEXT,"
            + COL_TO_TEAM_ONE + " INTEGER,"
            + COL_TO_TEAM_TWO + " INTEGER,"
            + COL_TO_TEAM_THREE + " INTEGER,"
            + COL_TO_TEAM_FOUR + " INTEGER,"
            + COL_TO_TEAM_FIVE + " INTEGER,"
            + COL_TO_TEAM_SIX + " INTEGER,"
            + COL_TO_TEAM_SEVEN + " INTEGER,"
            + COL_TO_TEAM_EIGHT + " INTEGER);";

    private static final String CREATE_TABLE_MAT = "CREATE TABLE "
            + TABLE_MAT + "(" + COL_MATCH_ID + " TEXT,"
            + COL_TOU_ID + " TEXT,"
            + COL_MATCH_TYPE + " TEXT,"
            + COL_MATCH_DATE + " TEXT,"
            + COL_STADIUM + " TEXT,"
            + COL_TEAM01 + " TEXT,"
            + COL_TEAM02 + " TEXT,"
            + COL_STATUS + " TEXT);";

    private static final String CREATE_TABLE_TID_MID = "CREATE TABLE "
            + TABLE_TID_MID + "(" + KEY_ID + " INTEGER,"
            + COL_MATCH_ID + " TEXT);";


    private static final String CREATE_TABLE_TLU = "CREATE TABLE "
            + TABLE_TLU + "(" + COL_TID + " TEXT,"
            + COL_PL1 + " TEXT,"
            + COL_PL2 + " TEXT,"
            + COL_PL3 + " TEXT,"
            + COL_PL4 + " TEXT,"
            + COL_PL5 + " TEXT,"
            + COL_PL6 + " TEXT,"
            + COL_PL7 + " TEXT,"
            + COL_PL8 + " TEXT,"
            + COL_PL9 + " TEXT,"
            + COL_PL10 + " TEXT,"
            + COL_PL11 + " TEXT);";

    private Context context;
    private Integer numI;


    public databaseHelper(@Nullable Context context) {
        super(context, "Howzaat.db", null, 5);
     //   this.context = context;
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // creating required tables
        sqLiteDatabase.execSQL(CREATE_TABLE_TOU);
        sqLiteDatabase.execSQL(CREATE_TABLE_MAT);
        sqLiteDatabase.execSQL(CREATE_TABLE_TID_MID);
        sqLiteDatabase.execSQL(CREATE_TABLE_TLU);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TOU);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MAT);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TID_MID);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TLU);

        // create new tables
        onCreate(sqLiteDatabase);

    }

   //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Insert Tournament Details
    public void addTou(Tournament tournament) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NUM, tournament.getNum());
        values.put(COL_TOU_NAME, tournament.getTouName());
        values.put(COL_TOU_TYPE, tournament.getTouType());
        values.put(COL_TOU_COUNTRY, tournament.getTouCountry());
        values.put(COL_FROM_DATE, tournament.getFromDate());
        values.put(COL_TO_DATE, tournament.getToDate());
        values.put(COL_TO_TEAM_ONE, tournament.getTeamOne());
        values.put(COL_TO_TEAM_TWO, tournament.getTeamTwo());
        values.put(COL_TO_TEAM_THREE, tournament.getTeamThree());
        values.put(COL_TO_TEAM_FOUR, tournament.getTeamFour());
        values.put(COL_TO_TEAM_FIVE, tournament.getTeamFive());
        values.put(COL_TO_TEAM_SIX, tournament.getTeamSix());
        values.put(COL_TO_TEAM_SEVEN, tournament.getTeamSeven());
        values.put(COL_TO_TEAM_EIGHT, tournament.getTeamEight());



        // insert row
        long insert = sqLiteDatabase.insert(TABLE_TOU, null, values);

    }

    //Insert Match Details
    public void addMat(Matches matches) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_TOU_ID , getTid());
        values.put(COL_MATCH_ID , matches.getMid());
        values.put(COL_MATCH_TYPE , matches.getMatchType());
        values.put(COL_MATCH_DATE , matches.getMatchdate());
        values.put(COL_STADIUM , matches.getStadium());
        values.put(COL_TEAM01  , matches.getTeam01());
        values.put(COL_TEAM02  , matches.getTeam02());
        values.put(COL_STATUS , matches.getStatus());

        // insert row
        long insertMat = sqLiteDatabase.insert(TABLE_MAT, null, values);

    }

    public void addTLU(TeamLineUp teamLineUp) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_TID, teamLineUp.getTid());
        values.put(COL_PL1, teamLineUp.getPlayerOne());
        values.put(COL_PL2, teamLineUp.getPlayerTwo());
        values.put(COL_PL3, teamLineUp.getPlayerThree());
        values.put(COL_PL4, teamLineUp.getPlayerFour());
        values.put(COL_PL5, teamLineUp.getPlayerFive());
        values.put(COL_PL6, teamLineUp.getPlayerSix());
        values.put(COL_PL7, teamLineUp.getPlayerSeven());
        values.put(COL_PL8, teamLineUp.getPlayerEight());
        values.put(COL_PL9, teamLineUp.getPlayerNine());
        values.put(COL_PL10, teamLineUp.getPlayerTen());
        values.put(COL_PL11, teamLineUp.getPlayerEleven());

        // insert row
        long insert = sqLiteDatabase.insert(TABLE_TLU, null, values);

    }

    //Insert Match Details
    public void addMatFortidNmid(Matches matches, String tid, String mid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

            values.put(COL_TOU_ID , getTid());
            values.put(COL_MATCH_ID , matches.getMid());
            values.put(COL_MATCH_TYPE, matches.getMatchType());
            values.put(COL_MATCH_DATE, matches.getMatchdate());
            values.put(COL_STADIUM, matches.getStadium());
            values.put(COL_TEAM01, matches.getTeam01());
            values.put(COL_TEAM02, matches.getTeam02());
            values.put(COL_STATUS, matches.getStatus());

            Log.d("muuudb", mid);
        // insert row
        long insertMat = sqLiteDatabase.replace(TABLE_MAT, null, values);

    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public Cursor getAllPlayers(String tid) {
        String selectQuery = "SELECT  * FROM " + TABLE_TLU
                + " WHERE " + COL_TID + " = " + tid + ";";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Log.d("dbfix", COL_TID);
        Cursor c = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            Log.d("dbfix2", COL_TID);
            c  = sqLiteDatabase.rawQuery(selectQuery, null);
        }

        return c;
    }



    public Cursor getAllTourneys() {
        String selectQuery = "SELECT  * FROM " + TABLE_TOU;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor c = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            c  = sqLiteDatabase.rawQuery(selectQuery, null);
        }

        return c;
    }

        public String getNumFromTid(String tidx) {
        String selectQuery = "SELECT "+ COL_NUM +" , "+ KEY_ID
                +" FROM "+  TABLE_TOU
                + " WHERE " + KEY_ID + " = " + tidx +";";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String tid = null;
        Cursor c = null;
        c  = sqLiteDatabase.rawQuery(selectQuery, null);
        //Integer tid = c.getColumnIndex(getTid());
        if(c!=null && c.getCount()>0)
        {
            c.moveToFirst();
            do {
                tid = c.getString(0);
                Log.d("DBgetNumFromTidaneee", tid);
            } while (c.moveToNext());
        }
        return tid;
    }

    public String getTid() {
        String selectQuery = "SELECT "+ KEY_ID
                + " FROM " + TABLE_TOU;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String tid = null;
        Cursor c = null;
        c  = sqLiteDatabase.rawQuery(selectQuery, null);
        //Integer tid = c.getColumnIndex(getTid());
        if(c!=null && c.getCount()>0)
        {
            c.moveToFirst();
            do {
                tid = c.getString(0);
                Log.d("dbgetTidaneee", tid);
            } while (c.moveToNext());
        }
      return tid;
    }

    public String getMid() {
        String selectQuery = "SELECT "+ COL_MATCH_ID
                + " FROM " + TABLE_TID_MID;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String mid = null;
        Cursor c = null;
        c  = sqLiteDatabase.rawQuery(selectQuery, null);
        //Integer tid = c.getColumnIndex(getTid());
        if(c!=null && c.getCount()>0)
        {
            c.moveToFirst();
            do {
                mid = c.getString(0);
                Log.d("getMidmid indbh", mid);
            } while (c.moveToNext());
        }
        return mid;
    }

    public Cursor getAllTourneysforUI() {
        String selectQuery = "SELECT *"
                + " FROM " + TABLE_TOU;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();


        Cursor c = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            c  = sqLiteDatabase.rawQuery(selectQuery, null);
        }
        Log.d("getAllTourneysforUIdatabasexo", " "+COL_TO_DATE);
        return c;
    }

    public Cursor getAllMatches(String tid, String mid) {
        String selectQuery = "SELECT  * FROM " + TABLE_MAT
                            + " WHERE " + COL_MATCH_ID + " = " + mid
                            + " AND " + COL_TOU_ID + " = " + tid + " ;";
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Log.d("nuxxm0DB0s", COL_STADIUM);
        Cursor cM = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            cM  = sqLiteDatabase.rawQuery(selectQuery, null);
        }
        return cM;
    }

    public Cursor getAllMatchesforUI() {
        String selectQuery = "SELECT  * FROM " + TABLE_MAT;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cM = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            cM  = sqLiteDatabase.rawQuery(selectQuery, null);
        }
        return cM;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public int updateTous(Tournament tournament) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

       // values.put(KEY_ID, tournament.getTid());
        values.put(COL_NUM, tournament.getNum());
        values.put(COL_TOU_NAME, tournament.getTouName());
        values.put(COL_TOU_TYPE, tournament.getTouType());
        values.put(COL_TOU_COUNTRY, tournament.getTouCountry());
        values.put(COL_TO_DATE, tournament.getFromDate());
        values.put(COL_FROM_DATE, tournament.getToDate());
        values.put(COL_TO_TEAM_ONE, tournament.getTeamOne());
        values.put(COL_TO_TEAM_TWO, tournament.getTeamTwo());
        values.put(COL_TO_TEAM_THREE, tournament.getTeamThree());
        values.put(COL_TO_TEAM_FOUR, tournament.getTeamFour());
        values.put(COL_TO_TEAM_FIVE, tournament.getTeamFive());
        values.put(COL_TO_TEAM_SIX, tournament.getTeamSix());
        values.put(COL_TO_TEAM_SEVEN, tournament.getTeamSeven());
        values.put(COL_TO_TEAM_EIGHT, tournament.getTeamEight());


        // updating row
        return sqLiteDatabase.update(TABLE_TOU, values, KEY_ID + " = ?",
                new String[] { String.valueOf(tournament.getTouName()) });
    }

    public int updateMatches(Matches matches) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_MATCH_ID , matches.getMid());
        values.put(COL_MATCH_TYPE , matches.getMatchType());
        values.put(COL_MATCH_DATE , matches.getMatchdate());
        values.put(COL_STADIUM , matches.getStadium());
        values.put(COL_TEAM01  , matches.getTeam01());
        values.put(COL_TEAM02  , matches.getTeam02());
        values.put(COL_STATUS , matches.getStatus());



        // updating row
        return sqLiteDatabase.update(TABLE_MAT, values, COL_MATCH_ID + " = ?",
                new String[] { String.valueOf(matches.getMid()) });
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void deleteTous(String touName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_TOU, COL_TOU_NAME + " = ?",
                new String[] { String.valueOf(touName) });
    }



    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void closeDB() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen())
            sqLiteDatabase.close();
    }

}

