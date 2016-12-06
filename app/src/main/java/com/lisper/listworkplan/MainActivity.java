package com.lisper.listworkplan;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ListView mlpListWorkPlan;
    private WorkPlanAdapter mlpWorkPlanAdater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();
        setData();
    }

    private void initView(){
        mlpListWorkPlan = (ListView)findViewById(R.id.mlpListWorkPlan);
    }

    private void initData(){
        mlpWorkPlanAdater = new WorkPlanAdapter(MainActivity.this);
        mlpListWorkPlan.setAdapter(mlpWorkPlanAdater);
    }

    private void setData(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, 12);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        int month = Calendar.MONTH;
        int day = Calendar.DAY_OF_MONTH;
        ArrayList<HashMap<String, String>> mlpList = new ArrayList<HashMap<String, String>>();
        HashMap<String, String> mlpMap = null;
        for(int i = 18; i > 0; i--){
            mlpMap = new HashMap<String, String>();
            mlpMap.put("date", month+"/"+( day + i ));
            mlpMap.put("workName", "What to do today?");
            mlpList.add(mlpMap);
        }
        mlpWorkPlanAdater.setData(mlpList);
    }
}
