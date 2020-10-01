package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Tournament;

public class vTournamentDetails extends AppCompatActivity {


    EditText txteditNamevt, txteditNumvt, txteditCountryvt;
    Button btnTEditV;
    TextView tdisplayDatevt;
    TextView tdisplayDatexvt;
    DatePickerDialog.OnDateSetListener tdateSetListenervt;
    DatePickerDialog.OnDateSetListener tdateSetListenerxvt;

    databaseHelper dbh;

    String touNamevt, touCountryvt, fromDatevt, toDatevt, touType;
    Integer numvt;

    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_v_tournament_details);

        //dbh = new databaseHelper(getApplicationContext());


        txteditNamevt   = findViewById(R.id.teditNamevt);
        txteditCountryvt= findViewById(R.id.teditCountryvt);
        txteditNumvt    = findViewById(R.id.teditNumvt);
        tdisplayDatevt  = findViewById(R.id.datetovtvt);
        tdisplayDatexvt = findViewById(R.id.datefromvtvt);

        btnTEditV    = findViewById(R.id.btnTEditV);

        btnTEditV.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View viewx) {
                databaseHelper dbh = new databaseHelper(vTournamentDetails.this);
                Tournament tournament;

                tournament = new Tournament(
                        txteditNamevt.getText().toString(),
                        txteditNumvt.getText().toString(),
                        txteditCountryvt.getText().toString(),
                        tdisplayDatevt.getText().toString(),
                        tdisplayDatexvt.getText().toString(), touType);

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
                && getIntent().hasExtra("touCountry")
                && getIntent().hasExtra("fromDate")
                && getIntent().hasExtra("toDate") ){

            //getData
            touNamevt    = getIntent().getStringExtra("touName");
            touCountryvt = getIntent().getStringExtra("touCountry");
            fromDatevt   = getIntent().getStringExtra("fromDate");
            toDatevt     = getIntent().getStringExtra("toDate");
           // numvt        = getIntent().getIntExtra("num", 0);


            //setData
            txteditNamevt.setText(touNamevt);
            txteditCountryvt.setText(touCountryvt);
            tdisplayDatevt.setText(toDatevt);
            tdisplayDatexvt.setText(fromDatevt);
          //  txteditNum.setText(num);



        }else{
            Toast.makeText(this, "UH?", Toast.LENGTH_SHORT).show();
        }
    }
}
