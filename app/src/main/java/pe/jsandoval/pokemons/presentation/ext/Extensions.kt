package a386systems.pe.admin.util

import android.app.Activity
import android.content.Context
import android.content.res.ColorStateList
import android.graphics.drawable.Drawable
import android.view.inputmethod.InputMethodManager
import android.widget.ImageView
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.widget.ImageViewCompat
import androidx.fragment.app.Fragment

fun Activity.hideKeyboard() {
    val inputManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    currentFocus?.apply {
        inputManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun Fragment.hideKeyboard() {
    val inputManager =
        activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
    activity?.currentFocus?.apply {
        inputManager.hideSoftInputFromWindow(windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
    }
}

fun Context.color(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

fun Context.drawable(@DrawableRes drawableRes: Int): Drawable? {
    return AppCompatResources.getDrawable(this, drawableRes)
}

fun Context.string(@StringRes stringRes: Int): String? {
    return getString(stringRes)
}

fun Context.string(@StringRes stringRes: Int, param1: String): String? {
    return getString(stringRes, param1)
}

fun Context.string(@StringRes stringRes: Int, param1: String, param2: String): String? {
    return getString(stringRes, param1, param2)
}

fun Context.drawable(@DrawableRes drawableRes: Int, @ColorRes tintRes: Int): Drawable? {
    val drawable = drawable(drawableRes)?.mutate()
    drawable?.tint(color(tintRes))
    return drawable
}

fun Drawable?.tint(@ColorInt color: Int): Drawable? {
    if (this == null) return null
    DrawableCompat.setTint(this, color)
    return this
}

fun ImageView.tint(@ColorInt color: Int) {
    ImageViewCompat.setImageTintList(this, ColorStateList.valueOf(color))
}