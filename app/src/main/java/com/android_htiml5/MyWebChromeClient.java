package com.android_htiml5;

import android.content.Context;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.Toast;

/**
 * Created by TR 105 on 2017/9/16.
 */

class MyWebChromeClient extends WebChromeClient {
    private Context context;

    public MyWebChromeClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {


        return true;
    }

    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        return true;
    }

}
