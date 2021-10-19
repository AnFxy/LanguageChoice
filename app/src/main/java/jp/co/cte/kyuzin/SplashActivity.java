package jp.co.cte.kyuzin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.DisplayMetrics;

import java.util.Locale;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Configuration configuration = getResources().getConfiguration();

        String languageLocal = PrefUtil.readString(Constants.LOCAL_LANGUAGE, "简体中文");
        Locale locale = Constants.LANGUAGE_MAP.get(languageLocal);
        configuration.setLocale(locale);

        DisplayMetrics dm = getResources().getDisplayMetrics();
        getResources().updateConfiguration(configuration, dm);

        new Handler().postDelayed(() -> {
            Intent intent=new Intent(SplashActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        },1000);
    }
}