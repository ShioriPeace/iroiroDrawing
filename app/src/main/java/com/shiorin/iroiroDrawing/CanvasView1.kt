//package com.shiorin.iroiroDrawing
//
//import android.content.Context
//import android.graphics.Canvas
//import android.graphics.Color
//import android.graphics.Paint
//import android.graphics.Path
//import android.text.method.TextKeyListener.clear
//import android.util.AttributeSet
//import android.view.MotionEvent
//import android.view.View
//import java.awt.font.ShapeGraphicAttribute.STROKE
//
//
//
//class CanvasView1 { // サイトのjavaをkotlinに変換したやつ
//
//    inner class DrawingView : View {
//        // 履歴
//        private lateinit var lines: MutableList<DrawLine>
//        // 現在、描いている線の情報
//        private val paint: Paint
//        private val path: Path
//
//        // 線の履歴(座標＋色)
//        internal inner class DrawLine(path: Path, paint: Paint) {
//            private val paint: Paint
//            private val path: Path
//
//            init {
//                this.paint = Paint(paint)
//                this.path = Path(path)
//            }
//
//            fun draw(canvas: Canvas) {
//                canvas.drawPath(this.path, this.paint)
//            }
//        }
//
//        constructor(context: Context) : super(context) {}
//
//        constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
//
//            this.path = Path()
//
//            this.paint = Paint()
//            this.paint.setStyle(Paint.Style.STROKE)
//            this.paint.setAntiAlias(true)
//            this.paint.setStrokeWidth(5)
//
//            this.lines = ArrayList()
//        }
//
//       override fun onDraw(canvas: Canvas) {
//            super.onDraw(canvas)
//
//            // キャンバスをクリア
//            canvas.drawColor(Color.WHITE)
//            // 履歴から線を描画
//            for (line in this.lines) {
//                line.draw(canvas)
//            }
//            // 現在、描いている線を描画
//            canvas.drawPath(this.path, this.paint)
//        }
//
//        override fun onTouchEvent(event: MotionEvent): Boolean {
//            val x = event.x
//            val y = event.y
//
//            when (event.action) {
//                MotionEvent.ACTION_DOWN -> this.path.moveTo(x, y)
//                MotionEvent.ACTION_MOVE -> this.path.lineTo(x, y)
//                MotionEvent.ACTION_UP -> {
//                    this.path.lineTo(x, y)
//                    // 指を離したので、履歴に追加する
//                    this.lines.add(DrawLine(this.path, this.paint))
//                    // パスをリセットする
//                    // これを忘れると、全ての線の色が変わってしまう
//                    this.path.reset()
//                }
//            }
//            invalidate()
//            return true
//        }
//
//        fun delete() {
//            // 履歴をクリア
//            this.lines.clear()
//            // 現在の線をクリア
//            this.path.reset()
//            invalidate()
//        }
//
//        fun setPen(color: Int) {
//            this.paint.setColor(color)
//        }
//    }
//}