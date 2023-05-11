package sg.edu.rp.c346.id22023219.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etTelephone;
    EditText etSize;
    DatePicker dp;
    TimePicker tp;
    Button btnReserve;
    Button btnReset;
    CheckBox cbSmoking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etTelephone = findViewById(R.id.editTextTelephone);
        etSize = findViewById(R.id.editTextSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        btnReserve = findViewById(R.id.buttonReserve);
        btnReset = findViewById(R.id.buttonReset);
        cbSmoking = findViewById(R.id.checkBoxSmoking);

        btnReserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String smokeCheck = "No";
                String names = etName.getText().toString();
                String tele = etTelephone.getText().toString();
                String sizes = etSize.getText().toString();
                String Date = dp.getDayOfMonth() + "/" + (dp.getMonth() + 1)+ "/" + dp.getYear();
                String times = "";
                if (tp.getMinute() < 10){
                    times = tp.getHour() + ":0" + tp.getMinute();
                }
                else{
                    times = tp.getHour() + ":" + tp.getMinute();
                }



                if (cbSmoking.isChecked()){
                    smokeCheck = "Yes";
                }
                Toast.makeText(MainActivity.this,"Name: " + names + " Tele: " + tele + " Size: " + sizes + " Smoking: " + smokeCheck + " Date: " + Date + " Time: " + times,
                        Toast.LENGTH_LONG).show();

            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etName.setText("");
                etTelephone.setText("");
                etSize.setText("");
                dp.updateDate(2023,5,1);
                tp.setHour(19);
                tp.setMinute(30);
                cbSmoking.setChecked(false);
            }
        });
    }
}