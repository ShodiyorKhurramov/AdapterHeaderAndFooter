package com.example.adapterheaderandfooter.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.adapterheaderandfooter.Model.Member;


import com.example.adapterheaderandfooter.R;


import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final int TYEP_ITEM_HEADER = 0;
    private final int TYEP_ITEM_YES_VIEW = 1;
    private final int TYEP_ITEM_NO_VIEW = 2;
    private final int TYEP_ITEM_FOOTER = 3;
   Context context;
   ArrayList<Member> members;

    public CustomAdapter(Context context, ArrayList<Member> members) {
        this.context = context;
        this.members = members;
    }


    @Override
    public int getItemViewType(int position) {
      if(isHeader (position)) return TYEP_ITEM_HEADER;
        if(isFooter (position)) return TYEP_ITEM_FOOTER;

        Member member= members.get(position);
        if(member.isAvailable()) return TYEP_ITEM_YES_VIEW;
           return TYEP_ITEM_NO_VIEW;
    }

   public boolean isFooter(int pasition){
        return pasition==members.size()-1;
   }

   public boolean isHeader(int pasition){
        return pasition==0;
   }


    @Override
    public int getItemCount() {
        return members.size();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(viewType==TYEP_ITEM_HEADER){
            View header= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layaout_header,parent,false);
                return  new CustomViewHeaderHolder(header);

        }else if (viewType==TYEP_ITEM_YES_VIEW){
            View yes=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layaout_yes,parent,false);
            return new  CustomViewYesHolder (yes);
        }else if (viewType==TYEP_ITEM_NO_VIEW){
            View no=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layaout_no,parent,false);
            return  new CustomViewNotHolder(no);
        }else {
            View footer=LayoutInflater.from(parent.getContext()).inflate(R.layout.item_custom_layaout_footer,parent,false);
          return  new CustomViewFooterHolder(footer);
        }

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(isFooter(position) || isHeader(position)) return;
        Member member=members.get(position);

        if(holder instanceof CustomViewYesHolder){
            TextView tv_firstName= (TextView) ((CustomViewYesHolder) holder).tv_fristName;
            TextView tv_lastName= (TextView) ((CustomViewYesHolder) holder).tv_lastname;
            tv_firstName.setText((member.getFirstName()));
            tv_lastName.setText(member.getLastName());
        }

        if(holder instanceof CustomViewNotHolder){
            TextView tv_firstName= (TextView) ((CustomViewNotHolder) holder).tv_fristName;
            TextView tv_lastName= (TextView) ((CustomViewNotHolder) holder).tv_lastname;
            tv_firstName.setText("This fristname is not available");
            tv_lastName.setText("This lastname is not available");
        }
    }


    // holder here

    public class CustomViewHeaderHolder extends  RecyclerView.ViewHolder{
        View view;
        CustomViewHeaderHolder(View v){
            super (v);
        view=v;
        }

    }



    public   class CustomViewYesHolder extends  RecyclerView.ViewHolder{
        private View view;

        private TextView tv_lastname,tv_fristName;
        public CustomViewYesHolder(View v){
            super(v);
            view=v;
            tv_fristName=view.findViewById(R.id.tv_firstName);
            tv_lastname=view.findViewById(R.id.tv_lastName);
        }
    }

    public   class CustomViewNotHolder extends  RecyclerView.ViewHolder{
        private View view;

        private View tv_lastname,tv_fristName;
        public CustomViewNotHolder(View v){
            super(v);
            view=v;
            tv_fristName=view.findViewById(R.id.tv_firstName);
            tv_lastname=view.findViewById(R.id.tv_lastName);
        }
    }
    public class CustomViewFooterHolder extends  RecyclerView.ViewHolder{
        View view;
        CustomViewFooterHolder(View v){
            super (v);
            view=v;
        }

    }
}
