package ir.easazade.alireza.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx
import ir.easazade.alireza.customview.CustomViewUtils.Companion.spToPx

class Sample1CustomView : View {

    var textPaddingLeft: Float = 0.toFloat()

    var drawingText = "عجب روز خوبیه امروز آره خوبه"
    var drawingTextBounds = Rect()
    var floatHolder = 0
    lateinit var textPaint: Paint
    lateinit var linePaint: Paint


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )


    private fun init(context: Context) {
        textPaddingLeft = dpToPx(2)

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.BLACK
        textPaint.textSize = spToPx(13)
        textPaint.textAlign = Paint.Align.RIGHT
        textPaint.typeface = Typeface.createFromAsset(context.assets, "irsans.ttf")


        linePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        linePaint.color = Color.RED
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawRect(0f, 0f, width.toFloat(), height.toFloat(), linePaint)

        println("width is $width")
        println("${drawingTextBounds.bottom} ${drawingTextBounds.top} ${drawingTextBounds.left} ${drawingTextBounds.right}")
        textPaint.getTextBounds(
            drawingText,
            0,
            drawingText.length,
            drawingTextBounds
        ) //TODO allocates bounds to the rect 4th arguments
        println("${drawingTextBounds.bottom} ${drawingTextBounds.top} ${drawingTextBounds.left} ${drawingTextBounds.right}")
        //Draw Text
        canvas.drawText(
            drawingText,
            width - textPaddingLeft,
            (height / 2 + drawingTextBounds.height() / 2).toFloat(),
            textPaint
        )
    }
}