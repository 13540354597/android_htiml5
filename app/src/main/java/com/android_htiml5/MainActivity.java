package com.android_htiml5;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private WebView mWebView;
    private Question question;
    private Button btn_getJsMethod;


    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.wv_login);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(question = new Question(), "question");
        mWebView.setWebChromeClient(new MyWebChromeClient(this));
        mWebView.loadUrl("file:///android_asset/index.html");
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        btn_getJsMethod = findViewById(R.id.btn_getJsMethod);
        btn_getJsMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLine();
            }
        });
    }

    public void addLine() {

        mWebView.loadUrl("javascript:addLine()");

    }

    public class Question {


        public Question() {
        }

        @JavascriptInterface
        public void setInfo(String info) {

            Toast.makeText(MainActivity.this, info, Toast.LENGTH_SHORT).show();


            Log.e("=================", "JS掉用了我的方法" + info);

        }


        @JavascriptInterface
        public void setInfo() {

            Toast.makeText(MainActivity.this, "JS掉用了我的方法", Toast.LENGTH_SHORT).show();


            Log.e("=================", "JS掉用了我的方法");

        }
    }
}
