package uz.ussd;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import static uz.ussd.Constants.colors;

public class ViewPagerAdapter extends PagerAdapter {
    String[] ops;
    Context mContext;

    public ViewPagerAdapter(Context context, String[] operators) {
        this.ops = operators;
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return ops.length;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {

        ViewGroup group = (FrameLayout) LayoutInflater.from(mContext).inflate(R.layout.vp_item, container, false);
        TextView textView = group.findViewById(R.id.vpTextView);
        textView.setText(ops[position]);
        textView.setBackgroundColor(colors[position]);
        container.addView(group);
        return textView;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((TextView) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == object;
    }
}
