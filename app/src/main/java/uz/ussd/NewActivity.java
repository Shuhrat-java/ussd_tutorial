package uz.ussd;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Locale;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        TextView textView = findViewById(R.id.new_activity_tv);
        String text = getIntent().getStringExtra("text");

        textView.setText(text);

        ListView listView = findViewById(R.id.internet_package_list);

        if (text.toLowerCase(Locale.ROOT).trim().equals("internet")) {
            textView.setVisibility(View.GONE);
            ArrayList<Internet> list = prepareUcellInternetPackages();
            listView.setAdapter(new InternetListAdapter(NewActivity.this, list));
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                    Internet internet = list.get(position);
                    PopupWindow popupWindow = new PopupWindow();
                    popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
                    popupWindow.setHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

                    View internetPopupLayout = LayoutInflater.from(NewActivity.this).inflate(R.layout.internet_popup, null, false);


                    TextView textView1 = internetPopupLayout.findViewById(R.id.internet_info);
                    textView1.setText(internet.toString());

                    Button activate = internetPopupLayout.findViewById(R.id.btnUssd);
                    activate.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            popupWindow.dismiss();
                        }
                    });

                    popupWindow.setContentView(internetPopupLayout);
                    popupWindow.showAtLocation(listView, Gravity.NO_GRAVITY, 30, 30);
                }
            });
        }
    }


    private ArrayList<Internet> prepareUcellInternetPackages() {
        ArrayList<Internet> packages = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Internet internet = new Internet();
            internet.setPackageName("Internet " + (i + 1) * 2 + " GB");
            internet.setPrice(10000 * i / 2);
            internet.setmBAmount((i + 1) * 2);
            internet.setUssdCode("*151*" + i + "*" + i + "123*11#");
            packages.add(internet);
        }
        return packages;
    }
}
