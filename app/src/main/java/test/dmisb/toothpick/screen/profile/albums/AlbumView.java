package test.dmisb.toothpick.screen.profile.albums;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;

import javax.inject.Inject;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BasePage;
import test.dmisb.toothpick.data.model.Album;
import test.dmisb.toothpick.di.Scopes;
import test.dmisb.toothpick.screen.profile.ProfilePresenter;

@SuppressWarnings("Injectable")
public class AlbumView extends BasePage {

    private AlbumAdapter adapter;

    @Inject
    ProfilePresenter presenter;

    public AlbumView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        adapter = new AlbumAdapter(new ArrayList<>(), item -> presenter.onAlbumClick(item));
        RecyclerView list = findViewById(R.id.profile_album_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        presenter.initAlbums();
    }

    @Override
    protected String getScope() {
        return Scopes.PROFILE_SCOPE;
    }

    public void addAlbum(Album album) {
        adapter.addAlbum(album);
    }
}
