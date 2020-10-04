package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class userMerchCardView extends AppCompatActivity {
    private DbHandlerS dbHandlerS;
    private List<MerchModel> merchModelList;
    private Context context;
    private Button buy;
    CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_merch_card_view);

        context = this;
        buy =findViewById(R.id.btnmerchbuy);
        cardView = findViewById(R.id.cardView);
        dbHandlerS = new DbHandlerS(context);
        merchModelList = new ArrayList<>();


    }


}