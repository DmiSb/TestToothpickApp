package test.dmisb.toothpick.screen.profile.posts;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import java.util.ArrayList;

import javax.inject.Inject;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BasePage;
import test.dmisb.toothpick.data.model.Post;
import test.dmisb.toothpick.di.Scopes;
import test.dmisb.toothpick.screen.profile.ProfilePresenter;

@SuppressWarnings("Injectable")
public class PostView extends BasePage {

    private PostAdapter adapter;

    @Inject
    ProfilePresenter presenter;

    public PostView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void initView() {
        adapter = new PostAdapter(new ArrayList<>(), null);
        RecyclerView list = findViewById(R.id.profile_post_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        list.setLayoutManager(layoutManager);
        list.setAdapter(adapter);

        presenter.initPosts();
    }

    @Override
    protected String getScope() {
        return Scopes.PROFILE_SCOPE;
    }

    public void addPost(Post post) {
        adapter.addPost(post);
    }
}
