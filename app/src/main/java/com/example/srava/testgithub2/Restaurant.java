package com.example.srava.testgithub2;

/**
 * Created by praudv on 15/03/2016.
 */
public class Restaurant {

    private String LIBELLE_RESTAURANT, LIBELLE_TYPE, VILLE_RESTAURANT;
    private Double LONGITUDE_RESTAURANT, LATITUDE_RESTAURANT;

    public Restaurant(String LIBELLE_RESTAURANT, String LIBELLE_TYPE, String VILLE_RESTAURANT, Double LONGITUDE_RESTAURANT, Double LATITUDE_RESTAURANT){

        this.setLIBELLE_RESTAURANT(this.LIBELLE_RESTAURANT);
        this.setLIBELLE_TYPE(this.LIBELLE_TYPE);
        this.setVILLE_RESTAURANT(this.VILLE_RESTAURANT);
        this.setLONGITUDE_RESTAURANT(this.LONGITUDE_RESTAURANT);
        this.setLATITUDE_RESTAURANT(this.LATITUDE_RESTAURANT);
    }

    public String getLIBELLE_TYPE() {
        return LIBELLE_TYPE;
    }

    public void setLIBELLE_TYPE(String LIBELLE_TYPE) {
        this.LIBELLE_TYPE = LIBELLE_TYPE;
    }

    public String getLIBELLE_RESTAURANT() {
        return LIBELLE_RESTAURANT;
    }

    public void setLIBELLE_RESTAURANT(String LIBELLE_RESTAURANT) {
        this.LIBELLE_RESTAURANT = LIBELLE_RESTAURANT;
    }

    public String getVILLE_RESTAURANT() {
        return VILLE_RESTAURANT;
    }

    public void setVILLE_RESTAURANT(String VILLE_RESTAURANT) {
        this.VILLE_RESTAURANT = VILLE_RESTAURANT;
    }

    public Double getLONGITUDE_RESTAURANT() {
        return LONGITUDE_RESTAURANT;
    }

    public void setLONGITUDE_RESTAURANT(Double LONGITUDE_RESTAURANT) {
        this.LONGITUDE_RESTAURANT = LONGITUDE_RESTAURANT;
    }

    public Double getLATITUDE_RESTAURANT() {
        return LATITUDE_RESTAURANT;
    }

    public void setLATITUDE_RESTAURANT(Double LATITUDE_RESTAURANT) {
        this.LATITUDE_RESTAURANT = LATITUDE_RESTAURANT;
    }
}
