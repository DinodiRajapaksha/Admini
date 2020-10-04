package app.mad.admini.tournaments.tournament;

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

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.databaseHelper;
import app.mad.admini.tournaments.tournament.models.Matches;

public class addUnMatch extends AppCompatActivity{

    EditText mid, mStadium, mTeam1, mTeam2, mType;
    Button btn_msub;
    TextView mDate;
    DatePickerDialog.OnDateSetListener tdateSetListener;
    public String matchID;
    String mStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_un_match);

        mStadium = findViewById(R.id.mStadium);
        mTeam1 = findViewById(R.id.mTeam1);
        mTeam2 = findViewById(R.id.mTeam2);
        mType = findViewById(R.id.mType);

        mDate = (TextView) findViewById(R.id.mDate);
        mid = findViewById(R.id.mid);
        btn_msub = findViewById(R.id.btn_msub);

        btn_msub.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View viewx) {
                databaseHelper dbh = new databaseHelper(addUnMatch.this);
                Matches matches;
                matches = new Matches(
                        mid.getText().toString(),
                        mType.getText().toString(),
                        mDate.getText().toString(),
                        mStadium.getText().toString(),
                        mTeam1.getText().toString(),
                        mTeam2.getText().toString(),
                        mStatus
                );

                dbh.addMat(matches);

                Intent intent = new Intent(addUnMatch.this, TournamentList.class);
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

}


