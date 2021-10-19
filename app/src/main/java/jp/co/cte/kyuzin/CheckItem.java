package jp.co.cte.kyuzin;

import android.widget.ImageView;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author
 * @date 2021/10/13
 */
public class CheckItem {
    private String textLanguage;
    private boolean isChecked;

    public CheckItem(String textLanguage, boolean isChecked){
        this.textLanguage = textLanguage;
        this.isChecked = isChecked;
    }

    public String getTextLanguage() {
        return textLanguage;
    }

    public void setTextLanguage(String textLanguage) {
        this.textLanguage = textLanguage;
    }

    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }
}
