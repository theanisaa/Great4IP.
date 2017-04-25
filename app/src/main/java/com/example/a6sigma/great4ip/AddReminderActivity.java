package com.example.a6sigma.great4ip;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;

/**
 * Created by Acer on 20/04/2017.
 */

public class AddReminderActivity extends AppCompatActivity {
    private RelativeLayout mRelativeLayout;
    private ImageButton mButtonTime;
    private PopupWindow mPopupWindow;

    private TextView mButtonCancel;
    private TextView mButtonSave;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);

        mRelativeLayout = (RelativeLayout) findViewById(R.id.layout);
        mButtonTime = (ImageButton) findViewById(R.id.buttonTime);
        mButtonTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);

                View timeView = inflater.inflate(R.layout.popup_timepicker, null);
                mPopupWindow = new PopupWindow(timeView, LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

                Button buttonOk = (Button) timeView.findViewById(R.id.buttonOk);
                buttonOk.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mPopupWindow.dismiss();
                    }
                });
                mPopupWindow.showAtLocation(mRelativeLayout, Gravity.CENTER,0,0);
            }
        });

        mButtonCancel = (TextView) findViewById(R.id.button_cancel);
        mButtonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        mButtonSave = (TextView) findViewById(R.id.button_save);
        mButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
