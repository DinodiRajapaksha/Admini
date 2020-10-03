package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;

public class UserStadium extends AppCompatActivity {

    Button btnUserSL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_stadium);
    }

    public void onClickListener(){

        btnUserSL = (Button)findViewById(R.id.btnUserSL);

        btnUserSL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(UserStadium.this,UserStadiumCountry.class);
                startActivity(intent);
            }
        });
    }


}