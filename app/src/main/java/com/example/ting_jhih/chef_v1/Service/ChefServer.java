package com.example.ting_jhih.chef_v1.Service;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Ting-Jhih on 2016/5/3.
 */
public class ChefServer {
    private final String serverAddress = "140.124.42.169";
    private final int port = 9002;
    Socket socket;
    BufferedReader receiveFromServer;
    PrintWriter requestToServer;
    public void connect(){
        try {
            socket = new Socket(serverAddress, port);
            receiveFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream(),"UTF-8"));
            requestToServer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
        } catch (IOException e) {
            System.out.println("ChefServer connect error:"+e.toString());
            Log.d("ChefServer", "ChefServer connect error:"+e.toString());
        }
    }
    public void close(){
        try {
            requestToServer.println("CLOSECONNECT");
            socket.close();
        } catch (IOException e) {
            System.out.println("ChefServer close error:" + e.toString());
            Log.d("ChefServer", "ChefServer close error:" + e.toString());
        }
    }
    public void request(String request){
        requestToServer.println(request);
    }

    public ArrayList<String> respond(){
        ArrayList<String> ar = new ArrayList<String>();
        try {
            while(true){
                String message = receiveFromServer.readLine();
                if(message.equals("CLOSECONNECT")){
                    break;
                }else if(message != null){
                    ar.add(message);
                    Log.d("ChefServer respond",message);
                }
            }
            return ar;
        } catch (IOException e) {
            System.out.println("ChefServer respond error:"+e.toString());
            Log.d("ChefServer", "ChefServer respond error:"+e.toString());
        }
        return null;
    }
}
