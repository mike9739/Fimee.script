package script.fimee.salvation;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.StrictMode;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Context;
import android.widget.Toast;



public class MainActivity extends Activity {


    EditText txtUsername, txtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtUsername=findViewById(R.id.txtUser);
        txtPassword=findViewById(R.id.txtPassword);

        Intent intent = new Intent(MainActivity.this, ContactActivity.class);
        intent.putExtra("Username", txtUsername.getText().toString());
        //startActivity(intent);
    }

    public void Login(View view) {


        if (txtUsername.getText().toString().equals("Miguel Vazquez")&&(txtPassword.getText().toString().equals("1234")))
        {
            startActivity(new Intent(MainActivity.this, ContactActivity.class));
        }
        else
        {
            Toast.makeText(getApplicationContext(), "DATOS ERRONEOS", Toast.LENGTH_SHORT).show();
        }





    }

    /*
    public void btnAdd(View v)
    {
        CallWebService("Addition");
    }

    public void btnSubtract(View v)
    {
        CallWebService("Subtraction");
    }
    */



}

