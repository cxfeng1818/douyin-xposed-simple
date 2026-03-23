package com.douyin.autopay;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setText("抖音商城支付拦截\n\n" +
                   "状态：已激活\n\n" +
                   "使用方法：\n" +
                   "1. 在 Xposed 框架中激活本模块\n" +
                   "2. 作用域选择抖音商城\n" +
                   "3. 重启抖音商城\n" +
                   "4. 下单时会自动拦截支付链接\n\n" +
                   "查看日志：\n" +
                   "Xposed 框架 > 日志");
        tv.setPadding(50, 50, 50, 50);
        tv.setTextSize(16);
        
        setContentView(tv);
    }
}
