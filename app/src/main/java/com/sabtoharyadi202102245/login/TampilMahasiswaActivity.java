package com.sabtoharyadi202102245.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import java.lang.reflect.Type;
import java.util.List;

import cz.msebera.android.httpclient.Header;

public class TampilMahasiswaActivity extends AppCompatActivity
{
    private FloatingActionButton _addButton;
    private RecyclerView _recyclerView1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _recyclerView1 = findViewById(R.id.recyclerView1);

        initAddButton();
        loadRecyclerView();
    }

    private void loadRecyclerView() {
        AsyncHttpClient ahc = new AsyncHttpClient();
        String url = "https://stmikpontianak.net/011100862/tampilMahasiswa.php";

        ahc.get(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody)
            {
                Gson g = new Gson();
                List<MahasiswaModel> mahasiswaModelList = g.fromJson(new String(responseBody), new TypeToken<List<MahasiswaModel>>(){}.getType());

                RecyclerView.LayoutManager lm = new LinearLayoutManager(TampilMahasiswaActivity.this);
                _recyclerView1.setLayoutManager(lm);

                MahasiswaAdapter ma = new MahasiswaAdapter(mahasiswaModelList);
                _recyclerView1.setAdapter(ma);
            }

            @Override
            public void onFailure(int statusCode, cz.msebera.android.httpclient.Header[] headers, byte[] responseBody, Throwable error)
            {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initAddButton() {
        _addButton = findViewById(R.id.addButton);

        _addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), TambahMahasiswaActivity.class);
                startActivity(intent);

                loadRecyclerView();
            }
        });
    }
}