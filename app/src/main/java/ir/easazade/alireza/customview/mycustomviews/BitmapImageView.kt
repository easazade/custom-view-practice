package ir.easazade.alireza.customview.mycustomviews

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.util.AttributeSet
import android.view.View

class BitmapImageView : View {

    private var bitmap: Bitmap? = null
    private var bitmapSrcBounds = Rect()
    private var bitmapDstBounds = Rect()
    private lateinit var mPaint: Paint

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet) : super(context, attributeSet) {
        init()
    }

    constructor(context: Context, attributeSet: AttributeSet, defStyleRes: Int) : super(
        context,
        attributeSet,
        defStyleRes
    ) {
        init()
    }

    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    }

    private fun getDesiredWidth(): Int {
        val horizontalPadding = paddingEnd + paddingStart
        return if (bitmap != null) bitmap!!.width + horizontalPadding else horizontalPadding
    }

    private fun getDesiredHeight(): Int {
        val verticalPadding = paddingBottom + paddingTop
        return if (bitmap != null) bitmap!!.height + verticalPadding else verticalPadding
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val widthMeasureMode = MeasureSpec.getMode(widthMeasureSpec)
        val widthMeasureSize = MeasureSpec.getSize(widthMeasureSpec)
        val heightMeasureMode = MeasureSpec.getMode(heightMeasureSpec)
        val heightMeasureSize = MeasureSpec.getSize(heightMeasureSpec)

        var width = 0
        when (widthMeasureMode) {
            MeasureSpec.UNSPECIFIED -> {
                width = getDesiredWidth()
            }
            MeasureSpec.EXACTLY -> {
                width = widthMeasureSize
            }
            MeasureSpec.AT_MOST -> {
                width = Math.min(widthMeasureSize, getDesiredWidth())
            }
        }

        var height = 0
        when (heightMeasureMode) {
            MeasureSpec.UNSPECIFIED -> {
                height = getDesiredHeight()
            }
            MeasureSpec.EXACTLY -> {
                height = heightMeasureSize
            }
            MeasureSpec.AT_MOST -> {
                height = Math.min(heightMeasureSize, getDesiredHeight())
            }
        }

        if (widthMeasureMode == MeasureSpec.EXACTLY
            && heightMeasureMode == MeasureSpec.EXACTLY
        ) {
            //sometimes we need to measure something based on exact height or width that is given to us
            //like radius of circle that we are going to draw
//            val size = Math.min(widthMeasureSize,getDesiredWidth())
//            radius = (size-mPaint.strokeWidth) /2
        } else {
            //in case of wrap content or match parent
//            radius = dpToPx(80)
        }

        setMeasuredDimension(width, height)
    }

    fun setBitmap(bitmap: Bitmap) {
        this.bitmap = bitmap
        requestLayout()
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null || bitmap == null) return
//        canvas.drawBitmap(bitmap, 0f, 0f, mPaint)
        bitmapSrcBounds = Rect(0, 0, bitmap!!.width, bitmap!!.height)
        println("$width $height")
        bitmapDstBounds = Rect(0, 0, width, height)
        canvas.drawBitmap(bitmap, bitmapSrcBounds, bitmapDstBounds, mPaint)

    }

}