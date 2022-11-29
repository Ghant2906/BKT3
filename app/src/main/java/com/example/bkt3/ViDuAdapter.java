package com.example.bkt3;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ViDuAdapter extends BaseAdapter {
    private Activity activity;
    private List<ViDu> viDuList;

    private class ViewHolder{
        TextView tenViDu, cauViDu;
    }

    public ViDuAdapter(Activity activity, List<ViDu> viDuList){
        this.activity = activity;
        this.viDuList = viDuList;
    }

    public Context getContext() {
        return activity;
    }

    public void setContext(Activity activity) {
        this.activity = activity;
    }

    public List<ViDu> getViDuList() {
        return viDuList;
    }

    public void setViDuList(List<ViDu> viDuList) {
        this.viDuList = viDuList;
    }

    @Override
    public int getCount() {
        return viDuList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = activity.getLayoutInflater();
            convertView =inflater.inflate(R.layout.layout_vidu, null);

            holder =new ViewHolder();

            holder.tenViDu = convertView.findViewById(R.id.textViewTenThi_ViDu);
            holder.cauViDu = convertView.findViewById(R.id.textViewCauViDu_ViDu);

            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        ViDu viDu = viDuList.get(position);

        holder.tenViDu.setText(viDu.getTenViDu());
        holder.cauViDu.setText(viDu.getCauViDu());

        return convertView;
    }
}
