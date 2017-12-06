package test.dmisb.toothpick.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    private final SharedPreferences sp;

    public Prefs(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);
    }

    //region ================= Private methods =================

    private void setStringValue(String keyName, String keyValue) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(keyName, keyValue);
        editor.apply();
    }

    private void setIntValue(String keyName, int keyValue) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(keyName, keyValue);
        editor.apply();
    }

    private void setBoolValue(String keyName, boolean keyValue) {
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(keyName, keyValue);
        editor.apply();
    }

    //endregion
}
