package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

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
                String touName =getIntent().getStringExtra("touName");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                String num =getIntent().getStringExtra("num");


                confirmDialog();


            }
        });

        cardView3for1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vTournamentDetails.class);

                String touName =getIntent().getStringExtra("touName");
                String touCountry =getIntent().getStringExtra("touCountry");
                String fromDate =getIntent().getStringExtra("fromDate");
                String toDate =getIntent().getStringExtra("toDate");
                String num =getIntent().getStringExtra("num");

                intent.putExtra("num", String.valueOf(num));
                intent.putExtra("touName", String.valueOf(touName));
                intent.putExtra("touCountry", String.valueOf(touCountry));
                intent.putExtra("fromDate", String.valueOf(fromDate));
                intent.putExtra("toDate", String.valueOf(toDate));

                startActivity(intent);

                Log.d("tash", "huh"+ touCountry);
            }
        });
        cardView3for2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vMatchDetails.class);
                startActivity(intent);
            }
        });
        cardView3for3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(viewTournament.this, vTLUDetails.class);
                startActivity(intent);
            }
        });
    }


    void confirmDialog () {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete " + getIntent().getStringExtra("touName") + " ?");
        builder.setMessage("Sure you wanna go there?");
        builder.setPositiveButton("Yeah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                databaseHelper dbh = new databaseHelper(viewTournament.this);
                dbh.deleteTous(getIntent().getStringExtra("touName"));
                Log.d("Delete?", "Is " +touName);
                finish();
            }
        });
        builder.setNegativeButton("Nah", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.create().show();
    }

}