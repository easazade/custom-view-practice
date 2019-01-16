package ir.easazade.alireza.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class LineView : View {

    private var mBlueFill: Paint? = null
    private var mRedFilled: Paint? = null
    private var mGreenStroked: Paint? = null
    private var mYellowStroked: Paint? = null
    private var mBlackStroked: Paint? = null
    private var mBlackText: Paint? = null
    val tempRectF = RectF(
        dp2Px(context, 20f),
        dp2Px(context, 20f),
        dp2Px(context, 90f),
        dp2Px(context, 90f)
    )
    val str = "text message !"

    constructor(context: Context) : super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs)

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
        mYellowStroked?.strokeWidth = dp2Px(context, 5f)
        //black
        mBlackStroked = Paint(Paint.ANTI_ALIAS_FLAG)
        mBlackStroked?.color = Color.BLACK
        mBlackStroked?.style = Paint.Style.STROKE
        mBlackStroked?.textSize = sp2Px(context, 14f)
        mBlackStroked?.strokeWidth = dp2Px(context, 2f)
        //black
        mBlackText = Paint(Paint.ANTI_ALIAS_FLAG)
        mBlackText?.color = Color.BLACK
        mBlackText?.style = Paint.Style.FILL
        mBlackText?.textSize = sp2Px(context, 14f)
        mBlackText?.strokeWidth = dp2Px(context, 2f)
    }


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null)
            return
        canvas.drawLine(
            dp2Px(context, 1f),
            dp2Px(context, 1f),
            dp2Px(context, 99f),
            dp2Px(context, 99f),
            mBlueFill
        )
        canvas.drawPoints(floatArrayOf(50f, 6f), mBlueFill)
        canvas.drawCircle(
            dp2Px(context, 50f),
            dp2Px(context, 50f),
            dp2Px(context, 40f),
            mRedFilled
        )
        canvas.drawCircle(
            dp2Px(context, 80f),
            dp2Px(context, 30f),
            dp2Px(context, 22f),
            mGreenStroked
        )
        canvas.drawRect(tempRectF, mGreenStroked)
        canvas.drawArc(tempRectF, 0f, 90f, true, mYellowStroked)
        canvas.drawArc(tempRectF, 90f, 150f, false, mBlueFill)
        mGreenStroked?.strokeWidth = dp2Px(context, 10f)
        canvas.drawArc(tempRectF, 180f, 200f, false, mGreenStroked)
        canvas.drawText(
            str,
            dp2Px(context, 10f),
            dp2Px(context, 40f),
            mBlackStroked
        )
    }
}