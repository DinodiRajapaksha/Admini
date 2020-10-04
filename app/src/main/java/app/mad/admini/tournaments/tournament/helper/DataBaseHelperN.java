package app.mad.admini.tournaments.tournament.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.tournaments.tournament.models.Stadium;

public class DataBaseHelperN extends SQLiteOpenHelper {

    // DATABASE DETAILS

    private static final int version = 10;
    private static final String dbName = "Howzaat-N";
    private static final String tableName = "Stadium";
    private static final String tableMatch = "Matches";
    private static final String tableSummary = "Summary";
    private static final String tableScorecard = "Scorecard";

    // COLUMN NAMES FOR STADIUM

    private static final String StadiumID = "StadiumID";
    private static final String StadiumName = "StadiumName";
    private static final String Country = "Country";
    private static final String Location = "Location";
    private static final String Seats = "Seats";
    private static final String Size = "Size";
    private static final String StadiumInfo = "StadiumInfo";

    // COLUMN NAMES FOR MATCH

    private static final String MatchID = "MatchID";
    private static final String MatchType = "MatchType";
    private static final String Date = "Date";
    private static final String Stadium = "Stadium";
    private static final String Team1 = "Team1";
    private static final String Team2 = "Team2";
    private static final String Status = "Status";

    //COLUMN NAMES FOR SUMMARY

    private static final String SummaryID = "SummaryID";
    private static final String DateSum = "Date";
    private static final String LocationSum = "Location";
    private static final String Team1Sum = "Team1";
    private static final String Team2Sum = "Team2";
    private static final String ManOfMatch = "ManOfMatch";
    private static final String Winner = "Winner";


    public DataBaseHelperN(@Nullable Context context) {
        super(context, dbName, null, version);
    }


    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        // CREATE TABLE QUERY - STADIUM TABLE

        String CREATE_TABLE_STADIUM = "CREATE TABLE " + tableName + " "
                + "( "
                + StadiumID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + StadiumName + " TEXT, "
                + Country + " TEXT, "
                + Location + " TEXT, "
                + Seats + " INTEGER, "
                + Size + " INTEGER, "
                + StadiumInfo + " TEXT"
                + " );";


        // CREATE TABLE QUERY - MATCH TABLE
/*
        String CREATE_TABLE_MATCH = "CREATE TABLE " + tableMatch
                + " ( "
                + MatchID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MatchType + " TEXT, "
                + Date + " TEXT, "
                + Stadium + " TEXT, "
                + Team1 + " TEXT, "
                + Team2 + " TEXT, "
                + Status + " TEXT "
                + " );";


        //CREATE SUMMARY TABLE

        String CREATE_TABLE_SUMMARY = "CREATE TABLE " + tableSummary
                + " ( "
                + SummaryID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + DateSum + " TEXT, "
                + LocationSum + " TEXT, "
                + Team1Sum + " TEXT, "
                + Team2Sum + " TEXT, "
                + ManOfMatch + " TEXT, "
                + Winner + " TEXT "
                + " );";


        // INSERT TABLE QUERY - MATCH TABLE

        String INSERT_MATCH = "INSERT INTO " + tableMatch + "(" + MatchID + "," + MatchType + "," + Date + "," + Stadium + "," + Team1 + "," + Team2 + "," + Status + ")"
                + "VALUES('1','National','1/2/2012','Asgiriya','Sri Lanka','Australia','Incomplete'), "
                + "('2','National','3/10/2020','Galle Stadium','Sri Lanka','New Zealand','Incomplete'), "
                + "('3','National','23/4/2018','Pallakele','Sri Lanka','New Zealand','Incomplete'), "
                + "('4','National','6/12/2020','Pallekele','Sri Lanka','Australia','Complete'),"
                + "('5','National','23/12/2021','Pallekele','Sri Lanka','Australia','Complete');";

        // INSERT TO SUMMARY

        String INSERT_SUMMARY = "INSERT INTO " + tableSummary + "(" + SummaryID + "," + DateSum + "," + LocationSum + "," + Team1Sum + "," + Team2Sum + "," + ManOfMatch + "," + Winner + ")"
                + "VALUES('1','1/2/2012','Asgiriya','Sri Lanka','Australia','Lasith Malinga','Sri Lanka'), "
                + "('2','3/10/2020','Galle Stadium','Sri Lanka','New Zealand','Adam Milne','New Zealand'), "
                + "('3','23/4/2018','Pallakele','Sri Lanka','New Zealand','Angelo Mathhews','Sri Lanka'), "
                + "('4','6/12/2020','Pallekele','Sri Lanka','Australia','Travis Head','Austrailia'),"
                + "('5','23/12/2021','Pallekele','Sri Lanka','Australia','Steve Smith','Australia');";


*/


