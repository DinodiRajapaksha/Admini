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
import app.mad.admini.tournaments.tournament.models.TeamLineUp;

public class vTLUDetails extends AppCompatActivity {

    ListView listTeam;
    Integer counterI=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_tlu_details);



        listTeam = (ListView)findViewById(R.id.listTeamv);
        ArrayList<String > arrayListv = new ArrayList<>();


        //TeamLineUp.co=counterI;

        Log.d("coco2", "teams"+counterI);


        for(int x=1; x<=2; x++){

            arrayListv.add("      Team "+x+" of "+2);
        }


        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayListv);
        listTeam.setAdapter(arrayAdapter);

        listTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(vTLUDetails.this, vUnTLU.class);

                String tid = getIntent().getStringExtra("tid");
                String num = getIntent().getStringExtra("num");
                String touName = getIntent().getStringExtra("touName");
                String touType = getIntent().getStringExtra("touType");
                String touCountry = getIntent().getStringExtra("touCountry");
                String fromDate = getIntent().getStringExtra("fromDate");
                String toDate = getIntent().getStringExtra("toDate");
                Integer teamOne = getIntent().getIntExtra("teamOne", 0);
                Integer teamTwo = getIntent().getIntExtra("teamTwo", 0);
                Integer teamThree = getIntent().getIntExtra("teamThree", 0);
                Integer teamFour = getIntent().getIntExtra("teamFour", 0);
                Integer teamFive = getIntent().getIntExtra("teamFive", 0);
                Integer teamSix = getIntent().getIntExtra("teamSix", 0);
                Integer teamSeven = getIntent().getIntExtra("teamSeven", 0);
                Integer teamEight = getIntent().getIntExtra("teamEight", 0);
                Log.d("dino", "" + teamOne);

                intent.putExtra("tid", tid);
                intent.putExtra("num", String.valueOf(num));
                intent.putExtra("touName", String.valueOf(touName));
                intent.putExtra("touType", String.valueOf(touType));
                intent.putExtra("touCountry", String.valueOf(touCountry));
                intent.putExtra("fromDate", String.valueOf(fromDate));
                intent.putExtra("toDate", String.valueOf(toDate));
                intent.putExtra("teamOne", (teamOne));
                intent.putExtra("teamTwo", (teamTwo));
                intent.putExtra("teamThree", (teamThree));
                intent.putExtra("teamFour", (teamFour));
                intent.putExtra("teamFive", (teamFive));
                intent.putExtra("teamSix", (teamSix));
                intent.putExtra("teamSeven", (teamSeven));
                intent.putExtra("teamEight", (teamEight));

                startActivity(intent);

            }
        });
    }
}