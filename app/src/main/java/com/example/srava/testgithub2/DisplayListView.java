package com.example.srava.testgithub2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.math.BigDecimal;


public class DisplayListView extends ActionBarActivity {

    String JSON_STRING;
    JSONObject jsonObject;
    JSONArray jsonArray;
    RestaurantAdapter restaurantAdapter;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_listview_layout);
        listView = (ListView) findViewById(R.id.listview);
        restaurantAdapter = new RestaurantAdapter(this,R.layout.row_layout);
        listView.setAdapter(restaurantAdapter);
        JSON_STRING = getIntent().getExtras().getString("json_data");
        try{

            jsonObject = new JSONObject(JSON_STRING);
            jsonArray = jsonObject.getJSONArray("server_response");
            int count = 0;
            String LIBELLE_RESTAURANT, LIBELLE_TYPE, VILLE_RESTAURANT;
            Double LONGITUDE_RESTAURANT, LATITUDE_RESTAURANT;

            while(count<jsonArray.length()){

                JSONObject JO = jsonArray.getJSONObject(count);
                LIBELLE_RESTAURANT = JO.getString("LIBELLE_RESTAURANT");
                LIBELLE_TYPE = JO.getString("LIBELLE_TYPE");
                VILLE_RESTAURANT = JO.getString("VILLE_RESTAURANT");
                LONGITUDE_RESTAURANT = JO.getDouble("LONGITUDE_RESTAURANT");
                LATITUDE_RESTAURANT = JO.getDouble("LATITUDE_RESTAURANT");

                Restaurant restaurant = new Restaurant(LIBELLE_RESTAURANT, LIBELLE_TYPE, VILLE_RESTAURANT, LONGITUDE_RESTAURANT, LATITUDE_RESTAURANT);
                restaurantAdapter.add(restaurant);
                count++;
            }

        }catch (JSONException e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display_list_view, menu);
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
}