package eu.tutorials.sevenminuteworkaut

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "history-table")
data class ExerciseEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Long = 0
)
