package com.example.ting_jhih.chef_v1.Service;

import android.util.Log;

/**
 * Created by Ting-Jhih on 2016/5/5.
 */
public class AccountService {
    public void register(){
        ChefServer cs = new ChefServer();
        cs.connect();
        cs.request("{'requestServiceType':'AccountService','requestService':'register','requestInt':123}");
        for (String message : cs.respond()) {
            Log.d("ChefClientService", message);
        }
        cs.close();
    }
}
