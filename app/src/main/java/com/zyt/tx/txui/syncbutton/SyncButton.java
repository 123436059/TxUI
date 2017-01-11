package com.zyt.tx.txui.syncbutton;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zyt.tx.txui.R;

import com.zyt.tx.txui.R.attr;
import com.zyt.tx.txui.R.color;
import com.zyt.tx.txui.R.dimen;
import com.zyt.tx.txui.R.id;
import com.zyt.tx.txui.R.layout;
import com.zyt.tx.txui.R.style;
import com.zyt.tx.txui.R.styleable;

import org.w3c.dom.Text;

/**
 * Created by MJS on 2017/1/10.
 */

public class SyncButton extends LinearLayout {

    private LayoutInflater layoutInflater;
    private View icon;
    private TextView text;

    public SyncButton(Context context) {
        this(context, null);
    }

    public SyncButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SyncButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }


    @TargetApi(16)
    void init(AttributeSet attrs, int defStyle) {
        this.layoutInflater = LayoutInflater.from(this.getContext());
        this.layoutInflater.inflate(R.layout.layout_sync_button, this, true);
        this.setOrientation(HORIZONTAL);
        this.icon = this.findViewById(id.icon);
        this.text = (TextView) this.findViewById(id.text);
        TypedArray a = this.getContext().obtainStyledAttributes(attrs, styleable.Common, attr.syncButtonStyle, style.DefaultSyncButtonStyle);
        boolean hasTextGravity = a.hasValue(styleable.Common_textGravity);
        boolean setTextGravity = true;
        LayoutParams colorStateList;
        if (a.hasValue(styleable.Common_commonIcon)) {
            this.icon.setVisibility(View.VISIBLE);
            this.icon.setBackground(a.getDrawable(styleable.Common_commonIcon));
            colorStateList = (LayoutParams) this.icon.getLayoutParams();
            colorStateList.width = a.getLayoutDimension(styleable.Common_iconWidth, -1);
            colorStateList.height = a.getLayoutDimension(styleable.Common_iconWidth, -1);
            colorStateList.leftMargin = a.getDimensionPixelSize(styleable.Common_iconLeftPadding, this.getResources().getDimensionPixelSize(dimen.SyncButtonIconLeftPadding));
            if (!hasTextGravity || a.getInt(styleable.Common_textGravity, 17) == 3) {
                this.text.setGravity(19);
                setTextGravity = false;
                colorStateList.rightMargin = a.getDimensionPixelSize(styleable.Common_textIconPadding, this.getResources().getDimensionPixelSize(dimen.SyncButtonIconTextSpace));
            }
        } else {
            this.icon.setVisibility(View.GONE);
            if (a.getInt(styleable.Common_textGravity, 17) == 3) {
                colorStateList = (LayoutParams) this.text.getLayoutParams();
                colorStateList.leftMargin = a.getDimensionPixelSize(styleable.Common_textIconPadding, this.getResources().getDimensionPixelSize(dimen.SyncButtonIconTextSpace));
            }
        }

        if (setTextGravity) {
            this.text.setGravity(a.getInt(styleable.Common_textGravity, 17));
        }

        ColorStateList colorStateList1 = a.getColorStateList(styleable.Common_android_textColor);
        if (colorStateList1 != null) {
            this.text.setTextColor(colorStateList1);
        } else {
            this.text.setTextColor(a.getColor(styleable.Common_android_textColor, this.getResources().getColor(color.SyncButtonTextColor)));
        }

        this.text.setTextSize((float) a.getDimensionPixelSize(styleable.Common_android_textSize, this.getResources().getDimensionPixelSize(dimen.SyncButtonTextSize)));
        this.text.setText(a.getText(styleable.Common_android_text));
        this.setBackground(a.getDrawable(styleable.Common_android_background));
        a.recycle();
        this.setClickable(true);
    }

    public void setText(CharSequence text) {
        this.text.setText(text);
    }

    public void setIconResource(int resId) {
        this.icon.setBackgroundResource(resId);
    }
}
