package test.dmisb.toothpick.di;

import test.dmisb.toothpick.screen.profile.ProfilePresenter;
import toothpick.config.Module;

public class ProfileModule extends Module {
    public ProfileModule(ProfilePresenter presenter) {
        bind(ProfilePresenter.class).toInstance(presenter);
    }
}
