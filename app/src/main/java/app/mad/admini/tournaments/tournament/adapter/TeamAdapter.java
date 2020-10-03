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
import app.mad.admini.tournaments.tournament.models.Teams;

public class TeamAdapter extends ArrayAdapter {

    private Context context;
    private int resource;
    List<Teams> teams;

    public TeamAdapter(@NonNull Context context, int resource, @NonNull List<Teams> teams) {
        super(context, resource, teams);

        this.context = context;
        this.resource = resource;
        this.teams = teams;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);

        TextView btnTeam = row.findViewById(R.id.BTNTeamSelect);

        Teams team = teams.get(position);
        btnTeam.setText(team.getTeamName());

        return row;
    }
}
