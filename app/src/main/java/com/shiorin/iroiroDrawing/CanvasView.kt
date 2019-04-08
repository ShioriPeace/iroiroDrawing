package com.shiorin.iroiroDrawing

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.Log
import android.view.MotionEvent
import android.view.View
import com.shiorin.iroiroDrawing.MainActivity

class
CanvasView @JvmOverloads constructor(
    context: Context?, attrs:AttributeSet? = null, defStyleSttr:Int = 0) : View(context,attrs,defStyleSttr) {

    var pathList = mutableListOf<Path>()
    var paint: Paint
    private var drawingPath : Path = Path()
    private var linePath : Path = Path()

    init {
        paint = Paint().also {
            it.color = Color.RED
            it.style = Paint.Style.STROKE
            it.strokeWidth = 50F
        }
    }

    // 線の履歴(座標＋色)
    internal inner class DrawLine(path: Path, paint: Paint) {
        private val paint: Paint
        private val path: Path

        init {
            this.paint = Paint(paint)
            this.path = Path(path)
        }

        fun draw(canvas: Canvas) {
            canvas.drawPath(this.path, this.paint)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val view = DrawLine(Path(), Paint()) //ここで

        for (line in this.pathList){
            view.draw(canvas!!)
        }

        // Log.e("path","$pathList")
        pathList.forEach {
        }
        canvas?.drawPath(drawingPath, paint)
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        event?.let {
            when(it.action){
                MotionEvent.ACTION_DOWN ->{
                    drawingPath.moveTo(it.x,it.y)

                }
                MotionEvent.ACTION_MOVE ->{
                    drawingPath.lineTo(it.x,it.y)
                    invalidate()
                }
                MotionEvent.ACTION_UP ->{
                    drawingPath.lineTo(it.x,it.y)
                    pathList.add(linePath)

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

    fun setColor(R:Int,G:Int,B:Int){
        paint.setARGB(255,R,G,B)
        Log.e("Color","R:$R,G:$G,B:$B")
    }



}