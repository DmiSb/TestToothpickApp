package test.dmisb.toothpick.screen.profile;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import test.dmisb.toothpick.R;

class ProfilePageAdapter extends PagerAdapter {

    private String[] titles = new String[] {"Albums", "Posts"};

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        View view;
        if (position == 0) {
            view = inflater.inflate(R.layout.profile_albums, container, false);
        } else {
            view = inflater.inflate(R.layout.profile_posts, container, false);
        }
        container.addView(view);
        return view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
