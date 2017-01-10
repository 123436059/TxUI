package com.zyt.tx.frameutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.zyt.tx.frameutils.eventBus.FragmentListDemo.EventBusListActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_eventBus, R.id.activity_main})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_eventBus:
                startActivity(new Intent(this, EventBusListActivity.class));
                break;
            case R.id.activity_main:
                break;
        }
    }
}
