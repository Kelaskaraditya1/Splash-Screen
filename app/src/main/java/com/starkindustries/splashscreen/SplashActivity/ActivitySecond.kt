package com.starkindustries.splashscreen.SplashActivity
import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.starkindustries.splashscreen.MainActivity
import com.starkindustries.splashscreen.R
import com.starkindustries.splashscreen.databinding.ActivitySecondBinding

class ActivitySecond : AppCompatActivity() {
    lateinit var binding:ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_second)
        LongOperation().execute()
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    open inner class LongOperation:AsyncTask<String ?,Void ?,String ?>(){
        override fun doInBackground(vararg params: String?): String? {
            for(i in 0..6)
            {
                try
                {
                    Thread.sleep(1000)
                }
                catch(e:Exception)
                {
                    Thread.interrupted()
                }
            }
            return "result"
        }

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            startActivity(Intent(this@ActivitySecond,MainActivity::class.java))

        }

    }

}