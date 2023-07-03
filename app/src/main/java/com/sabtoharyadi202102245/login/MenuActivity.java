package com.sabtoharyadi202102245.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MenuActivity extends AppCompatActivity {

    private Button _tampilMahasiswaButton;
    private Intent _tampilMahasiswaIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        _tampilMahasiswaButton = findViewById(R.id);

        _tampilMahasiswaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _tampilMahasiswaIntent = new Intent(getApplicationContext(), TampilMahasiswaActivity.class );
                startActivity(_tampilMahasiswaIntent);
            }
    }


}