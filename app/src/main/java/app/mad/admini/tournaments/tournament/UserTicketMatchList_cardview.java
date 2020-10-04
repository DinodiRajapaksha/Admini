package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MatchModel;

public class UserTicketMatchList_cardview extends AppCompatActivity {
    private DbHandlerS dbHandlerS;
    private List<MatchModel> matchModels;
    private Context context;
    ListView matchlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_ticket_match_list_cardview);

        context = this;
        dbHandlerS = new DbHandlerS(context);
        matchModels = new ArrayList<>();



    }
}