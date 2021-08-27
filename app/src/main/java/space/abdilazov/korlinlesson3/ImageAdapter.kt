package space.abdilazov.korlinlesson3

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class ImageAdapter(private val img: ArrayList<String>) :
        RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    private lateinit var clickListeneer: ItemListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false),clickListeneer)
    }

    override fun getItemCount(): Int {
        return img.size
    }

    fun setOnItemClickListener(clickListener: ItemListener){
        clickListeneer = clickListener
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.onBind(img[position])
    }

    class ViewHolder(itemView: View, var clickListener: ItemListener) :
            RecyclerView.ViewHolder(itemView) {

        fun onBind(url: String) {

            itemView.image_view.load(url)
            itemView.setOnClickListener {
                it.setBackgroundColor(Color.BLACK)
                clickListener.onClick(url)
            }
        }
    }

    interface ItemListener{
        fun onClick(url: String)
    }
}