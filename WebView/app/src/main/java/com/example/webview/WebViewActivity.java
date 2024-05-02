package com.example.webview;

import android.os.Bundle;
import android.webkit.WebView;

import androidx.appcompat.app.AppCompatActivity;

public class WebViewActivity extends AppCompatActivity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        webView = (WebView) findViewById(R.id.webView);

        String url = getIntent().getStringExtra("url");
        webView.loadUrl(url);

        webView.getSettings().setJavaScriptEnabled(true);
    }
}
