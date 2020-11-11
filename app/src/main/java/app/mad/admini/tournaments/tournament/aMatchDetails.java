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
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.Tournament;

import static app.mad.admini.tournaments.tournament.viewForTwo.INSTANCE;
import static java.lang.Integer.parseInt;

public class aMatchDetails extends AppCompatActivity {

    String data;
    ListView listMatch;
    Integer match_numb;
    String num, tid, number;
    Integer meow, mid, x, meowO;
    Integer[] arr;
    static aMatchDetails INSTANCE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        INSTANCE=this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_match_details);
        tid =viewForTwo.getActivityInstance().getData();
        final databaseHelper dbh = new databaseHelper(aMatchDetails.this);
        final Matches matches;
        matches = new Matches();


        //tid = dbh.getTid();
        number = dbh.getNumFromTid(tid);
        //num =getIntent().getStringExtra("num");
        meow= parseInt(number);

        listMatch = findViewById(R.id.listMatch);
        ArrayList<String > arrayList = new ArrayList<>();

        meowO = 2;
        for (x = 1; x <= meowO; x++) {
            num = getIntent().getStringExtra("num");

            arrayList.add("      Match " + x );
            try {
                meow = parseInt(num);
            }catch(NumberFormatException ex){

            }
            if(meowO==2){
                meowO=meow;
            }

        }

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listMatch.setAdapter(arrayAdapter);

        listMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(aMatchDetails.this, addUnMatch.class);
                num = getIntent().getStringExtra("num");

                tid = getIntent().getStringExtra("tid");

                if(position == 0){
                    intent.putExtra("num", String.valueOf(1));
                    intent.putExtra("tid", tid);
                }else if(position == 1){
                    intent.putExtra("num", String.valueOf(2));
                    intent.putExtra("tid", tid);
                }else if(position == 2){
                    intent.putExtra("num", String.valueOf(3));
                    intent.putExtra("tid", tid);
                }else if(position == 3){
                    intent.putExtra("num", String.valueOf(4));
                    intent.putExtra("tid", tid);
                }else if(position == 4){
                    intent.putExtra("num", String.valueOf(5));
                    intent.putExtra("tid", tid);
                }else if(position == 5){
                    intent.putExtra("num", String.valueOf(6));
                    intent.putExtra("tid", tid);
                }else if(position == 6){
                    intent.putExtra("num", String.valueOf(7));
                    intent.putExtra("tid", tid);
                }else if(position == 7){
                    intent.putExtra("num", String.valueOf(8));
                    intent.putExtra("tid", tid);
                }



                startActivity(intent);
            }
        });
    }
    public static aMatchDetails getActivityInstance()
    {
        return INSTANCE;
    }

    public String getData()
    {
        Log.d("pass", tid);
        return this.tid;
    }

    public String getNum()
    {
        Log.d("passnum", num);
        return this.num;
    }
}
