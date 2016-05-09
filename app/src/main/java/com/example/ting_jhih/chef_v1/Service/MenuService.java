package com.example.ting_jhih.chef_v1.Service;

import android.util.Log;

/**
 * Created by Ting-Jhih on 2016/5/3.
 */
public class MenuService {
    public String getMenu() {
        ChefServer cs = new ChefServer();
        cs.connect();
        cs.request("{'requestServiceType':'MenuManager','requestService':'getMenu'}");
        for (String message : cs.respond()){
            Log.d("MenuService",message);
        }
        cs.close();
        return null;
    }

    private String orderMeal(String idMeal) {
        ChefServer cs = new ChefServer();
        //cs.setMealListen(this);
        cs.connect();
        cs.request("{'requestServiceType':'MenuManager','requestService':'orderMeal','idMeal':'"+idMeal+"'}");
        for (String message : cs.respond()){
            Log.d("MenuService",message);
        }
        cs.close();
        return "orderMeal";
    }

    private String updateMeal() {
        return "updateMeal";
    }

    private String deleteMeal() {
        return "deleteMeal";
    }

    private boolean isConnectSerer() {
        return true;
    }

    public void onMealListen(String status){

    }
}
