package test.dmisb.toothpick.screen.photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;

import java.util.ArrayList;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseFragment;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.data.model.Photo;

public class PhotosFragment extends BaseFragment implements PhotosView {

    private Album album;
    private PhotosAdapter adapter;

    @InjectPresenter
    PhotosPresenter presenter;

    public static PhotosFragment newInstance(Album album) {
        PhotosFragment instance = new PhotosFragment();
        instance.album = album;
        return instance;
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.fragment_photos;
    }

    @Override
    protected void initView(@Nullable Bundle bundle) {
        ((TextView) $(R.id.photos_album_name)).setText(album.getTitle());

        $(R.id.photos_back).setOnClickListener(v -> presenter.onBackClick());

        adapter = new PhotosAdapter(new ArrayList<>(), null);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
        RecyclerView list = $(R.id.photos_list);
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        presenter.initPhotos(album.getId());
    }

    @Override
    public void addPhoto(Photo photo) {
        adapter.addPhoto(photo);
    }
}
