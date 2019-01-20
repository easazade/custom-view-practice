package ir.easazade.alireza.customview.mycustomviews

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx
import ir.easazade.alireza.customview.CustomViewUtils.Companion.spToPx

class PracticeView : View {

    private var mBlueFill: Paint? = null
    private var mRedFilled: Paint? = null
    private var mGreenStroked: Paint? = null
    private var mYellowStroked: Paint? = null
    private var mBlackStroked: Paint? = null
    private var mBlackText: Paint? = null
    val tempRectF = RectF(
        dpToPx(20),
        dpToPx(20),
        dpToPx(90),
        dpToPx(90)
    )
    val str = "text message !"

    constructor(context: Context) : super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    init {
        //black
        mBlueFill = Paint(Paint.ANTI_ALIAS_FLAG)
        mBlueFill?.color = Color.BLUE
        //style is fill by default
        mBlueFill?.strokeWidth = 3f //big point
        //red
        mRedFilled = Paint(Paint.ANTI_ALIAS_FLAG)
        mRedFilled?.color = Color.RED
        mRedFilled?.isAntiAlias = true
        mRedFilled?.strokeWidth = 3f
        //green
        mGreenStroked = Paint(Paint.ANTI_ALIAS_FLAG)
        mGreenStroked?.color = Color.GREEN
        mGreenStroked?.style = Paint.Style.STROKE
        mGreenStroked?.strokeWidth = 3f
        //yellow
        mYellowStroked = Paint(Paint.ANTI_ALIAS_FLAG)
        mYellowStroked?.color = Color.YELLOW
        mYellowStroked?.style = Paint.Style.STROKE
        mYellowStroked?.strokeWidth = dpToPx(5)
        //black
        mBlackStroked = Paint(Paint.ANTI_ALIAS_FLAG)
        mBlackStroked?.color = Color.BLACK
        mBlackStroked?.style = Paint.Style.STROKE
        mBlackStroked?.textSize = spToPx(14)
        mBlackStroked?.strokeWidth = dpToPx(2)
        //blac
        mBlackText = Paint(Paint.ANTI_ALIAS_FLAG)
        mBlackText?.color = Color.BLACK
        mBlackText?.style = Paint.Style.FILL
        mBlackText?.textSize = spToPx(14)
        mBlackText?.strokeWidth = dpToPx(2)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null)
            return
        canvas.drawLine(
            dpToPx(1),
            dpToPx(1),
            dpToPx(99),
            dpToPx(99),
            mBlueFill
        )
        canvas.drawPoints(floatArrayOf(50f, 6f), mBlueFill)
        canvas.drawCircle(
            dpToPx(50),
            dpToPx(50),
            dpToPx(40),
            mRedFilled
        )
        canvas.drawCircle(
            dpToPx(80),
            dpToPx(30),
            dpToPx(22),
            mGreenStroked
        )
        canvas.drawRect(tempRectF, mGreenStroked)
        canvas.drawArc(tempRectF, 0f, 90f, true, mYellowStroked)
        canvas.drawArc(tempRectF, 90f, 150f, false, mBlueFill)
        mGreenStroked?.strokeWidth = dpToPx(10)
        canvas.drawArc(tempRectF, 180f, 200f, false, mGreenStroked)
        canvas.drawText(
            str,
            dpToPx(10),
            dpToPx(40),
            mBlackStroked
        )
    }
}