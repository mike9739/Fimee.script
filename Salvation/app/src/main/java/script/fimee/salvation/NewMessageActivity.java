package script.fimee.salvation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.content.Intent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class NewMessageActivity extends Activity {


    EditText txtNewMessage;
    Button btnSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_message);

        txtNewMessage= findViewById(R.id.txtNewMessage);
        btnSend=findViewById(R.id.btnSend);




        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //GUARDAR FECHA DE MODIFICACIÓN DE PESO
                SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm"); //Formato hora
                SimpleDateFormat formatFecha=new SimpleDateFormat("dd/MM/yyy"); //Formato dia
                Date diaActual= Calendar.getInstance().getTime(); //Dia y hora del celular
                String Dia=formatFecha.format(diaActual);
                Date hora = Calendar.getInstance().getTime();//Hora Actual
                String HoraActual = formatoHora.format(hora);
                String Time= Dia+"  "+HoraActual;

                SharedPreferences preferences = getSharedPreferences("Mensajes", Context.MODE_PRIVATE); //Acceder a los archivos
                SharedPreferences.Editor editor = preferences.edit(); //Editar archivo

                String mensaje = txtNewMessage.getText().toString();

                editor.putString("newmensaje", mensaje);
                editor.commit();

                MessageArray messageArray = new MessageArray(mensaje); //Guarda datos recien ingresados
                messageArray.save();

                startActivity(new Intent(NewMessageActivity.this, MessageActivity.class));





            }
        });



    }
}