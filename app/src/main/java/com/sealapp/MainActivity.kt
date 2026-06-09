package com.sealapp

import android.graphics.*
import android.os.Bundle
import android.view.MotionEvent
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var sealX = 200f
    private var sealY = 200f

    // 用户输入的真实尺寸（mm）
    private var sealSizeMM = 40f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val imageView = ImageView(this)
        imageView.setBackgroundColor(Color.WHITE)
        setContentView(imageView)

        // 拖动印章（模拟）
        imageView.setOnTouchListener { _, event ->
            if (event.action == MotionEvent.ACTION_MOVE) {
                sealX = event.x
                sealY = event.y
                imageView.invalidate()
            }
            true
        }
    }

    // mm → PDF point（核心换算）
    private fun mmToPt(mm: Float): Float {
        return mm * 72f / 25.4f
    }

    // 获取真实打印尺寸（关键）
    private fun getSealSizeInPdf(): Float {
        return mmToPt(sealSizeMM)
    }
}
