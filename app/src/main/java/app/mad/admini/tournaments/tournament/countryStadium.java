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

public class countryStadium extends AppCompatActivity {

    ListView listView;
    List<Stadium> stadiums;
    Context context;
    DataBaseHelperN dataBaseHelperN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_country_stadium);

        context = this;

        listView = findViewById(R.id.ListStadium);

        stadiums = new ArrayList<>();

        dataBaseHelperN = new DataBaseHelperN(context);

        stadiums = dataBaseHelperN.getAllStadiums();

        StadiumAdapter stadiumAdapter = new StadiumAdapter(context, R.layout.one_stadium_button,stadiums);

        listView.setAdapter(stadiumAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                final Stadium stadium = stadiums.get(position);

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle(stadium.getStadiumName());

                builder.setNeutralButton("Update", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        Intent intent = new Intent(countryStadium.this,stadiumEdit.class);
                        intent.putExtra("StadiumID" , String.valueOf(stadium.getStadiumID()));
                        startActivity(intent);

                    }
                });

                builder.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        System.out.println(stadium.getStadiumID());

                        dataBaseHelperN.deleteStadium(stadium.getStadiumID());

                        Intent intent = new Intent(countryStadium.this, countryStadium.class);
                        startActivity(intent);

                    }
                });


                builder.show();
            }
        });



    }

}