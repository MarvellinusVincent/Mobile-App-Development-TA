package com.example.practicum20

import android.content.ContentResolver
import android.content.Context
import android.net.Uri
import android.util.Base64
import android.util.Log
import com.example.practicum20.network.GitHubApi
import com.example.practicum20.network.GitHubFile
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val TAG = "PhotoRepository"
class PhotoRepository private constructor(
    context: Context?,
    private val coroutineScope: CoroutineScope = GlobalScope
){
    private val githubApi: GitHubApi
    private val token = "Bearer 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"
    private val owner = "MarvellinusVincent"
    private val repo = "practicum20-photostore"
    private val branch = "master"

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        githubApi = retrofit.create(GitHubApi::class.java)
    }

    fun saveImage(base64Image: String, filename: String): Job {
        return coroutineScope.launch {
            uploadImageToGitHub(base64Image, filename)
        }
    }


    suspend private fun uploadImageToGitHub(base64Image: String, filename: String) {
        val path = "$filename"
        val file = GitHubFile(
            message = "Add $filename",
            content = base64Image
        )

        try {
            val response = githubApi.uploadFile(token, owner, repo, path, file)
            if (response.isSuccessful) {
                Log.d(TAG, "File uploaded successfully: ${response.body()?.content?.path}")
            } else {
                Log.e(TAG, "Error: ${response.errorBody()?.string()}")
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun getImageUrl(fileName: String): String {
        return "https://raw.githubusercontent.com/${owner}/${repo}/${branch}/${fileName}\n"
    }

    companion object {
        private  var INSTANCE: PhotoRepository? = null

        fun initialize(context: Context) {
            if (INSTANCE == null) {
                INSTANCE = PhotoRepository(context)
            }
        }

        fun get(): PhotoRepository {
            if (INSTANCE == null) {
                INSTANCE = PhotoRepository(null)
            }
            return INSTANCE!!
        }
    }

}