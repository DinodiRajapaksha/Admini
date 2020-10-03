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
import app.mad.admini.tournaments.tournament.AdminCalculatePlayer;
import app.mad.admini.tournaments.tournament.PlayerList;
import app.mad.admini.tournaments.tournament.PlayerProfileEdit;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class PlayerAdapter extends ArrayAdapter<PlayerODIModel> {
    private Context context;
    private int resource;
    List<PlayerODIModel> player;
    ImageView btnupdate,btndelete,btnCalc;
    DbHandlerS dbHandlerS;

    public PlayerAdapter(@NonNull Context context, int resource, @NonNull List<PlayerODIModel> player) {
        super(context, resource, player);
        this.context = context;
        this.resource=resource;
        this.player = player;
    }
    @Override
    public int getCount() {
        return player.size();
    }

    @Nullable
    @Override
    public PlayerODIModel getItem(int i) {
        return player.get(i);
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

        TextView playerName = row.findViewById(R.id.postPlayerName);
        TextView playerRole = row.findViewById(R.id.playerRole);
        ImageView image =  row.findViewById(R.id.palyerImage);
        btnupdate = row.findViewById(R.id.btnPlayerListEdit);
        btndelete = row.findViewById(R.id.btnPlayerListDelete);
        btnCalc = row.findViewById(R.id.btnPlayerListcal);



        final PlayerODIModel playerODIModel = player.get(position);
        playerName.setText(playerODIModel.getName());
        playerRole.setText(playerODIModel.getRole());

        try {
            byte[] recordImage = playerODIModel.getProfimage();
            Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length);
            image.setImageBitmap(bitmap);
        }catch (Exception e){
            e.printStackTrace();
        }

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, PlayerProfileEdit.class);
                intent.putExtra("id",String.valueOf(playerODIModel.getPid()));
                Toast.makeText(context, "Update Player Profile", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Delete Player");
                builder.setMessage("Confirm your action");

                builder.setPositiveButton("Delete", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dbHandlerS.deletePlayer(playerODIModel.getPid());
                        Toast.makeText(context, "Player Deleted Successfully", Toast.LENGTH_SHORT).show();
                        context.startActivity(new Intent(context, PlayerList.class));
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
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, AdminCalculatePlayer.class);
                intent.putExtra("id",String.valueOf(playerODIModel.getPid()));
                Toast.makeText(context, "Update Player Profile", Toast.LENGTH_SHORT).show();
                context.startActivity(intent);
            }
        });


        return row;
    }



}
