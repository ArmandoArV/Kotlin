package mx.tec.room.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity
data class Persona(
    @PrimaryKey(autoGenerate = true)
    @NonNull
    @ColumnInfo (name = "idPersona")
    val idPersona: Int,
    @ColumnInfo (name = "nombre")
    val nombre: String,
    @ColumnInfo (name = "apellido")
    val apellido: String,
    @ColumnInfo (name = "edad")
    val edad:Int,
    @ColumnInfo (name = "nacimiento")
    val nacimiento: Date,
)
