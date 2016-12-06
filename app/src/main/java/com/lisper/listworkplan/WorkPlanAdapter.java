package com.lisper.listworkplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by admin on 2016/12/6.
 */

public class WorkPlanAdapter extends BaseAdapter {
    private ArrayList<HashMap<String, String>> mlpList;
    private Context mlpConetxt;
    private LayoutInflater mlpInflater;

    public WorkPlanAdapter(Context context) {
        this.mlpConetxt = context;
        mlpInflater = LayoutInflater.from(context);
    }

    public void setData(ArrayList<HashMap<String, String>> mDist){
        if( mDist  != null ){
            mlpList = mDist;
        }else{
            mlpList = new ArrayList<HashMap<String, String>>();
        }
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mlpList == null ? 0 : mlpList.size();
    }

    @Override
    public Object getItem(int pos) {
        return mlpList == null ? null : mlpList.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View view, ViewGroup viewGroup) {
        if(view == null){
            view = mlpInflater.inflate(R.layout.item_work_plan, view.getParent(), true);
        }


        return view;
    }
}
