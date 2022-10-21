package uz.ussd;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

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
    }
}
