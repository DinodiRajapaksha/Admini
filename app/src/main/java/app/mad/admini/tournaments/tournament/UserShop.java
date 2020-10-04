package app.mad.admini.tournaments.tournament;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import app.mad.admini.R;

public class UserShop extends AppCompatActivity {
    CardView cardViewvmerch,cardViewvtick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_shop);

        cardViewvmerch = findViewById(R.id.cardViewvmerch);
        cardViewvtick = findViewById(R.id.cardViewvtick);


        cardViewvmerch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Merchandise";
                int duration = Toast.LENGTH_SHORT;
                Toast toast= Toast.makeText(context, text , duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), UserMerchList.class);
                startActivity(intent);
            }
        });
        cardViewvtick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Context context = getApplicationContext();
                CharSequence text = "Tickets";
                int duration = Toast.LENGTH_SHORT;
                Toast toast= Toast.makeText(context, text , duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();

                Intent intent = new Intent(getApplicationContext(), UserTicket_matchList.class);
                startActivity(intent);
            }
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomBarNav);
        bottomNavigationView.setSelectedItemId(R.id.ic_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.ic_shop:
                        startActivity(new Intent(getApplicationContext(),UserShop.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_stadiums:
                        startActivity(new Intent(getApplicationContext(), UserStadium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(), UserHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_teams:
                        startActivity(new Intent(getApplicationContext(), NationalTeams.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_tournaments:
                        startActivity(new Intent(getApplicationContext(), TournamentList.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
    }
}