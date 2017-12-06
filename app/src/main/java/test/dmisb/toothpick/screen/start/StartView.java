package test.dmisb.toothpick.screen.start;

import com.arellomobile.mvp.viewstate.strategy.SkipStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import test.dmisb.toothpick.core.BaseView;

@StateStrategyType(SkipStrategy.class)
interface StartView extends BaseView {
    void updatePoster(int posterId, int resId);
}
