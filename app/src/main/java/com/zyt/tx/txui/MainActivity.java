package com.zyt.tx.txui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zyt.tx.txui.freqView.FreqViewActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_freqView})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_freqView:
                startActivity(new Intent(this, FreqViewActivity.class));
                break;
        }
    }
}
