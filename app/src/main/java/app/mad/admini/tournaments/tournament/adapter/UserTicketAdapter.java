package app.mad.admini.tournaments.tournament.adapter;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;
import app.mad.admini.tournaments.tournament.userTicketCardView;

public class UserTicketAdapter extends ArrayAdapter<TicketModel>  {
    private Context context;
    private int resource;
    List<TicketModel> tickets;
    ListView listView;
    DbHandlerS dbHandlerS;
    TicketModel ticketModel;

    public UserTicketAdapter(@NonNull Context context, int resource, @NonNull List<TicketModel> tickets) {
        super(context, resource, tickets);
        this.context=context;
        this.resource=resource;
        this.tickets=tickets;
    }
    @Override
    public int getCount() {
        return tickets.size();
    }

    @Nullable
    @Override
    public TicketModel getItem(int i) {
        return tickets.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);

        dbHandlerS = new DbHandlerS(context);

        TextView block = row.findViewById(R.id.postblockname1);
        TextView price = row.findViewById(R.id.postblockprice1);

        //dbHandlerS.getTicketBlocks(String.valueOf(ticketModel.getTid()));

        final TicketModel ticketModel = tickets.get(position);
        block.setText(ticketModel.getBlockType());
        price.setText(String.valueOf(ticketModel.getUnitPrice()));

        context.startActivity(new Intent(context, userTicketCardView.class));

        return row;
    }
}


