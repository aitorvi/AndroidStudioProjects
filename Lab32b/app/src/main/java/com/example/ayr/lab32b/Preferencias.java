package com.example.ayr.lab32b;


import android.os.Bundle;
import android.preference.PreferenceActivity;


/**
 * Created by ayr on 31/01/2017.
 */
public class Preferencias extends PreferenceActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
