package com.sealapp

import android.graphics.Color
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var x = 200f
    private var y = 200f
    private var sizeMM = 40f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val view = ImageView(this)
        view.setBackgroundColor(Color.WHITE)
        setContentView(view)

        view.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE) {
                x = event.x
                y = event.y
            }
            true
        }
    }

    private fun mmToPx(mm: Float): Float {
        return mm * 72f / 25.4f
    }
}
