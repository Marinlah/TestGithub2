package com.example.srava.testgithub2;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.view.View.OnClickListener;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class MainActivity extends Activity implements OnClickListener{

    TextView label1;
    String JSON_STRING;
    ListView list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_activity);

        label1 = (TextView)findViewById(R.id.label1);

        Button button1=(Button)findViewById(R.id.btnAfficher); // Recuperation de l'instance bouton 1
        button1.setOnClickListener((OnClickListener) this); // Positionnons un listener sur ce bouton


        String[] mStrings = {
            "AAAAAAAA", "BBBBBBBB", "CCCCCCCC", "DDDDDDDD", "EEEEEEEE",
            "FFFFFFFF", "GGGGGGGG"
        };

        //Creation de l'adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mStrings);

        //Recuperation du ListView present dans notre IHM
        ListView list = (ListView)findViewById(R.id.lvRestos);

        //On passe nos donnees au composant ListView
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView parentView, View childView, int position, long id) {
                Log.d("Debug", "item click");
                Intent intent = new Intent(MainActivity.this, Infos.class);
                startActivity(intent);
            }
        });
        getJSON();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_activity, menu);
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
        // C'est notre bouton ? oui, alors affichage d'un message
        /*Toast.makeText(this,"Bouton 1", Toast.LENGTH_SHORT).show();*/
        if (view.getId()==R.id.btnAfficher) {
            parseJSON(view);
        }
    }

    public void getJSON(){
        new BackgroundTask().execute();
    }

    class BackgroundTask extends AsyncTask<Void, Void, String> {

        String json_url;
        @Override
        protected void onPreExecute() {
            json_url = "http://gitdafood.hol.es/index.php";
        }

        @Override
        protected String doInBackground(Void... voids) {
            try {
                URL url = new URL(json_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                StringBuilder stringBuilder = new StringBuilder();

                while((JSON_STRING = bufferedReader.readLine()) != null){
                    stringBuilder.append(JSON_STRING+"\n");
                }

                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return stringBuilder.toString().trim();

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String result) {
            JSON_STRING = result;
        }
    }

    public void parseJSON(View view){
        if(JSON_STRING == null){
            Toast.makeText(getApplicationContext(),"First Get JSON",Toast.LENGTH_LONG).show();
        }
        else{
            Intent intent = new Intent(this,DisplayListView.class);
            intent.putExtra("json_data", JSON_STRING);
            startActivity(intent);
        }
    }


}

