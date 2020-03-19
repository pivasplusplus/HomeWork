package ru.example.numbers.fragment;

import android.os.Bundle;
import android.util.Log;
import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;
import ru.example.numbers.R;
import ru.example.numbers.click_listener.ClickListener;

public class MainActivity extends AppCompatActivity implements ClickListener {
    private SingleFragment singleFragment;
    private NumFragment numFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        singleFragment = (SingleFragment) getSupportFragmentManager().findFragmentByTag(SingleFragment.TAG);
        numFragment = (NumFragment) getSupportFragmentManager().findFragmentByTag(NumFragment.TAG);

        if (singleFragment == null) {
            singleFragment = new SingleFragment();
        }

        if (numFragment == null) {
            numFragment = new NumFragment();
        }

        showNumFragment();
    }


    @Override
    public void onClick(int num, @ColorInt int color) {
        showSingleFragment(num, color);
    }

    private void showSingleFragment(int number, @ColorInt int color) {
        singleFragment.setNumber(number, color);

        if (getSupportFragmentManager().findFragmentByTag(SingleFragment.TAG) != null) {
            Log.wtf(MainActivity.class.toString(), "SingleFragment execute twice");
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content, singleFragment, SingleFragment.TAG).addToBackStack(SingleFragment.TAG).commit();
    }

    private void showNumFragment() {
        if (getSupportFragmentManager().findFragmentByTag(NumFragment.TAG) != null) {
            return;
        }

        getSupportFragmentManager().beginTransaction()
                .add(R.id.content, numFragment, NumFragment.TAG).commit();
    }
}
