package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DataBaseHelperN;
import app.mad.admini.tournaments.tournament.models.Stadium;

public class stadiumEdit extends AppCompatActivity {

    EditText stadiumName, country, location, seat, size, info;
    Button btnUpdate;
    DataBaseHelperN dataBaseHelperN;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium_edit);

        stadiumName = findViewById(R.id.txtStNameEdit);
        country = findViewById(R.id.txtCountryEdit);
        location = findViewById(R.id.txtLocationEdit);
        seat = findViewById(R.id.txtSeatsEdit);
        size = findViewById(R.id.txtSizeEdit);
        info = findViewById(R.id.txtInfoEdit);

        btnUpdate = findViewById(R.id.btnUpdateStadium);

        context = this;
        dataBaseHelperN = new DataBaseHelperN(context);

        final String id = getIntent().getStringExtra("StadiumID");

        System.out.println(id);

        final Stadium stadium = dataBaseHelperN.getSingleStadium(Integer.parseInt(id));

        stadiumName.setText(stadium.getStadiumName());
        country.setText(stadium.getCountry());
        location.setText(stadium.getLocation());
        seat.setText(stadium.getSeats());
        size.setText(stadium.getSize());
        info.setText(stadium.getInformation());

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String TxtName = stadiumName.getText().toString();
                String TxtCountry = country.getText().toString();
                String TxtLocation = location.getText().toString();
                String TxtSeats = seat.getText().toString();
                String TxtSize = size.getText().toString();
                String TxtInfo = info.getText().toString();

                Stadium stadium = new Stadium(Integer.parseInt(id),TxtName,TxtCountry,TxtLocation,TxtSeats,TxtSize,TxtInfo);

                int status = dataBaseHelperN.updateStadium(stadium);

                System.out.println(status);

                Intent intent = new Intent(stadiumEdit.this, countryStadium.class);
                startActivity(intent);
            }
        });
    }


}