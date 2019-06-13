package com.example.asekeyang.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.asekeyang.R;
import com.example.asekeyang.bean.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 华为 on 2019/6/13.
 */

public class HomeAdapter extends RecyclerView.Adapter{
    private final FragmentActivity activity;
    private final List<Student> students;

    public HomeAdapter(FragmentActivity activity, List<Student> students) {


        this.activity = activity;
        this.students = students;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int view) {
        RecyclerView.ViewHolder vh = null;
        if (view==1){
            View inflate = View.inflate(activity, R.layout.item_vh1, null);
            vh = new Vh1(inflate);
        }else if (view==2){
            View inflate = View.inflate(activity, R.layout.item_vh2, null);
            vh = new Vh2(inflate);
        }else if (view==3){
            View inflate = View.inflate(activity, R.layout.item_vh3, null);
            vh = new Vh3(inflate);
        }
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        final Student r = students.get(position);
        if (holder instanceof Vh1){
            Vh1 vh1 = (Vh1) holder;
            vh1.tv1.setText(r.getTitle());
        }else if (holder instanceof Vh2){
            Vh2 vh2 = (Vh2) holder;
            vh2.title2.setText(r.getTitle());

        }else if (holder instanceof Vh3){
            Vh3 vh3 = (Vh3) holder;
            vh3.title3.setText(r.getTitle());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(onListener!=null){
                    onListener.Listener(r,position);
                }
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        if (position%3==0){
            return 1;
        }else if (position%3==1){
            return 2;

        }
        return 3;
    }

    @Override
    public int getItemCount() {
        if (students.size()>0){

            return students.size();
        }
        return  0;
    }

    class Vh1 extends RecyclerView.ViewHolder{
        private ImageView img1;
        private ImageView img12;
        private TextView tv1;
        public Vh1(View itemView) {
            super(itemView);
            img1 = (ImageView) itemView.findViewById(R.id.img1);
            img12 = (ImageView) itemView.findViewById(R.id.img1_2);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);

        }
    }

    class Vh2 extends RecyclerView.ViewHolder{
        private TextView title2;
        private ImageView img2;


        public Vh2(View itemView) {
            super(itemView);

            title2 = (TextView) itemView.findViewById(R.id.title2);
            img2 = (ImageView) itemView.findViewById(R.id.img2);

        }
    }

    class Vh3 extends RecyclerView.ViewHolder{
        private TextView title3;
        private ImageView img3;

        public Vh3(View itemView) {
            super(itemView);
            title3 = (TextView) itemView.findViewById(R.id.title3);
            img3 = (ImageView) itemView.findViewById(R.id.img3);

        }
    }

    ///点击时间
    public interface OnListener{
        void Listener(Student student,int p );
    }
    private OnListener onListener;

    public void setOnListener(OnListener onListener) {
        this.onListener = onListener;
    }
}
