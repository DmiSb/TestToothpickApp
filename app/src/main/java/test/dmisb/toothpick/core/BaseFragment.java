package test.dmisb.toothpick.core;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;

public abstract class BaseFragment extends MvpAppCompatFragment {

    private View rootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(getLayoutRes(), container, false);
        initView(savedInstanceState);
        return rootView;
    }

    protected abstract @LayoutRes int getLayoutRes();

    protected abstract void initView(@Nullable Bundle bundle);

    protected <T extends View> T $(@IdRes int id) {
        //noinspection unchecked
        return (T) rootView.findViewById(id);
    }

    protected void openKeyboard(View view){
        InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
        view.requestFocus();
        imm.showSoftInput(view, 0);
    }

    @Override
    public void onPause() {
        closeKeyboard();
        super.onPause();
    }

    @Override
    public void onDestroy() {
        closeKeyboard();
        super.onDestroy();
    }

    private void closeKeyboard(){
        View view = getActivity().getCurrentFocus();
        if (view != null && view instanceof EditText) {
            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
