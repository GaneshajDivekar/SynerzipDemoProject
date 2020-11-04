package com.demoproject.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.demoproject.model.*

@Database(entities = [CompletedDB::class,DetailsDB::class,HeaderDB::class,AllTravelModeDB::class,AllTravelTypeDB::class,DisplayData::class,HomeScreenDB::class, VisitDB::class], version = 10, exportSchema = false)
abstract class MyRoomDataBase : RoomDatabase() {

    public abstract fun getNoteDao(): WeatherDao

    companion object {

        @Volatile
        private var INSTANCE: MyRoomDataBase? = null

        fun getInstance(context: Context): MyRoomDataBase {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        MyRoomDataBase::class.java,
                        "weatherdb"
                    )
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}