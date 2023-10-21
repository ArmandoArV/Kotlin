package mx.tec.arredondovalle_ep2.dao

import androidx.room.Query
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import mx.tec.arredondovalle_ep2.model.Reminder

@Dao
interface ReminderDao {
    @Query("SELECT * FROM Reminder")
    fun getAll(): List<Reminder>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun registrarReminder(reminder: Reminder)
    @Update
    fun updateReminder(reminder: Reminder)

}