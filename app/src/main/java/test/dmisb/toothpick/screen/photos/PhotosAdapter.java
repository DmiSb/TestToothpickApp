package test.dmisb.toothpick.screen.photos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseAdapter;
import test.dmisb.toothpick.core.BaseHolder;
import test.dmisb.toothpick.core.ItemClickListener;
import test.dmisb.toothpick.data.model.Photo;

class PhotosAdapter extends BaseAdapter<Photo, PhotosAdapter.Holder> {

    PhotosAdapter(List<Photo> items, ItemClickListener<Photo> listener) {
        super(items, listener);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_photo, parent, false);

        int width = parent.getWidth()/3;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.height = width;
        layoutParams.width = width;
        view.setLayoutParams(layoutParams);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Photo photo = getItems().get(position);
        holder.photoTitle.setText(photo.getTitle());

        RequestOptions options = new RequestOptions()
                .centerCrop();

        Glide.with(holder.photoImage.getContext())
                .load(photo.getUrl())
                .apply(options)
                .into(holder.photoImage);
    }

    void addPhoto(Photo photo) {
        getItems().add(photo);
        notifyDataSetChanged();
    }

    class Holder extends BaseHolder {
        final ImageView photoImage;
        final TextView photoTitle;

        Holder(View itemView) {
            super(itemView);
            photoImage = $(R.id.photo_image);
            photoTitle = $(R.id.photo_title);
        }
    }
}
