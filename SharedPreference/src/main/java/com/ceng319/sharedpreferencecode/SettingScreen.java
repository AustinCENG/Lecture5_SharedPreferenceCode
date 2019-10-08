package com.ceng319.sharedpreferencecode;


/*
Refer to: https://developer.android.com/guide/topics/ui/settings
*/


import android.content.res.Resources;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SettingScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_screen);

        // TODO 7.1: Generate and commit a fragment for the setting screen. finsihed.
        getFragmentManager().beginTransaction()
                .add(R.id.idSetting, new SettingFragment())
                .commit();  // have to commit to submit the transaction.
    }




    // Define a Inner Class for setting fragment. This will be used to load into
    // the activity_setting_screen layout.
    // Please notice that Fragment innerclass must be static
    // TODO 7.2: Generate a PreferenceFragment class to hold all the settings build in setting.xml.finsihed.
    public static class SettingFragment extends PreferenceFragment{
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.setting);
        }
    }

}
