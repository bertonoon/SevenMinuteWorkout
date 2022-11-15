package eu.tutorials.sevenminuteworkaut

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import eu.tutorials.sevenminuteworkaut.databinding.ItemsRowBinding
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ItemAdapter(private val items:ArrayList<ExerciseEntity>)
    : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(binding: ItemsRowBinding) : RecyclerView.ViewHolder(binding.root){
        val llMain = binding.llMain
        val tvDate = binding.tvDate
        val tvId = binding.tvId
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemsRowBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val context = holder.itemView.context
        val item = items[position]


        holder.tvId.text = item.id.toString()

        val date = SimpleDateFormat(
            "yyyy-MM-dd HH:mm", Locale.ENGLISH).format(item.date)

        holder.tvDate.text = date


        if(position % 2 == 0){
            holder.llMain.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context,
                R.color.lightGray))
        } else {
            holder.llMain.setBackgroundColor(
                ContextCompat.getColor(holder.itemView.context,
                R.color.white))
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }


}