        // EXECUTE CREATE TABLE QUERY

        sqLiteDatabase.execSQL(CREATE_TABLE_STADIUM);
        //sqLiteDatabase.execSQL(CREATE_TABLE_MATCH);
        //sqLiteDatabase.execSQL(INSERT_MATCH);
      //  sqLiteDatabase.execSQL(CREATE_TABLE_SUMMARY);
       // sqLiteDatabase.execSQL(INSERT_SUMMARY);

    }


    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // DROP TABLE QUERY- STADIUM TABLE

        String DROP_TABLE_STADIUM = "DROP TABLE IF EXISTS " + tableName;

       // String DROP_TABLE_MATCH = "DROP TABLE IF EXISTS " + tableMatch;

        //String DROP_TABLE_SUMMARY = "DROP TABLE IF EXISTS " + tableSummary;


        // EXECUTE DROP TABLE

        sqLiteDatabase.execSQL(DROP_TABLE_STADIUM);
       // sqLiteDatabase.execSQL(DROP_TABLE_MATCH);
        //sqLiteDatabase.execSQL(DROP_TABLE_SUMMARY);

        // CREATE NEW TABLE - STADIUM

        onCreate(sqLiteDatabase);

    }


    // INSERT INTO TABLE FUNCTION
    public void addStadium(app.mad.admini.tournaments.tournament.models.Stadium St) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(StadiumName, St.getStadiumName());
        contentValues.put(Country, St.getCountry());
        contentValues.put(Location, St.getLocation());
        contentValues.put(Seats, St.getSeats());
        contentValues.put(Size, St.getSize());
        contentValues.put(StadiumInfo, St.getInformation());

        // INSERT INTO TABLE

        sqLiteDatabase.insert(tableName, null, contentValues);

        // CLOSE DB CONNECTION

        sqLiteDatabase.close();

    }


    // SELECT ALL STADIUMS IN COUNTRY (LIST)
    public List<Stadium> getAllStadiums() {

        List<Stadium> stadium = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String SELECT_ALL_QUERY = "SELECT * FROM " + tableName;

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_QUERY, null);

        if (cursor.moveToFirst()) {

            do {
                // create new stadium object

                Stadium stadiums = new Stadium();

                stadiums.setStadiumID(cursor.getInt(0));
                stadiums.setStadiumName(cursor.getString(1));
                stadiums.setCountry(cursor.getString(2));
                stadiums.setLocation(cursor.getString(3));
                stadiums.setSeats(cursor.getString(4));
                stadiums.setSize(cursor.getString(5));
                stadiums.setInformation(cursor.getString(6));

                stadium.add(stadiums);

            } while (cursor.moveToNext());
        }

        return stadium;
    }


    //DELETE STADIUM FROM RECORD
    public void deleteStadium(int id) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(tableName, StadiumID + " = ? ", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }


    // SELECT A SINGLE STATEMENT
    public Stadium getSingleStadium(int id) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(tableName, new String[]{StadiumID, StadiumName, Country, Location, Seats, Size, StadiumInfo}, StadiumID + " = ?", new String[]{String.valueOf(id)}, null, null, null);

        Stadium stadium;

        if (cursor != null) {

            cursor.moveToFirst();

            stadium = new Stadium(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)

            );
            return stadium;

        }

        return null;
    }


    // update stadium
    public int updateStadium(Stadium stadium) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(StadiumName, stadium.getStadiumName());
        contentValues.put(Country, stadium.getCountry());
        contentValues.put(Location, stadium.getLocation());
        contentValues.put(Seats, stadium.getSeats());
        contentValues.put(Size, stadium.getSize());
        contentValues.put(StadiumInfo, stadium.getInformation());

        int result = sqLiteDatabase.update(tableName, contentValues, StadiumID + " = ?", new String[]{String.valueOf(stadium.getStadiumID())});

        sqLiteDatabase.close();

        return result;
    }

