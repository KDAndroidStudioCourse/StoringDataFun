package com.example.cj.darra.storingdatafun;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreferences sharedPreferences = this.getSharedPreferences("com.example.cj.darra.storingdatafun", Context.MODE_PRIVATE);

        ArrayList<String> friends = new ArrayList<>();

        friends.add("A");
        friends.add("B");
        friends.add("C");
        friends.add("D");
        friends.add("E");

        try {
            sharedPreferences.edit().putString("username", ObjectSerializer.serialize(friends)).apply();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String username = sharedPreferences.getString("username", "");

        try {
            Log.i("This is the username", "" + ObjectSerializer.deserialize(username));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
