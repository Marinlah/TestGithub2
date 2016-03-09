package com.example.srava.testgithub2;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;


public class TestGithub2 extends Activity implements OnClickListener{

    ListView list;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_github2);

        Button button1 = (Button) findViewById(R.id.btnTest); // Récupération de l'instance bouton 1
        button1.setOnClickListener((OnClickListener) this); // Positionnons un listener sur ce bouton


        String[] mStrings = {
                "AAAAA", "BBBBB", "CCCCC", "DDDDD", "EEEEE",
                "FFFFF", "GGGGG"
        };

        //Création de l'adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);

//Récupération du ListView présent dans notre IHM
        list = (ListView) findViewById(R.id.lvRestos);

//On passe nos données au composant ListView
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parentView, View childView,
                                       int position, long id) {
                Log.d("Debug", "item click");
                Intent intent= new Intent(TestGithub2.this, Infos.class);
                startActivity(intent);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test_github2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View view) {
        if (view.getId()==R.id.btnTest){ // C'est notre bouton ? oui, alors affichage d'un message
            Toast.makeText(this,"Bouton 1", Toast.LENGTH_SHORT).show();
        }
    }


}
