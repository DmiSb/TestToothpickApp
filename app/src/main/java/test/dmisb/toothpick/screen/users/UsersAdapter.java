package test.dmisb.toothpick.screen.users;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import test.dmisb.toothpick.R;
import test.dmisb.toothpick.core.BaseAdapter;
import test.dmisb.toothpick.core.BaseHolder;
import test.dmisb.toothpick.core.ItemClickListener;
import test.dmisb.toothpick.data.model.User;

class UsersAdapter extends BaseAdapter<User, UsersAdapter.Holder>{

    UsersAdapter(List<User> items, ItemClickListener<User> listener) {
        super(items, listener);
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(createView(parent, R.layout.item_user));
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        User user = getItems().get(position);
        holder.userName.setText(user.getName());
        holder.userEmail.setText(user.getEmail());
        holder.userPhone.setText(user.getPhone());

        holder.userRoot.setOnClickListener(v -> onClick(user));
    }

    void addUser(User user) {
        getItems().add(user);
        notifyDataSetChanged();
    }

    class Holder extends BaseHolder {

        final LinearLayout userRoot;
        final TextView userName;
        final TextView userEmail;
        final TextView userPhone;

        Holder(View itemView) {
            super(itemView);
            userRoot = $(R.id.user_root);
            userName = $(R.id.user_name);
            userEmail = $(R.id.user_email);
            userPhone = $(R.id.user_phone);
        }
    }
}
