package ir.easazade.alireza.customview.customviews

import android.animation.ValueAnimator
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import android.view.animation.OvershootInterpolator
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx
import ir.easazade.alireza.customview.R

class MyCircleView : View {

    lateinit var mPaint: Paint
    lateinit var mPaint2: Paint
    var radius: Float = 0.toFloat()

    var degree = 0f
    var radius2: Float = 0.toFloat()
    var receivedStrokeSize = -1f
    var strokeSize: Float
        get() = mPaint.strokeWidth
        set(strokeSize) {
            mPaint.strokeWidth = strokeSize
            requestLayout()
        }

    private val desireHeight: Int
        get() {
            val vPadding = paddingTop + paddingBottom
            return (radius * 2 + Math.max(
                mPaint.strokeWidth,
                radius2 * 2
            ) + vPadding.toFloat()).toInt()
        }

    private val desireWidth: Int
        get() {
            val hPadding = paddingLeft + paddingRight
            return (radius * 2 + Math.max(
                mPaint.strokeWidth,
                radius2 * 2
            ) + hPadding.toFloat()).toInt()
        }

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {

        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.MyCircleView
        )
        //16dp is default value
        receivedStrokeSize = a.getDimension(
            R.styleable.MyCircleView_mcv_stroke_size,
            dpToPx(16)
        )

        a.recycle()

        init()
    }
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ){
        val a = context.obtainStyledAttributes(
            attrs,
            R.styleable.MyCircleView
        )
        //16dp is default value
        receivedStrokeSize = a.getDimension(
            R.styleable.MyCircleView_mcv_stroke_size,
            dpToPx(16)
        )

        a.recycle()

        init()
    }

    private fun init() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        if (receivedStrokeSize > 0)
            mPaint.strokeWidth = receivedStrokeSize
        else
            mPaint.strokeWidth = dpToPx(16)

        mPaint.color = Color.BLUE
        mPaint.style = Paint.Style.STROKE
        radius = dpToPx(80)


        mPaint2 = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint2.color = Color.MAGENTA
        mPaint2.style = Paint.Style.FILL
        radius2 = dpToPx(22)


        val animator = ValueAnimator.ofFloat(0f, 360f)
        animator.interpolator = OvershootInterpolator()
        animator.duration = 2000
        animator.repeatCount = ValueAnimator.INFINITE
        animator.addUpdateListener { animation ->
            degree = animation.animatedValue as Float
            invalidate()
        }
        animator.start()


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val f = strokeSize
        //Width
        val widthMeasureMode = View.MeasureSpec.getMode(widthMeasureSpec)
        val widthMeasureSize = View.MeasureSpec.getSize(widthMeasureSpec)
        var width = 0
        when (widthMeasureMode) {
            View.MeasureSpec.UNSPECIFIED -> width = desireWidth
            View.MeasureSpec.EXACTLY -> width = widthMeasureSize
            View.MeasureSpec.AT_MOST -> width = Math.min(widthMeasureSize, desireWidth)
        }
        //Height
        val heightMeasureMode = View.MeasureSpec.getMode(heightMeasureSpec)
        val heightMeasureSize = View.MeasureSpec.getSize(heightMeasureSpec)
        var height = 0
        when (heightMeasureMode) {
            View.MeasureSpec.UNSPECIFIED -> height = desireHeight
            View.MeasureSpec.EXACTLY -> height = heightMeasureSize
            View.MeasureSpec.AT_MOST -> height = Math.min(heightMeasureSize, desireHeight)
        }
        //Radius
        if (widthMeasureMode == View.MeasureSpec.EXACTLY && heightMeasureMode == View.MeasureSpec.EXACTLY) {
            val size = Math.min(widthMeasureSize, heightMeasureSize)
            radius = (size - mPaint.strokeWidth) / 2
        } else {
            //Default Value
            radius = dpToPx(80)
        }
        //Tell to system measured size in px
        setMeasuredDimension(width, height)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        //Draw Main Circle
        val centerX = width / 2
        val centerY = height / 2
        canvas.drawCircle(centerX.toFloat(), centerY.toFloat(), radius, mPaint)


        //Draw the second Circle
        var drawX = Math.cos(
            Math.toRadians(degree.toDouble())
        ).toFloat()
        drawX *= radius
        drawX += centerX.toFloat()
        var drawY = Math.sin(
            Math.toRadians(degree.toDouble())
        ).toFloat()
        drawY *= radius
        drawY += centerY.toFloat()
        canvas.drawCircle(
            drawX, drawY,
            radius2, mPaint2
        )


    }

}