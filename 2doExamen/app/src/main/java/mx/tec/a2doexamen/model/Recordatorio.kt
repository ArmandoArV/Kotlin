package mx.tec.a2doexamen.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Recordatorio (
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "idRecordatorio")
    var idRecordatorio: Int,
    @ColumnInfo(name = "titulo")
    var titulo: String,
    @ColumnInfo(name = "descripcion")
    var descripcion: String,
    @ColumnInfo(name = "categoria")
    var categoria: String
)