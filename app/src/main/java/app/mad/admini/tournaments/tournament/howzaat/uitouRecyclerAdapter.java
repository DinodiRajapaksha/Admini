package app.mad.admini.tournaments.tournament.howzaat;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.adapter.CustomAdapter;
import app.mad.admini.tournaments.tournament.viewTournament;

public class uitouRecyclerAdapter extends RecyclerView.Adapter<uitouRecyclerAdapter.MyViewHolderx>{

    Fragment fragment;
    Activity activity;
    private Context context;
    private ArrayList touName, fromDate, toDate, touCountry, tid;
    Bundle extrasOut = new Bundle();

    public uitouRecyclerAdapter(Fragment fragment,
                                Context context,
                                ArrayList tid,
                                ArrayList touName,
                                ArrayList touCountry,
                                ArrayList fromDate,
                                ArrayList toDate){
        this.fragment  = fragment;
        this.context    = context;
        this.tid = tid;
        this.touName    = touName;
        this.touCountry = touCountry;
        this.fromDate   = fromDate;
        this.toDate     = toDate;


    }

    public uitouRecyclerAdapter(Activity activity, Context context, ArrayList<String> tid, ArrayList<String> touName, ArrayList<String> touCountry, ArrayList<String> fromDate, ArrayList<String> toDate) {
    }

    @NonNull
    @Override
    public uitouRecyclerAdapter.MyViewHolderx onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.user_tou_row, parent, false);
        return new MyViewHolderx(view);
    }

    @Override
    public void onBindViewHolder(@NonNull uitouRecyclerAdapter.MyViewHolderx holder, final int position) {

        holder.txtUTouName.setText(String.valueOf(touName.get(position)));
        holder.txtUTouCountry.setText(String.valueOf(touCountry.get(position)));
        holder.txtUDate.setText(String.valueOf((concat(fromDate, toDate)).get(position)));
        holder.user_mat_row.setAnimation(AnimationUtils.loadAnimation(context, R.anim.fade_transition_animation));

        holder.user_mat_row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, matchUI.class); intent.putExtra("tid", String.valueOf(tid.get(position)));

                intent.putExtra("touName", String.valueOf(touName.get(position)));
                intent.putExtra("touCountry", String.valueOf(touCountry.get(position)));
                intent.putExtra("fromDate", String.valueOf(fromDate.get(position)));
                intent.putExtra("toDate", String.valueOf(toDate.get(position)));
                activity.startActivity(intent);
            }
        });
    }

            @Override
            public int getItemCount() {
                return touName.size();
            }

            public ArrayList concat(ArrayList fromDate, ArrayList toDate) {
                int length = fromDate.size();
                if (length != toDate.size()) { // Too many names, or too many numbers
                    // Fail
                }
                ArrayList<String> Udate = new ArrayList<String>(length); // Make a new list
                for (int i = 0; i < length; i++) { // Loop through every name/phone number combo
                    Udate.add(fromDate.get(i) + "   -   " + toDate.get(i)); // Concat the two, and add it
                }
                return Udate;
            }


            class MyViewHolderx extends RecyclerView.ViewHolder {

                TextView txtUTouName, txtUTouCountry, txtUDate;
                CardView user_mat_row;
                FrameLayout user_tou_row;

                public MyViewHolderx(@NonNull View itemView) {
                    super(itemView);
                    txtUTouName = itemView.findViewById(R.id.txtUTouName);
                    txtUTouCountry = itemView.findViewById(R.id.txtUTouCountry);
                    txtUDate = itemView.findViewById(R.id.txtUDate);

                    user_mat_row = itemView.findViewById(R.id.user_mat_row);
                    user_tou_row = itemView.findViewById(R.id.user_tou_row);
                }
            }
        }