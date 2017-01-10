package com.zyt.tx.frameutils.eventBus.FragmentListDemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zyt.tx.frameutils.R;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * Created by MJS on 2017/1/10.
 */

public class ItemDetailFragment extends Fragment {

    private TextView tvDetail;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);
        tvDetail = (TextView) rootView.findViewById(R.id.tv_content);
        return rootView;
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changeTextEvent(Item item) {
        if (item != null) {
            tvDetail.setText(item.content);
        }
    }
}
