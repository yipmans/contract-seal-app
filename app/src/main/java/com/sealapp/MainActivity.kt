package com.sealapp

import android.graphics.*
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var sealX = 200f
    private var sealY = 200f
    private var sealSizeMM = 40f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageView = ImageView(this)
        imageView.setBackgroundColor(Color.WHITE)
        setContentView(imageView)

        imageView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE) {
                sealX = event.x
                sealY = event.y
            }
            true
        }
    }

    private fun mmToPt(mm: Float): Float {
        return mm * 72f / 25.4f
    }
}
