package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

import static java.lang.Integer.parseInt;

public class vMatchDetails extends AppCompatActivity {

    ListView listMatch;
    String num, data;
    Integer meow, x, meowO;
    databaseHelper dbh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_match_details);

        listMatch = (ListView) findViewById(R.id.listMatch);
        ArrayList<String> arrayList = new ArrayList<>();

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

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listMatch.setAdapter(arrayAdapter);

        listMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent intent = new Intent(vMatchDetails.this, vUnMatch.class);

                num = getIntent().getStringExtra("num");


                String tid = getIntent().getStringExtra("tid");

                if(position == 0){
                    intent.putExtra("numpass", String.valueOf(1));
                }else if(position == 1){
                    intent.putExtra("numpass", String.valueOf(2));
                }else if(position == 2){
                    intent.putExtra("numpass", String.valueOf(3));
                }else if(position == 3){
                    intent.putExtra("numpass", String.valueOf(4));
                }else if(position == 4){
                    intent.putExtra("numpass", String.valueOf(5));
                }else if(position == 5){
                    intent.putExtra("numpass", String.valueOf(6));
                }else if(position == 6){
                    intent.putExtra("numpass", String.valueOf(7));
                }else if(position == 7){
                    intent.putExtra("numpass", String.valueOf(8));
                }


                intent.putExtra("tid", tid);
                startActivity(intent);

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
