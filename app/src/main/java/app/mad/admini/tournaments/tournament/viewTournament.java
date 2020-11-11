package app.mad.admini.tournaments.tournament;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;

public class viewTournament extends AppCompatActivity {


    CardView cardView3for1;
    CardView cardView3for2;
    CardView cardView3for3;
    FloatingActionButton floatingActionButtonDelvt;

    String touName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_tournament);

        cardView3for1 = findViewById(R.id.cardViewTou);
        cardView3for2 = findViewById(R.id.cardViewMat);
        cardView3for3 = findViewById(R.id.cardViewTLU);
        floatingActionButtonDelvt = findViewById(R.id.floatingActionButtonDelvt);

        floatingActionButtonDelvt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tid = getIntent().getStringExtra("tid");
                String touName =getIntent().getStringExtra("touName");
                String num =getIntent().getStringExtra("num");
                String touType =getIntent().getStringExtra("touType");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                Integer teamOne =getIntent().getIntExtra("teamOne", 0);
                Integer teamTwo =getIntent().getIntExtra("teamTwo", 0);
                Integer teamThree =getIntent().getIntExtra("teamThree", 0);
                Integer teamFour =getIntent().getIntExtra("teamFour", 0);
                Integer teamFive =getIntent().getIntExtra("teamFive", 0);
                Integer teamSix =getIntent().getIntExtra("teamSix", 0);
                Integer teamSeven =getIntent().getIntExtra("teamSeven", 0);
                Integer teamEight =getIntent().getIntExtra("teamEight", 0);


                confirmDialog();


            }
        });



        cardView3for1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vTournamentDetails.class);

                String tid=getIntent().getStringExtra("tid");
                String num =getIntent().getStringExtra("num");
                String touName =getIntent().getStringExtra("touName");
                String touType =getIntent().getStringExtra("touType");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                Integer teamOne =getIntent().getIntExtra("teamOne", 0);
                Integer teamTwo =getIntent().getIntExtra("teamTwo", 0);
                Integer teamThree =getIntent().getIntExtra("teamThree", 0);
                Integer teamFour =getIntent().getIntExtra("teamFour", 0);
                Integer teamFive =getIntent().getIntExtra("teamFive", 0);
                Integer teamSix =getIntent().getIntExtra("teamSix", 0);
                Integer teamSeven =getIntent().getIntExtra("teamSeven", 0);
                Integer teamEight =getIntent().getIntExtra("teamEight", 0);
                Log.d("dino", ""+teamOne);

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

                Log.d("tidxo", "tid"+ tid);
                Log.d("numxo", "num"+ num);
                Log.d("touNamexo", "touName"+ touName);
                Log.d("touTypexo", "touType"+ touType);
                Log.d("touCountryxo", "touCountry"+ touCountry);
                Log.d("fromDatexo", "fromDate"+ fromDate);
                Log.d("toDatexo", "toDate"+ toDate);
            }
        });
        cardView3for2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vMatchDetails.class);

                String tid=getIntent().getStringExtra("tid");
                String num =getIntent().getStringExtra("num");
                String touName =getIntent().getStringExtra("touName");
                String touType =getIntent().getStringExtra("touType");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                Integer teamOne =getIntent().getIntExtra("teamOne", 0);
                Integer teamTwo =getIntent().getIntExtra("teamTwo", 0);
                Integer teamThree =getIntent().getIntExtra("teamThree", 0);
                Integer teamFour =getIntent().getIntExtra("teamFour", 0);
                Integer teamFive =getIntent().getIntExtra("teamFive", 0);
                Integer teamSix =getIntent().getIntExtra("teamSix", 0);
                Integer teamSeven =getIntent().getIntExtra("teamSeven", 0);
                Integer teamEight =getIntent().getIntExtra("teamEight", 0);
                Log.d("dino", ""+teamOne);

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

                Log.d("tidxo", "tid"+ tid);
                Log.d("numxo", "num"+ num);
                Log.d("touNamexo", "touName"+ touName);
                Log.d("touTypexo", "touType"+ touType);
                Log.d("touCountryxo", "touCountry"+ touCountry);
                Log.d("fromDatexo", "fromDate"+ fromDate);
                Log.d("toDatexo", "toDate"+ toDate);
            }
        });
        cardView3for3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vTLUDetails.class);

                String tid=getIntent().getStringExtra("tid");
                String num =getIntent().getStringExtra("num");
                String touName =getIntent().getStringExtra("touName");
                String touType =getIntent().getStringExtra("touType");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                Integer teamOne =getIntent().getIntExtra("teamOne", 0);
                Integer teamTwo =getIntent().getIntExtra("teamTwo", 0);
                Integer teamThree =getIntent().getIntExtra("teamThree", 0);
                Integer teamFour =getIntent().getIntExtra("teamFour", 0);
                Integer teamFive =getIntent().getIntExtra("teamFive", 0);
                Integer teamSix =getIntent().getIntExtra("teamSix", 0);
                Integer teamSeven =getIntent().getIntExtra("teamSeven", 0);
                Integer teamEight =getIntent().getIntExtra("teamEight", 0);
                Log.d("dino", ""+teamOne);

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

                Log.d("tidxo", "tid"+ tid);
                Log.d("numxo", "num"+ num);
                Log.d("touNamexo", "touName"+ touName);
                Log.d("touTypexo", "touType"+ touType);
                Log.d("touCountryxo", "touCountry"+ touCountry);
                Log.d("fromDatexo", "fromDate"+ fromDate);
                Log.d("toDatexo", "toDate"+ toDate);
            }
        });
    }


    void confirmDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + getIntent().getStringExtra("touName") + " ?");
        builder.setMessage("Are you sure?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseHelper dbh = new databaseHelper(viewTournament.this);
                dbh.deleteTous(getIntent().getStringExtra("touName"));
                Log.d("Delete?", "Is " +touName);
                finish();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }


}