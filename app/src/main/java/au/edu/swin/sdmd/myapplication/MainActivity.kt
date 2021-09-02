package au.edu.swin.sdmd.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    var state = R.drawable.ic_thumb_up_black_48dp
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView5)

        savedInstanceState?.let{
            state = it.getInt("IMAGE")
            imageView.setImageDrawable(getDrawable(state))
        }

        imageView.setOnLongClickListener {
            state = when (state) {
                R.drawable.ic_thumb_up_black_48dp -> R.drawable.ic_thumb_up_off_alt_black_48dp
                R.drawable.ic_thumb_up_off_alt_black_48dp -> R.drawable.ic_thumb_up_black_48dp
                else -> R.drawable.ic_thumb_up_black_48dp
            }
            imageView.setImageDrawable(getDrawable(state))
            true
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("IMAGE", state)
    }
}