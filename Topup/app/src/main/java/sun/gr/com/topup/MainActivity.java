package sun.gr.com.topup;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class MainActivity extends AppCompatActivity {

    @Bind(R.id.tv_topbar)
    TextView tvTopbar;
    @Bind(R.id.vp_1)
    ViewPager viewpager;
    @Bind(R.id.bt_bottombar_account)
    Button btBottombarAccount;
    @Bind(R.id.bt_bottombar_topup)
    Button btBottombarTopup;
    @Bind(R.id.bt_bottombar_transcation)
    Button btBottombarTranscation;
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViews();
    }

    private void initViews() {
        Fragment tab1 = new AccountFragment();
        Fragment tab2 = new TopupFragment();
        Fragment tab3 = new TopupFragment();
        fragments = new ArrayList<>();
        fragments.add(tab1);
        fragments.add(tab2);
        fragments.add(tab3);

        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        };

        viewpager.setAdapter(adapter);
        viewpager.setCurrentItem(0);
        viewpager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                viewpager.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }


}
