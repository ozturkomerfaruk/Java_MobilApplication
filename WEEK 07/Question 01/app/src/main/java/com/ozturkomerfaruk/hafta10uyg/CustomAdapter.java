package com.ozturkomerfaruk.hafta10uyg;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class CustomAdapter extends BaseAdapter {

    List<User> myUserList;
    LayoutInflater userInflater;

    public CustomAdapter(Activity activity, List<User> myUserList) {
        this.myUserList = myUserList;
        userInflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return myUserList.size();
    }

    @Override
    public Object getItem(int i) {
        return myUserList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @SuppressLint({"InflateParams", "ViewHolder", "SetTextI18n"})
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lineView;
        lineView = userInflater.inflate(R.layout.activity_listview, viewGroup, false);
        ImageView imgUser = lineView.findViewById(R.id.imgUser);
        TextView txtNameUser = lineView.findViewById(R.id.txtNameUser);
        TextView txtSurnameUser = lineView.findViewById(R.id.txtSurnameUser);
        TextView txtAgeUser = lineView.findViewById(R.id.txtAgeUser);
        TextView txtJobUser = lineView.findViewById(R.id.txtJobUser);
        TextView txtSexUser = lineView.findViewById(R.id.txtSex);

        User user = myUserList.get(i);

        txtNameUser.setText(user.get_name());
        txtSurnameUser.setText(user.get_surname());
        txtAgeUser.setText(user.get_age());
        txtJobUser.setText(user.get_job());
        if(user.get_isWoman()) {
            txtSexUser.setText("KADIN");
        } else {
            txtSexUser.setText("ERKEK");
        }

        int age = Integer.parseInt(txtAgeUser.getText().toString());

        if(age < 15 && user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.kid_woman);
        } else if ( age < 15 && !user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.kid_man);
        } else if (16 <= age && age <= 60 && user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.woman);
        } else if (16 <= age && age <= 60 && !user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.man);
        } else if (age > 60 && user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.old_woman);
        } else if (age > 60 && !user.get_isWoman()) {
            imgUser.setImageResource(R.drawable.old_woman);
        } else {
            imgUser.setImageResource(R.drawable.cycle);
        }

        return lineView;
    }
}
