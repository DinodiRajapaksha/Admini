package app.mad.admini.tournaments.tournament.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class databaseHelper extends SQLiteOpenHelper {


    //tables
    private static final String TABLE_TOU = "tournaments";
    private static final String TABLE_MAT = "matches";

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



    private static final String COL_MATCH_ID = "mid";
    private static final String COL_MATCH_TYPE = "matchType";
    private static final String COL_MATCH_DATE = "matchdate";
    private static final String COL_STADIUM = "stadium";
    private static final String COL_STATUS = "status";
    private static final String COL_TEAM01 = "team01";
    private static final String COL_TEAM02 = "team02";


    //create TABLE_TOU
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
            + COL_MATCH_TYPE + " TEXT,"
            + COL_MATCH_DATE + " TEXT,"
            + COL_STADIUM + " TEXT,"
            + COL_STATUS + " TEXT,"
            + COL_TEAM01 + " TEXT,"
            + COL_TEAM02 + " TEXT);";

    private Context context;


    public databaseHelper(@Nullable Context context) {
        super(context, "Howzaat.db", null, 1);
     //   this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        // creating required tables
        sqLiteDatabase.execSQL(CREATE_TABLE_TOU);
        sqLiteDatabase.execSQL(CREATE_TABLE_MAT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // on upgrade drop older tables
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_TOU);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_MAT);

        // create new tables
        onCreate(sqLiteDatabase);

    }

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

        values.put(COL_MATCH_ID , matches.getMid());
        values.put(COL_MATCH_TYPE , matches.getMatchType());
        values.put(COL_MATCH_DATE , matches.getMatchdate());
        values.put(COL_STADIUM , matches.getStadium());
        values.put(COL_STATUS , matches.getStatus());
        values.put(COL_TEAM01  , matches.getTeam01());
        values.put(COL_TEAM02  , matches.getTeam02());

        // insert row
        long insertMat = sqLiteDatabase.insert(TABLE_MAT, null, values);

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

    public Cursor getAllMatches() {
        String selectQuery = "SELECT  * FROM " + TABLE_MAT;
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cM = null;

        // looping through all rows and adding to list
        if (sqLiteDatabase != null) {
            cM  = sqLiteDatabase.rawQuery(selectQuery, null);
        }
        return cM;
    }


    public int updateTous(Tournament tournament) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_NUM, tournament.getNum());
        values.put(COL_TOU_NAME, tournament.getTouName());
        values.put(COL_TOU_TYPE, tournament.getTouType());
        values.put(COL_TOU_COUNTRY, tournament.getTouCountry());
        values.put(COL_FROM_DATE, tournament.getToDate());
        values.put(COL_TO_DATE, tournament.getFromDate());
        values.put(COL_TO_TEAM_ONE, tournament.getTeamOne());
        values.put(COL_TO_TEAM_TWO, tournament.getTeamTwo());
        values.put(COL_TO_TEAM_THREE, tournament.getTeamThree());
        values.put(COL_TO_TEAM_FOUR, tournament.getTeamFour());
        values.put(COL_TO_TEAM_FIVE, tournament.getTeamFive());
        values.put(COL_TO_TEAM_SIX, tournament.getTeamSix());
        values.put(COL_TO_TEAM_SEVEN, tournament.getTeamSeven());
        values.put(COL_TO_TEAM_EIGHT, tournament.getTeamEight());


        // updating row
        return sqLiteDatabase.update(TABLE_TOU, values, COL_TOU_NAME + " = ?",
                new String[] { String.valueOf(tournament.getTouName()) });
    }

    public int updateMatches(Matches matches) {

        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(COL_MATCH_ID , matches.getMid());
        values.put(COL_MATCH_TYPE , matches.getMatchType());
        values.put(COL_MATCH_DATE , matches.getMatchdate());
        values.put(COL_STADIUM , matches.getStadium());
        values.put(COL_STATUS , matches.getStatus());
        values.put(COL_TEAM01  , matches.getTeam01());
        values.put(COL_TEAM02  , matches.getTeam02());



        // updating row
        return sqLiteDatabase.update(TABLE_MAT, values, COL_MATCH_ID + " = ?",
                new String[] { String.valueOf(matches.getMid()) });
    }


    public void deleteTous(String touName) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_TOU, COL_TOU_NAME + " = ?",
                new String[] { String.valueOf(touName) });
    }


    public void deleteMatches(String mid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.delete(TABLE_MAT, COL_MATCH_ID + " = ?",
                new String[] { String.valueOf(mid) });
    }


    public void closeDB() {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        if (sqLiteDatabase != null && sqLiteDatabase.isOpen())
            sqLiteDatabase.close();
    }

}

