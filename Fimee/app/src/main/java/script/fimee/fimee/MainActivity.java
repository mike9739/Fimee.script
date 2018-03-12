package script.fimee.fimee;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Double[] numeros = new Double[20];
    Double resultado;
    boolean decimal = false;
    boolean suma = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se configuran los bones de numeros
        Button zero = findViewById(R.id.bt0);
        zero.setOnClickListener(this);
        Button one = (Button) findViewById(R.id.bt1);
        one.setOnClickListener(this);
        Button two = (Button) findViewById(R.id.bt2);
        two.setOnClickListener(this);
        Button three = (Button) findViewById(R.id.bt3);
        three.setOnClickListener(this);
        Button four = (Button) findViewById(R.id.bt4);
        four.setOnClickListener(this);
        Button five = (Button) findViewById(R.id.bt5);
        five.setOnClickListener(this);
        Button six = (Button) findViewById(R.id.bt6);
        six.setOnClickListener(this);
        Button seven = (Button) findViewById(R.id.bt7);
        seven.setOnClickListener(this);
        Button eight = (Button) findViewById(R.id.bt8);
        eight.setOnClickListener(this);
        Button nine = (Button) findViewById(R.id.bt9);
        nine.setOnClickListener(this);
        Button dec = (Button) findViewById(R.id.btdec);
        dec.setOnClickListener(this);


        //se configuran los botones de funciones
        Button sum = (Button) findViewById(R.id.btsum);
        sum.setOnClickListener(this);
        Button less = (Button) findViewById(R.id.btless);
        less.setOnClickListener(this);
        Button mult = (Button) findViewById(R.id.btmult);
        mult.setOnClickListener(this);
        Button div = (Button) findViewById(R.id.btdivision);
        div.setOnClickListener(this);
        Button desc = (Button) findViewById(R.id.btdesc);
        desc.setOnClickListener(this);
        Button equal = (Button) findViewById(R.id.btequal);
        equal.setOnClickListener(this);
        Button percent = (Button) findViewById(R.id.btpercent);
        percent.setOnClickListener(this);
        Button clear = (Button) findViewById(R.id.btclear);
        clear.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        TextView screen = (TextView)findViewById(R.id.TVResult);
        int selection = v.getId();
        String num = screen.getText().toString();
        try {
            switch (selection) {
                case R.id.bt0:
                    screen.setText(num + "0");
                    break;
                case R.id.bt1:
                    screen.setText(num + "1");
                    break;
                case R.id.bt2:
                    screen.setText(num + "2");
                    break;
                case R.id.bt3:
                    screen.setText(num + "3");
                    break;
                case R.id.bt4:
                    screen.setText(num + "4");
                    break;
                case R.id.bt5:
                    screen.setText(num + "5");
                    break;
                case R.id.bt6:
                    screen.setText(num + "6");
                    break;
                case R.id.bt7:
                    screen.setText(num + "7");
                    break;
                case R.id.bt8:
                    screen.setText(num + "8");
                    break;
                case R.id.bt9:
                    screen.setText(num + "9");
                    break;
                case R.id.btdec:
                    if (decimal == false) {
                        screen.setText(num + ".");
                        decimal = true;
                    } else return;
                    break;

                case R.id.btless:
                    numeros[0] = Double.parseDouble(num);
                    screen.setText(num + "-");
                    decimal = false;
                    break;
                case R.id.btsum:
                    suma = true;
                    numeros[0] = Double.parseDouble(num);
                    screen.setText(num + "+");
                    decimal = false;
                    break;
                case R.id.btdivision:
                    numeros[0] = Double.parseDouble(num);
                    screen.setText(num + "/");
                    decimal = false;
                    break;
                case R.id.btmult:
                    numeros[0] = Double.parseDouble(num);
                    screen.setText(num + "*");
                    decimal = false;
                    break;
                case R.id.btpercent:
                    numeros[0] = Double.parseDouble(num);
                    double result = numeros[0]*100/numeros[1];
                    screen.setText(String.valueOf(result));
                    decimal=false;
                    break;
                case R.id.btequal:
                    if (suma)
                    {
                        resultado = numeros[1] + numeros[2];
                        screen.setText((String.valueOf(resultado)));
                    }

            }

        }
        catch (Exception e)
        {
            screen.setText("Error");
        }
    }
}
