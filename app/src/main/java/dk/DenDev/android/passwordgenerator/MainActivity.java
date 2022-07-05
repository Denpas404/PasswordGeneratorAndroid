package dk.DenDev.android.passwordgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.security.SecureRandom;

public class MainActivity extends AppCompatActivity {

    /*
    private CheckBox bogstaver_CB;
    private TextView bogstaverCB_TV;
    private CheckBox tal_CB;
    private TextView talCB_TV;
    */
    private EditText passwordNR_ETN;
    private TextView passwordNR_TV;
    private Button password_BTN;
    private TextView passwordForslag_TV;

    private int len = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        bogstaver_CB = findViewById(R.id.bogstaver_checkBox);
        bogstaverCB_TV = findViewById(R.id.bogstaver_textView);
        tal_CB = findViewById(R.id.tal_checkBox);
        talCB_TV = findViewById(R.id.tal_textView);
         */
        passwordNR_ETN = findViewById(R.id.passwordNR_ETN);
        passwordNR_TV = findViewById(R.id.password_længde_textView);
        password_BTN = findViewById(R.id.passwordNR_btn);
        passwordForslag_TV = findViewById(R.id.passwordForslag_textView);

        password_BTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                len = Integer.parseInt((passwordNR_ETN.getText().toString()));
                if (len <= 5){
                    Toast.makeText(MainActivity.this, "Password skal mindst være 6 \"tegn\"", Toast.LENGTH_SHORT).show();
                }

                passwordForslag_TV.setText(generate(len));
            }
        });

    }//@Override onCreate end

    private static String generate (int len){

        final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder();

            // each iteration of the loop randomly chooses a character from the given
            // ASCII range and appends it to the `StringBuilder` instance

            for (int i = 0; i < len; i++)
            {
                int randomIndex = random.nextInt(chars.length());
                sb.append(chars.charAt(randomIndex));
            }

        return sb.toString();

    }//Methode end

}//Class end