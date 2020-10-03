package app.mad.admini.tournaments.tournament.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.models.Player;

public class PlayerAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    List<Player> players;

    public PlayerAdapter(@NonNull Context context, int resource, @NonNull List<Player> players) {
        super(context, resource,players );

        this.context = context;
        this.resource = resource;
        this.players = players;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(resource,parent,false);

        TextView nationalPlayer = row.findViewById(R.id.TVPlayer);

        Player player = players.get(position);

        nationalPlayer.setText(player.getName());

        return row;

    }
}
