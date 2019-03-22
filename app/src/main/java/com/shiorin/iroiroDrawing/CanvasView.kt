package com.shiorin.iroiroDrawing

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.shiorin.iroiroDrawing.MainActivity

class CanvasView @JvmOverloads constructor(
    context: Context?, attrs:AttributeSet? = null, defStyleSttr:Int = 0) : View(context,attrs,defStyleSttr) {

    var pathList = mutableListOf<Path>()
    var paint: Paint
    private var drawingPath : Path = Path()


    init {
        paint = Paint().also {
            it.color = Color.RED
            it.style = Paint.Style.STROKE
            it.strokeWidth = 50F
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        pathList.forEach {
               // paint.setARGB(255,)
                canvas?.drawPath(it,paint)
            }
            Log.e("path","$pathList")

    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when(it.action){
                MotionEvent.ACTION_DOWN ->{
                    drawingPath.moveTo(it.x,it.y)
                    pathList.add(drawingPath)
                }
                MotionEvent.ACTION_MOVE ->{
                    drawingPath.lineTo(it.x,it.y)
                    invalidate()
                }
                MotionEvent.ACTION_UP ->{
                    drawingPath.lineTo(it.x,it.y)
                    invalidate()
                }
                else ->{

                }
            }
            return true
        }?: return true
    }

    fun allDelete() {
        Log.e("delete","delete")
        invalidate()
        drawingPath.reset()

    }

}