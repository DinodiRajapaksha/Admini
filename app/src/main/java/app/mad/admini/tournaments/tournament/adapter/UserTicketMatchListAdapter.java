package app.mad.admini.tournaments.tournament.adapter;

import android.content.Context;
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
import app.mad.admini.tournaments.tournament.models.MatchModel;

public class UserTicketMatchListAdapter extends ArrayAdapter<MatchModel> {
    private Context context;
    private int resource;
    List<MatchModel> matches;
    ListView listView;
    DbHandlerS dbHandlerS;

    public UserTicketMatchListAdapter(@NonNull Context context, int resource, @NonNull List<MatchModel> matches) {
        super(context, resource, matches);
        this.context = context;
        this.resource = resource;
        this.matches = matches;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);
        dbHandlerS = new DbHandlerS(context);


        TextView team_1 = row.findViewById(R.id.postTeam1);
        TextView team_2 = row.findViewById(R.id.postTeam2);
        TextView match_Type = row.findViewById(R.id.postMatchType);
        TextView datee = row.findViewById(R.id.postDate);

        final MatchModel matchModel = matches.get(position);
        team_1.setText(matchModel.getTeam1());
        team_2.setText(matchModel.getTeam2());
        match_Type.setText(matchModel.getMatchType());
        datee.setText(matchModel.getDate());

        /*Intent intent1 = new Intent(context,UserTicketBlockView.class);
        intent1.putExtra("team1",String.valueOf(matchModel.getTeam1()));

        System.out.println("passing "+matchModel.getTeam1());*/



        return row;
    }
}
