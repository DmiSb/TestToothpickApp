package test.dmisb.toothpick.screen.intro;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TextView;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.SingleFragment;
import test.dmisb.toothpick.screen.Screens;

public class IntroFragment extends SingleFragment {

    private ViewPager pager;
    private HorizontalScrollView parallax;
    private LinearLayout parallaxContainer;
    private TextView nextButton;
    private TextView skipButton;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_intro;
    }

    @Override
    protected void initView(@Nullable Bundle bundle) {
        pager = $(R.id.intro_pager);
        parallax = $(R.id.intro_parallax);
        parallaxContainer = $(R.id.intro_parallax_container);
        nextButton = $(R.id.intro_next);
        skipButton = $(R.id.intro_skip);

        String[] texts = getResources().getStringArray(R.array.intro_text);
        int[] images = new int[] {R.drawable.ic_cocktail, R.drawable.ic_hot_coffee, R.drawable.ic_beer, R.drawable.ic_grapes};

        IntroPagerAdapter adapter = new IntroPagerAdapter(texts, images);
        pager.setAdapter(adapter);
        pager.setOverScrollMode(View.OVER_SCROLL_NEVER);

        TabLayout indicator = $(R.id.intro_indicator);
        indicator.setupWithViewPager(pager);
    }

    @Override
    public void onResume() {
        super.onResume();
        pager.addOnPageChangeListener(pageListener);
        nextButton.setOnClickListener(v -> nextPage());
        skipButton.setOnClickListener(v -> skip());
    }

    private void nextPage() {
        int position = pager.getCurrentItem();
        if (position < 3)
            pager.setCurrentItem(position + 1);
        else
            skip();
    }

    private void skip() {
        router.newRootScreen(Screens.START_SCREEN);
    }

    @Override
    public void onPause() {
        nextButton.setOnClickListener(null);
        skipButton.setOnClickListener(null);
        pager.removeOnPageChangeListener(pageListener);
        super.onPause();
    }

    private final ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            int x = (int) ((pager.getWidth() * position + positionOffsetPixels) * computeFactor());
            parallax.scrollTo(x, 0);
        }

        @Override
        public void onPageSelected(int position) {
            if (position == 3) {
                nextButton.setText(getString(R.string.intro_start));
                skipButton.setVisibility(View.GONE);
            } else {
                nextButton.setText(getString(R.string.intro_next));
                skipButton.setVisibility(View.VISIBLE);
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {  }

        private float computeFactor() {
            return (parallaxContainer.getWidth() - pager.getWidth()) /
                    (float)(pager.getWidth() * (pager.getAdapter().getCount() - 1));
        }
    };
}
