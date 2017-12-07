package test.dmisb.toothpick.screen.users;

import com.arellomobile.mvp.InjectViewState;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import test.dmisb.toothpick.core.BasePresenter;
import test.dmisb.toothpick.data.Repository;
import test.dmisb.toothpick.data.model.User;
import test.dmisb.toothpick.screen.Screens;

@InjectViewState
public class UsersPresenter extends BasePresenter<UsersView> {

    private List<User> users = new ArrayList<>();

    @Inject
    Repository repository;

    @Override
    public void attachView(UsersView view) {
        super.attachView(view);
        initViewData();
    }

    private void initViewData() {
        if (users.size() == 0) {
            repository.getUsers()
                    .subscribe(
                            user -> {
                                getViewState().addUser(user);
                                users.add(user);
                            }
                    );
        } else {
            getViewState().addUsers(users);
        }
    }

    void onItemClick(User item) {
        router.navigateTo(Screens.PROFILE_SCREEN, item);
    }
}
