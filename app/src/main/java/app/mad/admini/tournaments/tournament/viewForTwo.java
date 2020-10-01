package app.mad.admini.tournaments.tournament;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import app.mad.admini.R;

public class viewForTwo extends AppCompatActivity {

    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_for_two);

        btn    = findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
        Intent intent = new Intent(viewForTwo.this, aMatchDetails.class);
        String num =getIntent().getStringExtra("num");

        intent.putExtra("num", String.valueOf(num));
        startActivity(intent);

        Log.d("meowww", "touNumber"+ num);


       }
    });
    }
}