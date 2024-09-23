package com.rbk.tweetsyapp.repository

import com.rbk.tweetsyapp.api.TwitsyAPI
import com.rbk.tweetsyapp.models.CategoryResponse
import com.rbk.twitsyapp.models.TwitListItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetRepository @Inject constructor(private val twitsyAPI: TwitsyAPI) {

    private val _categories= MutableStateFlow<List<String>>(emptyList())
    val categories: MutableStateFlow<List<String>>
        get() = _categories

    private val _tweets= MutableStateFlow<List<TwitListItem>>(emptyList())
    val tweets: MutableStateFlow<List<TwitListItem>>
        get() = _tweets


    suspend fun getCategories(){
        val response=twitsyAPI.getCategories()
        if (response.isSuccessful && response.body()!=null){
            _categories.emit(response.body()!!.categories)
        }
    }
    suspend fun getTweets(category: String){
        val response=twitsyAPI.getTwits("records[?(@.category==\"$category\")]")
        if (response.isSuccessful && response.body()!=null){
            _tweets.emit(response.body()!!)
        }
    }
}