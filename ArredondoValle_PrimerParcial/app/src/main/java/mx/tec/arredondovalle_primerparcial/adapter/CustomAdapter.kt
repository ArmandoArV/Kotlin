/*

    Made by: Armando Arredondo Valle
    Finished: 10/09/2023 | 10:08 PM

*/

package mx.tec.arredondovalle_primerparcial.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import mx.tec.arredondovalle_primerparcial.MapActivity
import mx.tec.arredondovalle_primerparcial.R
import mx.tec.arredondovalle_primerparcial.model.Ubicacion

class CustomAdapter(
    private val context: Context,
    private val layout: Int,
    private val dataSource: MutableList<Ubicacion>
) : RecyclerView.Adapter<CustomAdapter.UbicacionViewHolder>() {

    interface OnItemClickListener {
        fun onItemClick(ubicacion: Ubicacion)
        fun onItemDelete(ubicacion: Ubicacion)
    }

    private var listener: OnItemClickListener? = null

    fun setOnItemClickListener(listener: OnItemClickListener) {
        this.listener = listener
    }

    class UbicacionViewHolder(inflater: LayoutInflater, parent: ViewGroup, layout: Int) :
        RecyclerView.ViewHolder(inflater.inflate(layout, parent, false)) {
        var nombreLugar: TextView? = null
        var descripcion: TextView? = null
        var estado: TextView? = null
        var latitud: TextView? = null
        var longitud: TextView? = null

        init {
            nombreLugar =
                itemView.findViewById(R.id.txtNombre) as TextView
            descripcion =
                itemView.findViewById(R.id.txtDesc) as TextView
            estado =
                itemView.findViewById(R.id.txtEdo) as TextView
            latitud =
                itemView.findViewById(R.id.txtLatitud) as TextView
            longitud =
                itemView.findViewById(R.id.txtLongitud) as TextView
        }

        fun bindData(ubicacion: Ubicacion) {
            nombreLugar!!.text = ubicacion.nombre
            descripcion!!.text = ubicacion.descripcion
            estado!!.text = ubicacion.estado
            latitud!!.text = ubicacion.latitud.toString()
            longitud!!.text = ubicacion.longitud.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return UbicacionViewHolder(inflater, parent, layout)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    // Inside onBindViewHolder method
    override fun onBindViewHolder(holder: UbicacionViewHolder, position: Int) {
        val ubicacion = dataSource[position]
        holder.bindData(ubicacion)

        // Set an OnClickListener for the item
        holder.itemView.setOnClickListener {
            listener?.onItemClick(ubicacion)
            showOptionsDialog(ubicacion)
        }

        holder.itemView.setOnLongClickListener {
            listener?.onItemDelete(ubicacion)
            true
        }


    }

    fun deleteItem(ubicacion: Ubicacion) {
        val position = dataSource.indexOf(ubicacion)
        if (position != -1) {
           dataSource.removeAt(position)
            notifyItemRemoved(position)
            Toast.makeText(context, "Ubicación eliminada", Toast.LENGTH_SHORT).show()
        }
    }


    private fun showOptionsDialog(ubicacion: Ubicacion) {
        val options = arrayOf("Ver en Mapa", "Eliminar")

        Log.d("CustomAdapter", "showOptionsDialog called")

        AlertDialog.Builder(context)
            .setTitle("Opciones")
            .setItems(options) { _, which ->
                when (which) {
                    0 -> {
                        Log.d("CustomAdapter", "Option selected: Ver en Mapa")
                        listener?.onItemClick(ubicacion)
                        val intent = Intent(context, MapActivity::class.java)
                        intent.putExtra("latitud", ubicacion.latitud)
                        intent.putExtra("longitud", ubicacion.longitud)
                        context.startActivity(intent)
                    }

                    1 -> {
                        Log.d("CustomAdapter", "Option selected: Eliminar")
                        deleteItem(ubicacion)
                        listener?.onItemDelete(ubicacion)
                    }
                }
            }
            .show()
    }


}
