package com.example.cvapp;

import static com.example.cvapp.MainActivity.GIT;
import static com.example.cvapp.MainActivity.LINKEDIN;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class WebActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linkedin);
        webView = findViewById(R.id.webView);

        webView.setWebViewClient(new WebViewClient());
        webView.getSettings().setJavaScriptEnabled(true);

        String url = null;
        Intent intent = getIntent();

        if (intent != null) {

            if (intent.getExtras().getString(LINKEDIN) != null) {
                url = intent.getExtras().getString(LINKEDIN);
            } else if (intent.getExtras().getString(GIT) != null) {
                url = intent.getExtras().getString(GIT);
            } else {
                Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
            }


            webView.loadUrl(url);
        } else {
            Toast.makeText(this, "Something went wrong!", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack())
            webView.goBack();
        else
            super.onBackPressed();
    }
}