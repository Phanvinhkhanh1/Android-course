package com.example.advancedlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class FruitAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Fruit> fruitList;

    public FruitAdapter(Context context, int layout, List<Fruit> fruitList) {
        this.context = context;
        this.layout = layout;
        this.fruitList = fruitList;
    }

    @Override
    public int getCount() {
        return fruitList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    private class ViewHolder {
        ImageView imgImage;
        TextView txtName, txtDesc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            viewHolder = new ViewHolder();

            viewHolder.imgImage = (ImageView) convertView.findViewById(R.id.imageViewImage);
            viewHolder.txtName = (TextView) convertView.findViewById(R.id.textViewName);
            viewHolder.txtDesc = (TextView) convertView.findViewById(R.id.textViewDesc);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Fruit fruit = fruitList.get(position);

        viewHolder.imgImage.setImageResource(fruit.getImg());
        viewHolder.txtName.setText(fruit.getName());
        viewHolder.txtDesc.setText(fruit.getDesc());

        return convertView;
    }
}
