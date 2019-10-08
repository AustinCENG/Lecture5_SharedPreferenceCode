package com.ceng319.sharedpreferencecode;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class UserScreen extends AppCompatActivity {

    Button mButton;
    EditText mUser;
    EditText mEmail;
    CheckBox mBox;
    // This is the sharedPreferences we will use to save the settings.
    SharedPreferences sharedPref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_screen);

        // TODO 1: Find all the Views on screen. finished.
        mButton = findViewById(R.id.idSubmit);
        mUser = findViewById(R.id.user);
        mEmail = findViewById(R.id.email);
        mBox = findViewById(R.id.checkBox);

        sharedPref = this.getPreferences(Context.MODE_PRIVATE);

        // TODO 2: Program the save setting button. finished.
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveSharedPreference();
            }
        });

        // TODO 3: Load all the settings. finished.
        LoadPreference();  // when this activity starts, it should load all the settings on File.


    }


    /**
     * Take care of popping the fragment back stack or finishing the activity
     * as appropriate.
     */
    @Override
    public void onBackPressed() {

        // TODO 13: Make sure the Up button will return the values back to MainActivity. Finished.
        saveSharedPreference();
        super.onBackPressed();
    }

    private void saveSharedPreference(){
        // TODO 4: Save all the settings. finished.
        if (mBox.isChecked()) {  // save the current user name for next time use.
            // save the current settings from UI, i.e. Username and E-mail.
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", mUser.getText().toString());
            editor.putString("email", mEmail.getText().toString());
            editor.putBoolean("checkbox", mBox.isChecked());
            editor.commit(); // Save the preference.
        }
        else
        {
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putString("username", "");
            editor.putString("email", "");
            editor.putBoolean("checkbox", false);
            editor.commit(); // Save the preference.
        }
        BacktoHome();
    }

    private void LoadPreference(){
        // TODO 5: Load all the settings. finished.
        Boolean checked = sharedPref.getBoolean("checkbox", false);
        String user = sharedPref.getString("username", "");
        String email = sharedPref.getString("email", "");
        // set the preference based on the saved data.
        mUser.setText(user);
        mBox.setChecked(checked);
        mEmail.setText(email);
    }

    private void BacktoHome(){
        // TODO 6: return user name back to the MainActivity. how to do this??? - use intents. finished
        Intent message = new Intent();
        message.putExtra("returned_message", String.valueOf(mUser.getText()));
        setResult(RESULT_OK, message);  // return message back to main.
        finish(); // make sure you always finish sub-activities before you go back home.
    }
}
