package space.abdilazov.korlinlesson3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.rv_item.*

class MainActivity : AppCompatActivity() {

    private lateinit var imageAdapter: ImageAdapter
    private var urls: ArrayList<String> = ArrayList()
    var list = arrayListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        urls = arrayListOf(
                "https://cdn.pixabay.com/photo/2013/10/02/23/03/mountains-190055__340.jpg",
                "https://cdn.pixabay.com/photo/2015/07/27/19/47/turtle-863336__340.jpg",
                "https://cdn.pixabay.com/photo/2018/08/14/13/23/ocean-3605547__340.jpg",
                "https://pixabay.com/ru/photos/iris-wild-iris-yellow-flower-5350997/",
                "https://cdn.pixabay.com/photo/2021/08/23/17/53/cat-6568422_960_720.jpg",
                "https://cdn.pixabay.com/photo/2021/08/13/12/04/seagull-6542951_960_720.jpg",
                "https://cdn.pixabay.com/photo/2021/08/03/07/02/bee-6518669_960_720.jpg",
                "https://cdn.pixabay.com/photo/2014/11/21/17/27/frog-540812_960_720.jpg",
                "https://cdn.pixabay.com/photo/2015/08/05/21/22/silver-bordered-fritillary-877121_960_720.jpg",
                "https://cdn.pixabay.com/photo/2013/06/30/18/56/butterfly-142506_960_720.jpg",
                "https://cdn.pixabay.com/photo/2017/09/25/13/12/cocker-spaniel-2785074_960_720.jpg",
                "https://i.pinimg.com/564x/8d/07/33/8d0733955aea68943afa57984a08d0d1.jpg")

        imageAdapter = ImageAdapter(urls)
        recyclerView.apply {
        recyclerView.layoutManager = GridLayoutManager(this@MainActivity, 3)
        recyclerView.adapter = imageAdapter
        }

        FAB.setOnClickListener {
            OpenMainActivity2()
        }

        imageAdapter.setOnItemClickListener(object : ImageAdapter.ItemListener{
            override fun onClick(url: String) {
                list.add(url)
            }
        })
    }

private fun OpenMainActivity2(){
    val intent = Intent(this@MainActivity,MainActivity2::class.java).apply{
        putStringArrayListExtra(KEY, list)
    }

    startActivity(intent)

}
    companion object {
        const val KEY= "key"
    }
}