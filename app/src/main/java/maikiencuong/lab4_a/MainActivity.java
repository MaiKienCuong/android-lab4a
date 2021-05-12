package maikiencuong.lab4_a;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements SendData {
    TextView tvThanhTien;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvThanhTien = findViewById(R.id.tvThanhTien);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment_below, BelowFragment.newInstance("141.800 d")).commit();
    }


    @Override
    public void SendingData(Integer s, Integer price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,##0 d");
        tvThanhTien.setText(decimalFormat.format(s * price));
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_below, BelowFragment.newInstance(decimalFormat.format(s * price))).commit();
    }
}