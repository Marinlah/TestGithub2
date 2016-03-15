package com.example.srava.testgithub2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by praudv on 15/03/2016.
 */
public class RestaurantAdapter extends ArrayAdapter{

    List list = new ArrayList();

    public RestaurantAdapter(Context context, int resource) {
        super(context, resource);
    }

    public void add(Restaurant object){
        super.add(object);
        list.add(object);
    }

    @Override
    public int getCount(){
        return list.size();
    }

    @Override
    public Object getItem(int position){
        return list.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row;
        row = convertView;
        RestaurantHolder restaurantHolder;

        if(row == null){
            LayoutInflater layoutInflater = (LayoutInflater)this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            restaurantHolder = new RestaurantHolder();
            restaurantHolder.txt_name = (TextView) row.findViewById(R.id.txt_name);
            // FAIRE POUR RESTAURANT

            row.setTag(restaurantHolder);
        }
        else{
            restaurantHolder = (RestaurantHolder)row.getTag();
        }

        Restaurant restaurant = (Restaurant)this.getItem(position);
        restaurantHolder.txt_name.setText(restaurant.getLIBELLE_RESTAURANT());
        // FAIRE POUR RESTAURANT

        return row;
    }

    static class RestaurantHolder{
        TextView txt_name, txt_email, txt_mobile;
    }

}
