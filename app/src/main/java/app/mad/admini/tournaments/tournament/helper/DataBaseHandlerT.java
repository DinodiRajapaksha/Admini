package app.mad.admini.tournaments.tournament.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.tournaments.tournament.models.Player;
import app.mad.admini.tournaments.tournament.models.Teams;
import app.mad.admini.tournaments.tournament.models.User;

public class DataBaseHandlerT extends SQLiteOpenHelper {

    //DataBase Details

    private static final int version = 7;
    private static final String DBName = "MADProjectT";
    private static final String TableName = "Teams";
    private static final String TABLE_NAME_PLAYERPROFODI = "Player";
    private static final String TABLE_USER= "User";
    private static final String TABLE_ADMIN= "Admin";

    // Column Names for Teams table

    private static final String TeamId = "TeamId";
    private static final String TeamName = "TeamName";
    private static final String Category = "Category";
    private static final String BatsmenNo = "BatsmenNo";
    private static final String BowlerNo = "BowlerNo";
    private static final String AllRounderNo = "AllRounderNo";
    private static final String WKNo = "WKNo";



    // column names for Player

    private static final String PID = "PID";
    private static final String PROFILE_IMAGE = "PROFILE_IMAGE";
    private static final String PNAME= "PNAME";
    private static final String AGE= "AGE";
    private static final String TEAMS= "TEAMS";
    private static final String ROLE= "ROLE";
    private static final String BAT_MATCHES= "BAT_MATCHES";
    private static final String BAT_INNINGS= "BAT_INNINGS";
    private static final String NOTOUTS= "NOTOUTS";
    private static final String RUNS= "RUNS";
    private static final String BF= "BF";
    private static final String HS= "HS";
    private static final String BAT_AVE= "BAT_AVE";
    private static final String BAT_SR= "BAT_SR";
    private static final String SFIFTY= "SFIFTY";
    private static final String SHUNDRED= "SHUNDRED";
    private static final String BO_MATCHES= "BO_MATCHES";
    private static final String BO_INNINGS= "BO_INNINGS";
    private static final String BO_BALLS= "BO_BALLS";
    private static final String BO_RUNS= "BO_RUNS";
    private static final String WKTS= "WKTS";
    private static final String BBM= "BBM";
    private static final String BO_AVE= "BO_AVE";
    private static final String ECON= "ECON";
    private static final String SR= "SR";


    // column names for user
    private static final String userId = "userId";
    private static final String username = "username";
    private static final String password = "password";
    private static final String email = "email";
    private static final String country = "country";


    //column names for admin
    private static final String AdminId= "AdminId";
    private static final String Username="username";
    private static final String Password="Password";


    // CREATE TABLE STATEMENT

    String CREATE_TABLE = "CREATE TABLE " + TableName + " " +
            "("
            + TeamId + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + TeamName + " TEXT, "
            + Category + " TEXT, "
            + BatsmenNo + " INTEGER, "
            + BowlerNo + " INTEGER, "
            + AllRounderNo + " INTEGER, "
            + WKNo + " INTEGER " +
            ");" ;



    // CREATE TABLE PLAYER

    String PLAYERODI_TABLE_CREATE = "CREATE TABLE "+ TABLE_NAME_PLAYERPROFODI+" "+
            "("
            +PID+" INTEGER PRIMARY KEY "+" AUTOINCREMENT,"
            //+PROFILE_IMAGE+ " BLOB,"
            +PNAME+ " TEXT,"
            +AGE+ " INTEGER,"
            +TEAMS+ " TEXT,"
            +ROLE+ " TEXT,"
            +BAT_MATCHES+ " INTEGER,"
            +BAT_INNINGS+ " INTEGER,"
            +NOTOUTS+ " INTEGER,"
            +RUNS+ " INTEGER,"
            +BF+ " INTEGER,"
            +HS+ " INTEGER,"
            +BAT_AVE+ " FLOAT,"
            +BAT_SR+ " FLOAT,"
            +SFIFTY+ " FLOAT,"
            +SHUNDRED+ " FLOAT,"
            +BO_MATCHES+ " INTEGER,"
            +BO_INNINGS+ " INTEGER,"
            +BO_BALLS+ " INTEGER,"
            +BO_RUNS+ " INTEGER,"
            +WKTS+ " INTEGER,"
            +BBM+ " INTEGER,"
            +BO_AVE+ " FLOAT,"
            +ECON+ " FLOAT,"
            +SR+ " FLOAT"
            +");";


    //Create table User

