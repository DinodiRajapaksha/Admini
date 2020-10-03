package app.mad.admini.tournaments.tournament;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
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

public class MerchAdd extends AppCompatActivity {
    Button addMerch;
    EditText tournamentNameMerch, matchIDMerch,Item,qtyMerch,itemPriceMerch;
    ImageView addImage;
    private DbHandlerS dbHandlerS;
    private Context context;

    private static final int REQUEST_CODE_GALLERY = 999;

    private String[] cameraPermisiion;
    private String[] storagePermssion;
    //private Uri imageUri;
   // private Object MediaStore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_merch_add);
        context=this;

        addMerch = findViewById(R.id.btnAddMerchSubmit);

        tournamentNameMerch = findViewById(R.id.TourName);
        matchIDMerch = findViewById(R.id.matchID);
        Item = findViewById(R.id.merchItem);
        qtyMerch = findViewById(R.id.itemQty);
        itemPriceMerch = findViewById(R.id.itemPrice);
        addImage = findViewById(R.id.merchImageAdd);
        dbHandlerS = new DbHandlerS(context);

        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        addImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        MerchAdd.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        addMerch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String mTourName = tournamentNameMerch.getText().toString();
                    String matchid = matchIDMerch.getText().toString();
                    String item = Item.getText().toString();
                    Integer qty = Integer.parseInt(qtyMerch.getText().toString());
                    Float price = Float.parseFloat(itemPriceMerch.getText().toString());
                    byte[] image = imageViewToByte(addImage);

                    MerchModel merchModel = new MerchModel(mTourName, matchid, item, qty, price, image);
                    dbHandlerS.addMerch(merchModel);
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                    clearControls();
                }catch(Exception e){
                    e.printStackTrace();
                }
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


    private void clearControls(){
        tournamentNameMerch.setText("");
        matchIDMerch.setText("");
        Item.setText("");
        qtyMerch.setText("");
        itemPriceMerch.setText("");
        addImage.setImageResource(R.drawable.ic_baseline_add_a_photo_24);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent gallertIntent = new Intent(Intent.ACTION_GET_CONTENT);
                gallertIntent.setType("image/*");
                startActivityForResult(gallertIntent,REQUEST_CODE_GALLERY);
            }else{
                Toast.makeText(context, "Don't have permission to access file location", Toast.LENGTH_SHORT).show();
            }
            return;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if(requestCode==REQUEST_CODE_GALLERY && resultCode ==RESULT_OK){
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
                addImage.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }


}