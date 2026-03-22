# 抖音自动下单APP

## 功能
- 无障碍服务自动操作抖音
- 剪贴板监听拦截支付链接
- WebSocket连接服务端
- 无需root
- 后台运行

## 工作原理

1. 无障碍服务自动点击"购买"按钮
2. 监听剪贴板捕获支付宝链接
3. 发送链接到服务端
4. 用户手动支付

## 使用方法

1. 安装APK
2. 开启无障碍服务
3. 打开抖音
4. 自动执行下单

## 编译

```bash
./gradlew assembleDebug
```

APK位置：`app/build/outputs/apk/debug/app-debug.apk`
