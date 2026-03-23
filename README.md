# 抖音支付链接拦截插件

## 手动构建方法

由于 GitHub Actions 构建失败，请使用以下方法之一：

### 方法1：Android Studio
1. 克隆项目：`git clone https://github.com/cxfeng1818/douyin-xposed-simple.git`
2. 用 Android Studio 打开
3. Build > Build Bundle(s) / APK(s) > Build APK(s)

### 方法2：命令行（需要 Android SDK）
```bash
./gradlew assembleDebug
```

### 方法3：使用 Frida（无需编译）
见 douyin-alipay-hook 项目

## 功能
- 拦截抖音跳转支付宝的链接
- 记录到 Xposed 日志
- 需要 LSPatch 或其他 Xposed 框架
