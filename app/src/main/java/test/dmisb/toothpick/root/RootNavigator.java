package test.dmisb.toothpick.root;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import ru.terrakok.cicerone.android.SupportAppNavigator;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.User;
import test.dmisb.toothpick.screen.Screens;
import test.dmisb.toothpick.screen.intro.IntroFragment;
import test.dmisb.toothpick.screen.photos.PhotosFragment;
import test.dmisb.toothpick.screen.profile.ProfileFragment;
import test.dmisb.toothpick.screen.start.StartFragment;
import test.dmisb.toothpick.screen.users.UsersFragment;

class RootNavigator extends SupportAppNavigator {

    RootNavigator(FragmentActivity activity, int containerId) {
        super(activity, containerId);
    }

    @Override
    protected Intent createActivityIntent(String screenKey, Object data) {
        return null;
    }

    @Override
    protected Fragment createFragment(String screenKey, Object data) {
        switch (screenKey) {
            case Screens.INTRO_SCREEN:                  return new IntroFragment();
            case Screens.START_SCREEN:                  return new StartFragment();
            case Screens.USERS_SCREEN:                  return new UsersFragment();
            case Screens.PROFILE_SCREEN:                return ProfileFragment.newInstance((User) data);
            case Screens.PHOTOS_SCREEN:                 return PhotosFragment.newInstance((Album) data);
        }
        return null;
    }
}
