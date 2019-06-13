package com.example.asekeyang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import com.example.asekeyang.fragemtn.HomeFragment;

public class BaiduContent extends AppCompatActivity {
    private WebView mMyweb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baidu_content);
        initView();
    }
    private void initView() {
        Intent intent = getIntent();
        String url = intent.getStringExtra("url");
        mMyweb = (WebView) findViewById(R.id.myweb);
        mMyweb.setWebChromeClient(new WebChromeClient());
        mMyweb.loadUrl(url);
    }
}
