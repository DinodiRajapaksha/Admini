package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

import app.mad.admini.R;

import static java.lang.Integer.parseInt;

public class aTLUDetails extends AppCompatActivity {

    ListView listTeam;
    Integer match_numb;
    String counter, tid;
    Integer counterI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_tlu_details);
        String matchid =getIntent().getStringExtra("matchID");
        counter =getIntent().getStringExtra("counter");
        tid =getIntent().getStringExtra("tid");
        counterI= parseInt(counter);

        Log.d("coco2", "teams"+counterI);
        Log.d("dino123", ""+tid);



        listTeam = (ListView)findViewById(R.id.listTeam);
        ArrayList<String > arrayList = new ArrayList<>();
        for(int x=1; x<=counterI; x++){

            arrayList.add("      Team "+x+" of "+counterI);
        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listTeam.setAdapter(arrayAdapter);

        listTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(aTLUDetails.this, addUnTLU.class);
                intent.putExtra("counter", String.valueOf(counter));

                String matchid =getIntent().getStringExtra("matchID");
                intent.putExtra("matchid", matchid);
                Log.d("cucukoko", "tid"+tid);
                startActivity(intent);
            }
        });
    }
}
