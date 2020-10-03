package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.TeamAdapter;
import app.mad.admini.tournaments.tournament.helper.DataBaseHandlerT;
import app.mad.admini.tournaments.tournament.models.Teams;

public class AdminNationalTeamList extends AppCompatActivity {

    private ListView listView;
    private List<Teams> teams;
    Context context;
    DataBaseHandlerT dataBaseHandlerT;
    Button BTNAdd;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_national_team_list);

        context = this;
        listView = findViewById(R.id.listTeam);
        BTNAdd = findViewById(R.id.BTAddNewTeam);

        BTNAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(AdminNationalTeamList.this, AdminAddNewTeam.class );
                startActivity(intent);
            }
        });

        teams = new ArrayList<>();
        dataBaseHandlerT = new DataBaseHandlerT(context);

        teams =  dataBaseHandlerT.getAllTeams();

        TeamAdapter adapter = new TeamAdapter(context,R.layout.single_team,teams);

        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {


                final Teams team = teams.get(position);
                System.out.println(team.getTeamId());
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setTitle(team.getTeamName());
                builder.setMessage("Choose next action");

                builder.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent=new Intent(AdminNationalTeamList.this, AdminUpdateDeleteTeam.class);
                        intent.putExtra("ID",String.valueOf(team.getTeamId()));
                        startActivity(intent);

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        System.out.println(team.getTeamId());
                        dataBaseHandlerT.deleteTeam(team.getTeamId());
                        Intent intent=new Intent(AdminNationalTeamList.this, MainActivity.class);
                        startActivity(intent);

                    }
                });

                builder.show();
            }
        });




    }
}