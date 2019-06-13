package com.example.asekeyang.fragemtn;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.asekeyang.BaiduContent;
import com.example.asekeyang.R;
import com.example.asekeyang.adapter.HomeAdapter;
import com.example.asekeyang.bean.Student;
import com.example.asekeyang.m.MyM;
import com.example.asekeyang.mydv.MyDb;
import com.example.asekeyang.p.MypI;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {


    private View view;
    private ImageView mImg;
    private RecyclerView mLv;
    private List<Student> students;
    private HomeAdapter adapter;
    private String url = "http://www.baidu.com";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_home, container, false);
        initView(inflate);
        return inflate;
    }
    private void initView(View inflate) {
        mImg = (ImageView) inflate.findViewById(R.id.img);
        mLv = (RecyclerView) inflate.findViewById(R.id.lv);

        mLv.setLayoutManager(new LinearLayoutManager(getActivity()));
        students = new ArrayList<>();
        adapter = new HomeAdapter(getActivity(), students);
        mLv.setAdapter(adapter);

        //点击时间
        adapter.setOnListener(new HomeAdapter.OnListener() {
            @Override
            public void Listener(Student student, int p) {

                if (bdUrl!=null){
                    bdUrl.MyUrl(student,p);
                }
                Intent intent = new Intent(getActivity(), BaiduContent.class);
                intent.putExtra("url",student.getUrl());
                startActivity(intent);
            }
        });

        //添加数据源
        for (int i = 0; i < 30; i++) {
            if (i%2==0){
                Student student = new Student((long)i, R.mipmap.ic_launcher, "标题" + i, url);
//                students.add(student);
                MyDb.getMyDb().insertAll(student);
            }else{
                Student student = new Student((long) i, R.mipmap.ic_launcher_round, "标题" + i, url);
//                students.add(student);
                MyDb.getMyDb().insertAll(student);
            }
        }
//        //查询
        List<Student> list = MyDb.getMyDb().queryAll();
        students.addAll(list);
        adapter.notifyDataSetChanged();
    }
    //将url地址传走
    public interface BdUrl{
        void MyUrl(Student student, int p);
    }
    public BdUrl bdUrl;

    public void setBdUrl(BdUrl bdUrl) {
        this.bdUrl = bdUrl;
    }

}
