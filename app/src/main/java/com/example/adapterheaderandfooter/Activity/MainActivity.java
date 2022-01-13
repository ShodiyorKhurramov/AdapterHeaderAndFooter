package com.example.adapterheaderandfooter.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.adapterheaderandfooter.Adapter.CustomAdapter;
import com.example.adapterheaderandfooter.R;
import com.example.adapterheaderandfooter.Model.Member;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        List<Member> members=prepareMemberList();
        refreshAdapter((ArrayList<Member>) members);
    }
    void initViews(){
        recyclerView=findViewById(R.id.recycler);
        recyclerView.setLayoutManager( new GridLayoutManager(context,1));
    }

    void refreshAdapter(ArrayList<Member> members){
        CustomAdapter adapter= new CustomAdapter(context, members);
        recyclerView.setAdapter(adapter);

    }

    public List<Member>  prepareMemberList(){
        List<Member> members= new ArrayList<>();


        for(int i=0; i<30; i++){
            if(i == 3 || i==8){
                members.add(new Member("Xurramov","Shodiyor",false));
            }else{
                members.add(new Member("Xurramov","Shodiyor",true));
            } }


        return members;
    }

}