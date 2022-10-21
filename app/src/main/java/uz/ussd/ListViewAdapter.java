package uz.ussd;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ListViewAdapter extends BaseAdapter {
    private String[] list;
    private Context mContext;
    private int mColor;

    public ListViewAdapter(Context context, String[] listITems, int color) {
        this.list = listITems;
        this.mContext = context;
        this.mColor = color;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int i) {
        return list[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = new TextView(mContext);
        textView.setText(list[i]);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(35);
        textView.setBackgroundColor(mColor);
        return textView;
    }
}
