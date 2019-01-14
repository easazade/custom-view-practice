package ir.easazade.alireza.customview

import android.content.Context

fun sp2Px(ctx: Context, sp: Float): Float {
    return sp * ctx.resources.displayMetrics.scaledDensity
}

fun px2Dp(context: Context, px: Float): Float {
    return px / context.resources.displayMetrics.density
}

fun dp2Px(context: Context, dp: Float): Float {
    return dp * context.resources.displayMetrics.density
}