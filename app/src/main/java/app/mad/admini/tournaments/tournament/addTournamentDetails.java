package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class addTournamentDetails extends AppCompatActivity
implements AdapterView.OnItemSelectedListener {

    EditText txteditName, txteditNum, txteditCountry;
    Button btnTSubmit;
    TextView tdisplayDate;
    TextView tdisplayDatex;
    DatePickerDialog.OnDateSetListener tdateSetListener;
    DatePickerDialog.OnDateSetListener tdateSetListenerx;
    Spinner spinner;

    String touType;

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

        btnTSubmit    = findViewById(R.id.btnTSubmit);

        btnTSubmit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View viewx) {
                databaseHelper dbh = new databaseHelper(addTournamentDetails.this);
                Tournament tournament;

                tournament = new Tournament(
                        txteditName.getText().toString(),
                        txteditNum.getText().toString(),
                        txteditCountry.getText().toString(),
                        tdisplayDate.getText().toString(),
                        tdisplayDatex.getText().toString(), touType);

                dbh.addTou(tournament);

                String num = txteditNum.getText().toString();

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