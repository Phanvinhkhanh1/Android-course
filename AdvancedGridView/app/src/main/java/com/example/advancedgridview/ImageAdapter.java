package com.example.advancedgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {

    private final Context context;
    private final int layout;
    ArrayList<Image> imageArrayList;

    public ImageAdapter(Context context, int layout, ArrayList<Image> imageArrayList) {
        this.context = context;
        this.layout = layout;
        this.imageArrayList = imageArrayList;
    }

    @Override
    public int getCount() {
        return imageArrayList.size();
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
        private ImageView imgImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(layout, null);
            viewHolder.imgImage = (ImageView) convertView.findViewById(R.id.imageViewImage);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Image image = imageArrayList.get(position);
        viewHolder.imgImage.setImageResource(image.getImg());

        return convertView;
    }
}
