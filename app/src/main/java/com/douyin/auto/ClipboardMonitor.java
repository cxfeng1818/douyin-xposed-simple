package com.douyin.auto;

import android.content.ClipboardManager;
import android.content.Context;
import android.util.Log;

public class ClipboardMonitor implements ClipboardManager.OnPrimaryClipChangedListener {
    
    private ClipboardManager clipboard;
    private PaymentLinkCallback callback;
    
    public interface PaymentLinkCallback {
        void onPaymentLink(String link);
    }
    
    public ClipboardMonitor(Context context, PaymentLinkCallback callback) {
        this.clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        this.callback = callback;
        clipboard.addPrimaryClipChangedListener(this);
    }
    
    @Override
    public void onPrimaryClipChanged() {
        if (clipboard.hasPrimaryClip()) {
            String text = clipboard.getPrimaryClip().getItemAt(0).getText().toString();
            if (text.startsWith("alipay://") || text.startsWith("alipays://")) {
                Log.d("ClipboardMonitor", "支付链接: " + text);
                callback.onPaymentLink(text);
            }
        }
    }
}
