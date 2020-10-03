package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DataBaseHelperN;
import app.mad.admini.tournaments.tournament.models.Stadium;

public class UserStadiumDetails extends AppCompatActivity {

    TextView txtStadiumName,txtStadiumInfo,txtStadiumSeats,txtStadiumSize,txtStadiumCountry,txtStadiumLocation;
    Button btnViewMatches;
    Context context;
    DataBaseHelperN dataBaseHelperN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_stadium_details);

        txtStadiumName = findViewById(R.id.txtNameOfSt);
        txtStadiumInfo = findViewById(R.id.txtStadiumInfo);
        txtStadiumSeats = findViewById(R.id.txtSeatValue);
        txtStadiumSize = findViewById(R.id.txtSizeValue);
        txtStadiumCountry = findViewById(R.id.txtCountry);
        txtStadiumLocation = findViewById(R.id.txtLocation);

        btnViewMatches = findViewById(R.id.btnMatchinStadium);

        context = this;
        dataBaseHelperN = new DataBaseHelperN(context);

        final String id = getIntent().getStringExtra("StadiumID");

        System.out.println(id);

        final Stadium stadium = dataBaseHelperN.getSingleStadium(Integer.parseInt(id));

        System.out.println(stadium.getStadiumName());

        txtStadiumName.setText(stadium.getStadiumName());
        txtStadiumSeats.setText(stadium.getSeats());
        txtStadiumSize.setText(stadium.getSize());
        txtStadiumInfo.setText(stadium.getInformation());
        txtStadiumCountry.setText(stadium.getCountry());
        txtStadiumLocation.setText(stadium.getLocation());

       btnViewMatches.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               Intent intent = new Intent(UserStadiumDetails.this,UserStadiumCountry.class);
               startActivity(intent);

           }
       });

    }
}