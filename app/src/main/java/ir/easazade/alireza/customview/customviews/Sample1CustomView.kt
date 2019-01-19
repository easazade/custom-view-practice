package ir.easazade.alireza.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx
import ir.easazade.alireza.customview.CustomViewUtils.Companion.spToPx

class Sample1CustomView : View {

    var textPaddingLeftRight: Float = 0.toFloat()

    var drawingText = "Custom View"
    var drawingTextBounds = Rect()

    lateinit var textPaint: Paint
    lateinit var linePaint: Paint


    constructor(context: Context) : super(context) {
        init(context)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(context)
    }


    private fun init(context: Context) {
        textPaddingLeftRight = dpToPx(8)

        textPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint.color = Color.BLACK
        textPaint.textSize = spToPx(16)
        textPaint.typeface = Typeface.create(Typeface.DEFAULT, Typeface.BOLD)


        linePaint = Paint(Paint.ANTI_ALIAS_FLAG)
        linePaint.color = Color.BLACK
        linePaint.strokeWidth = dpToPx(2)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        textPaint.getTextBounds(drawingText, 0, drawingText.length, drawingTextBounds)


        val lineSize =
            (width.toFloat() - drawingTextBounds.width().toFloat() - 2 * textPaddingLeftRight) / 2

        //Draw Left Line
        canvas.drawLine(0f, (height / 2).toFloat(), lineSize, (height / 2).toFloat(), linePaint)
        //Draw Text
        canvas.drawText(
            drawingText,
            lineSize + textPaddingLeftRight,
            (height / 2 + drawingTextBounds.height() / 2).toFloat(),
            textPaint
        )
        //Draw Right Line
        canvas.drawLine(
            lineSize + drawingTextBounds.width().toFloat() + textPaddingLeftRight * 2,
            (height / 2).toFloat(),
            width.toFloat(),
            (height / 2).toFloat(),
            linePaint
        )
    }
}