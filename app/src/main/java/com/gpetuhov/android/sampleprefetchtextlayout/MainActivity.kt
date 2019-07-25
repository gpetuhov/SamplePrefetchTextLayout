package com.gpetuhov.android.sampleprefetchtextlayout

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.text.PrecomputedTextCompat
import androidx.core.widget.TextViewCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val item = Item()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        show_button.setOnClickListener { showText() }
    }

    private fun showText() {
        // Here the app's layout work is largely done on a background thread.

        // Start precompute.
        // This is available in AndroidX only.
        val textFuture = PrecomputedTextCompat.getTextFuture(
            item.text,
            TextViewCompat.getTextMetricsParams(text_view),
            null
        )

        // Pass future to TextView, which awaits result before measuring.
        // We must use AppCompatTextView for this.
        text_view.setTextFuture(textFuture)
    }
}
