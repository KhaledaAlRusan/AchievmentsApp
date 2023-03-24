package com.example.projectone_v02.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.projectone_v02.data.model.Data
import com.example.projectone_v02.data.model.Response
import com.example.projectone_v02.data.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val repository: Repository)  : ViewModel() {


   private  val _getAchievementsSuccessLiveData:MutableLiveData<List<Data>> = MutableLiveData()
    val getAchievementsSuccessLiveData: LiveData<List<Data>> = _getAchievementsSuccessLiveData

    private val _getAchievementsErrorLiveData:MutableLiveData<Exception> = MutableLiveData()
    val getAchievementsErrorLiveData:MutableLiveData<Exception> = _getAchievementsErrorLiveData

    private val _getAchievementsLoadingLiveData:MutableLiveData<Boolean> = MutableLiveData()
    val getAchievementsLoadingLiveData:LiveData<Boolean> = _getAchievementsLoadingLiveData

    private fun getAchievements(){
        viewModelScope.launch{
            _getAchievementsLoadingLiveData.postValue(true)
            try{
                val response = repository.getAchievements()
                _getAchievementsSuccessLiveData.postValue(response)
            }
            catch (e:Exception){
                _getAchievementsErrorLiveData.postValue(e)
            }
            _getAchievementsLoadingLiveData.postValue(false)
        }

    }
    init {
        getAchievements()
    }


}