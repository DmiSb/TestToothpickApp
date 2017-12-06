package test.dmisb.toothpick.utils;

import android.os.Build;
import android.text.Html;
import android.text.Spanned;

public class FormatUtil {

    @SuppressWarnings("deprecation")
    public static Spanned htmlFormat(String text) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY);
        } else {
            return Html.fromHtml(text);
        }
    }
}
