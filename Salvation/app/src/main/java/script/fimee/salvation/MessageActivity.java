package script.fimee.salvation;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;


public class MessageActivity extends Activity {

    ListView lvMessages;
    Button btnContacts, btnAddMessage, btnDeleteMessage;
    //String[] valores = new String[]{"Mexico", "holanda"};
    //ArrayList<String> nombres= new ArrayList<String>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        lvMessages= findViewById(R.id.lvMessages);
        btnContacts=findViewById(R.id.btnContacts);
        btnAddMessage=findViewById(R.id.btnAdd);
        btnDeleteMessage=findViewById(R.id.btnDelete);
        //nombres= new ArrayList<String>();


        SharedPreferences preferences = getSharedPreferences("Mensajes", Activity.MODE_PRIVATE); //Acceder a los archivos
        SharedPreferences.Editor editor = preferences.edit(); //Editar archivo
        String mensaje= preferences.getString("newmensaje", " ");
        //nombres.add(mensaje);

        List<MessageArray> resultadoConsulta = MessageArray.listAll(MessageArray.class);
        final ArrayList<String> lista1=new ArrayList<String>();
        for (int i=0; i<resultadoConsulta.size(); i++)
        {
            MessageArray result = resultadoConsulta.get(i);
            lista1.add(""+result.getNewMessage());
        }



        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista1);
        lvMessages.setAdapter(adapter);


        btnAddMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MessageActivity.this, NewMessageActivity.class));
            }
        });

        btnContacts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(MessageActivity.this, ContactActivity.class));
            }
        });



        lvMessages.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                btnDeleteMessage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MessageActivity.this);
                        dialogo1.setTitle("ATENTION");
                        dialogo1.setMessage("Are you sure?");
                        dialogo1.setCancelable(false);

                        dialogo1.setPositiveButton("Yes, do it!", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {

                                lista1.remove(position);
                                adapter.notifyDataSetChanged();
                            }
                        });

                        dialogo1.setNegativeButton("No, I'm not", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogo1, int id) {
                            }
                        });
                        dialogo1.show();



                    }
                });



            }
        });




    }
}
