package com.azamovhudstc.foodapprecoginizng.presentation.screen.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.azamovhudstc.foodapprecoginizng.R
import com.azamovhudstc.foodapprecoginizng.models.ProductFireBase
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item.view.*

class MainAdapter() :
    ListAdapter<ProductFireBase, MainAdapter.Wh>(ContactItemCallBack) {
    inner class Wh(view: View) : RecyclerView.ViewHolder(view) {
        @SuppressLint("NewApi", "SetTextI18n")
        fun onBind(contact: ProductFireBase, position: Int) {
            itemView.productName.text=contact.name
            Picasso.get().load(contact.image).into(itemView.image)
            itemView.setOnClickListener {
                println("==================================")
                println("height:"+contact.toString())
                println("==================================")

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
        return Wh(LayoutInflater.from(parent.context).inflate(
            R.layout.list_item,
            parent,
            false
        ))
    }

    override fun onBindViewHolder(holder: Wh, position: Int) {
        holder.onBind(getItem(position), position)
    }

    object ContactItemCallBack : DiffUtil.ItemCallback<ProductFireBase>() {
        override fun areItemsTheSame(
            oldItem: ProductFireBase,
            newItem: ProductFireBase
        ): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(
            oldItem: ProductFireBase,
            newItem: ProductFireBase
        ): Boolean {
            return oldItem == newItem
        }



    }

}
//package com.azamovhudstc.quranuz.ui.adapter
//
//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.azmovhudstc.playmarketcloneui.R
//import com.azmovhudstc.playmarketcloneui.model.GeneralData
//import kotlinx.android.synthetic.main.general_item.view.*
//
//class ProductFireBasesAdapter(var arrayList: List<GeneralData>, var context:Context) :
//    RecyclerView.Adapter<ProductFireBasesAdapter.Wh>() {
//    inner class Wh(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        fun generalData(generalData: GeneralData) {
//            itemView.title_general.text=generalData.title
//            var topsAdapter=TopsAdapter(list = generalData.appList )
//            itemView.rv_inside.layoutManager=LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false,)
//            itemView.rv_inside.adapter=topsAdapter
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Wh {
//        return Wh(LayoutInflater.from(parent.context).inflate(R.layout.general_item, parent, false))
//    }
//
//    override fun onBindViewHolder(holder: Wh, position: Int) {
//        holder.generalData(arrayList[position]!!)
//    }
//
//    override fun getItemCount(): Int = arrayList.size
//
//}
