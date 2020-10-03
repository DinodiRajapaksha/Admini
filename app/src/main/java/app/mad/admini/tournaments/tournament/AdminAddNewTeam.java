package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DataBaseHandlerT;
import app.mad.admini.tournaments.tournament.models.Teams;

public class AdminAddNewTeam extends AppCompatActivity {

    EditText TeamName,Category,NoOfBatsmen,NoOfBowlers,NoOfAllRounders,NoOfWK;
    Button BTConfirmNW;
    DataBaseHandlerT DBHandlerT;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_add_new_team);

        TeamName = findViewById(R.id.TName);
        Category = findViewById(R.id.TCategory2);
        NoOfBatsmen = findViewById(R.id.TNoBatsmen);
        NoOfBowlers = findViewById(R.id.TNoBowler);
        NoOfAllRounders = findViewById(R.id.TNoAllR);
        NoOfWK = findViewById(R.id.TNoWK);
        BTConfirmNW = findViewById(R.id.BTConfirmNW);
        context = this;

        DBHandlerT = new DataBaseHandlerT(context);

        BTConfirmNW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Tname = TeamName.getText().toString();
                String Cat = Category.getText().toString();
                int NoBats = Integer.parseInt(NoOfBatsmen.getText().toString());
                int NoBowler = Integer.parseInt (NoOfBowlers.getText().toString());
                int NoAllR = Integer.parseInt(NoOfAllRounders.getText().toString());
                int WK = Integer.parseInt(NoOfWK.getText().toString());

                Teams teams = new Teams(Tname,Cat,NoBats,NoBowler,NoAllR,WK);

                DBHandlerT.insertTeam(teams);


                Intent intent = new Intent(AdminAddNewTeam.this,AdminNationalTeamList.class);
                startActivity(intent);

            }
        });
    }
}
