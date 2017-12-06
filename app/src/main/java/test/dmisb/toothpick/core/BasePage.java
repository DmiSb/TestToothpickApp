package test.dmisb.toothpick.core;

import android.content.Context;
import android.support.annotation.IdRes;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import toothpick.Scope;
import toothpick.Toothpick;

public abstract class BasePage extends RelativeLayout {

    public BasePage(Context context, AttributeSet attrs) {
        super(context, attrs);
        Scope scope = Toothpick.openScope(getScope());
        Toothpick.inject(this, scope);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        if (!isInEditMode()){
           initView();
        }
    }

    protected abstract void initView();

    protected abstract String getScope();

    protected <T extends View> T $(@IdRes int id) {
        //noinspection unchecked
        return (T) findViewById(id);
    }
}
