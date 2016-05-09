package com.example.ting_jhih.chef_v1;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.ting_jhih.chef_v1.Service.AccountService;

/**
 * Created by Ting-Jhih on 2016/5/3.
 */
public class Register extends AppCompatActivity {
    private SharedPreferences settings;
    private static final String data = "DATA";
    private static final String nameField = "NAME";
    private static final String phoneField = "PHONE";
    private static final String passwordField = "PASSWORD";
    private static final String rePasswordField = "REPASSWORD";
    private static final String accountField = "ACCOUNT";
    EditText name;
    EditText account;
    EditText password;
    EditText rePassword;
    EditText phone;
    Button save;
    Button read;
    Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        Bundle bData = this.getIntent().getExtras();
        String str = bData.getString("str");
        ((TextView)findViewById( R.id.textView )).setText(str);
        init();
        save.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

        read.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                readData();
            }
        });

        register.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                AccountService account = new AccountService();
                account.register();
            }
        });



    }
    public void init(){
        name = (EditText)findViewById(R.id.nameEdit);
        account = (EditText)findViewById(R.id.accountEdit);
        password = (EditText)findViewById(R.id.passwordEdit);
        rePassword = (EditText)findViewById(R.id.againPassword);
        phone = (EditText)findViewById(R.id.phoneEdit);
        save = (Button)findViewById(R.id.save);
        read = (Button)findViewById(R.id.read);
        register = (Button)findViewById(R.id.register);
    }
    public void readData(){
        settings = getSharedPreferences(data,0);
        name.setText(settings.getString(nameField, ""));
        account.setText(settings.getString(accountField, ""));
        password.setText(settings.getString(passwordField, ""));
        rePassword.setText(settings.getString(rePasswordField, ""));
        phone.setText(settings.getString(phoneField, ""));
    }
    public void saveData(){
        settings = getSharedPreferences(data, 0);
        settings.edit()
                .putString(nameField, name.getText().toString())
                .putString(phoneField, phone.getText().toString())
                .putString(passwordField, password.getText().toString())
                .putString(rePasswordField, rePassword.getText().toString())
                .putString(accountField, account.getText().toString())
                .commit();
    }
}
