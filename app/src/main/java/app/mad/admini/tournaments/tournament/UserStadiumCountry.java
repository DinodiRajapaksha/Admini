package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.StadiumAdapter;
import app.mad.admini.tournaments.tournament.helper.DataBaseHelperN;
import app.mad.admini.tournaments.tournament.models.Stadium;

public class UserStadiumCountry extends AppCompatActivity {

    ListView listView;
    List<Stadium> stadiums;
    Context context;
    DataBaseHelperN dataBaseHelperN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_stadium_country);

        context = this;

        listView = findViewById(R.id.ListUserStadium);

        stadiums = new ArrayList<>();

        dataBaseHelperN = new DataBaseHelperN(context);

        stadiums = dataBaseHelperN.getAllStadiums();

        StadiumAdapter stadiumAdapter = new StadiumAdapter(context,R.layout.user_single_stadium,stadiums);

        listView.setAdapter(stadiumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final Stadium stadium = stadiums.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(stadium.getStadiumName());

                builder.setNeutralButton("View Stadium Details", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(UserStadiumCountry.this,UserStadiumDetails.class);
                        intent.putExtra("StadiumID" , String.valueOf(stadium.getStadiumID()));
                        startActivity(intent);

                    }
                });

                builder.show();
            }

        });


    }
}