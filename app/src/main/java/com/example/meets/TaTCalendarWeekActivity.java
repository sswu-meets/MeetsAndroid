package com.example.meets;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import static com.example.meets.R.layout.activity_week_calendar;

/**
 * Created by kitte on 2016-12-29.
 */

public class TaTCalendarWeekActivity extends AppCompatActivity implements TaTCalendarWeekFragment.OnFragmentListener {
    private static final String TAG = "TaTCalendarWeekActivity";
    private static final int COUNT_PAGE = 50;
    private ViewPager viewPager;
    private TaTCalendarWeekAdapter taTCalendarWeekAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_week_calendar);

        viewPager = (ViewPager)findViewById(R.id.calendar_week_pager);
        taTCalendarWeekAdapter = new TaTCalendarWeekAdapter(getSupportFragmentManager());
        viewPager.setAdapter(taTCalendarWeekAdapter);

        taTCalendarWeekAdapter.setOnFragmentListener(this);
        taTCalendarWeekAdapter.setNumOfWeek(COUNT_PAGE);
        viewPager.setCurrentItem(COUNT_PAGE);
        String title = taTCalendarWeekAdapter.getMonthDisplayed(COUNT_PAGE);
        getSupportActionBar().setTitle(title);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                String title = taTCalendarWeekAdapter.getMonthDisplayed(position);
                getSupportActionBar().setTitle(title);

                if (position == 0) {
                    taTCalendarWeekAdapter.addPrev();
                    viewPager.setCurrentItem(COUNT_PAGE, false);
                    Log.d("TaTCalendarActivity","position("+position+") COUNT_PAGE("+COUNT_PAGE+")");
                } else if (position == taTCalendarWeekAdapter.getCount() - 1) {
                    taTCalendarWeekAdapter.addNext();
                    viewPager.setCurrentItem(taTCalendarWeekAdapter.getCount() - (COUNT_PAGE + 1), false);
                    Log.d("TaTCalendarActivity","position("+position+") COUNT_PAGE("+(taTCalendarWeekAdapter.getCount() - (COUNT_PAGE + 1))+")");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void onFragmentListener(View view) {
        resizeHeight(view);
    }

    public void resizeHeight(View mRootView) {

        if (mRootView.getHeight() < 1) {
            return;
        }
        ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
        if (layoutParams.height <= 0) {
            layoutParams.height = mRootView.getHeight();
            viewPager.setLayoutParams(layoutParams);
            return;
        }
        ValueAnimator anim = ValueAnimator.ofInt(viewPager.getLayoutParams().height, mRootView.getHeight());
        anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                int val = (Integer) valueAnimator.getAnimatedValue();
                ViewGroup.LayoutParams layoutParams = viewPager.getLayoutParams();
                layoutParams.height = val;
                viewPager.setLayoutParams(layoutParams);
            }
        });
        anim.setDuration(200);
        anim.start();
    }
}
