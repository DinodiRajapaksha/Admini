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

     private static final int version = 2 ;
     private static final String dbName = "Howzaat-N";
     private static final String tableName = "Stadium";
     private static final String tableMatch = "Matches";

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

        String CREATE_TABLE_MATCH = "CREATE TABLE " + tableMatch
                + " ( "
                + MatchID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + MatchType + " TEXT, "
                + Date + " TEXT, "
                + Stadium + " TEXT, "
                +Team1 + " TEXT, "
                +Team2 + " TEXT "
                + " );";

        // INSERT TABLE QUERY - MATCH TABLE

        String INSERT_MATCH = "INSERT INTO " + tableMatch +"(" + MatchID +","+ MatchType + ","+ Date + ","+ Stadium + ","+ Team1 + ","+ Team2 + ")"
                + "VALUES('1','National','1/2/12','Asgiriya','Sri Lanka','Australia'), "
                + "('2','National','23/4/18','Pallakele','Sri Lanka','New Zealand'), "
                + "('3','National','6/12/20','Pallekele','Sri Lanka','Australia');";




        // EXECUTE CREATE TABLE QUERY

        sqLiteDatabase.execSQL(CREATE_TABLE_STADIUM);
        sqLiteDatabase.execSQL(CREATE_TABLE_MATCH);
        sqLiteDatabase.execSQL(INSERT_MATCH);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // DROP TABLE QUERY- STADIUM TABLE

        String DROP_TABLE_STADIUM = "DROP TABLE IF EXISTS " + tableName;

        // EXECUTE DROP TABLE

        sqLiteDatabase.execSQL(DROP_TABLE_STADIUM);

        // CREATE NEW TABLE - STADIUM

        onCreate(sqLiteDatabase);

    }

    // INSERT INTO TABLE FUNCTION

    public void addStadium(app.mad.admini.tournaments.tournament.models.Stadium St){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(StadiumName,St.getStadiumName());
        contentValues.put(Country,St.getCountry());
        contentValues.put(Location,St.getLocation());
        contentValues.put(Seats,St.getSeats());
        contentValues.put(Size,St.getSize());
        contentValues.put(StadiumInfo,St.getInformation());

        // INSERT INTO TABLE

        sqLiteDatabase.insert(tableName,null,contentValues);

        // CLOSE DB CONNECTION

        sqLiteDatabase.close();

    }

    // SELECT ALL STADIUMS IN COUNTRY (LIST)

    public List<Stadium> getAllStadiums(){

        List<Stadium> stadium = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String SELECT_ALL_QUERY = "SELECT * FROM " + tableName;

        Cursor cursor = sqLiteDatabase.rawQuery(SELECT_ALL_QUERY,null);

        if(cursor.moveToFirst()){

            do{
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

            }while(cursor.moveToNext());
        }

        return stadium;
    }

    //DELETE STADIUM FROM RECORD

    public void deleteStadium(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        sqLiteDatabase.delete(tableName,StadiumID + " = ? ", new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
    }

    // SELECT A SINGLE STATEMENT

    public Stadium getSingleStadium(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(tableName,new String[] {StadiumID,StadiumName,Country,Location,Seats,Size,StadiumInfo},StadiumID + " = ?",new String[] {String.valueOf(id)},null,null,null);

        Stadium stadium;

        if(cursor != null){

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

    public int updateStadium(Stadium stadium){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(StadiumName, stadium.getStadiumName());
        contentValues.put(Country, stadium.getCountry());
        contentValues.put(Location, stadium.getLocation());
        contentValues.put(Seats, stadium.getSeats());
        contentValues.put(Size, stadium.getSize());
        contentValues.put(StadiumInfo, stadium.getInformation());

        int result = sqLiteDatabase.update(tableName,contentValues,StadiumID + " = ?", new String[] {String.valueOf(stadium.getStadiumID())});

        sqLiteDatabase.close();

        return result;
    }


}
