package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.UserTeamAdapter;
import app.mad.admini.tournaments.tournament.helper.DataBaseHandlerT;
import app.mad.admini.tournaments.tournament.models.Teams;

public class NationalTeams extends AppCompatActivity {

    private ListView listViewTeam;
    private List<Teams> teams;
    Context context;
    DataBaseHandlerT dataBaseHandlerT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_national_teams);

        listViewTeam = findViewById(R.id.listTeam);

        context = this;

        teams = new ArrayList<>();
        dataBaseHandlerT = new DataBaseHandlerT(context);

        teams =  dataBaseHandlerT.getAllTeams();

        UserTeamAdapter adapter = new UserTeamAdapter(context,R.layout.single_national_team,teams);

        listViewTeam.setAdapter(adapter);

        listViewTeam.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Teams team = teams.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);

                builder.setTitle(team.getTeamName() + " National Team");
                builder.setPositiveButton("View Players in Team", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = new Intent(NationalTeams.this,SriLankaNatTeamPlayers.class);
                        startActivity(intent);
                    }
                });

                builder.show();

            }
        });

    }
}