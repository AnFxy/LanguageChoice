package jp.co.cte.kyuzin;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

/**
 * 课题号（GORASA-XXXX)
 * 类或接口的描述信息
 *
 * @author
 * @date 2021/10/13
 */
public class PopWindowAdapter extends RecyclerView.Adapter<PopWindowAdapter.MyViewHolder> {

    private List<CheckItem> listData = new ArrayList<>();
    private String currentLanguage = "";

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pop, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        holder.itemView.setOnClickListener(view1 -> {
            holder.ivChecked.setVisibility(View.VISIBLE);
            for (CheckItem item : listData){
                if (item.getTextLanguage().equals(holder.tvLanguage.getText().toString())){
                    item.setChecked(true);
                    setCurrentLanguage(item.getTextLanguage());
                }else {
                    item.setChecked(false);
                }
            }
            notifyDataSetChanged();
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(PopWindowAdapter.MyViewHolder holder, int position) {
        CheckItem item = listData.get(holder.getAdapterPosition());
        if (item != null){
            holder.ivChecked.setVisibility(item.isChecked() ? View.VISIBLE : View.INVISIBLE);
            holder.tvLanguage.setText(item.getTextLanguage());
        }else {
            holder.ivChecked.setVisibility(View.INVISIBLE);
            holder.tvLanguage.setText("LANGUAGE");
        }

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView tvLanguage;
        public ImageView ivChecked;
        public MyViewHolder(View itemView) {
            super(itemView);
            tvLanguage = (TextView)itemView.findViewById(R.id.tv_language);
            ivChecked = (ImageView)itemView.findViewById(R.id.iv_check);
        }
    }

    public void refleshData(List<CheckItem> listData){
        boolean isOld = false;
        if (listData.size()!=0){

            for (CheckItem item : listData){
                for (CheckItem itemOld : this.listData){
                    if (itemOld.getTextLanguage().equals(item.getTextLanguage())){
                        itemOld.setChecked(item.isChecked());
                        isOld = true;
                    }
                }
                if (!isOld){
                    this.listData.add(item);
                }
                isOld = false;
            }
        }
        notifyDataSetChanged();
    }

    public void setCurrentLanguage(String languageNow){
        this.currentLanguage = languageNow;
    }
    public String getCurrentLanguage(){
        return this.currentLanguage;
    }
}
