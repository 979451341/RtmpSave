package com.ws.ffmpegandroidavfilter;

import android.Manifest;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TwoActivity extends AppCompatActivity {

    String in_filename  = "rtmp://live.hkstv.hk.lxdns.com/live/hks";
    String out_filename = "/storage/emulated/0/pauseRecordDemo/video/receive.flv";
    Button btn;
    EditText et_in,et_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);

        et_in = (EditText)findViewById(R.id.et_in);
        et_out = (EditText)findViewById(R.id.et_out);

        et_in.setText(in_filename);
        et_out.setText(out_filename);
        btn = (Button)findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        NativePlayer.saveRTMP(et_in.getText().toString(),et_out.getText().toString());
                    }
                }).start();
                btn.setText("started");
            }

        });


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE
                    ,Manifest.permission.CHANGE_WIFI_STATE,Manifest.permission.CHANGE_NETWORK_STATE,Manifest.permission.ACCESS_NETWORK_STATE,
                    Manifest.permission.WAKE_LOCK}, 5);
        }
    }
}
