package ir.easazade.alireza.customview.customviews

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import ir.easazade.alireza.customview.CustomViewUtils.Companion.dpToPx
import ir.easazade.alireza.customview.CustomViewUtils.Companion.spToPx
import ir.easazade.alireza.customview.R

class MyShowingCanvasView : View {

    lateinit var axisPaint: Paint
    var axisXYSize: Float = 0.toFloat()

    lateinit var mPaint: Paint

    lateinit var tempRect: RectF
    lateinit var tempRect2: Rect
    lateinit var srcTmp: Rect
    lateinit var dstTmp: RectF

    lateinit var santaBmp: Bitmap
    lateinit var patternBg: Bitmap
    lateinit var patternText: Bitmap

    lateinit var mPath: Path

    var isTouchDown = false
    var touchX: Int = 0
    var touchY: Int = 0

    lateinit var touchPaint: Paint

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
        axisPaint = Paint()
        axisPaint.strokeWidth = dpToPx(2)
        axisPaint.color = Color.LTGRAY
        axisPaint.style = Paint.Style.STROKE


        axisXYSize = dpToPx(30)


        mPaint = Paint()

        tempRect = RectF()
        tempRect2 = Rect()
        srcTmp = Rect()
        dstTmp = RectF()

        santaBmp = BitmapFactory.decodeResource(resources, R.drawable.santa)

        mPath = Path()

        patternBg = BitmapFactory.decodeResource(resources, R.drawable.pattern4)
        patternText = BitmapFactory.decodeResource(resources, R.drawable.pattern2)


        touchPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        touchPaint.style = Paint.Style.FILL_AND_STROKE
        touchPaint.color = Color.BLUE
        touchPaint.strokeWidth = dp2px(1)
        touchPaint.textSize = sp2px(18)
        touchPaint.typeface = Typeface.create(touchPaint.typeface, Typeface.BOLD)
    }


    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (width > 0 && height > 0) {
            for (x in 1..10) {
                canvas.drawLine(x * axisXYSize, 0f, x * axisXYSize, height.toFloat(), axisPaint)
            }

            for (y in 1..8) {
                canvas.drawLine(0f, y * axisXYSize, width.toFloat(), y * axisXYSize, axisPaint)
            }
        }


        if (isTouchDown) {
            canvas.drawLine(
                0f, touchY.toFloat(),
                width.toFloat(), touchY.toFloat(), touchPaint
            )
            canvas.drawLine(
                touchX.toFloat(), 0f,
                touchX.toFloat(), height.toFloat(), touchPaint
            )
            canvas.drawText(
                "x : " + touchX
                        + " , y : " + touchY + " (Touch Down)",
                dp2px(8), height - dp2px(8),
                touchPaint
            )
        }


        /*
               //Green Line
               mPaint.setStrokeWidth(dp2px(15));
               mPaint.setColor(Color.GREEN);
               canvas.drawLine(dp2px(30),dp2px(30),
                       dp2px(270),dp2px(150),mPaint);


               //Red Line
               mPaint.setStrokeWidth(dp2px(15));
               mPaint.setColor(Color.RED);
               canvas.drawLine(dp2px(30),dp2px(150),
                       dp2px(270),dp2px(30),mPaint);


               //Magenta Line
               mPaint.setStrokeWidth(dp2px(10));
               mPaint.setColor(Color.MAGENTA);
               canvas.drawLine(dp2px(0),dp2px(120),
                       dp2px(270),dp2px(120),mPaint);*/


        /*//Black circle
        mPaint.setStrokeWidth(dp2px(16));
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawCircle(dp2px(150),dp2px(120),
                            dp2px(90),mPaint);


        //Magenta Circle
        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(dp2px(150),dp2px(120),
                dp2px(60),mPaint);


        //Green Circle
        mPaint.setStrokeWidth(dp2px(16));
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setAntiAlias(true);
        canvas.drawCircle(dp2px(270),dp2px(210),
                dp2px(30),mPaint);*/


        /*mPaint.setAntiAlias(true);


        tempRect.set(dp2px(30),dp2px(30),
                dp2px(180),dp2px(180));

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(4));
        canvas.drawRect(tempRect,mPaint);


        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(16));
        canvas.drawArc(tempRect,
                        0f,90F,
                        false,mPaint);


        mPaint.setColor(Color.CYAN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(12));
        canvas.drawArc(tempRect,
                180f,135F,
                true,mPaint);*/


        /*Rect tempRect = new Rect();
         mPaint.setAntiAlias(true);



         String text = "Left Top";
         mPaint.setColor(Color.RED);
         mPaint.setStyle(Paint.Style.FILL);
         mPaint.setTextSize(sp2px(30));
         canvas.drawText(text,
                 dp2px(30),dp2px(60),mPaint);



         mPaint.setStrokeWidth(dp2px(1));
         mPaint.setStyle(Paint.Style.STROKE);
         mPaint.setColor(Color.BLUE);
         mPaint.getTextBounds(text, 0,text.length(), tempRect);
         canvas.drawRect(dp2px(30),dp2px(60)-tempRect.height(),
                 dp2px(30) + tempRect.width(),dp2px(60),mPaint);*/


        /*srcTmp.set(0,0,
                santaBmp.getWidth(),
                santaBmp.getHeight());
        dstTmp.set(dp2px(30),dp2px(30),
                dp2px(210),dp2px(210));
        canvas.drawBitmap(santaBmp,
                srcTmp,dstTmp,mPaint);*/


        /*mPaint.setAntiAlias(true);


        float currentX = getWidth()/2;
        float currentY = getHeight()/2;
        mPath.moveTo(currentX,currentY);

        currentX += dp2px(30);
        mPath.lineTo(currentX,currentY);

        currentY -= dp2px(30);
        mPath.lineTo(currentX,currentY);

        currentX -= dp2px(60);
        mPath.lineTo(currentX,currentY);

        currentY += dp2px(60);
        mPath.lineTo(currentX,currentY);

        currentX += dp2px(90);
        mPath.lineTo(currentX,currentY);

        currentX += dp2px(30);
        mPath.addCircle(currentX,currentY,
                dp2px(30), Path.Direction.CW);

        mPaint.setColor(Color.MAGENTA);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(dp2px(3));

        //Corner Path Effect
        cornerPathEffect(mPaint);

        //Dash Path Effect
        dashPathEffect(mPaint);

        //Discrete Path Effect
        discretePathEffect(mPaint);

        //Compose Path Effect
        composePathEffect();

        canvas.drawPath(mPath,mPaint);*/


        //        drawTextShader(canvas);

        //        drawBitmapShader(canvas);


    }

    private fun cornerPathEffect(mPaint: Paint) {

        val radius = dp2px(12)
        val cornerEffect = CornerPathEffect(radius)
        mPaint.pathEffect = cornerEffect

    }

    private fun dashPathEffect(mPaint: Paint) {

        val intervals = floatArrayOf(dp2px(20), dp2px(10))
        val dashEffect = DashPathEffect(
            intervals, 0f
        )
        mPaint.pathEffect = dashEffect

    }

    private fun discretePathEffect(mPaint: Paint) {

        val segmentLength = dp2px(2)
        val deviation = dp2px(4)

        val discreteEffect = DiscretePathEffect(
            segmentLength, deviation
        )
        mPaint.pathEffect = discreteEffect

    }

    private fun composePathEffect() {

        val intervals = floatArrayOf(dp2px(20), dp2px(10))
        val dashEffect = DashPathEffect(
            intervals, 0f
        )


        val radius = dp2px(12)
        val cornerPathEffect = CornerPathEffect(radius)


        val composeEffect = ComposePathEffect(
            dashEffect,
            cornerPathEffect
        )
        mPaint.pathEffect = composeEffect
    }

    private fun drawTextShader(canvas: Canvas) {
        mPaint.isAntiAlias = true
        mPaint.textSize = sp2px(28)
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = dp2px(2)


        val text = "Linear Gradient Shader"
        mPaint.getTextBounds(
            text,
            0, text.length,
            tempRect2
        )

        val colors = intArrayOf(Color.RED, Color.GREEN, Color.BLUE, Color.MAGENTA)
        val shader = LinearGradient(
            0f, 0f,
            tempRect2.width().toFloat(), 0f,
            colors, null,
            Shader.TileMode.MIRROR
        )

        mPaint.shader = shader

        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()
        canvas.drawText(
            text,
            centerX - tempRect2.width() / 2,
            centerY + tempRect2.height() / 2,
            mPaint
        )
    }

    private fun drawBitmapShader(canvas: Canvas) {
        mPaint.isAntiAlias = true
        mPaint.textSize = sp2px(42)
        mPaint.style = Paint.Style.FILL_AND_STROKE
        mPaint.strokeWidth = dp2px(2)


        val bgShader = BitmapShader(
            patternBg,
            Shader.TileMode.REPEAT,
            Shader.TileMode.REPEAT
        )
        tempRect.set(0f, 0f, width.toFloat(), height.toFloat())
        mPaint.shader = bgShader
        canvas.drawRect(tempRect, mPaint)

        val text = "Bitmap Shader"
        mPaint.getTextBounds(
            text,
            0, text.length,
            tempRect2
        )

        val textShader = BitmapShader(
            patternText,
            Shader.TileMode.REPEAT,
            Shader.TileMode.REPEAT
        )

        val centerX = (width / 2).toFloat()
        val centerY = (height / 2).toFloat()
        mPaint.shader = textShader
        canvas.drawText(
            text,
            centerX - tempRect2.width() / 2,
            centerY + tempRect2.height() / 2,
            mPaint
        )


    }


    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(dp2px(300).toInt(), dp2px(240).toInt())
    }

    private fun dp2px(dp: Int): Float {
        return dpToPx(dp)
    }

    private fun sp2px(sp: Int): Float {
        return spToPx(sp)
    }


    override fun onTouchEvent(event: MotionEvent): Boolean {
        super.onTouchEvent(event)

        touchX = event.x.toInt()
        touchY = event.y.toInt()

        when (event.action) {
            MotionEvent.ACTION_DOWN -> isTouchDown = true

            MotionEvent.ACTION_MOVE -> {
            }

            MotionEvent.ACTION_UP -> isTouchDown = false
        }

        invalidate()
        return true
    }


}