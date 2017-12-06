package test.dmisb.toothpick.screen.users;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import test.dmisb.toothpick.core.BaseView;
import test.dmisb.toothpick.data.model.User;

@StateStrategyType(SkipStrategy.class)
interface UsersView extends BaseView {
    void addUser(User user);
}
