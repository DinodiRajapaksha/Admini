package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;

public class AdminStadium extends AppCompatActivity {

    Button btnSL;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_stadium);
        onClickListener();
    }

    public void onClickListener(){
        btnSL = (Button)findViewById(R.id.btnUserSL);
        btnSL.setOnClickListener(
                new View.OnClickListener(){
                    @Override
                    public void onClick(View view) {

                        Intent intent = new Intent(AdminStadium.this,countryStadium.class);
                        startActivity(intent);

                    }
                }
        );

        btnAdd = (Button)findViewById(R.id.btnAddStadiumPage);
        btnAdd.setOnClickListener(
                new View.OnClickListener(){

                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(AdminStadium.this,stadiumAdd.class);
                        startActivity(intent);
                    }
                }
        );



    }
}