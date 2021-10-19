package jp.co.cte.kyuzin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author
 * @date 2021/10/18
 */
public class Constants {
    public static final CheckItem[] LIST_CHECK_ITEM = new CheckItem[]{
            new CheckItem("简体中文",true),
            new CheckItem("English",false),
            new CheckItem("繁體中文",false),
            new CheckItem("Italiano",false),
            new CheckItem("日本語",false),
            new CheckItem("한국어공부해요",false),
            new CheckItem("Français",false),
            new CheckItem("Deutsch",false),
    };

    public static final HashMap<String, Locale> LANGUAGE_MAP = new HashMap<String, Locale>(){
        {
            put("简体中文", Locale.SIMPLIFIED_CHINESE);
            put("English", Locale.ENGLISH);
            put("繁體中文", Locale.TRADITIONAL_CHINESE);
            put("Italiano", Locale.ITALIAN);
            put("日本語", Locale.JAPANESE);
            put("한국어공부해요", Locale.KOREAN);
            put("Français", Locale.FRENCH);
            put("Deutsch", Locale.GERMANY);
        }
    };

    public static final String SHARED_PREFERENCE_NAME = "shared_preference_name";
    public static final String LOCAL_LANGUAGE = "local_language";
}
