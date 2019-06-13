package com.example.asekeyang.mydv;

import com.example.asekeyang.app.MyApplication;
import com.example.asekeyang.bean.Student;
import com.example.asekeyang.db.DaoMaster;
import com.example.asekeyang.db.DaoSession;
import com.example.asekeyang.db.StudentDao;

import java.util.List;

/**
 * Created by 华为 on 2019/6/13.
 */

public class MyDb {

    private volatile static MyDb myDb;
    private StudentDao dao;

    public MyDb() {
        //创建数据库

        createDatabase();
    }

    public static MyDb getMyDb() {
        if (myDb==null){

            synchronized (MyDb.class){

                if (myDb==null){
                    myDb = new MyDb();
                }
            }

        }
        return myDb;
    }

    private void createDatabase() {

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(MyApplication.getApplication(), "sky.db", null);

        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());

        DaoSession daoSession = daoMaster.newSession();

        dao = daoSession.getStudentDao();


    }

    //添加

    public void insertAll(Student student){
        dao.insertOrReplace(student);
    }

    //查询

    public List<Student> queryAll(){
        List<Student> list = dao.queryBuilder().list();
        return list;
    }
}
