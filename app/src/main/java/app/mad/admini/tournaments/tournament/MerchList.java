package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.MerchAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class MerchList extends AppCompatActivity {
    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<MerchModel> merchModelList;
    private Context context;
    FloatingActionButton addMerch_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merch_list);
        context = this;

        listView=findViewById(R.id.merchListView);
        addMerch_btn  = findViewById(R.id.addMerch_btn);

        dbHandlerS = new DbHandlerS(context);
        merchModelList = new ArrayList<>();

        merchModelList= dbHandlerS.getAllMerch();

        addMerch_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MerchAdd.class);
                startActivity(intent);
            }
        });

        MerchAdapter merchAdapter = new MerchAdapter(context, R.layout.activity_merch_list_card_view,merchModelList);
        listView.setAdapter(merchAdapter);
    }
}