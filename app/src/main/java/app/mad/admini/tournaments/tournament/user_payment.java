package app.mad.admini.tournaments.tournament;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputEditText;

import app.mad.admini.R;
import app.mad.admini.tournaments.tournament.helper.DbHandlerS;
import app.mad.admini.tournaments.tournament.models.TicketModel;

public class user_payment extends AppCompatActivity {
    RadioGroup rg;
    RadioButton rb;
    Button pay;
    Context context;
    TextInputEditText cardNo, cardName,expireDate,cvv;
    //int id;
    DbHandlerS dbHandlerS;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_payment);
        context=this;
        dbHandlerS = new DbHandlerS(context);

        pay = findViewById(R.id.paybtn);
        cardNo = findViewById(R.id.cardNo);
        cardName = findViewById(R.id.holderName);
        expireDate = findViewById(R.id.exdate);
        cvv = findViewById(R.id.cvv);

        /*id=userTicketCardView.getActivityInstance().getData();
        System.out.println("get id integer payment "+id);*/
        Intent intent = getIntent();
        final String ID = intent.getStringExtra("matchID");
        System.out.println("get id integer payement intent "+ID);

        //assert ID != null;
        //final int id = Integer.parseInt(ID);

        final String qty1 = intent.getStringExtra("qty1");
        System.out.println("qty1  "+qty1);
        final String qty2 = intent.getStringExtra("qty2");
        System.out.println("qty2  "+qty2);
        /*try {
            final int ticket1 = Integer.parseInt(qty1);
            final int ticket2 = Integer.parseInt(qty2);
            final int id = Integer.parseInt(ID);
        }catch (Exception e){
            e.printStackTrace();
        }
*/

        final String spin1 = intent.getStringExtra("spinner1");
        System.out.println("spinner 1 pay  "+spin1);
        final String spin2 = intent.getStringExtra("spinner2");
        System.out.println("spinner 2 pay "+spin2);

        pay.setOnClickListener(new View.OnClickListener() {

            @Override
                public void onClick(View view) {
                //validation
                    if(!validateCardNo() | !validateHolderName() | !validateExDate() | !validateCvv()){
                        return;
                    }
                    //do calculations for tickets
                TicketModel ticketmodel = new TicketModel();
                dbHandlerS.getNumberOfTickets(Integer.parseInt(ID),spin1,spin2,Integer.parseInt(qty1),Integer.parseInt(qty2));


                    //alert box
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle("Your data has been recorded successfully!!");
                    builder.setMessage("Confirm your payment");

                    builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            //dbHandlerS.deleteTickets(ticketModel.getTid());
                            Toast.makeText(context, "Payment Successful", Toast.LENGTH_SHORT).show();
                            context.startActivity(new Intent(context, UserHome.class));
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
        }

        public boolean validateCardNo(){
            String cardInput = cardNo.getText().toString().trim();
            if(cardInput.isEmpty()){
                cardNo.setError("Field can't be empty!");
                return false;
            }else if(cardInput.length()>16){
                cardNo.setError("Card Number is too long!");
                return false;
            }else if(cardInput.length()<16) {
                cardNo.setError("Card Number is too short!");
                return false;
            }else{
                cardNo.setError(null);
                return true;
            }
        }
    public boolean validateHolderName(){
        String name = cardName.getText().toString().trim();
        if(name.isEmpty()){
            cardName.setError("Field can't be empty!");
            return false;
        }else{
            cardName.setError(null);
            return true;
        }
    }
    public boolean validateExDate(){
        String exdate = expireDate.getText().toString().trim();
        if(exdate.isEmpty()){
            expireDate.setError("Field can't be empty!");
            return false;
        }else{
            expireDate.setError(null);
            return true;
        }
    }
    public boolean validateCvv(){
        String cvvl = cvv.getText().toString().trim();
        if(cvvl.isEmpty()){
            cvv.setError("Field can't be empty!");
            return false;
        }else if(cvvl.length()>3){
            cardNo.setError("CVV Number is too long!");
            return false;
        }else if(cvvl.length()<3){
        cardNo.setError("CVV Number is too short!");
        return false;
        }else{
            cvv.setError(null);
            return true;
        }
    }

}