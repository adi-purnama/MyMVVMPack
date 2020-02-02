package com.adi.purnama.mymvvm.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Adi Purnama
 * @2019
 */
@Entity(tableName = "todo_list")
data class TodoList(@PrimaryKey(autoGenerate = true) val id: Long?,
                      @ColumnInfo(name = "nama") val nama: String,
                      @ColumnInfo(name = "deskripsi") val deskripsi: String,
                      @ColumnInfo(name = "gambar") val gambar: String,
                      @ColumnInfo(name = "status") val status: Int)