/*
    // get all matches
    public List<Match> getAllMatches() {

        List<Match> match = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String SELECT_ALL_QUERY = "SELECT * FROM " + tableMatch;

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_QUERY, null);

        if (cursor.moveToFirst()) {

            do {
                // create new stadium object

                Match matches = new Match();

                matches.setMatchID(cursor.getInt(0));
                matches.setMatchType(cursor.getString(1));
                matches.setDate(cursor.getString(2));
                matches.setStadium(cursor.getString(3));
                matches.setTeam1(cursor.getString(4));
                matches.setTeam2(cursor.getString(5));
                matches.setStatus(cursor.getString(6));


                match.add(matches);

            } while (cursor.moveToNext());
        }

        return match;
    }


    // GET SINGLE MATCH

    public Match getSingleMatch(int id) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(tableMatch, new String[]{MatchID, MatchType, Date, Stadium, Team1, Team2, Status}, MatchID + " =?", new String[]{String.valueOf(id)}, null, null, null);

        Match match;

        if (cursor != null) {

            cursor.moveToFirst();

            match = new Match(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );

            return match;
        }

        return null;
    }


    //INSERT INTO SUMMARY
    public void addSummary(Summary summary) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(SummaryID, summary.getSummaryID());
        contentValues.put(DateSum, summary.getDate());
        contentValues.put(LocationSum, summary.getLocation());
        contentValues.put(Team1Sum, summary.getTeam1());
        contentValues.put(Team2Sum, summary.getTeam2());
        contentValues.put(ManOfMatch, summary.getManOfMatch());
        contentValues.put(Winner, summary.getManOfMatch());

        // INSERT INTO TABLE

        sqLiteDatabase.insert(tableSummary, null, contentValues);

        // CLOSE DB CONNECTION

        sqLiteDatabase.close();

    }


    //GET ONE SUMMARY

    public Summary getSingleSummary(int id) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(tableSummary, new String[]{SummaryID, DateSum, LocationSum, Team1Sum, Team2Sum, ManOfMatch, Winner}, SummaryID + " =?", new String[]{String.valueOf(id)}, null, null, null);

        Summary summary;

        if (cursor != null) {

            cursor.moveToFirst();

            summary = new Summary(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6)
            );

            return summary;
        }

        return null;
    }


    //UPDATE SUMMARY

    public int updateSummary(Summary summary) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DateSum, summary.getDate());
        contentValues.put(LocationSum, summary.getLocation());
        contentValues.put(Team1Sum, summary.getTeam1());
        contentValues.put(Team2Sum, summary.getTeam2());
        contentValues.put(ManOfMatch, summary.getManOfMatch());
        contentValues.put(Winner, summary.getWinner());

        int result = sqLiteDatabase.update(tableSummary, contentValues, SummaryID + " = ?", new String[]{String.valueOf(summary.getSummaryID())});

        sqLiteDatabase.close();

        return result;
    }


    public int updateMatchComplete(Match match) {

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(Status, "Completed");

        int result = sqLiteDatabase.update(tableMatch, contentValues, MatchID + " = ?", new String[]{String.valueOf(match.getMatchID())});

        sqLiteDatabase.close();

        return result;


    }

 */
}
