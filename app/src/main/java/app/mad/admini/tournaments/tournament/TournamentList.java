package app.mad.admini.tournaments.tournament;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.CustomAdapter;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

public class TournamentList extends AppCompatActivity {

    RecyclerView recyclerViewTL;
    FloatingActionButton addT_btn;

    databaseHelper dbh;
    ArrayList<String> touName, touCountry, fromDate, toDate;
    ArrayList<Integer> num, tid;
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
        touCountry = new ArrayList<>();
        fromDate   = new ArrayList<>();
        toDate     = new ArrayList<>();

        storeDataInArray();

        customAdapter = new CustomAdapter(TournamentList.this, this,tid, num, touName, touCountry, fromDate, toDate);
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
               // tid.add(c.getInt(0));
                num.add(c.getInt(1));
                touName.add(c.getString(2));
                touCountry.add(c.getString(3));
                fromDate.add(c.getString(4));
                toDate.add(c.getString(5));
            }
        }
    }
}