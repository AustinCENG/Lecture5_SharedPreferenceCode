package com.ceng319.sharedpreferencecode;
/**
 * This code is built to verify two concepts:
 * 1. Use the sharedpreference to store some settings. (UserScreen)
 * 2. Use the PreferenceScreen to generate the setting screens and process the requests from
 *    the setting change. (SettingScreen activity)
 * *
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public final int USER_SCREEN = 1000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // TODO 8: Process the loading preference procedure. finished
        ProcessPreference();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void ProcessPreference() {

        // TODO 9: This is to load the preference from the default PreferenceScreen setting screen.   finished.
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        // boolean grid = settings.getBoolean("check_box_preference_1", false);
        String color = settings.getString("list_preference_1", "1");
        Boolean tired = settings.getBoolean("check_box_preference_1", false);
        Log.d("MapleLeaf", "Color Index is: " + color);
        Log.d("MapleLeaf", "Tired? -  " + String.valueOf(tired));
        switch (Integer.parseInt(color))
        {
            case 1:  // Blue
                setTheme(R.style.AppTheme_NoActionBar);
                break;
            case 2:   // Yellow
                setTheme(R.style.AppThemeYellow_NoActionBar);
                break;
            case 3:   // Purple
                setTheme(R.style.AppThemePurple_NoActionBar);
                break;
            case 4:   // Green
                setTheme(R.style.AppThemeGreen_NoActionBar);
                break;
            default:
                setTheme(R.style.AppTheme_NoActionBar);
                break;
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_users) {
            // TODO 10: Start the userscreen if choose users. Should expect results from userscreen finished.
            Intent intent = new Intent(this, UserScreen.class);
            startActivityForResult(intent, USER_SCREEN);
            // Is this implicit or explicit.
        }
        else if (id == R.id.action_settings){
            // TODO 11: Start the settingscreen if choose users. finished.
            Intent intent1 = new Intent (this, SettingScreen.class);
            startActivity(intent1);
        }
        else if (id == R.id.quit)
        {
            finishAndRemoveTask();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Dispatch incoming result to the correct fragment.
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            // TODO 12: Process the data returned from userscreen. finished.
            if ((requestCode == USER_SCREEN &&
                    resultCode == RESULT_OK)) {
                if (data.hasExtra("returned_message")){
                    String mUserName  = data.getExtras().getString("returned_message");
                    Toast.makeText(this,"Welcome to my App, "+ mUserName,Toast.LENGTH_LONG).show();
                    TextView textView = findViewById(R.id.idMessage);
                    textView.setText("Welcome to my App, "+ mUserName);
                }
            }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
