package ir.easazade.alireza.customview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.annotation.Nullable

class LineView : View {

    private var mPaint: Paint? = null

    constructor(context: Context) : super(context)
    constructor(context: Context, @Nullable attrs: AttributeSet) : super(context, attrs)

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint?.color = Color.BLACK
        mPaint?.strokeWidth = dp2Px(context, 5f)
    }


    override fun onDraw(c: Canvas?) {
        super.onDraw(c)
        c?.drawLine(10f, 10f, 200f, 200f, mPaint!!)
    }
}