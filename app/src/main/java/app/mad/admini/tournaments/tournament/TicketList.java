package app.mad.admini.tournaments.tournament;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.TicketsAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;


public class TicketList extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<TicketModel> ticketList;
    private Context context;
    FloatingActionButton addTicket_btn;
   // Button btnUpdate,btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list);
        context = this;

        listView=findViewById(R.id.ticketListView);
        addTicket_btn  = findViewById(R.id.addTicket_btn);
        dbHandlerS = new DbHandlerS(context);
        ticketList = new ArrayList<>();

        ticketList= dbHandlerS.getAllTickets();
        System.out.println("ticket list : "+ticketList);

        addTicket_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TicketAdd.class);
                startActivity(intent);
            }
        });

        TicketsAdapter ticketsAdapter = new TicketsAdapter(context,R.layout.activity_ticket_list_card_view,ticketList);
        listView.setAdapter(ticketsAdapter);


    }



}