package com.zhang.okhttp3;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class MainActivity extends AppCompatActivity {
    OkHttpClient mOkHttpClient;
    OkHttpClient okHttpClient;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        okHttpClient = new OkHttpClient();
        mOkHttpClient = new OkHttpClient().newBuilder().build();

        Button tvSync = findViewById(R.id.tv_sync);
        tvSync.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Request.Builder builder = new Request.Builder();
                final Request request = new Request.Builder().url("http://rap2api.taobao.org/app/mock/118200/SMSCode").build();
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        try {
                            Response execute = mOkHttpClient.newCall(request).execute();
                            ResponseBody body = execute.body();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();

            }
        });

        OkHttpClient build = new OkHttpClient().newBuilder().build();


//            mOkHttpClient.newCall(request).enqueue(new Callback() {
//                @Override
//                public void onFailure(Call call, IOException e) {
//
//                }
//
//                @Override
//                public void onResponse(Call call, Response response) throws IOException {
//
//                }
//            });


    }
}
