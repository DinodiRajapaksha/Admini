package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class PlayerList_cardView extends AppCompatActivity {

    ImageView btnEdit, btnDelete, calculate;
    private DbHandlerS dbHandlerS;
    private List<PlayerODIModel> playerODIModels;
    private Context context;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list_card_view);

        context = this;
        btnEdit =findViewById(R.id.btnPlayerListEdit);
        btnDelete = findViewById(R.id.btnPlayerListDelete);
        calculate=findViewById(R.id.btnPlayerListcal);
        cardView = findViewById(R.id.pcardView);
        dbHandlerS = new DbHandlerS(context);
        playerODIModels = new ArrayList<>();

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToCalc();
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToUpdatePlayerProfile();
            }
        });
    }

   private void moveToCalc() {
        Context context = getApplicationContext();
        CharSequence text = "Navigating to calculator";
        int duration = Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(context, text , duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    public void moveToUpdatePlayerProfile(){
        Context context = getApplicationContext();
        CharSequence text = "Navigating to update player profile";
        int duration = Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(context, text , duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), PlayerProfileEdit.class);
        startActivity(intent);
    }

}