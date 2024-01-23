package com.example.uiuxadapterpractical;

import android.content.Context;
import android.content.res.TypedArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class OurAdapter extends BaseAdapter {

    private String[] titles;
    private String[] desc;
    private TypedArray imageID;

    private Context context;

    private static LayoutInflater layoutInflater;

    OurAdapter (Context adapterContext, String[] titleList, String[] descList, TypedArray images)
    {
        titles=titleList;
        desc=descList;
        imageID=images;
        context=adapterContext;

        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return titles.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private class ViewHolder
    {
        TextView tv1;
        TextView tv2;
        ImageView img;
    }


    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder = new ViewHolder();

        if (view== null)
        {
            view = layoutInflater.inflate(R.layout.list_layout, viewGroup, false);

            viewHolder.tv1 = (TextView)view.findViewById(R.id.textView);
            viewHolder.tv2 = (TextView)view.findViewById(R.id.textView2);
            viewHolder.img = (ImageView)view.findViewById(R.id.imageView);

            view.setTag(viewHolder);
        }
        else
        {
            viewHolder = (ViewHolder)view.getTag();
        }

        viewHolder.tv1.setText(titles[position]);
        viewHolder.tv2.setText(desc[position]);
        viewHolder.img.setImageResource(imageID.getResourceId(position,0));

        return view;
    }
}
