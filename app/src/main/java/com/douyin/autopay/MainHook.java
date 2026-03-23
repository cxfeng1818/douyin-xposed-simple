package com.douyin.autopay;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;
import android.content.Intent;
import android.net.Uri;

public class MainHook implements IXposedHookLoadPackage {
    
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {
        // 只 Hook 抖音商城
        if (!lpparam.packageName.equals("com.ss.android.ugc.aweme.shop")) {
            return;
        }
        
        XposedBridge.log(">>> 抖音商城支付拦截已激活");
        
        // Hook Intent.setData 拦截支付宝链接
        XposedHelpers.findAndHookMethod(
            Intent.class,
            "setData",
            Uri.class,
            new XC_MethodHook() {
                @Override
                protected void beforeHookedMethod(MethodHookParam param) throws Throwable {
                    Uri uri = (Uri) param.args[0];
                    if (uri != null) {
                        String url = uri.toString();
                        
                        // 只拦截支付宝链接
                        if (url.startsWith("alipays://") || url.startsWith("alipay://")) {
                            XposedBridge.log(">>> 支付链接: " + url);
                        }
                    }
                }
            }
        );
    }
}
