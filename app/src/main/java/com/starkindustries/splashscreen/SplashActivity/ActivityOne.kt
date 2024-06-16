package com.starkindustries.splashscreen.SplashActivity
import android.content.Intent
import android.database.DatabaseUtils
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.starkindustries.splashscreen.MainActivity
import com.starkindustries.splashscreen.R
import com.starkindustries.splashscreen.databinding.ActivityOneBinding
class ActivityOne : AppCompatActivity() {
    lateinit var binding:ActivityOneBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_one)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_one)
        Handler(Looper.getMainLooper()).postDelayed({
            val inext:Intent = Intent(this,MainActivity::class.java)
            startActivity(inext)
        },3000)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}