package test.dmisb.toothpick.screen.profile;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import test.dmisb.toothpick.core.BasePresenter;
import test.dmisb.toothpick.data.Repository;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.di.ProfileModule;
import test.dmisb.toothpick.di.Scopes;
import test.dmisb.toothpick.screen.Screens;
import toothpick.Toothpick;

@InjectViewState
public class ProfilePresenter extends BasePresenter<ProfileView> {

    private int userId;

    @Inject
    Repository repository;

    public ProfilePresenter() {
        Toothpick.openScopes(Scopes.DATA_SCOPE, Scopes.PROFILE_SCOPE).installModules(new ProfileModule(this));
    }

    @Override
    public void onDestroy() {
        Toothpick.closeScope(Scopes.PROFILE_SCOPE);
        super.onDestroy();
    }

    void setUserId(int userId) {
        this.userId = userId;
    }

    public void initAlbums() {
        repository.getUserAlbums(userId)
                .subscribe(
                        album -> getViewState().addAlbum(album)
                );
    }

    public void initPosts() {
        repository.getUserPosts(userId)
                .subscribe(
                        post -> getViewState().addPost(post)
                );
    }

    public void onAlbumClick(Album album) {
        router.navigateTo(Screens.PHOTOS_SCREEN, album);
    }
}
