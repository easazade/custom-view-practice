package ir.easazade.alireza.customview

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_preview2.*

class PreviewActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preview2)
        val bitmap = BitmapFactory.decodeResource(resources, R.drawable.image15)
        bitmapImagePreview.setBitmap(bitmap)


    }
}
