package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class addTournamentDetails extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText txteditName, txteditNum, txteditCountry;
    Button btnTSubmit;
    TextView tdisplayDate;
    TextView tdisplayDatex;
    DatePickerDialog.OnDateSetListener tdateSetListener;
    DatePickerDialog.OnDateSetListener tdateSetListenerx;
    Spinner spinner;
    CheckBox teamOne, teamTwo, teamThree, teamFour, teamFive, teamSix, teamSeven, teamEight;
    Boolean teamOneB, teamTwoB, teamThreeB, teamFourB, teamFiveB, teamSixB, teamSevenB, teamEightB;
    Integer teamOneI, teamTwoI, teamThreeI, teamFourI, teamFiveI, teamSixI, teamSevenI, teamEightI;


    String touType,tid;

    databaseHelper dbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tournament_details);

        //dbh = new databaseHelper(getApplicationContext());

        spinner       = findViewById(R.id.spinnerxo);

        txteditName   = findViewById(R.id.teditName);
        txteditCountry= findViewById(R.id.teditCountry);
        txteditNum    = findViewById(R.id.teditNum);
        tdisplayDate  = (TextView) findViewById(R.id.dateto);
        tdisplayDatex = (TextView) findViewById(R.id.datefrom);
        teamOne       = (CheckBox)findViewById(R.id.teamOne);
        teamTwo       = (CheckBox)findViewById(R.id.teamTwo);
        teamThree     = (CheckBox)findViewById(R.id.teamThree);
        teamFour      = (CheckBox)findViewById(R.id.teamFour);
        teamFive      = (CheckBox)findViewById(R.id.teamFive);
        teamSix       = (CheckBox)findViewById(R.id.teamSix);
        teamSeven     = (CheckBox)findViewById(R.id.teamSeven);
        teamEight     = (CheckBox)findViewById(R.id.teamEight);

        btnTSubmit    = findViewById(R.id.btnTSubmit);

        btnTSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View viewx) {
                databaseHelper dbh = new databaseHelper(addTournamentDetails.this);
                Tournament tournament;
                while(teamOne.isChecked()){
                    teamOneB = true;
                    teamOneI = (teamOneB) ? 1 : 0;
                    break;
                }
                while(teamTwo.isChecked()){
                    teamTwoB = true;
                    teamTwoI = (teamTwoB) ? 1 : 0;
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

                tournament = new Tournament(
                        tid,
                        txteditNum.getText().toString(),
                        txteditName.getText().toString(),
                        touType,
                        txteditCountry.getText().toString(),
                        tdisplayDate.getText().toString(),
                        tdisplayDatex.getText().toString(),
                        teamOneI, teamTwoI, teamThreeI, teamFourI,
                        teamFiveI, teamSixI, teamSevenI, teamEightI);

                String num = txteditNum.getText().toString();

                Log.d("teamsss", String.valueOf(teamOneI));
                Log.d("teamsss", String.valueOf(teamOneB));

                dbh.addTou(tournament);

                Intent intent = new Intent(addTournamentDetails.this, viewForTwo.class);
                intent.putExtra("num", num);
                startActivity(intent);

            }
        });

        tdisplayDatex.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int yearx  = cal.get(Calendar.YEAR);
                int monthx = cal.get(Calendar.MONTH);
                int dayx   = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialogx = new DatePickerDialog(
                        addTournamentDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        tdateSetListenerx,
                        yearx,monthx,dayx);
                dialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogx.show();
            }
        });

        tdateSetListenerx = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yearx, int monthx, int dayx) {
                monthx = monthx+1;

                String datex = monthx + "/" + dayx +"/" + yearx;
                tdisplayDatex.setText(datex);
            }
        };


        tdisplayDate.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int year  = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day   = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        addTournamentDetails.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        tdateSetListener,
                        year,month,day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        tdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month+1;

                String date = month + "/" + day +"/" + year;
                tdisplayDate.setText(date);
            }
        };

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.teams_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        touType = adapterView.getItemAtPosition(i).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}