package com.zyt.tx.txui.syncbutton;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//


import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.zyt.tx.txui.R;

public class SyncIconButton extends FrameLayout {
    public SyncIconButton(Context context) {
        this(context, (AttributeSet)null);
    }

    public SyncIconButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SyncIconButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.init(attrs, defStyle);
    }

    @TargetApi(16)
    public void init(AttributeSet attrs, int defStyle) {
        this.setClickable(true);
        if(this.getBackground() == null) {
            TypedArray a = this.getContext().obtainStyledAttributes(attrs, R.styleable.Common
                    , R.attr.syncButtonStyle, R.style.DefaultSyncButtonStyle);
            this.setBackground(a.getDrawable(R.styleable.Common_android_background));
            a.recycle();
        }

    }

    protected void onFinishInflate() {
        super.onFinishInflate();

        for(int i = 0; i < this.getChildCount(); ++i) {
            this.getChildAt(i).setClickable(false);
        }

    }
}
