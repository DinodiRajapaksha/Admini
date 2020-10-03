package app.mad.admini.tournaments.tournament.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class UserMerchAdapter extends ArrayAdapter<MerchModel> {
    private Context context;
    private int resource;
    List<MerchModel> merch;
    DbHandlerS dbHandlerS;

    public UserMerchAdapter(Context context, int resource, List<MerchModel> merch) {
        super(context, resource, merch);
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

        TextView itemname = row.findViewById(R.id.itemname);
        TextView itemprice = row.findViewById(R.id.itemprice);
        ImageView image = row.findViewById(R.id.imgitem);


        final MerchModel merchModel = merch.get(position);
        itemname.setText(merchModel.getItemMerch());
        itemprice.setText(String.valueOf(merchModel.getPriceMerch()));

        byte[] recordImage = merchModel.getMerchImage();
        Bitmap bitmap = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length);
        image.setImageBitmap(bitmap);

        return row;
    }
}
