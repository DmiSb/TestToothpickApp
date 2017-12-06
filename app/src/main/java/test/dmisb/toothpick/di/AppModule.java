package test.dmisb.toothpick.di;

import android.content.Context;

import ru.terrakok.cicerone.Cicerone;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;
import toothpick.config.Module;

public class AppModule extends Module {
    public AppModule(Context context) {
        bind(Context.class).toInstance(context);
        // Navigation
        Cicerone cicerone = Cicerone.create();
        bind(Router.class).toInstance((Router) cicerone.getRouter());
        bind(NavigatorHolder.class).toInstance(cicerone.getNavigatorHolder());
    }
}
