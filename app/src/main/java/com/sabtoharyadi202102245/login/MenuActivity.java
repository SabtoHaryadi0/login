package com.sabtoharyadi202102245.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.text.DecimalFormat;

import cz.msebera.android.httpclient.Header;


public class MenuActivity extends AppCompatActivity {

    private Button _tampilMahasiswaButton, _tampilForexButton;
    private Intent _tampilMahasiswaIntent, _tampilForexIntent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        initTampilForexButton();

        _tampilMahasiswaButton = findViewById(R.id.tampilMahasiswaButton);

        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class );
                startActivity(_tampilMahasiswaIntent);
            }
    });}

    private void initTampilForexButton(){
        _tampilForexButton = (Button) findViewById(R.id.tampilForexButton);

        _tampilForexButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilForexIntent = new Intent(getApplicationContext(), ForexMainActivity.class);
                startActivity(_tampilForexIntent);
            }
        });
    }


}