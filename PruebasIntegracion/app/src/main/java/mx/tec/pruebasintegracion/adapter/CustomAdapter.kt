package mx.tec.pruebasintegracion.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import mx.tec.pruebasintegracion.R
import mx.tec.pruebasintegracion.model.Usuario

class CustomAdapter(
    private val context: Context, private val layout: Int, private val dataSource: List<Usuario>
) : RecyclerView.Adapter<CustomAdapter.UsuarioViewHolder>() {
    class UsuarioViewHolder(inflater: LayoutInflater, parent: ViewGroup, layout: Int) :
        RecyclerView.ViewHolder(inflater.inflate(layout, parent, false)) {
        var remitente: TextView? = null;
        var asunto: TextView? = null;

        init {
            remitente = itemView.findViewById(R.id.text_sender) as TextView;
            asunto = itemView.findViewById(R.id.text_subject) as TextView;
        }

        fun bindData(usuario: Usuario) {
            remitente!!.text = usuario.Remitente
            asunto!!.text = usuario.Asunto
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsuarioViewHolder {
        val inflater = LayoutInflater.from(parent.context);
        return UsuarioViewHolder(inflater, parent, layout)
    }

    override fun getItemCount(): Int {
        return dataSource.size
    }

    override fun onBindViewHolder(holder: UsuarioViewHolder, position: Int) {
        val usuario = dataSource[position];
        holder.bindData(usuario)
    }
}