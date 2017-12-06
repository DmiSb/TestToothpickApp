package test.dmisb.toothpick.screen.photos;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import test.dmisb.toothpick.core.BaseView;
import test.dmisb.toothpick.data.model.Photo;

@StateStrategyType(SkipStrategy.class)
interface PhotosView extends BaseView {
    void addPhoto(Photo photo);
}
