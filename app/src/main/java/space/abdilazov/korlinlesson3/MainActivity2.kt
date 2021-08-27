package space.abdilazov.korlinlesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import space.abdilazov.korlinlesson3.MainActivity.Companion.KEY

class MainActivity2 : AppCompatActivity() {

    private var imageAdapter: ImageAdapter? = null
    private var imageView: ArrayList<String> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val url: ArrayList<String>? = intent.getStringArrayListExtra(KEY)
        if (url != null) {
            imageView = url
        }

        imageAdapter = ImageAdapter(imageView)

        recyclerview2.apply {
            layoutManager = GridLayoutManager(this@MainActivity2, 3)
            adapter = imageAdapter
        }

        imageAdapter?.setOnItemClickListener(object : ImageAdapter.ItemListener{
            override fun onClick(url: String) {
            }
        })
        back.setOnClickListener(View.OnClickListener {
            backActivity()
        })
    }

    private fun backActivity() {
        val intent = Intent(this@MainActivity2,MainActivity::class.java)
        startActivity(intent)
    }
}