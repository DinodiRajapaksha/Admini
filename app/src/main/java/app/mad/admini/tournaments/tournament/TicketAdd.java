package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;


public class TicketAdd extends AppCompatActivity {
    EditText etTournName, etMatchID, etStadiumName,etBlock1,etQty1,etPrice1;
    Button btnSubmit;
    private DbHandlerS dbHandlerS;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_add);

        etTournName = findViewById(R.id.etTournamentName);
        etMatchID = findViewById(R.id.etMatchID);
        etStadiumName = findViewById(R.id.etStadiumname);
        etBlock1 = findViewById(R.id.etBlock1);
        etQty1 = findViewById(R.id.etQty1);
        etPrice1 = findViewById(R.id.etPrice1);
        context = this;

        btnSubmit = findViewById(R.id.btnAddTicketSubmit);

        dbHandlerS = new DbHandlerS(context);



        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tournamentName = etTournName.getText().toString();
                String matchid = etMatchID.getText().toString();
                String stadiumname = etStadiumName.getText().toString();
                String block = etBlock1.getText().toString();
                Integer quantity = Integer.parseInt(etQty1.getText().toString());
                Float price = Float.parseFloat(etPrice1.getText().toString());
                long started = System.currentTimeMillis();

                TicketModel tmodel = new TicketModel(quantity,tournamentName,matchid,stadiumname,block,price,started,0);
                dbHandlerS.addTickets(tmodel);
                Toast.makeText(getApplicationContext(),"Successfully inserted", Toast.LENGTH_SHORT).show();
                clearControls();


            }
        });

    }
    private void clearControls(){
        etTournName.setText("");
        etMatchID.setText("");
        etStadiumName.setText("");
        etBlock1.setText("");
        etQty1.setText("");
        etPrice1.setText("");
    }



}