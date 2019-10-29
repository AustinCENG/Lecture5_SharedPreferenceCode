package com.ceng319.sharedpreferencecode;


/*
Refer to: https://developer.android.com/guide/topics/ui/settings
*/


import android.preference.PreferenceFragment;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceFragmentCompat;

import android.os.Bundle;

public class SettingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);
        // TODO 7.1: Generate and commit a fragment for the setting screen. finsihed.
        // getFragmentManager deprecated from API 28 and needs to be updated later on.

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.idSetting, new SettingFragment())
                .commit();
    }


    // Define a Inner Class for setting fragment. This will be used to load into
    // the activity_setting_screen layout.
    // Please notice that Fragment innerclass must be static
    // TODO 7.2: Generate a PreferenceFragment class to hold all the settings build in setting.xml.finsihed.
    // PreferenceFragment deprecated from API 28 and needs to be updated later on.
    public static class SettingFragment extends PreferenceFragmentCompat {
        @Override
        public void onCreatePreferences(Bundle savedInstanceState, String rootKey) {
            setPreferencesFromResource(R.xml.setting, rootKey);
        }
    }


}