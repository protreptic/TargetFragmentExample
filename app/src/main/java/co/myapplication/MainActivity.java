package co.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static co.myapplication.TargetFragment.TAG_TARGET;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.content, new TargetFragment(), TAG_TARGET)
                    .commit();
        }
    }

}
