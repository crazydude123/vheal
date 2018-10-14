

package thatteidlipudina.com.vheal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
//import android.animation.*;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

//import thatteidlipudina.com.vheal.R;

public class Credit extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit);
        Animation animation;
        animation = AnimationUtils.loadAnimation(getApplicationContext(),
                R.anim.zoom);
        ImageView im= findViewById(R.id.imageView);
        im.startAnimation(animation);

    }
}
