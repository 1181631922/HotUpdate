package com.fanyafeng.hotupdate.app;

import android.app.Application;

import com.tencent.tinker.loader.app.TinkerApplication;
import com.tencent.tinker.loader.shareutil.ShareConstants;


/**
 * Author： fanyafeng
 * Data： 17/2/17 下午3:45
 * Email: fanyafeng@live.cn
 */
public class AppConfig extends TinkerApplication {


    public AppConfig() {
        super(ShareConstants.TINKER_ENABLE_ALL, "com.fanyafeng.hotupdate.ApplicationLike", "com.tencent.tinker.loader.TinkerLoader", false);
    }
}
