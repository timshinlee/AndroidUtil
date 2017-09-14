package com.timshinlee.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.TypedValue;

import static android.util.TypedValue.COMPLEX_UNIT_DIP;
import static android.util.TypedValue.COMPLEX_UNIT_SP;

@SuppressWarnings("unused")
public class DimensionUtils {
    private DimensionUtils() {
    }

    /**
     * get the baseline of text according to a given center line.
     * <br>
     * formula:
     * <code>
     * <pre>
     *      float yBottom = baseline + fontMetrics.bottom;
     *      float yTop = baseline + fontMetrics.top;
     *      float center = (yBottom + yTop) / 2
     *                   = (baseline + fontMetrics.bottom + baseline + fontMetrics.top) / 2
     *                   = baseline + (fontMetrics.bottom + fontMetrics.top) / 2;
     *      float baseline = center - (fontMetrics.bottom + fontMetrics.top) / 2;
     *  </pre>
     * </code>
     *
     * @param center      y coordinate of center line
     * @param fontMetrics obtained by paint.getFontMetrics();
     * @return the y coordinate of text's baseline
     */
    public static float getTextBaseline(int center, Paint.FontMetrics fontMetrics) {
        return center - (fontMetrics.bottom + fontMetrics.top) / 2;
    }

    public static float getTextBaselineGivenBottom(int bottom, Paint.FontMetrics fontMetrics) {
        return bottom - fontMetrics.bottom;
    }

    /**
     * get bounds of text.
     */
    public static Rect getTextBounds(Paint paint, String text) {
        final Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        return rect;
    }

    /**
     * 获取状态栏高度
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 底部虚拟按键栏的高度
     */
    private int getNavigationBarHeight(Context context) {
        final Resources resources = context.getResources();
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            return resources.getDimensionPixelSize(resourceId);
        }
        return 0;
    }

    /**
     * 获取屏幕高度，以px为单位
     */
    public static int getScreenHeight() {
        return Resources.getSystem().getDisplayMetrics().heightPixels;
//        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics metrics = new DisplayMetrics();
//        manager.getDefaultDisplay().getMetrics(metrics);
//        return metrics.heightPixels;
    }

    /**
     * 获取屏幕宽度，以px为单位
     */
    public static int getScreenWidth() {
        return Resources.getSystem().getDisplayMetrics().widthPixels;
//        WindowManager manager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
//        DisplayMetrics metrics = new DisplayMetrics();
//        manager.getDefaultDisplay().getMetrics(metrics);
//        return metrics.widthPixels;
    }

    /**
     * 获取屏幕对应的标准dpi，如320、480等
     */
    public static int getDensityDpi() {
        return Resources.getSystem().getDisplayMetrics().densityDpi;
    }

    /**
     * 获取屏幕对应的标准dpi与160dpi的比率，如2.0、3.0等
     */
    public static float getDensity() {
        return Resources.getSystem().getDisplayMetrics().density;
    }

    /**
     * 获取字体放大的比例
     */
    public static float getScaledDensity() {
        return Resources.getSystem().getDisplayMetrics().scaledDensity;
    }

    /**
     * 获取水平方向的每英寸像素数
     */
    public static float getXDpi() {
        return Resources.getSystem().getDisplayMetrics().xdpi;
    }

    /**
     * 获取垂直方向的每英寸像素数
     */
    public static float getYDpi() {
        return Resources.getSystem().getDisplayMetrics().ydpi;
    }

    /**
     * dip转px
     */
    public static int dip2px(float dipValue) {
        return (int) TypedValue.applyDimension(COMPLEX_UNIT_DIP, dipValue, Resources.getSystem().getDisplayMetrics());
        // 另一种测量方式
//        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
//        float px = dp * (metrics.densityDpi / 160f);
//        return (int) px;
    }

    /**
     * sp转px
     */
    public static int sp2px(float spValue) {
        return (int) TypedValue.applyDimension(COMPLEX_UNIT_SP, spValue, Resources.getSystem().getDisplayMetrics());
    }
}
