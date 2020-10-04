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
import app.mad.admini.tournaments.tournament.models.PlayerODIModel;

public class PlayerProfileEdit extends AppCompatActivity {

    EditText name, age,teams,role,tmatch,tinnings,notout,truns,tbf,ths,tave,tsr,t50,t100;
    EditText bmatch,binning,balls,bruns,wkts,bsr,bbm,bave,econ;
    Button btnUpdate,btnCancel;
    ImageView editPlayerImage;
    private DbHandlerS dbHandlerS;
    private Context context;
    private long updatedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_profile_edit);

        context = this;
        editPlayerImage = findViewById(R.id.editprofilePic);

        name = findViewById(R.id.editplayername);
        age = findViewById(R.id.editage);
        teams = findViewById(R.id.editteams);
        role = findViewById(R.id.editrole);
        tmatch = findViewById(R.id.editmatch1);
        notout = findViewById(R.id.editnotout);
        truns = findViewById(R.id.editruns);
        tbf = findViewById(R.id.editbf);
        ths = findViewById(R.id.ediths);
        tave = findViewById(R.id.editavg);
        tsr = findViewById(R.id.editsr);
        t50 = findViewById(R.id.edits50);
        t100 = findViewById(R.id.edits100);
        bmatch = findViewById(R.id.editmatch2);
        binning = findViewById(R.id.editinn2);
        balls = findViewById(R.id.editballs);
        bruns = findViewById(R.id.editruns2);
        wkts = findViewById(R.id.editwkt);
        bsr = findViewById(R.id.editsr2);
        bbm = findViewById(R.id.editbbm);
        bave = findViewById(R.id.editavg2);
        econ = findViewById(R.id.editecon);
        tinnings = findViewById(R.id.editinn1);

        dbHandlerS = new DbHandlerS(context);
        final String id =getIntent().getStringExtra("id");
        System.out.println("id passing "+id);

        final PlayerODIModel playerODIModel = dbHandlerS.getSinglePlayer(Integer.parseInt(id));

        editPlayerImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityCompat.requestPermissions(
                        PlayerProfileEdit.this,
                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                        888
                );
            }
        });

        btnUpdate = findViewById(R.id.editbtnSubmit);
        btnCancel = findViewById(R.id.editbtnRemove);

        name.setText(playerODIModel.getName());
        age.setText(String.valueOf(playerODIModel.getAge()));
        teams.setText(playerODIModel.getTeams());
        role.setText(String.valueOf(playerODIModel.getRole()));
        tmatch.setText(String.valueOf(playerODIModel.getTmatches()));
        notout.setText(String.valueOf(playerODIModel.getNotout()));
        truns.setText(String.valueOf(playerODIModel.getTruns()));
        tbf.setText(String.valueOf(playerODIModel.getBf()));
        ths.setText(String.valueOf(playerODIModel.getHs()));
        tave.setText(String.valueOf(playerODIModel.getTaverage()));
        tsr.setText(String.valueOf(playerODIModel.getTsr()));
        t50.setText(String.valueOf(playerODIModel.getS50()));
        t100.setText(String.valueOf(playerODIModel.getS100()));
        bmatch.setText(String.valueOf(playerODIModel.getBmatches()));
        binning.setText(String.valueOf(playerODIModel.getBinnings()));
        balls.setText(String.valueOf(playerODIModel.getBalls()));
        bruns.setText(String.valueOf(playerODIModel.getBruns()));
        wkts.setText(String.valueOf(playerODIModel.getWkts()));
        bsr.setText(String.valueOf(playerODIModel.getBsr()));
        bbm.setText(String.valueOf(playerODIModel.getBbm()));
        bave.setText(String.valueOf(playerODIModel.getBaverage()));
        econ.setText(String.valueOf(playerODIModel.getEconomy()));
        tinnings.setText(String.valueOf(playerODIModel.getTinnings()));

        try {
            byte[] recordImage = playerODIModel.getProfimage();
            Bitmap bm = BitmapFactory.decodeByteArray(recordImage, 0, recordImage.length);
            editPlayerImage.setImageBitmap(bm);
        }catch (Exception e){
            e.printStackTrace();
        }



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String pname = name.getText().toString();
                    String page = age.getText().toString();
                    String pteams = teams.getText().toString();
                    String prole =role.getText().toString();
                    String inn2 = binning.getText().toString();
                    String ball = balls.getText().toString();
                    String run2 = bruns.getText().toString();
                    String wkt = wkts.getText().toString();
                    String match1 =tmatch.getText().toString();
                    String pnotout = notout.getText().toString();
                    String inn1 = tinnings.getText().toString();
                    String run1 = truns.getText().toString();
                    String bf1 = tbf.getText().toString();
                    String hs1 = ths.getText().toString();
                    String sr1 = tsr.getText().toString();
                    String ave1 = tave.getText().toString();
                    String s50 = t50.getText().toString();
                    String s100 = t100.getText().toString();
                    String match2 =bmatch.getText().toString();
                    String sr2 = bsr.getText().toString();
                    String bbm1 = bbm.getText().toString();
                    String ave2 = bave.getText().toString();
                    String economy = econ.getText().toString();
                    byte[] image = PlayerProfileAdd.imageViewToByte(editPlayerImage);
                    updatedDate = System.currentTimeMillis();

                    PlayerODIModel playerODIModel2 = new PlayerODIModel(Integer.parseInt(id),image,pname,Integer.parseInt(page),pteams,prole,
                            Integer.parseInt(match1),Integer.parseInt(inn1),Integer.parseInt(pnotout),Integer.parseInt(run1),Integer.parseInt(bf1),
                            Integer.parseInt(hs1),Float.parseFloat(ave1),Float.parseFloat(sr1),Integer.parseInt(s50),Integer.parseInt(s100),
                            Integer.parseInt(match2),Integer.parseInt(inn2),Integer.parseInt(ball),Integer.parseInt(run2),Integer.parseInt(wkt),
                            Integer.parseInt(bbm1),Float.parseFloat(ave2),Float.parseFloat(economy),Float.parseFloat(sr2));
                    int state = dbHandlerS.updatePlayer(playerODIModel2);
                    System.out.println(pname);
                    //System.out.println(playerODIModel2);
                    System.out.println(state);
                    Toast.makeText(context, "updated!!!", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(context, PlayerList.class));
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,PlayerList.class);
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
                editPlayerImage.setImageURI(resultUri);
            }else if(requestCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE){
                Exception error = result.getError();
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}