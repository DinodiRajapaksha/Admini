package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class vTournamentDetails extends AppCompatActivity {


    EditText txteditNamevt, txteditNumvt, txteditCountryvt, txteditTouvt;
    Button btnTEditV;
    TextView tdisplayDatevt;
    TextView tdisplayDatexvt;
    DatePickerDialog.OnDateSetListener tdateSetListenervt;
    DatePickerDialog.OnDateSetListener tdateSetListenerxvt;
    CheckBox teamOne, teamTwo, teamThree, teamFour, teamFive, teamSix, teamSeven, teamEight;

    databaseHelper dbh;

    String touNamevt, numvt, touCountryvt, fromDatevt, toDatevt, touTypevt, tid;
    Integer teamOneI, teamTwoI, teamThreeI, teamFourI, teamFiveI, teamSixI, teamSevenI, teamEightI;
    Boolean teamOneB, teamTwoB, teamThreeB, teamFourB, teamFiveB, teamSixB, teamSevenB, teamEightB;

    // Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_tournament_details);

        //dbh = new databaseHelper(getApplicationContext());


        txteditNamevt   = findViewById(R.id.teditNamevt);
        txteditTouvt    = findViewById(R.id.teditTouvt);
        txteditCountryvt= findViewById(R.id.teditCountryvt);
        txteditNumvt    = findViewById(R.id.teditNumvt);
        tdisplayDatevt  = findViewById(R.id.datetovtvt);
        tdisplayDatexvt = findViewById(R.id.datefromvtvt);
        teamOne       = (CheckBox)findViewById(R.id.teamOne);
        teamTwo       = (CheckBox)findViewById(R.id.teamTwo);
        teamThree     = (CheckBox)findViewById(R.id.teamThree);
        teamFour      = (CheckBox)findViewById(R.id.teamFour);
        teamFive      = (CheckBox)findViewById(R.id.teamFive);
        teamSix       = (CheckBox)findViewById(R.id.teamSix);
        teamSeven     = (CheckBox)findViewById(R.id.teamSeven);
        teamEight     = (CheckBox)findViewById(R.id.teamEight);

        btnTEditV    = findViewById(R.id.btnTEditV);

        btnTEditV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View viewx) {
                databaseHelper dbh = new databaseHelper(vTournamentDetails.this);
                Tournament tournament;

                tournament = new Tournament(
                        tid,
                        txteditNumvt.getText().toString(),
                        txteditNamevt.getText().toString(),
                        txteditCountryvt.getText().toString(),
                        txteditTouvt.getText().toString(),
                        tdisplayDatevt.getText().toString(),
                        tdisplayDatexvt.getText().toString(),
                        teamOneI, teamTwoI,teamThreeI, teamFourI,
                        teamFiveI, teamSixI, teamSevenI, teamEightI);

                while(teamOne.isChecked()){
                    teamOneB = true;
                    teamOneI = (teamOneB) ? 1 : 0;
                    tournament.setTeamOne(teamOneI);
                    break;
                }
                while(teamTwo.isChecked()){
                    teamTwoB = true;
                    teamTwoI = (teamTwoB) ? 1 : 0;
                    tournament.setTeamTwo(teamTwoI);
                    break;
                }
                while(teamThree.isChecked()){
                    teamThreeB = true;
                    teamThreeI = (teamThreeB) ? 1 : 0;
                    break;
                }
                while(teamFour.isChecked()){
                    teamFourB = true;
                    teamFourI = (teamFourB) ? 1 : 0;
                    break;
                }
                while(teamFive.isChecked()){
                    teamFiveB= true;
                    teamOneI = (teamOneB) ? 1 : 0;
                    break;
                }
                while(teamSix.isChecked()){
                    teamSixB= true;
                    teamSixI = (teamSixB) ? 1 : 0;
                    break;
                }
                while(teamSeven.isChecked()){
                    teamSevenB= true;
                    teamSevenI = (teamSevenB) ? 1 : 0;
                    break;
                }
                while(teamEight.isChecked()){
                    teamEightB= true;
                    teamEightI = (teamEightB) ? 1 : 0;
                    break;
                }

                dbh.updateTous(tournament);

                Intent intent = new Intent(vTournamentDetails.this, viewTournament.class);
                startActivity(intent);

            }
        });

        tdisplayDatexvt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int yearx  = cal.get(Calendar.YEAR);
                int monthx = cal.get(Calendar.MONTH);
                int dayx   = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialogx = new DatePickerDialog(
                        vTournamentDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        tdateSetListenerxvt,
                        yearx,monthx,dayx);
                dialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogx.show();
            }
        });

        tdateSetListenerxvt = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yearx, int monthx, int dayx) {
                monthx = monthx+1;

                String datex = monthx + "/" + dayx +"/" + yearx;
                tdisplayDatexvt.setText(datex);
            }
        };


        tdisplayDatevt.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day   = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        vTournamentDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        tdateSetListenervt,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        tdateSetListenervt = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;

                String date = month + "/" + day +"/" + year;
                tdisplayDatevt.setText(date);
            }
        };

        getsetIntentData();

        ActionBar ab = getSupportActionBar();
        if(ab != null){
            ab.setTitle(touNamevt);
        }


    }

    void getsetIntentData(){
        if(getIntent().hasExtra("num")
                && getIntent().hasExtra("touName")
                && getIntent().hasExtra("touType")
                && getIntent().hasExtra("touCountry")
                && getIntent().hasExtra("fromDate")
                && getIntent().hasExtra("toDate")
                && getIntent().hasExtra("teamOne")
                && getIntent().hasExtra("teamTwo")
                && getIntent().hasExtra("teamThree")
                && getIntent().hasExtra("teamFour")
                && getIntent().hasExtra("teamFive")
                && getIntent().hasExtra("teamSix")
                && getIntent().hasExtra("teamSeven")
                && getIntent().hasExtra("teamEight") ){

            //getData
            numvt        = getIntent().getStringExtra("num");
            touNamevt    = getIntent().getStringExtra("touName");
            touTypevt    = getIntent().getStringExtra("touType");
            touCountryvt = getIntent().getStringExtra("touCountry");
            fromDatevt   = getIntent().getStringExtra("fromDate");
            toDatevt     = getIntent().getStringExtra("toDate");
            teamOneI      =getIntent().getIntExtra("teamOne", 0);
            teamTwoI      =getIntent().getIntExtra("teamTwo", 0);
            teamThreeI    =getIntent().getIntExtra("teamThree", 0);
            teamFourI     =getIntent().getIntExtra("teamFour", 0);
            teamFiveI     =getIntent().getIntExtra("teamFive", 0);
            teamSixI      =getIntent().getIntExtra("teamSix", 0);
            teamSevenI    =getIntent().getIntExtra("teamSeven", 0);
            teamEightI    =getIntent().getIntExtra("teamEight", 0);


            //setData

            txteditNumvt.setText(numvt);
            txteditNamevt.setText(touNamevt);
            txteditTouvt.setText(touTypevt);
            txteditCountryvt.setText(touCountryvt);
            tdisplayDatexvt.setText(fromDatevt);
            tdisplayDatevt.setText(toDatevt);


            while(teamOneI==1){
                teamOne.setChecked(true);
                break;}
            while(teamTwoI==1){
                teamTwo.setChecked(true);
                break;}
            while(teamThreeI==1){
                teamThree.setChecked(true);
                break;}
            while(teamFourI==1){
                teamFour.setChecked(true);
                break;}
            while(teamFiveI==1){
                teamFive.setChecked(true);
                break;}
            while(teamSixI==1){
                teamSix.setChecked(true);
                break;}
            while(teamSevenI==1){
                teamSeven.setChecked(true);
                break;}
            while(teamEightI==1){
                teamEight.setChecked(true);
                break;}



        }else{
            Toast.makeText(this, "UH?", Toast.LENGTH_SHORT).show();
        }
    }
}
