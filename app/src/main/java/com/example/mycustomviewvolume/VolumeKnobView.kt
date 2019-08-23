package com.example.mycustomviewvolume

import android.content.Context
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.R
import android.graphics.*
import androidx.core.content.ContextCompat
import android.R.attr.bottom
import android.R.attr.right
import android.R.attr.top
import android.R.attr.left
import android.graphics.drawable.Drawable
import android.graphics.BitmapFactory
import android.graphics.Bitmap






class VolumeKnobView(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    //val b = BitmapFactory.decodeResource(resources, R.drawable.knob)

    var knobRotation:Float=0f
    private val rect = Rect()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val paint2 = Paint(Paint.ANTI_ALIAS_FLAG)

    private var startPoint: Float = 0f
    private var distance: Float = 0f


    init {

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        when(event?.action) {
            MotionEvent.ACTION_DOWN -> {
                startPoint = event.x
            }
            MotionEvent.ACTION_MOVE -> {
                distance= startPoint + event.x
                knobRotation=distance
                println(distance)

                invalidate()
            }
            MotionEvent.ACTION_UP-> {

            }

        }

        return true
    }

    override fun onDraw(canvas: Canvas?) {

        rect.left = 150
        rect.right = 200
        rect.top = 950
        rect.bottom = 1000
        canvas?.rotate(knobRotation,canvas?.width/2.toFloat(),canvas?.height/2.toFloat())

        paint.color = Color.BLACK
        paint2.color=Color.RED

        canvas?.drawCircle(width/2.0f, height/2f, 500f, paint)
        canvas?.drawRect(rect, paint2)




        super.onDraw(canvas)
    }

}