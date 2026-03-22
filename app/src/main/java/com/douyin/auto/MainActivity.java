package com.douyin.auto;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ScrollView;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
    
    private static TextView logView;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setPadding(20, 20, 20, 20);
        
        TextView title = new TextView(this);
        title.setText("抖音自动下单");
        title.setTextSize(24);
        layout.addView(title);
        
        logView = new TextView(this);
        logView.setText("等待连接...\n");
        
        ScrollView scroll = new ScrollView(this);
        scroll.addView(logView);
        layout.addView(scroll);
        
        setContentView(layout);
    }
}
