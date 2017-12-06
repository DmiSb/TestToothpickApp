package test.dmisb.toothpick.screen.start;

import com.arellomobile.mvp.InjectViewState;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import test.dmisb.toothpick.core.BasePresenter;
import test.dmisb.toothpick.data.model.Poster;
import test.dmisb.toothpick.screen.Screens;

@InjectViewState
public class StartPresenter extends BasePresenter<StartView> {

    private int[] posterList = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
    private Disposable disposable;

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        startPostersChange();
    }

    void onNextClick() {
        router.newRootScreen(Screens.USERS_SCREEN);
    }

    private void startPostersChange() {
        disposable = getPosters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        poster -> {
                            getViewState().updatePoster(poster.getFirstPoster(), poster.getFirstImage());
                            getViewState().updatePoster(poster.getSecondPoster(), poster.getSecondImage());
                            posterList[poster.getFirstPoster() - 1] = poster.getFirstImage();
                            posterList[poster.getSecondPoster() - 1] = poster.getSecondImage();
                            posterList[9] = 0;
                        }
                );
    }

    private Observable<Poster> getPosters() {
        return Observable.interval(1000, TimeUnit.MILLISECONDS)
                .map(aLong -> {
                    Poster poster = new Poster(rnd(1, 9), getImage());
                    posterList[9] = poster.getFirstImage();
                    poster.setSecondPoster(getSecondPoster(poster.getFirstPoster()));
                    poster.setSecondImage(getImage());
                    return poster;
                });
    }

    private int getImage(){
        boolean match = true;
        int image = 0;
        while (match) {
            image = rnd(1, 25);
            match = false;
            for (int poster : posterList) {
                if (poster == image)
                    match = true;
            }
        }
        return image;
    }

    private int getSecondPoster(int fistPoster) {
        boolean match = true;
        int poster = 0;
        while (match) {
            poster = rnd(1, 9);
            match = false;
            switch (fistPoster){
                case 1:
                    match = poster == 2 || poster == 4;
                    break;
                case 2:
                    match = poster == 1 || poster == 3 || poster == 5;
                    break;
                case 3:
                    match = poster == 2 || poster == 6;
                    break;
                case 4:
                    match = poster == 1 || poster == 5 || poster == 7;
                    break;
                case 5:
                    match = poster == 2 || poster == 4 || poster == 6 || poster == 8;
                    break;
                case 6:
                    match = poster == 3 || poster == 5 || poster == 9;
                    break;
                case 7:
                    match = poster == 4 || poster == 8;
                    break;
                case 8:
                    match = poster == 5 || poster == 7 || poster == 9;
                    break;
                case 9:
                    match = poster == 6 || poster == 8;
                    break;
            }
        }
        return poster;
    }

    private int rnd(int min, int max) {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    @Override
    public void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
