package test.dmisb.toothpick.network;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import retrofit2.Response;

public class RestCallTransformer<S> implements ObservableTransformer<Response<S>, S> {

    @Override
    public ObservableSource<S> apply(Observable<Response<S>> upstream) {
        return NetworkStatusChecker.isInternetAvailable()
                .flatMap(aBoolean -> aBoolean ? upstream : Observable.error(new Throwable("Network is not available")))
                .flatMap(rResponse -> {
                    switch (rResponse.code()) {
                        case 200:
                            return Observable.just(rResponse.body());
                        default:
                            return Observable.error(new Throwable(
                                    rResponse.errorBody().string()
                            ));
                    }
                });
    }
}
