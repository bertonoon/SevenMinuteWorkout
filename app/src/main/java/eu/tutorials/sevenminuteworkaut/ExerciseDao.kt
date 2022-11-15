package eu.tutorials.sevenminuteworkaut

import androidx.room.*

@Dao
interface ExerciseDao {
    @Insert
    suspend fun insert (exerciseEntity: ExerciseEntity)

    @Update
    suspend fun update (exerciseEntity: ExerciseEntity)

    @Delete
    suspend fun delete(exerciseEntity: ExerciseEntity)

    @Query("SELECT * FROM `history-table` ORDER BY id DESC")
    fun fetchAll():kotlinx.coroutines.flow.Flow<List<ExerciseEntity>> // Flow - wartosci, ktore moge zmieniac sie w runtime

}