    String TABLE_USER_CREATE ="CREATE TABLE "+TABLE_USER+" "+"( "
            +userId+" INTEGER PRIMARY KEY "+"AUTOINCREMENT,"
            +username+" TEXT,"
            +password+" TEXT,"
            +email+" TEXT,"
            +country+" TEXT"
            +" );";

    //CREATE ADMIN
    String TABLE_ADMIN_CREATE ="CREATE TABLE "+TABLE_ADMIN+"( "
            +AdminId+" INTEGER PRIMARY KEY "+"AUTOINCREMENT,"
            +username+" TEXT,"
            +password+" TEXT"
            +" );";


    //INSERT STATEMENT
    String INSERT_ADMIN = "INSERT INTO " + TABLE_ADMIN+"(AdminId,Username,Password)"
            +"VALUES" + "('1','Tharu98','Tharu98pw'),"
            +"('2','Nishadi99','Nishadi99pw'),"
            +"('3','Dinodi95','Dinodi95pw'),"
            +"('4','Sewmini99','Sewmini99pw');";


    // INSERT STATEMENT

    String INSERT_PLAYER = "INSERT INTO " + TABLE_NAME_PLAYERPROFODI + "(PID,PNAME,AGE,TEAMS,ROLE,BAT_MATCHES,BAT_INNINGS,NOTOUTS,RUNS,BF,HS,BAT_AVE,BAT_SR,SFIFTY,SHUNDRED,BO_MATCHES,BO_INNINGS,BO_BALLS,BO_RUNS,WKTS,BBM,BO_AVE,ECON,SR)"
            + "VALUES" + "('01','Dimuth =Karunarathna','32','Sri Lanka','Captain','66','128','5','4524','9263','196','36.8','48.8','24','9','66','11','237','149','2','1/12','74.5','3.77','118.5'), " +
            "('02','Lasith Malinga','37','Sri Lanka','Bowler','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('03','Anjelo Mathews','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('04','Thissara Perera','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('05','Kusal Mendis','37','Sri Lanka','Wicket Interface','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('06','Avishka Fernando','37','Sri Lanka','Batsman','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('07','Lahiru Thirimanna','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('08','Suranga Lakmal','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('09','Isuru Udana','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('10','Dhananjaya De Silva','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6')," +
            "('11','Jeewan Mendis','37','Sri Lanka','All Rounder','30','37','13','275','75','64','11.4','44.5','1','0','30','59','5209','3349','101','5/50','33.1','3.85','51.6');" ;


    public DataBaseHandlerT(@Nullable Context context) {
        super(context, DBName, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


            // EXECUTE CREATE TABLE

            sqLiteDatabase.execSQL(CREATE_TABLE);

            //EXECUTE PLAYER TABLE

             sqLiteDatabase.execSQL(PLAYERODI_TABLE_CREATE);

             sqLiteDatabase.execSQL(INSERT_PLAYER);

             //EXECUTE USER TABLE

            sqLiteDatabase.execSQL(TABLE_USER_CREATE);

            //EXECUTE ADMIN TABLE

             sqLiteDatabase.execSQL(TABLE_ADMIN_CREATE);

             sqLiteDatabase.execSQL(INSERT_ADMIN);


    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        // DROP TABLE STATEMENT

        String DROP_TABLE = "DROP TABLE IF EXISTS " + TableName;

        String DROP_TABLE_PLAYER = "DROP TABLE IF EXISTS " + TABLE_NAME_PLAYERPROFODI;


        // EXECUTE DROP TABLE

        sqLiteDatabase.execSQL(DROP_TABLE);

        sqLiteDatabase.execSQL(DROP_TABLE_PLAYER);

        // CREATE NEW TABLE

        onCreate(sqLiteDatabase);

    }


    public void insertTeam(Teams teams) {
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        //contentValues.put(TeamId,teams.getTeamId());
        contentValues.put(TeamName,teams.getTeamName());
        contentValues.put(Category,teams.getCategory());
        contentValues.put(BatsmenNo,teams.getBatsmenNo());
        contentValues.put(BowlerNo,teams.getBowlerNo());
        contentValues.put(AllRounderNo,teams.getAllRounderNo());
        contentValues.put(WKNo,teams.getWKNo());

        sqLiteDatabase.insert(TableName,null,contentValues);

        sqLiteDatabase.close();




    }

    // select all into a list
    public List<Teams> getAllTeams() {
        List<Teams> Teams = new ArrayList();
        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String query="SELECT * FROM " + TableName;
        Cursor cursor = sqLiteDatabase.rawQuery(query,null);
        if(cursor.moveToFirst()) {
            do{
                //create new Team object
                Teams teams = new Teams();
                teams.setTeamId(cursor.getInt(0));
                teams.setTeamName(cursor.getString(1));
                teams.setCategory(cursor.getString(2));
                teams.setBatsmenNo(cursor.getInt(3));
                teams.setBowlerNo(cursor.getInt(4));
                teams.setAllRounderNo(cursor.getInt(5));
                teams.setWKNo(cursor.getInt(6));

                Teams.add(teams);

            }
            while(cursor.moveToNext());
        }

        return Teams;


    }

    // Delete

    public void deleteTeam(int id){

        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        sqLiteDatabase.delete(TableName, TeamId + " =?",new String[] {String.valueOf(id)});
        sqLiteDatabase.close();
    }

    public int updateTeams(Teams teams){
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TeamName,teams.getTeamName());
        contentValues.put(Category,teams.getCategory());
        contentValues.put(BatsmenNo,teams.getBatsmenNo());
        contentValues.put(BowlerNo,teams.getBowlerNo());
        contentValues.put(AllRounderNo,teams.getAllRounderNo());
        contentValues.put(WKNo,teams.getWKNo());

        int status = sqLiteDatabase.update(TableName,contentValues,TeamId + " = ?", new String[] {String.valueOf(teams.getTeamId())} );

        sqLiteDatabase.close();
        return status;
    }

