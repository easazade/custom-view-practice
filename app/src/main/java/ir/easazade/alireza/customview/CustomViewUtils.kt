package ir.easazade.alireza.customview

class CustomViewUtils {

    companion object {

        private var app: App? = null

        fun init(app: App) {
            this.app = app
        }

        fun spToPx(sp: Int): Float {
            return sp * app!!.resources.displayMetrics.scaledDensity
        }

        fun pxToDp(px: Int): Float {
            return px / app!!.resources.displayMetrics.density
        }

        fun dpToPx(dp: Int): Float {
            return dp * app!!.resources.displayMetrics.density
        }
    }

}