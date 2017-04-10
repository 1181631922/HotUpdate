package com.fanyafeng.hotupdate.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.fanyafeng.hotupdate.R;
import com.fanyafeng.hotupdate.BaseActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

//需要搭配Baseactivity，这里默认为Baseactivity,并且默认BaseActivity为包名的根目录
public class MainActivity extends BaseActivity {
    private TextView tvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //这里默认使用的是toolbar的左上角标题，如果需要使用的标题为中心的采用下方注释的代码，将此注释掉即可
        title = getString(R.string.title_activity_main);
        isSetNavigationIcon = false;
        initView();
        initData();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //toolbar_center_title.setText(getString(R.string.title_activity_main));
    }

    //初始化UI控件
    private void initView() {
        tvMain = (TextView) findViewById(R.id.tvMain);
        tvMain.setText("测试----------------");
        tvMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, WebActivity.class);
                intent.putExtra("url","https://www.baidu.com");
                startActivity(intent);
            }
        });
    }

    //初始化数据
    private void initData() {
        try {
            JSONObject jsonObject = new JSONObject("");
            if (jsonObject != null) {
                int error = jsonObject.optInt("error");
                String message = jsonObject.optString("message");
                int pageCount = jsonObject.optInt("pageCount");
                if ("成功".equals(message)) {
                    JSONObject data = jsonObject.optJSONObject("data");
                    if (data != null) {
                        JSONArray ds = jsonObject.optJSONArray("ds");
                        for (int i = 0; i < ds.length(); i++) {

                        }
                    }
                } else {

                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
