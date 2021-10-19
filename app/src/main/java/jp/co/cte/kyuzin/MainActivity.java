package jp.co.cte.kyuzin;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private PopWindowAdapter adapter;
    private TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView)findViewById(R.id.tv_main);
        button = (Button)findViewById(R.id.btn_main);
        adapter = new PopWindowAdapter();

        String oldLanguage = PrefUtil.readString(Constants.LOCAL_LANGUAGE, "简体中文");
        List<CheckItem> list = Arrays.asList(Constants.LIST_CHECK_ITEM.clone());
        for (CheckItem item : list){
            if (item.getTextLanguage().equals(oldLanguage)){
                item.setChecked(true);
            }else{
                item.setChecked(false);
            }
        }

        adapter.refleshData(list);
        button.setOnClickListener(view -> {
            createPopWindow();
        });
    }

    public void createPopWindow(){
        View view = LayoutInflater.from(this).inflate(R.layout.choose_language_pop_window, null, false);
        RecyclerView rVPop = view.findViewById(R.id.rv_pop);
        rVPop.setAdapter(adapter);
        final PopupWindow popupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0x00000000));
        popupWindow.showAsDropDown(text, 50, 0);
        popupWindow.setOnDismissListener(() -> {
            String currentLanguage = adapter.getCurrentLanguage();
            if (!currentLanguage.equals("")){
                String oldLanguage = PrefUtil.readString(Constants.LOCAL_LANGUAGE, "简体中文");
                if (!currentLanguage.equals(oldLanguage)){
                    PrefUtil.writeString(Constants.LOCAL_LANGUAGE, currentLanguage);
                    showRestartDialog();
                }
            }
        });
    }

    public void showRestartDialog(){
        AlertDialog.Builder dialog = new AlertDialog.Builder(this).setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_message)
                .setPositiveButton(getString(R.string.dialog_positive), (dialogInterface, i) -> {
                    finish();
                    startActivity(new Intent(MainActivity.this, SplashActivity.class));
                })
                .setNegativeButton(getString(R.string.dialog_nagative), (dialogInterface, i) -> {
                    dialogInterface.dismiss();
                });
        dialog.setCancelable(true);
        dialog.show();
    }
}