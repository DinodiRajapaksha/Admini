package app.mad.admini.tournaments.tournament;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.aMatchDetails;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;
import app.mad.admini.tournaments.tournament.models.Tournament;

import static java.lang.Integer.parseInt;

public class addUnMatch extends AppCompatActivity{

    EditText mid, mStadium, mTeam1, mTeam2, mType;
    Button btn_msub;
    TextView mDate;
    DatePickerDialog.OnDateSetListener tdateSetListener;
    public String matchID;
    String mStatus, num, tidS, midS;
    Integer x, numI, midI;
    Matches matches;
    Tournament tournament;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_un_match);
        tidS =aMatchDetails.getActivityInstance().getData();
        midS =aMatchDetails.getActivityInstance().getNum();
        matches = new Matches();
        tournament = new Tournament();

        databaseHelper dbh;
        dbh = new databaseHelper(addUnMatch.this);

        mStadium = findViewById(R.id.mStadium);
        mTeam1 = findViewById(R.id.mTeam1);
        mTeam2 = findViewById(R.id.mTeam2);
        mType = findViewById(R.id.mType);

        mDate = (TextView) findViewById(R.id.mDate);
        mid = findViewById(R.id.mid);
        btn_msub = findViewById(R.id.btn_msub);


        midS = getIntent().getStringExtra("num");
        tidS = getIntent().getStringExtra("tid");

        if(tidS == null && savedInstanceState != null){
            tidS = savedInstanceState.getString(tidS);
        }

        Log.d("addUnMatchmidxxx", midS);
        Log.d("addUnMatchmidoo", tidS);
        midI= parseInt(midS);

        /*Cursor c = dbh.getAllMatchesforUI();
        if(c.getCount() == 0){
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }else {
            while (c.moveToNext()) {
                tidS = (c.getString(0));
                midS = (c.getString(1));
            }
        }*/


        btn_msub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View viewx) {


                databaseHelper dbh = new databaseHelper(addUnMatch.this);
                Matches matches;
                matches = new Matches(
                        tidS,
                        midI,
                        mType.getText().toString(),
                        mDate.getText().toString(),
                        mStadium.getText().toString(),
                        mTeam1.getText().toString(),
                        mTeam2.getText().toString(),
                        mStatus
                );
                Log.d("getTid", tournament.getTid());
                Log.d("getMid", String.valueOf(matches.getMid()));
                Log.d("tidS", tidS);
                Log.d("midi", String.valueOf(midI));
                String no1 = tournament.getTid();
                Integer no1I = Integer.parseInt(no1);
                Integer tidI = Integer.parseInt(tidS);
                Integer no2 = matches.getMid();
                if(no1I == tidI) {
                    Log.d("gogo1", String.valueOf(midI));
                    if (no2==midI) {
                        Log.d("gogo2", String.valueOf(midI));
                        dbh.addMatFortidNmid(matches, tidS, midS);
                    }
                }else{
                    Log.d("gogo3", tidS);
                }
                Intent intent = new Intent(addUnMatch.this, aMatchDetails.class);
                startActivity(intent);
            }
        });


        mDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar cal = Calendar.getInstance();
                int yearx = cal.get(Calendar.YEAR);
                int monthx = cal.get(Calendar.MONTH);
                int dayx = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialogx = new DatePickerDialog(
                        addUnMatch.this,
                        android.R.style.Theme_DeviceDefault_Dialog_MinWidth,
                        tdateSetListener,
                        yearx, monthx, dayx);
                dialogx.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialogx.show();
            }
        });

        tdateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int yearx, int monthx, int dayx) {
                monthx = monthx + 1;

                String datex = monthx + "/" + dayx + "/" + yearx;
                mDate.setText(datex);
            }
        };

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tid", tidS);
    }

}


