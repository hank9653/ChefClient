package com.example.ting_jhih.chef_v1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ting_jhih.chef_v1.Service.ChefClientService;

public class MainActivity extends AppCompatActivity {
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button)findViewById( R.id.button );


        new Thread(new Runnable() {
            @Override
            public void run() {
                    new Thread(new ChefClientService()).start();
                    ////MenuService ms = new MenuService();
                    //ms.getMenu();
            }
        }).start();


        b1.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent newAct = new Intent();
                newAct.setClass(MainActivity.this, Register.class);
                Bundle bData = new Bundle();

                bData.putString("str", ((TextView) findViewById(R.id.textView5))
                        .getText()
                        .toString());
                newAct.putExtras(bData);

                startActivity(newAct);
                */
                Intent newAct = new Intent();
                newAct.setClass(MainActivity.this, OrderMenu.class);
                startActivity(newAct);
            }

        });
    }
}
