package test.dmisb.toothpick.core;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import test.dmisb.toothpick.di.Scopes;
import toothpick.Scope;
import toothpick.Toothpick;

public abstract class SingleFragment extends Fragment {

    private View rootView;

    @Inject
    protected Router router;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Scope scope = Toothpick.openScope(Scopes.DATA_SCOPE);
        Toothpick.inject(this, scope);

        rootView = inflater.inflate(getLayoutRes(), container, false);
        initView(savedInstanceState);
        return rootView;
    }

    protected abstract @LayoutRes
    int getLayoutRes();

    protected abstract void initView(@Nullable Bundle bundle);

    protected <T extends View> T $(@IdRes int id) {
        //noinspection unchecked
        return (T) rootView.findViewById(id);
    }
}
