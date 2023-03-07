package com.example.mywish

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val items: List<Item>) : RecyclerView.Adapter<ItemAdapter.ViewHolder>()
{

    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    {

        // TODO: Create member variables for any view that will be set
        // as you render a row.

        val nameTextView: TextView
        val costTextView: TextView
        val urlTextView: TextView



        // We also create a constructor that accepts the entire item row
        // and does the view lookups to find each sub-view
        init
        {
            // TODO: Store each of the layout's views into
            // the public final member variables created above



            nameTextView = itemView.findViewById(R.id.tvName)
            costTextView = itemView.findViewById(R.id.tvCost)
            urlTextView = itemView.findViewById(R.id.tvURL)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {

        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val contactView = inflater.inflate(R.layout.list_item, parent, false)

        return ViewHolder(contactView)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        val item = items.get(position)

        holder.nameTextView.text = item.title
        holder.costTextView.text = item.cost.toString()
        holder.urlTextView.text = item.url
    }
}