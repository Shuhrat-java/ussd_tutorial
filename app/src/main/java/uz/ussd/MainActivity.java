package uz.ussd;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        String[] operators = {"MOBIUZ", "UCELL", "BEELINE", "UZMOBILE"};
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(MainActivity.this, operators);
        viewPager.setAdapter(viewPagerAdapter);

        String[] listITems = {"News", "USSD", "Internet", "Services", "SSM and calls"};
        ListView listView = findViewById(R.id.listView);
        ListViewAdapter listViewAdapter = new ListViewAdapter(MainActivity.this, listITems);
        listView.setAdapter(listViewAdapter);
    }
}
