package app.mad.admini.tournaments.tournament;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class AdminCalculatePlayer extends AppCompatActivity {

    // PlayerODIModel playerODIModel;
    EditText runs,balls,wkts,ovrs,inns,editruns2;
    Button btncalc;
    DbHandlerS dbHandlerS;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_calculate_player);
        context=this;


        btncalc = findViewById(R.id.btncalc);
        runs = findViewById(R.id.etruns);
        balls = findViewById(R.id.etballs);
        wkts = findViewById(R.id.etwkts);
        ovrs = findViewById(R.id.etovers);
        inns = findViewById(R.id.etinnings);
        editruns2 = findViewById(R.id.etrunsballs);


        final String id =getIntent().getStringExtra("id");
        System.out.println("id passing "+id);
        dbHandlerS = new DbHandlerS(context);

        final PlayerODIModel playerODIModel = dbHandlerS.getPlayerRecords(Integer.parseInt(id));

        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Context context = getApplicationContext();
                try {
                    float batstrikeRate, bataverage,economy,ballaverage,ballstrikerate ;
                    int inn,runn,bf , ballruns,wick,balll;

                    //new values
                    String wickets =wkts.getText().toString().trim();
                    String run= runs.getText().toString().trim();
                    String ball = balls.getText().toString().trim();
                    String overs = ovrs.getText().toString().trim();
                    String innings = inns.getText().toString().trim();
                    String bruns = editruns2.getText().toString().trim();

                    //existing values
                    float avg = playerODIModel.getTaverage();
                    float sr = playerODIModel.getTsr();
                    float econ = playerODIModel.getEconomy();
                   int inning = playerODIModel.getTinnings();
                   int runs = playerODIModel.getTruns();
                   int ballf = playerODIModel.getBf();
                   int brun = playerODIModel.getBruns();
                   float avg2 = playerODIModel.getBaverage();
                   int wicket = playerODIModel.getWkts();
                   float sr2 = playerODIModel.getBsr();
                   int balls = playerODIModel.getBalls();

                   System.out.println("current avg :"+avg);

                    bf =  calcBF(ballf,Integer.parseInt(ball));
                    balll = calcBowlingBalls(balls,Integer.parseInt(ball));
                    runn =calcBattingRuns(runs,Integer.parseInt(run));
                    ballruns = calcBowlingRuns(brun,Integer.parseInt(bruns));
                    wick = calcWickets(wicket ,Integer.parseInt(wickets));
                    inn =  calcBatInnings(inning,Integer.parseInt(innings));
                    bataverage = calcBattingAverage(runn,inn);
                    batstrikeRate = calcBattingSR(runn,bf);
                    economy = calcEconomy(runn,Integer.parseInt(overs));
                    ballaverage =calcBowlingAverage(ballruns,wick);
                    ballstrikerate =calcBowlingSR(balll,wick);

                    System.out.println("new avg " + bataverage);
                    System.out.println("new sr " + batstrikeRate);
                    System.out.println("new economy " + economy);


                    PlayerODIModel playerODIModel1 = new PlayerODIModel(Integer.parseInt(id),bataverage,batstrikeRate,economy,inn,ballaverage,ballstrikerate,wick,ballruns,bf,runn,balll);
                    int state = dbHandlerS.updateCalc(playerODIModel1);
                    System.out.println(state);
                }catch (NumberFormatException e){
                    e.printStackTrace();
                }
                CharSequence text = "Navigating to player details";
                int duration = Toast.LENGTH_SHORT;
                Toast toast= Toast.makeText(context, text , duration);
                toast.setGravity(Gravity.CENTER_VERTICAL, 0,0);
                toast.show();
                Intent intent = new Intent(getApplicationContext(), PlayerList.class);
                startActivity(intent);

            }
        });

    }

    public static float calcBattingAverage(int runs,int innings){
        return (runs/innings);
    }
    public static float calcBattingSR(int runs,int bf){
        return ((runs/bf)*100);
    }
    public static float calcEconomy(int runs,int overs){
        return  (runs/overs);
    }
    public static int calcBatInnings(int currentInnings,int newInnings){
        return (currentInnings + newInnings);
    }
    public static float calcBowlingAverage(int runs,int wickets){
        return (runs/wickets);
    }
    public static float calcBowlingSR(int balls,int wickets){
        return ((balls/wickets)*100);
    }
    public static int calcWickets(int currentWickets,int newWickets){
        return (currentWickets + newWickets);
    }
    public static int calcBowlingRuns(int currentBalls,int newBalls){
        return (currentBalls + newBalls);
    }
    public static int calcBF(int currentBF,int newBF){
        return (currentBF + newBF);
    }
    public static int calcBattingRuns(int currentRuns,int newRuns){
        return (currentRuns + newRuns);
    }
    public static int calcBowlingBalls(int currentBalls,int newBalls){
        return (currentBalls + newBalls);
    }


}