package app.mad.admini.tournaments.tournament.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.TicketEdit;
import app.mad.admini.tournaments.tournament.TicketList;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class TicketsAdapter extends ArrayAdapter<TicketModel> {

    private Context context;
    private int resource;
    List<TicketModel> tickets;
    ImageView btnupdate,btndelete;
    DbHandlerS dbHandlerS;

    public TicketsAdapter(Context context, int resource, List<TicketModel> tickets){
        super(context, resource,tickets);
        this.context = context;
        this.resource = resource;
        this.tickets = tickets;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);
        dbHandlerS = new DbHandlerS(context);

        TextView tournamentName = row.findViewById(R.id.postTourName);
        TextView matchID = row.findViewById(R.id.postMatchID);
        TextView block = row.findViewById(R.id.postBlock);
        btnupdate = row.findViewById(R.id.btnTicketListEdit);
        btndelete = row.findViewById(R.id.btnTicketListDelete);



        final TicketModel ticketModel = tickets.get(position);
        tournamentName.setText(ticketModel.getTournamentName());
        matchID.setText(ticketModel.getMatchID());
        block.setText(ticketModel.getBlockType());



        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(context, TicketEdit.class);
               intent.putExtra("id",String.valueOf(ticketModel.getTid()));
                Toast.makeText(context, "Update Ticket Details", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Tickets");
                builder.setMessage("Confirm your action");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHandlerS.deleteTickets(ticketModel.getTid());
                        Toast.makeText(context, "Tickets Deleted Successfully", Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context, TicketList.class));
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();


            }
        });
        return row;
    }
}
