package latihan.ihsan.submission1_ihsan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class SplashScreen : AppCompatActivity() {

    companion object {
        private const val SPLASH_TIME_OUT:Long = 3000
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, SPLASH_TIME_OUT)

        val actionBar = supportActionBar
        actionBar?.hide()
    }
}