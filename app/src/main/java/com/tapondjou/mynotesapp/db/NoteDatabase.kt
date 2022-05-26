    package com.tapondjou.simplenotes.db

    import android.content.Context
    import android.content.res.Resources
    import android.provider.Settings.Global.getString
    import androidx.room.Database
    import androidx.room.Room
    import androidx.room.RoomDatabase
    import androidx.sqlite.db.SupportSQLiteDatabase
    import com.tapondjou.mynotesapp.MainActivity
    import com.tapondjou.mynotesapp.R
    import kotlinx.coroutines.CoroutineScope
    import kotlinx.coroutines.launch

    @Database(
        entities = [Note::class],
        version = 1
    )

    abstract class NoteDatabase(): RoomDatabase() {
        abstract fun getNoteDao(): NoteDao

        private class NoteDatabaseCallback(
            private val scope: CoroutineScope
        ) : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                INSTANCE?.let { database ->
                    scope.launch {
                        populateDatabase(database.getNoteDao())
                    }
                }
            }

            suspend fun populateDatabase(noteDao: NoteDao) {
                // Delete all content here.
                //noteDao.deleteAll()

                // Add sample words.
                var note = Note("Title 1", "Description 1", "1", "Not checked")
                noteDao.addNode(note)
                note= Note("Title 2","Description 2","2","Checked")
                noteDao.addNode(note)
                note= Note("Title 3","Description 3","3","Checked")
                noteDao.addNode(note)
                note= Note("Title 4","Description 4","4","Not checked")
                noteDao.addNode(note)
                note= Note("Title 5","Description 5","5","Not checked")
                noteDao.addNode(note)
                note= Note("Title 6","Description 6","6","Not checked")
                noteDao.addNode(note)


                // TODO: Add your own words!
            }
        }

        companion object{
            @Volatile
            private var INSTANCE: NoteDatabase? = null
            fun getDatabase(context: Context, scope: CoroutineScope): NoteDatabase{
                return INSTANCE ?: synchronized(this) {
                    val instance = Room.databaseBuilder(
                        context.applicationContext,
                        NoteDatabase::class.java,
                        "note_database"
                    )
                        .addCallback(NoteDatabaseCallback(scope))
                        .build()
                    INSTANCE = instance
                    // return instance
                    instance
                }

            }

        }
    }


