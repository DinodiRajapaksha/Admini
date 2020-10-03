package app.mad.admini.tournaments.tournament.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.MerchEdit;
import app.mad.admini.tournaments.tournament.MerchList;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class MerchAdapter extends ArrayAdapter<MerchModel> {

    private Context context;
    private int resource;
    List<MerchModel> merch;
    ImageView btnupdate,btndelete;
    DbHandlerS dbHandlerS;

    public MerchAdapter(Context context, int resource, List<MerchModel> merch){
        super(context, resource,merch);
        this.context = context;
        this.resource = resource;
        this.merch = merch;
    }

    @Override
    public int getCount() {
        return merch.size();
    }

    @Nullable
    @Override
    public MerchModel getItem(int i) {
        return merch.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource, parent, false);
        dbHandlerS = new DbHandlerS(context);

        TextView tournamentNameM = row.findViewById(R.id.postTourNameMerch);
        TextView matchIDM = row.findViewById(R.id.postMatchIDMerch);
        TextView itemM = row.findViewById(R.id.postItemMerch);
        ImageView image =  row.findViewById(R.id.merchImage);
        btnupdate = row.findViewById(R.id.btnMerchListEdit);
        btndelete = row.findViewById(R.id.btnMerchListDelete);


        final MerchModel merchModel = merch.get(position);
        tournamentNameM.setText(merchModel.getTournamentNameMerch());
        matchIDM.setText(merchModel.getMatchIDMerch());
        itemM.setText(merchModel.getItemMerch());

        byte[] recordImage = merchModel.getMerchImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        image.setImageBitmap(bitmap);

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, MerchEdit.class);
                intent.putExtra("id",String.valueOf(merchModel.getMid()));
                Toast.makeText(context, "Update Merch Details", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Item");
                builder.setMessage("Confirm your action");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHandlerS.deleteMerch(merchModel.getMid());
                        Toast.makeText(context, "Item Deleted Successfully", Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context, MerchList.class));
                    }
                });
                builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                builder.show();

            }
        });

        return row;
    }



}
