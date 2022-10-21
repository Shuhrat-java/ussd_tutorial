package uz.ussd;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<String[]> listViewContents;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        listView = findViewById(R.id.listView);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                setPageListContent(position);
            }

            @Override
            public void onPageSelected(int position) {
                setPageListContent(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        String[] operators = {"MOBIUZ", "UCELL", "BEELINE", "UZMOBILE"};

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, operators);
        viewPager.setAdapter(viewPagerAdapter);

        prepareOperators();

        setPageListContent(0);

    }

    private void prepareOperators() {
        String[] mobiuzItems = {"News", "USSD", "Internet", "Services", "SSM and calls", "MobiUZ bonuses"};
        String[] ucellItems = {"News", "USSD", "Internet", "Services", "SSM and calls", "Ucell bonuses"};
        String[] beelineItems = {"News", "USSD", "Internet", "Services", "SSM and calls", "Beeline bonuses"};
        String[] uzmobileItems = {"News", "USSD", "Internet", "Services", "SSM and calls", "Uzmobile bonuses"};

        listViewContents = new ArrayList<>();

        listViewContents.add(mobiuzItems);
        listViewContents.add(ucellItems);
        listViewContents.add(beelineItems);
        listViewContents.add(uzmobileItems);
    }

    private void setPageListContent(int position) {
        String[] list = listViewContents.get(position);
        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this,
                list,
                Constants.colors[position]);

        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener((adapterView, view, listViewPosition, l) -> {

            Intent intent = new Intent(MainActivity.this, NewActivity.class);
            intent.putExtra("text", list[listViewPosition]);
            startActivity(intent);

        });

    }
}
