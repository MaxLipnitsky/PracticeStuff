package com.maxl.roomwordsample.room

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WordDao {

    @Query("SELECT * FROM word_table ORDER BY word ASC")
    fun getAlphabetizedWords(): Flow<List<Word>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(word: Word)

    @Query("DELETE FROM word_table")
    suspend fun deleteAll()

    // My Extra methods
//    @Update(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun insertWithUpdate(word: Word)
//
//    @Query("DELETE FROM word_table WHERE id = :id")
//    suspend fun deleteById(id: Int)
//
//    @Delete
//    suspend fun deleteByIdNoSql(id: Int)

}