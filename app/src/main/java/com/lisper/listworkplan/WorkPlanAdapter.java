package com.lisper.listworkplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

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

    public void setData(ArrayList<HashMap<String, String>> mDist) {
        if (mDist != null) {
            mlpList = mDist;
        } else {
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
        if (view == null) {
            view = mlpInflater.inflate(R.layout.item_work_plan, null);
        }

        View mlpViewTop = LPViewHolder.get(view, R.id.mlpViewTop);
        View mlpViewBottom = LPViewHolder.get(view, R.id.mlpViewBottom);
        TextView mlpViewRound = LPViewHolder.get(view, R.id.mlpViewRound);
        TextView mlpTvContent = LPViewHolder.get(view, R.id.mlpTvContent);
        HashMap<String, String> mlpMap = (HashMap<String, String>) getItem(pos);
        if(pos == 0){
            mlpViewTop.setVisibility(View.INVISIBLE);
            mlpViewBottom.setVisibility(View.VISIBLE);
            mlpViewRound.setBackgroundResource(R.drawable.shape_red_round);
        }else if(pos == getCount() - 1){
            mlpViewTop.setVisibility(View.VISIBLE);
            mlpViewBottom.setVisibility(View.INVISIBLE);
            mlpViewRound.setBackgroundResource(R.drawable.shape_gray_round);
        }else{
            mlpViewTop.setVisibility(View.VISIBLE);
            mlpViewBottom.setVisibility(View.VISIBLE);
            mlpViewRound.setBackgroundResource(R.drawable.shape_gray_round);
        }
        mlpTvContent.setText(mlpMap.get("workName").toString());
        return view;
    }
}
