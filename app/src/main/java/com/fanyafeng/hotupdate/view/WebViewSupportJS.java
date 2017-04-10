package com.fanyafeng.hotupdate.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Author： fanyafeng
 * Data： 17/3/14 上午11:14
 * Email: fanyafeng@live.cn
 */
public class WebViewSupportJS extends WebView{
    Context context;

    private Activity currentActiviy;

    public WebViewSupportJS(Context context) {
        super(context);
        init();
    }


    public WebViewSupportJS(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WebViewSupportJS(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public void setCurrentActiviy(Activity currentActiviy) {
        this.currentActiviy = currentActiviy;
    }


    @SuppressLint("SetJavaScriptEnabled")
    private void init() {
        requestFocusFromTouch();
        setScrollBarStyle(WebView.SCROLLBARS_INSIDE_OVERLAY);
        getSettings().setJavaScriptEnabled(true);
        getSettings().setAllowFileAccess(true);
        getSettings().setSupportZoom(true);
        getSettings().setBuiltInZoomControls(false);
        getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        getSettings().setUserAgentString(getSettings().getUserAgentString());
        getSettings().setDomStorageEnabled(true);
        // mWebView.getSettings().setAppCachePath(appCachePath);
        getSettings().setAppCacheEnabled(false);

        getSettings().setTextZoom(100);

        setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                return false;
            }
        });
        setWebChromeClient(new WebChromeClient());
    }
}
