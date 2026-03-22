package com.douyin.auto;

import android.accessibilityservice.AccessibilityService;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;

public class AutoService extends AccessibilityService {
    
    private ClipboardMonitor clipboardMonitor;
    
    @Override
    protected void onServiceConnected() {
        super.onServiceConnected();
        clipboardMonitor = new ClipboardMonitor(this, link -> {
            // 发送支付链接到服务端
            sendToServer(link);
        });
    }
    
    @Override
    public void onAccessibilityEvent(AccessibilityEvent event) {
        AccessibilityNodeInfo rootNode = getRootInActiveWindow();
        if (rootNode == null) return;
        
        // 查找购买按钮
        findAndClickButton(rootNode, "立即购买");
        findAndClickButton(rootNode, "提交订单");
    }
    
    private void findAndClickButton(AccessibilityNodeInfo node, String text) {
        if (node.getText() != null && node.getText().toString().contains(text)) {
            node.performAction(AccessibilityNodeInfo.ACTION_CLICK);
        }
        for (int i = 0; i < node.getChildCount(); i++) {
            findAndClickButton(node.getChild(i), text);
        }
    }
    
    private void sendToServer(String paymentLink) {
        // TODO: 通过WebSocket发送到服务端
    }
    
    @Override
    public void onInterrupt() {}
}
