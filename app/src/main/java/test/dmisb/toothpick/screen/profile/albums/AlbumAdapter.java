package test.dmisb.toothpick.screen.profile.albums;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseAdapter;
import test.dmisb.toothpick.core.BaseHolder;
import test.dmisb.toothpick.core.ItemClickListener;
import test.dmisb.toothpick.data.model.Album;

class AlbumAdapter extends BaseAdapter<Album, AlbumAdapter.Holder>{

    AlbumAdapter(List<Album> items, ItemClickListener<Album> listener) {
        super(items, listener);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(createView(parent, R.layout.item_album));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Album album = getItems().get(position);
        holder.albumTitle.setText(album.getTitle());
        holder.albumTitle.setOnClickListener(v -> onClick(album));
    }

    void addAlbum(Album album) {
        getItems().add(album);
        notifyDataSetChanged();
    }

    class Holder extends BaseHolder {
        final TextView albumTitle;

        Holder(View itemView) {
            super(itemView);
            albumTitle = $(R.id.album_title);
        }
    }
}
