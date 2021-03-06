package com.up.lhm.getoffer.hashmap;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.up.lhm.getoffer.R;
import com.up.lhm.hmtools.system.IntentUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentHashMap;


/**
 * @author lianghaimiao
 * @date 2019/3/4
 * @function
 */

public class HashMapActivity extends Activity {

    private ListView mListView;
    private ListAdapter mAdapter;

    public static void start(Context context, boolean finishSelf) {
        Bundle args = new Bundle();
        IntentUtil.redirect(context, HashMapActivity.class, finishSelf, args);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_hashmap);
        initview();
//        testData();
        initData();

    }

    private void testData() {
        HashMap<String, Integer> hm1 = new HashMap<>();
        HashMap<String, Integer> hm = new HashMap<>(1);
        hm.put("", 11);
        Integer integer = hm.get("");
        Log.d("测试", integer + "");

        ArrayList<String> list = new ArrayList<>();
        list.add("2");
        list.get(1);
        list.remove(1);
        ThreadLocal<String> tl = new ThreadLocal<>();
        tl.set("ces");
        tl.get();

        LinkedList<Integer> objects = new LinkedList<>();
        objects.add(1);

        LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
        map.put(null, null);
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("q", "q");

        Hashtable<String, String> stringStringHashtable = new Hashtable<>();
        stringStringHashtable.put("q", "q");

        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("ss");
        threadLocal.get();
    }

    private void initview() {
        mListView = findViewById(R.id.lv);
    }

    private void initData() {
        String[] data=new String[20];
        for (int i = 0; i < 20; i++) {
           data[i]="第"+i+"个数据";
        }
        mAdapter = new MyAdapter(data,this);
        mListView.setAdapter(mAdapter);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
    }
}
