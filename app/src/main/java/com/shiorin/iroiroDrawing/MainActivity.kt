package com.shiorin.iroiroDrawing

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val cv : CanvasView = findViewById(R.id.canvas_view)
        val button : Button = findViewById(R.id.clear_button)


        button.setOnClickListener {
            cv.allDelete()
        }
    }
}
