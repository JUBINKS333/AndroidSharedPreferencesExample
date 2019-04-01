package com.pritesh.sharedpreferencesexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class SharedPreferencesMainActivity extends AppCompatActivity
{

    private final String TAG = SharedPreferencesMainActivity.class.getCanonicalName();
    private EditText edtName;
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);

        //Global Preferences
        sharedPreferences = getSharedPreferences("myPref",MODE_PRIVATE);

        if (sharedPreferences.contains("name"))
        {
            String name = sharedPreferences.getString("name", null);

            if (name != null)
            {
                Log.d(TAG, name);
                Log.i(TAG, name);
                Log.v(TAG, name);
                Log.w(TAG, name);
                Log.e(TAG, name);

                edtName.setText(name);

            }
        }

    }

    public void btnSaveClick(View view)
    {


        if(edtName.getText().length() != 0)
        {
            String name = edtName.getText().toString();

            SharedPreferences.Editor mEditor = sharedPreferences.edit();

            mEditor.putString("name", name);
            //mEditor.remove("name");
            //mEditor.clear();

            mEditor.apply();
            //mEditor.commit();

            Intent mIntent = new Intent(SharedPreferencesMainActivity.this, PrivateToActivityPreferencesActivity.class);
            startActivity(mIntent);
        }


    }
}
