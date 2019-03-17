package com.example.bilge.listview;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;


public class MainActivity extends AppCompatActivity {

   private String[] sehir =
           {"Edirne", "Antalya","İstanbul", "İzmir","Ankara","Çanakkale","Amasya","Ağrı","Tekirdağ","Kırklareli","Sinop","Muğla"};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listemiz = (ListView) findViewById(R.id.listView);

        //Adaptörü tanımladık ve verileri buluşturduk.
        ArrayAdapter<String> veriAdaptoru = new ArrayAdapter<>
                (this,android.R.layout.simple_list_item_1,android.R.id.text1,sehir);
// this context
        //Adaptörü belirledik.
        listemiz.setAdapter(veriAdaptoru);

        listemiz.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                AlertDialog.Builder diyalogOlusturucu = new AlertDialog.Builder(MainActivity.this);

                diyalogOlusturucu.setMessage(sehir[position])

                        .setCancelable(false)
                        .setPositiveButton("Tamam", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                diyalogOlusturucu.create().show();
                diyalogOlusturucu.setMessage(sehir[position]);
                //alertdialog başlığı şehir listesinden pozisyonuna göre çekildi.

        }
        });

    }
}
