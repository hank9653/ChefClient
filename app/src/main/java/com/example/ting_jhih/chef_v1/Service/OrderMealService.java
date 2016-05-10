package com.example.ting_jhih.chef_v1.Service;

import android.util.Log;

/**
 * Created by Ting-Jhih on 2016/5/10.
 */
public class OrderMealService {
    ChefServer cs;
    public boolean orderMeal(int idRestaurant, int tableNum, int idMeal,int idUser){
        ChefServer cs = new ChefServer();
        cs.connect();
        cs.request("{'requestServiceType':'OrderMealService','requestService':'OrderMeal','OrderMeal':{'idRestaurant':" + idRestaurant + ",'tableNum': " + tableNum + ",'idMeal': " + idMeal + ",'idUser':" + idUser + "}}");
        for (String message : cs.respond()) {
            Log.d("OrderMealService",message);
        }
        cs.close();
        return true;
    }

    public void getStatus(int idUser){
        cs = new ChefServer();
        cs.connect();
        cs.request("{'requestServiceType':'OrderMealService','requestService':'GetStatus'}");
        for (String message : cs.respond()) {
            Log.d("OrderMealService", message);
            if(message.equals("OrderMealNull")){
                cs.close();
            }
        }
        cs.close();
    }

    public void close() {
        cs.request("CLOSECONNECT");
    }

    public boolean deleteMeal(int idRestaurant, int tableNum, int mealNum){
        request("DeleteMeal", idRestaurant, tableNum, mealNum);
        return response();
    }
/*
    public boolean orderComboMeal(int idRestaurant, int tableNum, ComboMeal comboMeal){
        request("OrderComboMeal", idRestaurant, tableNum, comboMeal);
        return response();
    }

    public boolean deleteComboMeal(int idRestaurant, int tableNum, int comboMealNum){
        request("DeleteComboMeal", idRestaurant, tableNum, comboMealNum);
        return response();
    }*/
}
