package test.dmisb.toothpick.data;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.Photo;
import test.dmisb.toothpick.data.model.Post;
import test.dmisb.toothpick.data.model.User;
import test.dmisb.toothpick.network.RestCallTransformer;
import test.dmisb.toothpick.network.RestService;

public class Repository {
    private final Prefs prefs;
    private final RestService restService;

    public Repository(Prefs prefs, RestService restService) {
        this.prefs = prefs;
        this.restService = restService;
    }

    public Observable<User> getUsers() {
        return restService.getUsers()
                .compose(new RestCallTransformer<>())
                .flatMap(Observable::fromIterable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Album> getUserAlbums(int userId) {
        return restService.getUserAlbums(userId)
                .compose(new RestCallTransformer<>())
                .flatMap(Observable::fromIterable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Post> getUserPosts(int userId) {
        return restService.getUserPosts(userId)
                .compose(new RestCallTransformer<>())
                .flatMap(Observable::fromIterable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public Observable<Photo> getAlbumPhoto(int albumId) {
        return  restService.getAlbumPhoto(albumId)
                .compose(new RestCallTransformer<>())
                .flatMap(Observable::fromIterable)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
