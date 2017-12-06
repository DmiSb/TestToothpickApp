package test.dmisb.toothpick.screen.profile;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import test.dmisb.toothpick.core.BaseView;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.Post;

@StateStrategyType(SkipStrategy.class)
interface ProfileView extends BaseView {
    void addAlbum(Album album);
    void addPost(Post post);
}
