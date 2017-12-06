package test.dmisb.toothpick;

import android.app.Application;
import android.content.Context;

import test.dmisb.toothpick.di.AppModule;
import test.dmisb.toothpick.di.DataModule;
import test.dmisb.toothpick.di.Scopes;
import toothpick.Toothpick;
import toothpick.configuration.Configuration;

public class App extends Application {

    private static Context appContext;

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();

        initToothpick();
        initScopes();
    }

    public static Context getAppContext() {
        return appContext;
    }

    private void initToothpick() {
        if (BuildConfig.DEBUG) {
            Toothpick.setConfiguration(Configuration.forDevelopment().preventMultipleRootScopes());
        } else {
            Toothpick.setConfiguration(Configuration.forProduction().disableReflection());
        }
    }

    private void initScopes() {
        Toothpick.openScope(Scopes.APP_SCOPE)
                .installModules(new AppModule(appContext));
        Toothpick.openScopes(Scopes.APP_SCOPE, Scopes.DATA_SCOPE)
                .installModules(new DataModule(appContext));
    }
}
