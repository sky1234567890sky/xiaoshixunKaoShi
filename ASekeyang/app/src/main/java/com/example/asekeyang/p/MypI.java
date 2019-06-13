package com.example.asekeyang.p;

import com.example.asekeyang.bean.Student;
import com.example.asekeyang.m.MyM;
import com.example.asekeyang.v.MyBb;
import com.example.asekeyang.v.MyV;

import java.util.List;

/**
 * Created by 华为 on 2019/6/13.
 */

public class MypI implements MyP, MyBb {

     MyM myM;
     MyV myV;

    @Override
    public void getData(List<Student> list, int url) {
        if (myM!=null){
            myM.onSucess(list, String.valueOf(url),this);
        }
    }

    @Override
    public void onSucess(List<Student> students, int url) {
        if (myV!=null){
            myV.onSucess(students,url);
        }
    }
}
