package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebViewClient;

import com.itheima.view.BridgeWebView;

public class DisplayMessageActivity extends AppCompatActivity {

    private BridgeWebView mWeview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        initView();
        setWebViewClient();
        setTitle("JS调用展示");
//        // Get the Intent that started this activity and extract the string
//        Intent intent = getIntent();
//        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
//
//        // Capture the layout's TextView and set the string as its text
//        TextView textView = findViewById(R.id.textView);
//        textView.setText(message);
    }

    private void initView() {
        mWeview = (BridgeWebView) findViewById(R.id.weview);
        mWeview.addBridgeInterface(new JavaSctiptMethods(DisplayMessageActivity.this, mWeview));//设置js和android通信桥梁方法
        //mWeview.loadUrl("http://10.0.3.2:8080/BridgeWebView/index.html");//显示网页,在线模板
        mWeview.loadUrl("file:///android_asset/BridgeWebView/index.html");//本地模板
    }

    private void setWebViewClient() {
        mWeview.setWebViewClient(new WebViewClient());
        mWeview.setWebChromeClient(new WebChromeClient());
    }
}
