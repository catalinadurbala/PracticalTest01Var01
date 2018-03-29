package practicaltest01var01.eim.systems.cs.pub.ro.practicaltest01var01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PracticalTest01Var01MainActivity extends AppCompatActivity {

    private int numCardSelected = 0;

    final public static int SECONDARY_REQUEST_CODE = 123;

    private Button NButton;
    private Button WButton;
    private Button EButton;
    private Button SButton;
    private TextView cardinalTextView;
    private TextView numCardinalTextView;
    private Button SecActivityButton;

    private CardinalButtonClickListener cardinalButtonClickListener = new CardinalButtonClickListener();
    private class CardinalButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Button b = (Button)view;
            String card = b.getText().toString();
            if (cardinalTextView.getText().toString().equals("")) {
                cardinalTextView.setText(cardinalTextView.getText().toString() + card);
            } else {
                cardinalTextView.setText(cardinalTextView.getText().toString() + ", " + card);
            }

            numCardSelected++;
            numCardinalTextView.setText(Integer.toString(numCardSelected));
        }
    }

    private SecActivityButtonClickListener secActivityButtonClickListener = new SecActivityButtonClickListener();
    private class SecActivityButtonClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent("practicaltest01var01.eim.systems.cs.pub.ro.intent.action.PracticalTest01Var01SecondaryActivity");
            intent.putExtra("text", cardinalTextView.getText().toString());
            
            startActivityForResult(intent, SECONDARY_REQUEST_CODE);
        }
    }


    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        Toast.makeText(getApplicationContext(), Integer.toString(resultCode), Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var01_main);

        NButton = findViewById(R.id.button_n);
        NButton.setOnClickListener(cardinalButtonClickListener);
        EButton = findViewById(R.id.button_e);
        EButton.setOnClickListener(cardinalButtonClickListener);
        WButton = findViewById(R.id.button_w);
        WButton.setOnClickListener(cardinalButtonClickListener);
        SButton = findViewById(R.id.button_s);
        SButton.setOnClickListener(cardinalButtonClickListener);
        cardinalTextView = findViewById(R.id.cardinal_text_view);
        numCardinalTextView = findViewById(R.id.num_cardinal_text_view);
        numCardinalTextView.setText(Integer.toString(numCardSelected));
        SecActivityButton = findViewById(R.id.button_sec_activity);
        SecActivityButton.setOnClickListener(secActivityButtonClickListener);

        if (savedInstanceState != null) {
            numCardSelected = savedInstanceState.getInt("num_card");
            numCardinalTextView.setText(Integer.toString(numCardSelected));
        }
    }

    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("num_card", numCardSelected);
    }
}
