package test.dmisb.toothpick.screen.profile.posts;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseAdapter;
import test.dmisb.toothpick.core.BaseHolder;
import test.dmisb.toothpick.core.ItemClickListener;
import test.dmisb.toothpick.data.model.Post;

class PostAdapter extends BaseAdapter<Post, PostAdapter.Holder>{

    PostAdapter(List<Post> items, ItemClickListener<Post> listener) {
        super(items, listener);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(createView(parent, R.layout.item_post));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.postTitle.setText(getItems().get(position).getTitle());
        holder.postBody.setText(getItems().get(position).getBody());
    }

    void addPost(Post post) {
        getItems().add(post);
        notifyDataSetChanged();
    }

    class Holder extends BaseHolder {
        final TextView postTitle;
        final TextView postBody;

        Holder(View itemView) {
            super(itemView);
            postTitle = $(R.id.post_title);
            postBody = $(R.id.post_body);
        }
    }
}
