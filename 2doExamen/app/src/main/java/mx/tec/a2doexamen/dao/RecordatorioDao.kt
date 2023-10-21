package mx.tec.a2doexamen.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mx.tec.a2doexamen.model.Recordatorio

@Dao
interface RecordatorioDao {
    @Query("SELECT * FROM Recordatorio")
    fun obtenerRecordatorios(): List<Recordatorio>

    @Insert
    fun registrarRecordatorio(recordatorio: Recordatorio)

    // Borrar base de datos
    @Query("DELETE FROM Recordatorio")
    fun borrarRecordatorios()
}