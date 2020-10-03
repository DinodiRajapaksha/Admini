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

public class AdminUpdateDeleteTeam extends AppCompatActivity {

    Button btnEdit;
    EditText txtName,txtCategory,txtBat,txtBowl,txtAll,txtWk;
    DataBaseHandlerT dbHandler;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_update_delete_team);

        txtName = findViewById(R.id.TNUD);
        txtCategory = findViewById(R.id.CatUD);
        txtBat = findViewById(R.id.NOBUD);
        txtBowl = findViewById(R.id.NOBoUD);
        txtAll = findViewById(R.id.NOAllUD);
        txtWk = findViewById(R.id.NOWKUD);

        btnEdit = findViewById(R.id.BTUpdateUD);

        context = this;

        dbHandler = new DataBaseHandlerT(context);

        final String ID = getIntent().getStringExtra("ID");

        System.out.println("id : " + ID);

        final Teams team = dbHandler.getSingleTeam(Integer.parseInt(ID));

        txtName.setText(team.getTeamName());
        txtCategory.setText(team.getCategory());
        txtBat.setText("" + team.getBatsmenNo());
        txtBowl.setText(""+team.getBowlerNo());
        txtAll.setText(""+team.getAllRounderNo());
        txtWk.setText(""+team.getWKNo());

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = txtName.getText().toString();
                String cat = txtCategory.getText().toString();
                String bat = txtBat.getText().toString();
                String bowl = txtBowl.getText().toString();
                String all = txtAll.getText().toString();
                String wk = txtWk.getText().toString();

                Teams teams = new Teams(Integer.parseInt(ID),name,cat,Integer.parseInt(bat),Integer.parseInt(bowl),Integer.parseInt(all),Integer.parseInt(wk));

                int state = dbHandler.updateTeams(teams);

                System.out.println(state);

                Intent intent = new Intent(AdminUpdateDeleteTeam.this,AdminNationalTeamList.class);
                startActivity(intent);
            }
        });
    }
}