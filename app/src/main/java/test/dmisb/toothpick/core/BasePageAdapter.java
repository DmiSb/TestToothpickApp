package test.dmisb.toothpick.core;

import android.support.annotation.LayoutRes;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BasePageAdapter extends PagerAdapter {

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(container.getContext())
                .inflate(getLayoutRes(), container, false);
        initView(view, position);
        container.addView(view);
        return view;
    }

    protected abstract @LayoutRes
    int getLayoutRes();

    protected abstract void initView(View view, int position);

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
