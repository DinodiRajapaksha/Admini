package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class TicketEdit extends AppCompatActivity {

    EditText etEditTournName, etEditMatchID, etEditStadiumName,etEditBlock1,etEditQty1,etEditPrice1;
    Button btnUpdate,btnCancel;
    private DbHandlerS dbHandlerS;
    private Context context;
    private long updatedDate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_edit);
        context = this;

        etEditTournName = findViewById(R.id.etEditTournamentName);
        etEditMatchID = findViewById(R.id.etEditMatchID);
        etEditStadiumName = findViewById(R.id.etEditStadiumname);
        etEditBlock1 = findViewById(R.id.etEditBlock1);
        etEditQty1 = findViewById(R.id.etEditQty1);
        etEditPrice1 = findViewById(R.id.etEdiPrice1);

        dbHandlerS = new DbHandlerS(context);
        final String id =getIntent().getStringExtra("id");
        System.out.println("id passing "+id);

        final TicketModel ticket = dbHandlerS.getSingleTicket(Integer.parseInt(id));


        btnUpdate = findViewById(R.id.btnUpdateTicket);
        btnCancel = findViewById(R.id.btnUpdateCancelTicket);

        etEditTournName.setText(ticket.getTournamentName());
        etEditMatchID.setText(ticket.getMatchID());
        etEditStadiumName.setText(ticket.getStadiumName());
        etEditBlock1.setText(ticket.getBlockType());
        etEditPrice1.setText(String.valueOf(ticket.getUnitPrice()));
        etEditQty1.setText(String.valueOf(ticket.getQty()));


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tournamentName = etEditTournName.getText().toString();
                String matchid = etEditMatchID.getText().toString();
                String stadium = etEditStadiumName.getText().toString();
                String block = etEditBlock1.getText().toString();
                String price = etEditPrice1.getText().toString();
                String quatity = etEditQty1.getText().toString();
                updatedDate=System.currentTimeMillis();

                TicketModel ticketModel = new TicketModel(Integer.parseInt(id),tournamentName,matchid,stadium,block,Float.parseFloat(price),Integer.parseInt(quatity));
                int state = dbHandlerS.updateTickets(ticketModel);
                System.out.println(tournamentName);
                System.out.println(state);
                Toast.makeText(context, "updated!!!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(context, TicketList.class));
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, TicketList.class);
                startActivity(intent);
            }
        });
    }
}