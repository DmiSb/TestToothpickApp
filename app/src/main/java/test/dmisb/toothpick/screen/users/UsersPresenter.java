package test.dmisb.toothpick.screen.users;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import test.dmisb.toothpick.core.BasePresenter;
import test.dmisb.toothpick.data.Repository;
import test.dmisb.toothpick.data.model.User;
import test.dmisb.toothpick.screen.Screens;

@InjectViewState
public class UsersPresenter extends BasePresenter<UsersView> {

    @Inject
    Repository repository;

    void initUsers() {
        repository.getUsers()
                .subscribe(
                        user -> getViewState().addUser(user)
                );
    }

    void onItemClick(User item) {
        router.navigateTo(Screens.PROFILE_SCREEN, item);
    }
}
