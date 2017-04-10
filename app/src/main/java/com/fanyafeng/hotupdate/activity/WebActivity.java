package com.fanyafeng.hotupdate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.View;

import com.fanyafeng.hotupdate.R;
import com.fanyafeng.hotupdate.BaseActivity;
import com.fanyafeng.hotupdate.view.WebViewSupportJS;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class WebActivity extends BaseActivity {

    WebViewSupportJS w;
    String pkgName;
    String className;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_web);

        initView();
        initData();
    }


    //初始化UI控件
    private void initView() {
        Intent intent = getIntent();

        pkgName = intent.getStringExtra("pkgName");
        className = intent.getStringExtra("className");
        String url = intent.getStringExtra("url");


        w = (WebViewSupportJS) findViewById(R.id.webviewSupportJS);
        w.loadUrl(url);
    }

    //初始化数据
    private void initData() {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (w.canGoBack()){
                w.goBack();
                return true;
            }else{
                Intent i ;
                if (className == null || className.equals("")) {
                    i = getPackageManager().getLaunchIntentForPackage(pkgName);
                }else{
                    i = new Intent();
                    i.setClassName(pkgName,className);
                }
                if (i != null) {
                    startActivity(i);
                }
                finish();
                return true;
            }
        }

        return super.onKeyDown(keyCode, event);
    }

    @Override
    protected void onPause() {
        super.onPause();
        w.onPause();
    }

}
