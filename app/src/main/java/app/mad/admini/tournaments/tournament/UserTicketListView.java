package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.UserTicketAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class UserTicketListView extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<TicketModel> ticketModelList;
    private Context context;


    //new
    static UserTicketListView INSTANCE;
    public int matchID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ticket_list_view);
        context = this;


        listView=findViewById(R.id.blocklistview);

        //number format exception
        dbHandlerS = new DbHandlerS(context);
        ticketModelList = new ArrayList<>();

        // block = (TextView) findViewById(R.id.postblockname);
        //price = (TextView) findViewById(R.id.postblockprice);


       /*id=UserTicket_matchList.getActivityInstance().getData();
        System.out.println("get id integer "+id);
        String newid = String.valueOf(id);
        System.out.println("get id string "+id);*/
        //ticketModelList = dbHandlerS.getTicketBlocks();

        System.out.println("block details : "+ticketModelList);
        //block.setText(.getBlockType());*/

        //matchID = ticketModel.getMatchID();

        ticketModelList = dbHandlerS.getTTX();
        System.out.println("ticket list : "+ticketModelList);

        UserTicketAdapter userTicketAdapter = new UserTicketAdapter(context,R.layout.activity_user_ticket_card_view,ticketModelList);
        listView.setAdapter(userTicketAdapter);

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



}