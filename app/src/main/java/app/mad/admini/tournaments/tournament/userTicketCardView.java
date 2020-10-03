package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class userTicketCardView extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<TicketModel> ticketModelList;
    private Context context;
    TextView block,price;
    Button btnpay;
    TicketModel ticketModel;
    int id;
    TextInputEditText textInputQty1,textInputQty2;
    Spinner spinner1,spinner2;

    //for match id passing
    static userTicketCardView INSTANCE;
    public int matchID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ticket_card_view);
        context = this;

        INSTANCE = this;

        dbHandlerS = new DbHandlerS(context);
        ticketModelList = new ArrayList<>();
        btnpay = findViewById(R.id.btnbuy1);
        textInputQty1 = findViewById(R.id.noOfTickets1);
        textInputQty2 = findViewById(R.id.noOfTickets2);
        spinner1 = findViewById(R.id.block1);
        spinner2 = findViewById(R.id.block2);


       /* final TicketModel ticketModel = new TicketModel();
        block.setText(ticketModel.getBlockType());
        System.out.println("block type "+ticketModel.getBlockType());
        */

        /*Intent intent = getIntent();
        String id = intent.getStringExtra("id");
        System.out.println("get string" + id);*/

        id=UserTicket_matchList.getActivityInstance().getData();
        System.out.println("get id integer card view "+id);

        btnpay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!validateInputQty1() | !validateInputQty2()){
                    return;
                }
                String qty1 = textInputQty1.getText().toString();
                String qty2 = textInputQty2.getText().toString();
                String spinnerVal1 = spinner1.getSelectedItem().toString();
                String spinnerVal2 = spinner2.getSelectedItem().toString();

                System.out.println("no of tickets "+qty1);
                System.out.println("no of tickets "+qty2);
                System.out.println("spinner1 "+spinnerVal1);
                System.out.println("spinner 2 "+spinnerVal2);

                Context context = getApplicationContext();
                CharSequence text = "Navigating to payment";
                int duration = Toast.LENGTH_SHORT;
                Toast toast= Toast.makeText(context, text , duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();
                //matchID = Integer.parseInt(ticketModel.getMatchID());


                Intent intent = new Intent(getApplicationContext(), user_payment.class);
                intent.putExtra("matchID",String.valueOf(id));
                intent.putExtra("qty1",qty1);
                intent.putExtra("qty2",qty2);
                intent.putExtra("spinner1",spinnerVal1);
                intent.putExtra("spinner2",spinnerVal2);
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
                        startActivity(new Intent(getApplicationContext(),UserMerchList.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_stadiums:
                        startActivity(new Intent(getApplicationContext(), AdminStadium.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_home:
                        startActivity(new Intent(getApplicationContext(),UserHome.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.ic_teams:
                        startActivity(new Intent(getApplicationContext(), UserTicket_matchList.class));
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

    public boolean validateInputQty1(){
        String qty = textInputQty1.getText().toString().trim();

        if(qty.isEmpty()){
            textInputQty1.setError("Field Can't be empty");
            return false;
        }else{
            textInputQty1.setError(null);
            return true;
        }

    }
    public boolean validateInputQty2(){
        String qty2 = textInputQty2.getText().toString().trim();

        if(qty2.isEmpty()){
            textInputQty2.setError("Field Can't be empty!! If you do not want a ticket from this block please put 0 there!");
            return false;
        }else{
            textInputQty1.setError(null);
            return true;
        }

    }

    public static userTicketCardView getActivityInstance(){
        return INSTANCE;
    }
    public int getData(){
        System.out.println("match id "+matchID);
        return this.matchID;
    }



}