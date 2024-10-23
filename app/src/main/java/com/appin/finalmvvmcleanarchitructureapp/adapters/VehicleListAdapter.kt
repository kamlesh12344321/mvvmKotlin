package com.appin.finalmvvmcleanarchitructureapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.appin.finalmvvmcleanarchitructureapp.R
import com.appin.finalmvvmcleanarchitructureapp.domain.model.MyVehicleData


/**
 * Created by Kamlesh Patel on 22/10/24.
 */
class VehicleListAdapter (private var vehicleList: List<MyVehicleData>): RecyclerView.Adapter<VehicleListAdapter.VehicleViewHolder> (){

    inner class VehicleViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun bind(vehicleData: MyVehicleData) {
          itemView.findViewById<TextView>(R.id.vehicle_name).text = vehicleData.name
          itemView.findViewById<TextView>(R.id.vehicle_model).text = vehicleData.model
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return VehicleViewHolder(view)
    }

    override fun getItemCount(): Int {
        return vehicleList.size
    }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
       val vehicle = vehicleList[position]
        holder.bind(vehicle)
    }

    fun updateVehicleList(newVehicleList:List<MyVehicleData>) {
        vehicleList = newVehicleList
        notifyDataSetChanged()
    }
}