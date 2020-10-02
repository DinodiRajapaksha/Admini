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
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class MerchList_cardView extends AppCompatActivity {
    ImageView btnEdit, btnDelete;
    private DbHandlerS dbHandlerS;
    private List<MerchModel> merchModelList;
    private Context context;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merch_list_card_view);

        context = this;
        btnEdit =findViewById(R.id.btnMerchListEdit);
        btnDelete = findViewById(R.id.btnMerchListDelete);
        cardView = findViewById(R.id.cardView);
        dbHandlerS = new DbHandlerS(context);
        merchModelList = new ArrayList<>();

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                moveToUpdateMerch();
            }
        });
    }
    public void moveToUpdateMerch(){
        Context context = getApplicationContext();
        CharSequence text = "Navigating to update merch details";
        int duration = Toast.LENGTH_SHORT;
        Toast toast= Toast.makeText(context, text , duration);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
        toast.show();

        Intent intent = new Intent(getApplicationContext(), MerchEdit.class);
        startActivity(intent);
    }
}