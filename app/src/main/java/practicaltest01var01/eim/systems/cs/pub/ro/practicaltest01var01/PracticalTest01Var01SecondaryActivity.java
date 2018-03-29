package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01SecondaryActivity extends AppCompatActivity {

    final public static int SECONDARY_REQUEST_CODE = 123;

    private Button cancelButton;
    private Button registerButton;
    private TextView cardTextView;

    private RegisterButtonListener registerButtonListener = new RegisterButtonListener();
    private class RegisterButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_OK, new Intent());
            finish();
        }
    }

    private CancelButtonListener cancelButtonListener = new CancelButtonListener();
    private class CancelButtonListener implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            setResult(Activity.RESULT_CANCELED, new Intent());
            finish();
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_secondary);
        cancelButton = findViewById(R.id.button_cancel);
        cancelButton.setOnClickListener(cancelButtonListener);
        registerButton = findViewById(R.id.button_register);
        registerButton.setOnClickListener(registerButtonListener);
        cardTextView = findViewById(R.id.cardinal_text_view);

        Intent intent = getIntent();
        if (intent != null) {
            String cardText = intent.getStringExtra("text");
            if (cardText != null) {
                cardTextView.setText(cardText);
            } else {
                Toast.makeText(this, "nope", Toast.LENGTH_LONG).show();
            }
        }
    }
}
