package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.UserTicketMatchListAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MatchModel;

public class UserTicket_matchList extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<MatchModel> matchModelList;
    private Context context;

    //new
    static UserTicket_matchList INSTANCE;
    public int matchID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ticket_match_list);
        context = this;

        INSTANCE = this;

        listView = findViewById(R.id.matchListView);
        dbHandlerS = new DbHandlerS(context);
        matchModelList = new ArrayList<>();


        matchModelList = dbHandlerS.getUpcomingMatches();

        UserTicketMatchListAdapter userTicketMatchListAdapter = new UserTicketMatchListAdapter(context, R.layout.activity_user_ticket_match_list_cardview, matchModelList);
        listView.setAdapter(userTicketMatchListAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                final MatchModel matchModel = matchModelList.get(position);

                //Intent intent1 = new Intent(context, UserTicketBlockView.class);
                //intent1.putExtra("team1", String.valueOf(matchModel.getTeam1()));
                //System.out.println("passing " + matchModel.getTeagem1());

                Context context = getApplicationContext();
                CharSequence text = "You can buy your tickets now!";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
                toast.show();

                matchID = matchModel.getMathcID();

                Intent intent = new Intent(getApplicationContext(), UserTicketListView.class);
                startActivity(intent);
            }
        });
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBarNav);
        bottomNavigationView.setSelectedItemId(R.id.ic_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_shop:
                        startActivity(new Intent(getApplicationContext(),UserMerchList.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_stadiums:
                        startActivity(new Intent(getApplicationContext(), AdminStadium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(),UserHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_teams:
                        startActivity(new Intent(getApplicationContext(), UserTicket_matchList.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_tournaments:
                        startActivity(new Intent(getApplicationContext(), TournamentList.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }

        public static UserTicket_matchList getActivityInstance(){
            return INSTANCE;
        }
        public int getData(){
        System.out.println("match id "+matchID);
            return this.matchID;
        }

}