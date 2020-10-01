package app.mad.admini.tournaments.tournament.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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
    private ArrayList touName,  num,fromDate, toDate, touCountry;
    private ArrayList<Integer> tid;

    public CustomAdapter(Activity activity,
                         Context context,
                         ArrayList tid,
                         ArrayList num,
                         ArrayList touName,
                         ArrayList touCountry,
                         ArrayList fromDate,
                         ArrayList toDate){
        this.activity = activity;
        this.context    = context;
        this.tid = tid;
        this.num = num;
        this.touName    = touName;
        this.touCountry = touCountry;
        this.fromDate   = fromDate;
        this.toDate     = toDate;
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

              holder.tourow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, viewTournament.class);
                intent.putExtra("num", String.valueOf(num.get(position)));
                intent.putExtra("touName", String.valueOf(touName.get(position)));
                intent.putExtra("touCountry", String.valueOf(touCountry.get(position)));
                intent.putExtra("fromDate", String.valueOf(fromDate.get(position)));
                intent.putExtra("toDate", String.valueOf(toDate.get(position)));
                activity.startActivityForResult(intent, 1);
            }
        });


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
            txtVTouName  = itemView.findViewById(R.id.txtVTouName);
            txtVTouFDate = itemView.findViewById(R.id.txtVTouFDate);
            txtVTouTDate = itemView.findViewById(R.id.txtVTouTDate);

            //vtouDetails  = itemView.findViewById(R.id.vtouDetails);
            tourow       = itemView.findViewById(R.id.tourow);

            cardViewto3for1 = itemView.findViewById(R.id.gotoview3);
        }
    }
}

