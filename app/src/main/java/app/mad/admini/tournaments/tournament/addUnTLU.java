package app.mad.admini.tournaments.tournament;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.TeamLineUp;
import app.mad.admini.tournaments.tournament.models.Tournament;

import static java.lang.Integer.parseInt;

public class addUnTLU extends AppCompatActivity {

    EditText mid, aTLU1, aTLU2, aTLU3, aTLU4, aTLU5, aTLU6, aTLU7, aTLU8, aTLU9, aTLU10, aTLU11;
    Button btn_tsub;
    public String matchID;
    String tidS;
    Tournament tournament;
    TeamLineUp teamLineUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_un_tlu);
        tournament = new Tournament();
        teamLineUp = new TeamLineUp();


        databaseHelper dbh;
        dbh = new databaseHelper(addUnTLU.this);

        aTLU1 = findViewById(R.id.aTLU1);
        aTLU2 = findViewById(R.id.aTLU2);
        aTLU3 = findViewById(R.id.aTLU3);
        aTLU4 = findViewById(R.id.aTLU4);
        aTLU5 = findViewById(R.id.aTLU5);
        aTLU6 = findViewById(R.id.aTLU6);
        aTLU7 = findViewById(R.id.aTLU7);
        aTLU8 = findViewById(R.id.aTLU8);
        aTLU9 = findViewById(R.id.aTLU9);
        aTLU10 = findViewById(R.id.aTLU10);
        aTLU11 = findViewById(R.id.aTLU11);
        btn_tsub = findViewById(R.id.btn_tsub);

        tidS = getIntent().getStringExtra("tid");

        teamLineUp.setTid(tidS);

        if(tidS == null && savedInstanceState != null){
            tidS = savedInstanceState.getString(tidS);
        }

        btn_tsub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View viewx) {


                databaseHelper dbh = new databaseHelper(addUnTLU.this);
                teamLineUp = new TeamLineUp(
                        "29",
                        aTLU1.getText().toString(),
                        aTLU2.getText().toString(),
                        aTLU3.getText().toString(),
                        aTLU4.getText().toString(),
                        aTLU5.getText().toString(),
                        aTLU6.getText().toString(),
                        aTLU7.getText().toString(),
                        aTLU8.getText().toString(),
                        aTLU9.getText().toString(),
                        aTLU10.getText().toString(),
                        aTLU11.getText().toString()
                );

                    dbh.addTLU(teamLineUp);
                Intent intent = new Intent(addUnTLU.this, aMatchDetails.class);
                startActivity(intent);
            }
        });


    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tid", tidS);
    }
}
