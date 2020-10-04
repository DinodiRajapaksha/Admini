package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.PlayerAdapter;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class PlayerList extends AppCompatActivity {

    private ListView listView;
    private DbHandlerS dbHandlerS;
    private List<PlayerODIModel> playerODIModelList;
    private Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_list);
        context = this;

        listView=findViewById(R.id.playerListView);

        dbHandlerS = new DbHandlerS(context);
        playerODIModelList = new ArrayList<>();

        playerODIModelList= dbHandlerS.getAllPlayers();

        PlayerAdapter playerAdapter = new PlayerAdapter(context,R.layout.activity_player_list_card_view,playerODIModelList);
        listView.setAdapter(playerAdapter);
    }
}