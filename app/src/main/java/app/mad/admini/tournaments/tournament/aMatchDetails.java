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

public class aMatchDetails extends AppCompatActivity {

    ListView listMatch;
    Integer match_numb;
    String num;
    Integer meow=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a_match_details);

        num =getIntent().getStringExtra("num");
        meow= parseInt(num);

        Log.d("blehxoxo", "too"+meow);

        listMatch = (ListView)findViewById(R.id.listMatch);
        ArrayList<String > arrayList = new ArrayList<>();
        for(int x=1; x<=meow; x++){

            arrayList.add("      Match "+x+" of "+meow);
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,arrayList);
        listMatch.setAdapter(arrayAdapter);

        listMatch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(aMatchDetails.this, vUnMatch.class);
                intent.putExtra("num", String.valueOf(num));
                Log.d("blehxx", "too"+num);
                startActivity(intent);
            }
        });
    }
}
