package mx.tec.a2doexamen.utility

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import mx.tec.a2doexamen.dao.RecordatorioDao
import mx.tec.a2doexamen.model.Recordatorio

@Database(entities = [Recordatorio::class], version = 1)

abstract class AppDatabase: RoomDatabase() {
    abstract fun recordatorioDao(): RecordatorioDao

    companion object {
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase{
            if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context,
                        AppDatabase::class.java,
                        "app_database" // Nombre de la base de datos
                    ).build()
            }
            return INSTANCE as AppDatabase
        }
    }
}