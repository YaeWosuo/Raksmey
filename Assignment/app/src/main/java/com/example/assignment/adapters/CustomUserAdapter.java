package com.example.assignment.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.assignment.R;
import com.example.assignment.models.User;

import java.util.List;

public class CustomUserAdapter extends BaseAdapter {
    private final Context context;
    private final List <User> userList;
    public CustomUserAdapter(Context context, List<User> userList) {
        this.context = context;
        this.userList = userList;
    }

    @Override
    public int getCount() {
        return userList.size();
    }

    @Override
    public Object getItem(int position) {
        return userList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return userList.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.user_card_listlayout,null,false);
            User user = userList.get(position);
            TextView username = view.findViewById(R.id.txtusername);
            TextView gender = view.findViewById(R.id.txtgender);
            TextView email = view.findViewById(R.id.txtemail);
            TextView role = view.findViewById(R.id.txtrole);
            if(!user.getName().isEmpty()){
                username.setText(user.getName());
            }
            if(!user.getGender().isEmpty()){
                gender.setText(user.getGender());
            }
            if(!user.getEmail().isEmpty()){
                email.setText(user.getEmail());
            }
            if(user.getRole() !=null){
                role.setText(user.getRole().getName());
            }
        }
        return view;
    }
}
