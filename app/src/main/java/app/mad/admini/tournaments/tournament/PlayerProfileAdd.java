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
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class PlayerProfileAdd extends AppCompatActivity {
    Button addPlayer;
    EditText name, age,teams,role,tmatch,tinnings,notout,truns,tbf,ths,tave,tsr,t50,t100;
    EditText bmatch,binning,balls,bruns,wkts,bsr,bbm,bave,econ;
    ImageView profimage;
    private DbHandlerS dbHandlerS;
    private Context context;

    private static final int REQUEST_CODE_GALLERY = 999;

    private String[] cameraPermisiion;
    private String[] storagePermssion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile_add);
        context=this;

        addPlayer = findViewById(R.id.btnprofileadd);

        name = findViewById(R.id.playername);
        age = findViewById(R.id.age);
        teams = findViewById(R.id.teams);
        role = findViewById(R.id.role);
        tmatch = findViewById(R.id.match1);
        notout = findViewById(R.id.notout);
        truns = findViewById(R.id.runs);
        tbf = findViewById(R.id.bf);
        ths = findViewById(R.id.hs);
        tave = findViewById(R.id.avg);
        tsr = findViewById(R.id.sr);
        t50 = findViewById(R.id.s50);
        t100 = findViewById(R.id.s100);
        bmatch = findViewById(R.id.match2);
        binning = findViewById(R.id.inn2);
        balls = findViewById(R.id.balls);
        bruns = findViewById(R.id.runs2);
        wkts = findViewById(R.id.wkt);
        bsr = findViewById(R.id.sr2);
        bbm = findViewById(R.id.bbm);
        bave = findViewById(R.id.avg2);
        econ = findViewById(R.id.econ);
        tinnings = findViewById(R.id.inn1);

        profimage = findViewById(R.id.profilePic);


        dbHandlerS = new DbHandlerS(context);

        cameraPermisiion =new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermssion = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        profimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        PlayerProfileAdd.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        REQUEST_CODE_GALLERY
                );
            }
        });

        addPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String pname = name.getText().toString();
                    Integer page = Integer.parseInt(age.getText().toString());
                    String pteams = teams.getText().toString();
                    String prole =role.getText().toString();
                    Integer inn2 = Integer.parseInt(binning.getText().toString());
                    Integer ball = Integer.parseInt(balls.getText().toString());
                    Integer run2 = Integer.parseInt(bruns.getText().toString());
                    Integer wkt = Integer.parseInt(wkts.getText().toString());
                    Integer match1 = Integer.parseInt(tmatch.getText().toString());
                    Integer pnotout = Integer.parseInt(notout.getText().toString());
                    Integer inn1 = Integer.parseInt(tinnings.getText().toString());
                    Integer run1 = Integer.parseInt(truns.getText().toString());
                    Integer bf1 = Integer.parseInt(tbf.getText().toString());
                    Integer hs1 = Integer.parseInt(ths.getText().toString());
                    Float sr1 = Float.parseFloat(tsr.getText().toString());
                    Float ave1 = Float.parseFloat(tave.getText().toString());
                    Integer s50 = Integer.parseInt(t50.getText().toString());
                    Integer s100 = Integer.parseInt(t100.getText().toString());
                    Integer match2 = Integer.parseInt(bmatch.getText().toString());

                    Float sr2 = Float.parseFloat(bsr.getText().toString());
                    Integer bbm1 = Integer.parseInt(bbm.getText().toString());
                    Float ave2 = Float.parseFloat(bave.getText().toString());
                    Float economy = Float.parseFloat(econ.getText().toString());

                    byte[] image = imageViewToByte(profimage);

                    PlayerODIModel playerODIModel = new PlayerODIModel(page,match1,inn1,pnotout,run1,bf1,hs1,s50,s100,
                            match2,inn2,ball,run2,wkt,bbm1,pname,pteams,prole,ave1,sr1,ave2,economy,sr2,image);
                    dbHandlerS.addPlayerOdi(playerODIModel);
                    Toast.makeText(getApplicationContext(), "Successfully inserted", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, PlayerList.class));
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
        name.setText("");
        age.setText("");
        teams.setText("");
        role.setText("");
        tmatch.setText("");
        notout.setText("");
        truns.setText("");
        tbf.setText("");
        ths.setText("");
        tsr.setText("");
        tave.setText("");
        t50.setText("");
        t100.setText("");
        bmatch.setText("");
        binning.setText("");
        balls.setText("");
        bruns.setText("");
        wkts.setText("");
        bsr.setText("");
        bbm.setText("");
        bave.setText("");
        econ.setText("");
        tinnings.setText("");
        profimage.setImageResource(R.drawable.profpicupload);
    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if(requestCode==REQUEST_CODE_GALLERY){
            if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED){
                //gallery intent
                Intent galleryIntent = new Intent(Intent.ACTION_GET_CONTENT);
                galleryIntent.setType("image/*");
                startActivityForResult(galleryIntent,REQUEST_CODE_GALLERY);
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
                profimage.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

}