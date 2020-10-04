package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.CustomAdapter;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

public class TournamentList extends AppCompatActivity {

    RecyclerView recyclerViewTL;
    FloatingActionButton addT_btn;

    databaseHelper dbh;
    ArrayList<String> touName, touCountry, fromDate, toDate, touType, num, tid;
    ArrayList<Integer> teamOne, teamTwo, teamThree, teamFour, teamFive, teamSix, teamSeven, teamEight;
    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tournament_list);

        recyclerViewTL = findViewById(R.id.recyclerViewTL);
        addT_btn       = findViewById(R.id.addT_btn);

        addT_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TournamentList.this, addTournamentDetails.class);
                startActivity(intent);
            }
        });



        dbh = new databaseHelper(TournamentList.this);
        tid        = new ArrayList<>();
        num        = new ArrayList<>();
        touName    = new ArrayList<>();
        touType    = new ArrayList<>();
        touCountry = new ArrayList<>();
        fromDate   = new ArrayList<>();
        toDate     = new ArrayList<>();
        teamOne    = new ArrayList<>();
        teamTwo    = new ArrayList<>();
        teamThree  = new ArrayList<>();
        teamFour   = new ArrayList<>();
        teamFive   = new ArrayList<>();
        teamSix    = new ArrayList<>();
        teamSeven  = new ArrayList<>();
        teamEight  = new ArrayList<>();

        storeDataInArray();

        customAdapter = new CustomAdapter(TournamentList.this, this,tid, num, touName, touType, touCountry, fromDate, toDate,
                teamOne, teamTwo, teamThree, teamFour, teamFive, teamSix, teamSeven, teamEight);
        recyclerViewTL.setAdapter(customAdapter);
        recyclerViewTL.setLayoutManager(new LinearLayoutManager(TournamentList.this));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            recreate();
        }
    }

    void storeDataInArray(){
        Cursor c = dbh.getAllTourneys();
        if(c.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else{
            while (c.moveToNext()){
                tid.add(c.getString(0));
                num.add(c.getString(1));
                touName.add(c.getString(2));
                touType.add(c.getString(3));
                touCountry.add(c.getString(4));
                fromDate.add(c.getString(5));
                toDate.add(c.getString(6));
                teamOne.add(c.getInt(7));
                teamTwo.add(c.getInt(8));
                teamThree.add(c.getInt(9));
                teamFour.add(c.getInt(10));
                teamFive.add(c.getInt(11));
                teamSix.add(c.getInt(12));
                teamSeven.add(c.getInt(13));
                teamEight.add(c.getInt(14));
            }
        }
        Log.d("dino1", ""+teamOne);


    }
}