package com.example.cxx.tabhostbyfmdemo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by CXX on 2016/4/11.
 */
public class MyAdapter extends RecyclerView.Adapter implements View.OnClickListener{

    public static interface  OnRecycleViewItemClickListener{
        void onItemClick(View view,String data);
    }
    private OnRecycleViewItemClickListener myOnItemClickListener = null;
    public void setOnItemClickListener(OnRecycleViewItemClickListener listener){
        this.myOnItemClickListener = listener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        private  View root;
        private TextView tvTitle,tvContent;

        public TextView getTvContent() {
            return tvContent;
        }
        public TextView getTvTitle() {
            return tvTitle;
        }
        public ViewHolder(View root) {
            super(root);
            tvTitle= (TextView) root.findViewById(R.id.tvTitle);
            tvContent = (TextView) root.findViewById(R.id.tvcontent);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_set,null);
        ViewHolder vh = new ViewHolder(view);
        view.setOnClickListener(this);
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int i) {
        ViewHolder vh = (ViewHolder) holder;
        ItemData itemData = data[i];
        vh.getTvTitle().setText(itemData.getTitle());
        vh.getTvContent().setText(itemData.getContent());
        vh.itemView.setTag(itemData.getTitle());

    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    @Override
    public void onClick(View v) {
        if(myOnItemClickListener!=null){
            myOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }
    private ItemData[] data = new ItemData[]{
            new ItemData("标题1","内容1"),
            new ItemData("标题2","内容2"),
            new ItemData("标题3","内容3")
    };
}
