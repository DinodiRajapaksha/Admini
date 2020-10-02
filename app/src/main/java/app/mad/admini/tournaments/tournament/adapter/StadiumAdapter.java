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
import app.mad.admini.tournaments.tournament.models.Stadium;

public class StadiumAdapter extends ArrayAdapter {

    Context context;
    int resource;
    List<Stadium> stadiums;

    public StadiumAdapter(@NonNull Context context, int resource, @NonNull List<Stadium> stadiums) {

        super(context, resource, stadiums);
        this.context=context;
        this.resource=resource;
        this.stadiums=stadiums;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(context);

        View row = inflater.inflate(resource,parent,false);

        TextView txtStadiumButton = row.findViewById(R.id.txtStadiumSelect);

        Stadium stadium = stadiums.get(position);

        txtStadiumButton.setText(stadium.getStadiumName());

        return row;
    }
}
