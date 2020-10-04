package app.mad.admini.tournaments.tournament.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.viewTournament;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{

    Activity activity;
    private Context context;
    private ArrayList touName,  num, touType, fromDate, toDate, touCountry, tid;
    private ArrayList<Boolean> teamOne, teamTwo, teamThree, teamFour, teamFive, teamSix, teamSeven, teamEight;
    Bundle extrasOut = new Bundle();

    public CustomAdapter(Activity activity,
                         Context context,
                         ArrayList tid, ArrayList num,
                         ArrayList touName, ArrayList touType,
                         ArrayList touCountry, ArrayList fromDate,
                         ArrayList toDate, ArrayList teamOne,
                         ArrayList teamTwo, ArrayList teamThree,
                         ArrayList teamFour, ArrayList teamFive,
                         ArrayList teamSix, ArrayList teamSeven, ArrayList teamEight ){
        this.activity = activity;
        this.context    = context;
        this.tid = tid;
        this.num = num;
        this.touName    = touName;
        this.touType    = touType;
        this.touCountry = touCountry;
        this.fromDate   = fromDate;
        this.toDate     = toDate;
        this.teamOne    = teamOne;
        this.teamTwo    = teamTwo;
        this.teamThree  = teamThree;
        this.teamFour   = teamFour;
        this.teamFive   = teamFive;
        this.teamSix    = teamSix;
        this.teamSeven  = teamSeven;
        this.teamEight  = teamEight;

    }



    @NonNull
    @Override
    public CustomAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.tou_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomAdapter.MyViewHolder holder, final int position) {

        holder.txtVTouName.setText(String.valueOf(touName.get(position)));
        holder.txtVTouFDate.setText(String.valueOf(fromDate.get(position)));
        holder.txtVTouTDate.setText(String.valueOf(toDate.get(position)));
        holder.tourow.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));

              holder.tourow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, viewTournament.class);
                intent.putExtra("tid", String.valueOf(tid.get(position)));
                intent.putExtra("num", String.valueOf(num.get(position)));
                intent.putExtra("touName", String.valueOf(touName.get(position)));
                intent.putExtra("touType", String.valueOf(touType.get(position)));
                intent.putExtra("touCountry", String.valueOf(touCountry.get(position)));
                intent.putExtra("fromDate", String.valueOf(fromDate.get(position)));
                intent.putExtra("toDate", String.valueOf(toDate.get(position)));
                intent.putExtra("teamOne", (teamOne.get(position)));
                intent.putExtra("teamTwo", (teamTwo.get(position)));
                intent.putExtra("teamThree", (teamThree.get(position)));
                intent.putExtra("teamFour", (teamFour.get(position)));
                intent.putExtra("teamFive", (teamFive.get(position)));
                intent.putExtra("teamSix", (teamSix.get(position)));
                intent.putExtra("teamSeven", (teamSeven.get(position)));
                intent.putExtra("teamEight", (teamEight.get(position)));


                Log.d("dino12", ""+teamOne);

                activity.startActivityForResult(intent, 1);
            }
        });
        Log.d("dulmev", "huhu"+tid);


    }


    @Override
    public int getItemCount() {
        return touName.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtVTouName, txtVTouTDate, txtVTouFDate;
        LinearLayout tourow;
        //ConstraintLayout vtouDetails;
        Button btn_touliEdit;
        CardView cardViewto3for1;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtVTouName  = itemView.findViewById(R.id.txtATouName);
            txtVTouFDate = itemView.findViewById(R.id.txtVTouFDate);
            txtVTouTDate = itemView.findViewById(R.id.txtVTouTDate);

            //vtouDetails  = itemView.findViewById(R.id.vtouDetails);
            tourow       = itemView.findViewById(R.id.tourow);

            cardViewto3for1 = itemView.findViewById(R.id.gotoview3);
        }
    }
}

