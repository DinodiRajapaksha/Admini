package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.UserMerchAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class UserMerchList extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<MerchModel> merchModelList;
    private Context context;
    Button buy;
    TextInputEditText qty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_merch_list);
        context = this;

        listView=findViewById(R.id.usermerchListView);
        buy = findViewById(R.id.btnmerchbuy);
        qty = findViewById(R.id.merchq1);

        dbHandlerS = new DbHandlerS(context);
        merchModelList = new ArrayList<>();

        merchModelList= dbHandlerS.getAllMerch();


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

        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movetopayment();
            }
        });

        UserMerchAdapter userMerchAdapter = new UserMerchAdapter(context,R.layout.activity_user_merch_card_view,merchModelList);
        listView.setAdapter(userMerchAdapter);
    }
    private void movetopayment(){
      /*  if(!validateInputQty()){
            return;
        }*/
        //String qty1 = qty.getText().toString();
        Context context = getApplicationContext();
        CharSequence text = "Navigating to payement";
        int duration = Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(context, text , duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();

        Intent intent = new Intent(context, user_payment.class);
        startActivity(intent);


    }
    public boolean validateInputQty(){
        int qtyw = Integer.parseInt(qty.getText().toString().trim());

        if(qtyw == 0){
            qty.setError("Field Can't be empty");
            return false;
        }else{
            qty.setError(null);
            return true;
        }

    }
}