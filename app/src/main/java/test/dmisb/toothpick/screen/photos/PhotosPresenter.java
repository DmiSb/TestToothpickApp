package test.dmisb.toothpick.screen.photos;

import com.arellomobile.mvp.InjectViewState;

import javax.inject.Inject;

import test.dmisb.toothpick.core.BasePresenter;
import test.dmisb.toothpick.data.Repository;

@InjectViewState
public class PhotosPresenter extends BasePresenter<PhotosView> {

    @Inject
    Repository repository;

    void initPhotos(int albumId) {
        repository.getAlbumPhoto(albumId)
                .subscribe(
                        photo -> getViewState().addPhoto(photo)
                );
    }
}
