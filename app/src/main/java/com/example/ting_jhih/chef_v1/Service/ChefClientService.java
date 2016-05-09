package com.example.ting_jhih.chef_v1.Service;

import android.util.Log;
/**
 * Created by Ting-Jhih on 2016/5/3.
 */
public class ChefClientService implements Runnable {
    public ChefClientService() {

    }

    @Override
    public void run() {
        ChefServer cs = new ChefServer();
        cs.connect();
        cs.request("{'requestServiceType':'ChefClientService','requestService':'connectToServer','requestInt':123}");
        for (String message : cs.respond()) {
            Log.d("ChefClientService",message);
        }
        cs.close();
    }
}
