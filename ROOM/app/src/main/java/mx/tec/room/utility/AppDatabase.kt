package mx.tec.room.utility

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.TypeConverters
import mx.tec.room.dao.PersonaDao
import mx.tec.room.model.Persona
import androidx.room.RoomDatabase
@Database(entities = arrayOf(Persona::class), version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personaDao(): PersonaDao

    companion object{
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context : Context): AppDatabase {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "Agenda"
                ).build()
            }
            return INSTANCE as AppDatabase
        }
    }
}