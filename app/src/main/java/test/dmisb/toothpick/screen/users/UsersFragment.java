package test.dmisb.toothpick.screen.users;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseFragment;
import test.dmisb.toothpick.data.model.User;

public class UsersFragment extends BaseFragment implements UsersView {

    private UsersAdapter adapter;

    @InjectPresenter
    UsersPresenter presenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_users;
    }

    @Override
    protected void initView(@Nullable Bundle bundle) {
        RecyclerView list = $(R.id.users_list);

        adapter = new UsersAdapter(new ArrayList<>(), item -> presenter.onItemClick(item));
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        presenter.initUsers();
    }

    @Override
    public void addUser(User user) {
        adapter.addUser(user);
    }
}
