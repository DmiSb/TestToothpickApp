package test.dmisb.toothpick.root;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;
import test.dmisb.toothpick.data.Repository;
import test.dmisb.toothpick.di.Scopes;
import test.dmisb.toothpick.screen.Screens;
import toothpick.Scope;
import toothpick.Toothpick;

@InjectViewState
public class RootPresenter extends MvpPresenter<RootView> {

    @Inject
    Router router;
    @Inject
    Repository repository;

    RootPresenter() {
        Scope scope = Toothpick.openScope(Scopes.DATA_SCOPE);
        Toothpick.inject(this, scope);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.newRootScreen(Screens.INTRO_SCREEN);
    }
}
