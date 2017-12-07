package com.cmclachicaplarvis.plarvis.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cmclachicaplarvis.plarvis.R;

import java.util.ArrayList;

/**
 * Created by CMLachica on 05/12/2017.
 */

public class CustomAdapter extends BaseAdapter {

    TextView name, sname;
    Context context;
    ArrayList<Data> data;
    LayoutInflater inflater;


    public CustomAdapter(Context context, ArrayList<Data> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.from(context).inflate(R.layout.custom_list,viewGroup,false);

        name = (TextView) view.findViewById(R.id.readname);
        sname = (TextView) view.findViewById(R.id.readsname);


        name.setText(name.getText()+data.get(i).getName());
        sname.setText(sname.getText()+""+data.get(i).getSName());

        return view;
    }
}
