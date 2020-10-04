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

import static java.lang.Integer.parseInt;

public class vMatchDetails extends AppCompatActivity {

    ListView listMatch;
    Integer match_numb;
    String num;
    Integer meow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_match_details);

        num = getIntent().getStringExtra("num");
        meow = parseInt(num);

        Log.d("blehxoxo", "too" + meow);




        listMatch = (ListView) findViewById(R.id.listMatch);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int x = 1; x <= meow; x++) {

            arrayList.add("      Match " + x + " of " + meow);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listMatch.setAdapter(arrayAdapter);

        listMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(vMatchDetails.this, vUnMatch.class);


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

                Log.d("tidxo", "tid" + tid);
                Log.d("numxo", "num" + num);
                Log.d("touNamexo", "touName" + touName);
                Log.d("touTypexo", "touType" + touType);
                Log.d("touCountryxo", "touCountry" + touCountry);
                Log.d("fromDatexo", "fromDate" + fromDate);
                Log.d("toDatexo", "toDate" + toDate);

                intent.putExtra("num", String.valueOf(num));
                Log.d("blehxx", "too" + num);
                startActivity(intent);
            }
        });
    }
}
