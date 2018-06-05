package script.fimee.salvation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;


public class ContactActivity extends Activity {

    ListView lvContacts;

    String[] contactos= new String[]{"Juan Calderon", "David Morita", "Hugo Hernandez","Ariel Bautista","Javier Ramirez","Aldair Zepeda","Dulce Frias","Miguel Cortes"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        lvContacts = findViewById(R.id.lvContacts);

        ArrayAdapter<String> adapterC = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, contactos);

        lvContacts.setAdapter(adapterC);


        lvContacts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {

                    Intent intent = new Intent(ContactActivity.this, MessageActivity.class);
                    intent.putExtra("case", "0");
                    startActivity(intent);

                    //startActivity(new Intent(ContactActivity.this, MessageActivity.class));
                } else if (position == 1) {

                    Intent intent = new Intent(ContactActivity.this, MessageActivity.class);
                    intent.putExtra("case", "1");
                    startActivity(intent);

                } else if (position == 2) {

                    Intent intent = new Intent(ContactActivity.this, MessageActivity.class);
                    intent.putExtra("case", "2");
                    startActivity(intent);

                } else if (position == 3) {

                    Intent intent = new Intent(ContactActivity.this, MessageActivity.class);
                    intent.putExtra("case", "3");
                    startActivity(intent);

                }
            }
        });



    }

}
