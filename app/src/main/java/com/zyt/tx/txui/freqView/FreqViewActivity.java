package com.zyt.tx.txui.freqView;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

import com.zyt.tx.txui.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FreqViewActivity extends AppCompatActivity {

    @BindView(R.id.freq_view)
    TestFreqView freqView;
    @BindView(R.id.seekBar)
    SeekBar seekBar;
    @BindView(R.id.tv_current)
    TextView tvCurrent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_freq_view);
        ButterKnife.bind(this);


        freqView.setCurrentBand(2);
        seekBar.setMax(2050);
        int current = seekBar.getProgress() + 8750;
        tvCurrent.setText(String.valueOf(current));
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int current= progress+8750;
                tvCurrent.setText(String.valueOf(current));
                freqView.setTargetFreqHz(current,true);
//                freqView.setStepFreq(20);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
