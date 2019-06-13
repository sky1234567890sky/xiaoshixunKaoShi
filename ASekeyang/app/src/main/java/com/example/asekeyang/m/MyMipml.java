package com.example.asekeyang.m;

import com.example.asekeyang.R;
import com.example.asekeyang.bean.Student;
import com.example.asekeyang.mydv.MyDb;
import com.example.asekeyang.v.MyBb;

import java.util.List;

/**
 * Created by 华为 on 2019/6/13.
 */

public class MyMipml implements MyM {
    @Override
    public void onSucess(List<Student> list, String url, MyBb myBb) {

        //添加数据源
        for (int i = 0; i < 30; i++) {
            if (i%2==0){
                Student student = new Student((long)i, R.mipmap.ic_launcher, "标题" + i, url);
//                list.add(student);
                MyDb.getMyDb().insertAll(student);
            }else{
                Student student = new Student((long) i, R.mipmap.ic_launcher_round, "标题" + i, url);
//                list.add(student);
                MyDb.getMyDb().insertAll(student);
            }
        }
    }

}
