package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.mad.admini.R;

public class viewForTwo extends AppCompatActivity {

    CardView cardb, cardc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_for_two);

        cardb    = findViewById(R.id.cardViewvf2b);
        cardc    = findViewById(R.id.cardViewvf2c);


        cardb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewForTwo.this, aMatchDetails.class);
                String num =getIntent().getStringExtra("num");

                intent.putExtra("num", String.valueOf(num));
                startActivity(intent);

                Log.d("meowww", "touNumber"+ num);
            }
        });

        cardc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(viewForTwo.this, vUnTLU.class);
                String num =getIntent().getStringExtra("num");

                intent.putExtra("num", String.valueOf(num));
                startActivity(intent);

                Log.d("meowww", "touNumber"+ num);
            }
        });

    }
}