package ir.easazade.alireza.customview.mycustomviews

import android.content.Context
import android.graphics.Canvas
import android.util.AttributeSet
import android.view.View
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx

class MySimpleView : View {

    constructor(context:Context): super(context)
    constructor(context: Context,attributeSet: AttributeSet):super(context,attributeSet)
    constructor(context: Context, attributeSet: AttributeSet, defStyleAttr:Int):super(context,attributeSet,defStyleAttr)

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        if (canvas == null) return
//        canvas.drawLine(dpToPx())
    }


}