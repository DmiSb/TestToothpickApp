package test.dmisb.toothpick.screen.intro;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BasePageAdapter;

class IntroPagerAdapter extends BasePageAdapter {

    private final String[] texts;
    private final int[] images;

    IntroPagerAdapter(String[] texts, int[] images) {
        this.texts = texts;
        this.images = images;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.page_intro;
    }

    @Override
    public int getCount() {
        return texts.length;
    }

    @Override
    protected void initView(View view, int position) {
        ((ImageView) view.findViewById(R.id.intro_page_image)).setImageResource(images[position]);
        ((TextView) view.findViewById(R.id.intro_page_text)).setText(texts[position]);
    }
}
