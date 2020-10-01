package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

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

        listMatch = findViewById(R.id.listMatch);

        Intent intent = new Intent(aMatchDetails.this, viewTournament.class);
        num =getIntent().getStringExtra("num");
        meow= parseInt(num);

        intent.putExtra("num", String.valueOf(num));
        Log.d("bleh", "too"+num);

        listMatch = findViewById(R.id.listMatch);
        //match_numb=
        ArrayAdapter<Integer> matchAdapter = new ArrayAdapter<>(this, R.layout.mat_row, meow);
        listMatch.setAdapter(matchAdapter);
        listMatch.setOnItemClickListener((AdapterView.OnItemClickListener) this);

        startActivity(intent);
    }
}
