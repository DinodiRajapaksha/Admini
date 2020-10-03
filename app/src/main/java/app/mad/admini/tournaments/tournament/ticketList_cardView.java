package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class ticketList_cardView extends AppCompatActivity {
   ImageView btnEdit, btnDelete;
    private DbHandlerS dbHandlerS;
    private List<TicketModel> ticketList;
    private Context context;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_list_card_view);

        context = this;
        btnEdit =findViewById(R.id.btnTicketListEdit);
        btnDelete = findViewById(R.id.btnTicketListDelete);
        cardView = findViewById(R.id.cardView);
        dbHandlerS = new DbHandlerS(context);
        ticketList = new ArrayList<>();

        //click listner to edit button
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               moveToUpdateTickets();
            }
        });
        //click listner to card view
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Navigating to update ticket details";
                int duration = Toast.LENGTH_SHORT;
                Toast toast= Toast.makeText(context, text , duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), TicketEdit.class);
                startActivity(intent);
            }
        });


    }
    public void moveToUpdateTickets(){
        Context context = getApplicationContext();
        CharSequence text = "Navigating to update ticket details";
        int duration = Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(context, text , duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), TicketEdit.class);
        startActivity(intent);
    }
}