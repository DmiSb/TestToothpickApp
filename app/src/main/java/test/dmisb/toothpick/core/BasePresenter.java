package test.dmisb.toothpick.core;

import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import test.dmisb.toothpick.di.Scopes;
import toothpick.Scope;
import toothpick.Toothpick;

public abstract class BasePresenter<V extends BaseView> extends MvpPresenter<V> {

    @Inject
    protected Router router;

    public BasePresenter() {
        Scope scope = Toothpick.openScope(Scopes.DATA_SCOPE);
        Toothpick.inject(this, scope);
    }

    public void onBackClick() {
        router.exit();
    }
}
