package com.rbk.tweetsyapp.viewmodels

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rbk.tweetsyapp.repository.TweetRepository
import com.rbk.twitsyapp.models.TwitListItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(private val repository: TweetRepository,
    savedStateHandle: SavedStateHandle

) :ViewModel() {

    val tweets:StateFlow<List<TwitListItem>>
        get() = repository.tweets

    init {
        viewModelScope.launch {

            val category=savedStateHandle.get<String>("category")?:"technology"
            repository.getTweets(category)
        }
    }
}