package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import app.mad.admini.R;

public class login extends AppCompatActivity {

    EditText editUname, editUpwd;
    Button btnLogin;
    TextView txtWarn;
    Integer counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        editUname = findViewById(R.id.editUname);
        editUpwd = findViewById(R.id.editUpwd);
        btnLogin = findViewById(R.id.btnLogin);
        txtWarn = findViewById(R.id.txtWarn);


        txtWarn.setText("Remaining Attempts: "+ 5);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(editUname.getText().toString(), editUpwd.getText().toString());
            }
        });
    }

    private void validate(String editUname, String editUpwd){

        if(editUname.equals("ADMIN") && (editUpwd.equals("ADMIN123"))){
            Intent intent = new Intent(login.this, MainActivity.class);
            startActivity(intent);
        }else {
            counter--;

            txtWarn.setText("Remaining Attempts: "+ String.valueOf(counter));

            if(counter==0){
                btnLogin.setEnabled(false);
            }
        }
    }
}

