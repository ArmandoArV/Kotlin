package mx.tec.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import mx.tec.room.model.Persona

@Dao
interface PersonaDao {
    @Query("SELECT * FROM Persona")
    fun getAll(): List<Persona>
    @Insert
    fun registrarPersona(persona: Persona)
}