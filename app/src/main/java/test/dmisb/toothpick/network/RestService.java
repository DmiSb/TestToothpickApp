package test.dmisb.toothpick.network;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.Photo;
import test.dmisb.toothpick.data.model.Post;
import test.dmisb.toothpick.data.model.User;

public interface RestService {

    @GET("users")
    Observable<Response<List<User>>> getUsers();

    @GET("users/{user_id}")
    Observable<Response<User>> getUserById(@Path("user_id") int userId);

    @GET("users/{user_id}/albums")
    Observable<Response<List<Album>>> getUserAlbums(@Path("user_id") int userId);

    @GET("users/{user_id}/posts")
    Observable<Response<List<Post>>> getUserPosts(@Path("user_id") int userId);

    @GET("albums/{album_id}/photos")
    Observable<Response<List<Photo>>> getAlbumPhoto(@Path("album_id") int albumId);
}
