package app.mad.admini.tournaments.tournament;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import java.io.ByteArrayOutputStream;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.MerchModel;

public class MerchEdit extends AppCompatActivity {
    EditText etEditTournName, etEditMatchID, editItemname,editqty,editPrice;
    Button btnUpdate,btnCancel;
    ImageView editImage;
    private DbHandlerS dbHandlerS;
    private Context context;
    private long updatedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merch_edit);

        context = this;

        etEditTournName = findViewById(R.id.TourName);
        etEditMatchID = findViewById(R.id.matchID);
        editItemname = findViewById(R.id.merchItem);
        editqty = findViewById(R.id.itemQty);
        editPrice = findViewById(R.id.itemPrice);
        editImage = findViewById(R.id.merchImageAdd);

        dbHandlerS = new DbHandlerS(context);
        final String id =getIntent().getStringExtra("id");
        System.out.println("id passing "+id);

        final MerchModel merchModel = dbHandlerS.getSingleMerch(Integer.parseInt(id));


        editImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        MerchEdit.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        btnUpdate = findViewById(R.id.btnUpdateMerch);
        btnCancel = findViewById(R.id.btnUpdateCancelMerch);

        etEditTournName.setText(merchModel.getTournamentNameMerch());
        etEditMatchID.setText(merchModel.getMatchIDMerch());
        editItemname.setText(merchModel.getItemMerch());
        editqty.setText(String.valueOf(merchModel.getQtyMerch()));
        editPrice.setText(String.valueOf(merchModel.getPriceMerch()));
        byte[] recordImage = merchModel.getMerchImage();
        Bitmap bm = BitmapFactory.decodeByteArray(recordImage,0,recordImage.length);
        editImage.setImageBitmap(bm);



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String tournamentName = etEditTournName.getText().toString();
                    String matchid = etEditMatchID.getText().toString();
                    String item = editItemname.getText().toString();
                    String qty = editqty.getText().toString();
                    String price = editPrice.getText().toString();
                    byte[] image = MerchAdd.imageViewToByte(editImage);


                    updatedDate = System.currentTimeMillis();

                    MerchModel merchModel1 = new MerchModel(Integer.parseInt(id), tournamentName, matchid, item, Integer.parseInt(qty), Float.parseFloat(price), image);
                    int state = dbHandlerS.updateMerch(merchModel1);
                    System.out.println(tournamentName);
                    System.out.println(state);
                    Toast.makeText(context, "updated!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, MerchList.class));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,MerchList.class);
                startActivity(intent);
            }
        });

    }
    public static byte[] imageViewToByte(ImageView image) {
        Bitmap bitmap = ((BitmapDrawable)image.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==888){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent gallertIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallertIntent.setType("image/*");
                startActivityForResult(gallertIntent,888);
            }else{
                Toast.makeText(context, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==888 && resultCode ==RESULT_OK){
            Uri imageUri = data.getData();
            CropImage.activity(imageUri)
                    .setGuidelines(CropImageView.Guidelines.ON)
                    .setAspectRatio(1,1)
                    .start(this);
        }
        if(requestCode== CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE){
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if(resultCode ==RESULT_OK){
                Uri resultUri = result.getUri();
                //set image choose from gallery to image view
                editImage.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}