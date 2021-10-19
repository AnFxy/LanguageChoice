package jp.co.cte.kyuzin;

import android.app.Application;
import android.content.Context;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author
 * @date 2021/10/18
 */
public class ContextAll extends Application {
    private static Context context ;
    public static Context getContext(){
        return context;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }
}
