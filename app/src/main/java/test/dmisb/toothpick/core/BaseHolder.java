package test.dmisb.toothpick.core;

import android.support.annotation.IdRes;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public abstract class BaseHolder extends RecyclerView.ViewHolder {

    public BaseHolder(View itemView) {
        super(itemView);
    }

    protected <T extends View> T $(@IdRes int id) {
        //noinspection unchecked
        return (T) itemView.findViewById(id);
    }
}
