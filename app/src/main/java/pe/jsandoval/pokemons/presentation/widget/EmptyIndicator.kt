package pe.jsandoval.pokemons.presentation.widget

import a386systems.pe.admin.util.string
import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import pe.jsandoval.pokemons.R

class EmptyIndicator constructor(context: Context, attributeSet: AttributeSet) : LinearLayout(context, attributeSet) {

    var ivImage: ImageView? = null
    var tvTitle: TextView? = null
    var tvSubtitle: TextView? = null

    init {
        LayoutInflater.from(context).inflate(R.layout.empty_indicator, this, true)

        ivImage = findViewById(R.id.ivImage)
        tvTitle = findViewById(R.id.tvTitle)
        tvSubtitle = findViewById(R.id.tvSubtitle)

        setImage(R.drawable.pokeball)
        setTitle(R.string.oopss)
        setSubTitle(R.string.no_se_encontraron_pokemons)
    }

    fun setImage(image: Drawable?) {
        ivImage?.setImageDrawable(image)
        ivImage?.visibility = if (image != null) View.VISIBLE else View.GONE
    }

    fun setImage(@DrawableRes image: Int) {
        ivImage?.setImageDrawable(context.getDrawable(image))
        ivImage?.visibility = if (image != 0) View.VISIBLE else View.GONE
    }

    fun setTitle(title: String?) {
        tvTitle?.text = title
        tvTitle?.visibility = if (title != null) View.VISIBLE else View.GONE
    }

    fun setTitle(@StringRes stringResId: Int) {
        tvTitle?.text = context.string(stringResId)
        tvTitle?.visibility = if (stringResId != 0) View.VISIBLE else View.GONE
    }

    fun setColorTitle(@ColorInt colorInt: Int) {
        tvTitle?.setTextColor(colorInt)
    }

    fun setSubTitle(subtitle: String?) {
        tvSubtitle?.text = subtitle
        tvSubtitle?.visibility = if (subtitle != null) View.VISIBLE else View.GONE
    }

    fun setSubTitle(@StringRes stringResId: Int) {
        tvSubtitle?.text = context.string(stringResId)
        tvSubtitle?.visibility = if (stringResId != 0) View.VISIBLE else View.GONE
    }

    fun setColorSubtitle(@ColorInt colorInt: Int) {
        tvSubtitle?.setTextColor(colorInt)
    }
}