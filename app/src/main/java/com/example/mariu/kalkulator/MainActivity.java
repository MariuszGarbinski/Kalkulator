package com.example.mariu.kalkulator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView textViewResult;
    private TextView textViewWarning;
    private EditText editTextKm;
    private EditText editTextPrice;
    private EditText editTextZl;
    private Button btnResult;
    private Button btnHelp;
    private Button btnReturn;
    private Float num1;
    private Float num2;
    private Float num3;
    private Float num4;
    private Float eq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onClick(View view) {

        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewWarning = (TextView) findViewById(R.id.textViewWarning);
        editTextKm = (EditText) findViewById(R.id.editTextKm);
        editTextZl = (EditText) findViewById(R.id.editTextZl);
        editTextPrice = (EditText) findViewById(R.id.editTextPrice);
        btnResult = (Button) findViewById(R.id.btnResult);
        btnHelp = (Button) findViewById(R.id.btnHelp);
        if (view == btnResult) Result();

        if (view == btnHelp) helpClick(view);
    }

    public void Result() {
        String msg = "";
        if (editTextZl.length() == 0) {
            num1 = 0F;
            msg += "Brak wartości tankowania!!! \n";
        } else {
            num1 = Float.parseFloat(editTextZl.getText().toString());
        }
        if (editTextPrice.length() == 0) {
            num2 = 0F;
            msg += "Brak ceny paliwa!!! \n";
        } else {
            num2 = Float.parseFloat(editTextPrice.getText().toString());
        }
        if (editTextKm.length() == 0) {
            num3 = 0F;
            msg += "Brak ilości kilometrów!!!";
        } else {
            num3 = Float.parseFloat(editTextKm.getText().toString());
        }
        textViewWarning.setText(msg);

        if(num1 == 0 || num2 == 0 || num3 == 0){
            textViewResult.setText("");
        }else{
            num4 = num1 / num2 / num3;
            eq = num4 * 100;

            textViewResult.setText(String.format("= %.2f", eq));
        }
    }

    public void helpClick(View view) {
        setContentView(R.layout.help);
        btnReturn = (Button) findViewById(R.id.btnReturn);

        TextView helper = (TextView) findViewById(R.id.text);
        helper.setText("Sposób obliczania spalania paliwa\n\n" +
                "Wartość tankowania w złotówkach jest dzielona przez cenę litra co daje liczbę zatankowanych litrów\n" +
                "Liczba zatankowanych litrów jest dzielona przez liczbę kilometrów\n" +
                "Wynik tego dzielenia mnoży się przez 100 aby uzyskać wynik z dwoma miejscami po przecinku\n");
    }

    public void rightClick(View view) {
        setContentView(R.layout.rights);
        btnReturn = (Button) findViewById(R.id.btnReturn);
        //btnReturn.setOnClickListener(this);
        TextView right = (TextView) findViewById(R.id.text1);
        right.setText("Mariusz Garbiński (id.: 29304)\n\n" +
                "Projekt był inspirowany przez rozwiązania GNU GPL.\n" +
                "Powstała aplikacja, która pomaga autorom w przeznaczeniu swoich prac do publicznego udostępnienia\n" +
                "albo zachowania copyright w wypadku licencjonowania prac do bezpłatnego użytku\n" +
                "dla określonych osób, na określonych warunkach");
    }

    public void returnClick(View view) {
        setContentView(R.layout.activity_main);
    }
}
