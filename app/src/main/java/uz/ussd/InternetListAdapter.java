package uz.ussd;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class InternetListAdapter extends BaseAdapter {
    private ArrayList<Internet> list;
    private Context mContext;
    private int mColor;

    public InternetListAdapter(Context context, ArrayList<Internet>  listITems) {
        this.list = listITems;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewGroup viewGroup1 = (ViewGroup) LayoutInflater.from(mContext).inflate(R.layout.listview_item, null, false);
        TextView textView = viewGroup1.findViewById(R.id.listview_tv);
        textView.setText(list.get(i).getPackageName());
        textView.setTextColor(Color.BLACK);
        return textView;
    }
}
