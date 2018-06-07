package io.mattcarroll.hover;

import android.content.res.Resources;

public final class Utils {
    private Utils() {

    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }
}
