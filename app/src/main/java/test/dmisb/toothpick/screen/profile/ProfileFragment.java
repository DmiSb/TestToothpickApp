package test.dmisb.toothpick.screen.profile;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseFragment;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.Post;
import test.dmisb.toothpick.data.model.User;
import test.dmisb.toothpick.screen.profile.albums.AlbumView;
import test.dmisb.toothpick.screen.profile.posts.PostView;

public class ProfileFragment extends BaseFragment implements ProfileView {

    private User user;
    private ViewPager pager;

    @InjectPresenter
    ProfilePresenter presenter;

    public static ProfileFragment newInstance(User user) {
        ProfileFragment instance = new ProfileFragment();
        instance.user = user;
        return instance;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_profile;
    }

    @Override
    protected void initView(@Nullable Bundle bundle) {
        ((TextView) $(R.id.profile_user_name)).setText(user.getName());
        ((TextView) $(R.id.profile_email)).setText(user.getEmail());
        ((TextView) $(R.id.profile_phone)).setText(user.getPhone());
        ((TextView) $(R.id.profile_address)).setText(user.getAddress().getFullAddress());

        $(R.id.profile_back).setOnClickListener(v -> presenter.onBackClick());

        pager = $(R.id.profile_pager);
        initAdapter($(R.id.profile_tab));

        presenter.setUserId(user.getId());
    }

    private void initAdapter(TabLayout tab) {
        ProfilePageAdapter adapter = new ProfilePageAdapter();
        tab.setupWithViewPager(pager);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(
                new TabLayout.TabLayoutOnPageChangeListener(tab)
        );
    }

    @Override
    public void addAlbum(Album album) {
        ((AlbumView) pager.getChildAt(0)).addAlbum(album);
    }

    @Override
    public void addPost(Post post) {
        ((PostView) pager.getChildAt(1)).addPost(post);
    }
}
