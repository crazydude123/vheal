

package thatteidlipudina.com.vheal;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.widget.NumberPicker;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ToggleButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.Toast;

//import thatteidlipudina.com.vheal.R;

public class Ailments_or_Report extends AppCompatActivity {
    int page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ailment_or_report);

        NumberPicker np = findViewById(R.id.np);

        np.setMinValue(2);
        np.setMaxValue(20);

        np.setOnValueChangedListener(onValueChangeListener);




        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleButton);


        toggle.setOnCheckedChangeListener(new OnCheckedChangeListener() {

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                //int page;
                if (isChecked) {
                    page =1;
                } else {
                    page =0;
                }
            }
        });

        FloatingActionButton mFloat= (FloatingActionButton) findViewById(R.id.fab);
        mFloat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(page==1){
                    Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
                    startActivity(intent);

                }
                else if(page==0){
                    Intent intent = new Intent(getApplicationContext(), Credit.class);
                    startActivity(intent);
                }
            }
        });


    }
    /*public void onClickFloat(View view) {
        if(page==1){
            Intent intent = new Intent(getApplicationContext(), UploadActivity.class);
            startActivity(intent);

        }
        else if(page==0){
            Intent intent = new Intent(getApplicationContext(), Credit.class);
            startActivity(intent);
        }
    }*/



    NumberPicker.OnValueChangeListener onValueChangeListener =
            new 	NumberPicker.OnValueChangeListener(){
                @Override
                public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                    Toast.makeText(Ailments_or_Report.this,
                            "selected number "+numberPicker.getValue(), Toast.LENGTH_SHORT).show();
                }
            };
}
