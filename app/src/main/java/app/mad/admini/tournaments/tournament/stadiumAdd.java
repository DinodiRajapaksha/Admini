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

public class stadiumAdd extends AppCompatActivity {

    EditText StName,Country,Location,Seats,Size,Info;
    Button btnAdd;
    DataBaseHelperN dbHelper;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stadium_add);

        StName=findViewById(R.id.txtStName);
        Country=findViewById(R.id.txtCountry);
        Location=findViewById(R.id.txtLocation);
        Seats=findViewById(R.id.txtSeats);
        Size=findViewById(R.id.txtSize);
        Info=findViewById(R.id.txtInfo);

        btnAdd=findViewById(R.id.btnAddStadiumToDB);

        context = this;
        dbHelper = new DataBaseHelperN(context);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String StadiumName = StName.getText().toString();
                String country = Country.getText().toString();
                String location = Location.getText().toString();
                String seat = Seats.getText().toString();
                String size = Size.getText().toString();
                String info = Info.getText().toString();

                Stadium St = new Stadium(StadiumName,country,location,seat,size,info);

                dbHelper.addStadium(St);

                Intent intent = new Intent(stadiumAdd.this,AdminStadium.class);
                startActivity(intent);
            }
        });


    }
}