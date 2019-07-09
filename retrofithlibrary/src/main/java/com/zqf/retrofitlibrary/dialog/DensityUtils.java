package com.zqf.retrofitlibrary.dialog;

import android.content.res.Resources;

/**
 * <像素转换>
 */
class DensityUtils {

    private static final String TAG = "DensityUtils";

    DensityUtils() {
        throw new IllegalStateException("DensityUtils class");
    }


    /**
     * <将dip或dp值转换为px值，保证尺寸大小不变>
     *
     * @param dipValue DisplayMetrics类中属性density
     * @return
     */
    public static int dip2px(float dipValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

}
