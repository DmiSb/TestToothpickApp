package test.dmisb.toothpick.screen.start;

import android.os.Bundle;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.Locale;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseFragment;

public class StartFragment extends BaseFragment implements StartView {

    private static final String POSTER_RES = "poster_%d";

    private ImageView poster1;
    private ImageView poster2;
    private ImageView poster3;
    private ImageView poster4;
    private ImageView poster5;
    private ImageView poster6;
    private ImageView poster7;
    private ImageView poster8;
    private ImageView poster9;

    @InjectPresenter
    StartPresenter presenter;

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_start;
    }

    @Override
    protected void initView(@Nullable Bundle bundle) {
        poster1 = $(R.id.poster_1);
        poster2 = $(R.id.poster_2);
        poster3 = $(R.id.poster_3);
        poster4 = $(R.id.poster_4);
        poster5 = $(R.id.poster_5);
        poster6 = $(R.id.poster_6);
        poster7 = $(R.id.poster_7);
        poster8 = $(R.id.poster_8);
        poster9 = $(R.id.poster_9);

        $(R.id.start_go).setOnClickListener(v -> presenter.onNextClick());
    }

    @Override
    public void updatePoster(int posterId, int resId) {
        String resName = String.format(Locale.getDefault(), POSTER_RES, resId);
        @DrawableRes int drawableId = getResources().getIdentifier(resName, "drawable", getContext().getPackageName());
        if (drawableId > 0) {
            switch (posterId) {
                case 1:
                    poster1.setImageResource(drawableId);
                    break;
                case 2:
                    poster2.setImageResource(drawableId);
                    break;
                case 3:
                    poster3.setImageResource(drawableId);
                    break;
                case 4:
                    poster4.setImageResource(drawableId);
                    break;
                case 5:
                    poster5.setImageResource(drawableId);
                    break;
                case 6:
                    poster6.setImageResource(drawableId);
                    break;
                case 7:
                    poster7.setImageResource(drawableId);
                    break;
                case 8:
                    poster8.setImageResource(drawableId);
                    break;
                case 9:
                    poster9.setImageResource(drawableId);
                    break;
            }
        }
    }
}
