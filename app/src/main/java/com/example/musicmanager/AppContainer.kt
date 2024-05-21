package com.example.musicmanager

import android.content.Context
import com.example.musicmanager.database.AppDatabase
import com.example.musicmanager.database.Repository
import kotlinx.coroutines.CoroutineScope

class AppContainer {
    lateinit var db:AppDatabase
        private set
    val repository by lazy{
        Repository(
            db.albumDao(),
            db.songDao(),
            db.songAlbumCrossDao()
        )
    }
    fun provide(context: Context,scope: CoroutineScope){
        db = AppDatabase.getDatabase(context,scope)
    }
}