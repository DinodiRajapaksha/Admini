package app.mad.admini.tournaments.tournament;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import app.mad.admini.R;

public class one extends AppCompatActivity {

    String UserLoginS, AdminLoginS;
    private CardView UserLogin, AdminLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.one);

        UserLogin = findViewById(R.id.UserLogin);
        AdminLogin= findViewById(R.id.AdminLogin);

        UserLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(one.this, UserHome.class);
                intent.putExtra("UserLoginS", UserLoginS);
                startActivity(intent);
            }
        });

        AdminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(one.this, login.class);
                intent.putExtra("AdminLoginS", AdminLoginS);
                startActivity(intent);
            }
        });
    }
}
