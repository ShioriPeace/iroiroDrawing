package com.shiorin.iroiroDrawing

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View

class CanvasView(context: Context?, attrs:AttributeSet?) : View(context,attrs) {
   private val pathList = ArrayList<Path>()
    private var paint: Paint = Paint()
    private var drawingPath = Path()


    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.color = Color.RED
        paint.strokeWidth = 10F
        paint.style = Paint.Style.STROKE
        //canvas!!.drawRect(300f,300f,600f,600f,paint)

        for (path in pathList) {
            canvas!!.drawPath(path, paint)
            Log.e("Path","$path")
        }
    }


    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {

            when(event!!.action){
                MotionEvent.ACTION_DOWN -> {
                   Log.e("Touch","drawingPath$drawingPath")
                    drawingPath = Path()
                    drawingPath.moveTo(event.x,event.y)
                    pathList.add(drawingPath)
                }
                MotionEvent.ACTION_MOVE -> {
                    drawingPath.moveTo(event.x,event.y)
                }
                MotionEvent.ACTION_UP ->{
                }
            }
        invalidate()


        return true
    }

    fun allDelete(){
        pathList.clear()
    }

}