    public Teams getSingleTeam(int id){

        SQLiteDatabase sqLiteDatabase = getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query(TableName,new String[] {TeamId,TeamName,Category,BatsmenNo,BowlerNo,AllRounderNo,WKNo},TeamId + " =?",new String[] {String.valueOf(id)},null,null,null);

        Teams team;

        if(cursor!=null){

            cursor.moveToFirst();

            team = new Teams(

                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getInt(3),
                    cursor.getInt(4),
                    cursor.getInt(5),
                    cursor.getInt(6)

            );

            return team;
        }
        return null;
    }

    // SELECT ALL ITEMS IN PLAYER TABLE

    public List<Player> getAllPlayers(){

        List<Player> player = new ArrayList<>();

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();

        String query = "SELECT * FROM "  + TABLE_NAME_PLAYERPROFODI;

        Cursor cursor = sqLiteDatabase.rawQuery(query,null);

        if(cursor.moveToFirst()){

            do{
                Player players = new Player();

                players.setPid(cursor.getInt(0));
                players.setName(cursor.getString(1));
                players.setAge(cursor.getInt(2));
                players.setTeams(cursor.getString(3));
                players.setTmatches(cursor.getInt(4));
                players.setTinnings(cursor.getInt(5));
                players.setNotout(cursor.getInt(6));
                players.setTruns(cursor.getInt(7));
                players.setBf(cursor.getInt(8));
                players.setHs(cursor.getInt(9));
                players.setTaverage(cursor.getFloat(10));
                players.setTsr(cursor.getFloat(11));
                players.setS50(cursor.getInt(12));
                players.setS100(cursor.getInt(13));
                players.setBmatches(cursor.getInt(14));
                players.setBinnings(cursor.getInt(15));
                players.setBalls(cursor.getInt(16));
                players.setBruns(cursor.getInt(17));
                players.setWkts(cursor.getInt(18));
                players.setBbm(cursor.getInt(19));
                players.setBaverage(cursor.getFloat(20));
                players.setEconomy(cursor.getFloat(21));
                players.setBsr(cursor.getFloat(22));



                 player.add(players);

            }while(cursor.moveToNext());

            return player;
        }

        return null;
    }

   public void addUser (User user) {
        SQLiteDatabase sqLiteDatabase=getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(username,user.getUsername());
       contentValues.put(email,user.getEmail());
       contentValues.put(country,user.getCountry());
       contentValues.put(password,user.getPassword());


        sqLiteDatabase.insert(TABLE_USER,null,contentValues);
       sqLiteDatabase.close();

   }


   public boolean validateUser(String un, String pw){

        SQLiteDatabase sqLiteDatabase = getReadableDatabase();
        String[] column = {"username"};

        Cursor cursor = sqLiteDatabase.query(TABLE_USER,column,"username = ? and password = ?", new String[] {un,pw},null,null,null);

       int count = cursor.getCount();

       cursor.close();
       close();

       if(count > 0){
           return true;
       } else {
           return false;
       }
   }




}
