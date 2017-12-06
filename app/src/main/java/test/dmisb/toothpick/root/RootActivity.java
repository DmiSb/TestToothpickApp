package test.dmisb.toothpick.root;

import android.os.Bundle;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import test.dmisb.toothpick.R;
import test.dmisb.toothpick.di.Scopes;
import toothpick.Scope;
import toothpick.Toothpick;

public class RootActivity extends MvpAppCompatActivity implements RootView {

    @InjectPresenter
    RootPresenter presenter;
    @Inject
    NavigatorHolder navigatorHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_root);

        initToothPick();
    }

    private void initToothPick() {
        Scope scope = Toothpick.openScope(Scopes.APP_SCOPE);
        Toothpick.inject(this, scope);
    }

    @Override
    protected void onResume() {
        super.onResume();
        navigatorHolder.setNavigator(new RootNavigator(this, R.id.root_frame));
    }

    @Override
    protected void onPause() {
        navigatorHolder.removeNavigator();
        super.onPause();
    }
}
