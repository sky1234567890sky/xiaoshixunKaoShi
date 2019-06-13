package com.example.asekeyang.m;

import com.example.asekeyang.bean.Student;
import com.example.asekeyang.v.MyBb;

import java.util.List;

/**
 * Created by 华为 on 2019/6/13.
 */

public interface MyM {
    void onSucess(List<Student> list, String url, MyBb myBb);
}
