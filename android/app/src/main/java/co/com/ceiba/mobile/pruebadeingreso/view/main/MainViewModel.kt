package co.com.ceiba.mobile.pruebadeingreso.view.main


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.FilterUsersByName
import co.com.ceiba.mobile.pruebadeingreso.domain.usecases.ListUsers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(
        private val listUsers: ListUsers,
        private val filterUsersByName: FilterUsersByName
):ViewModel() {
    val users : LiveData<List<User>>
        get()= _users
    private val _users = MutableLiveData<List<User>>()

    val loading : LiveData<Boolean>
        get()= _loading
    private val _loading = MutableLiveData(true)

    val emptyList : LiveData<Boolean>
        get()= _emptyList
    private val _emptyList = MutableLiveData(false)

    init {
        viewModelScope.launch {
            when (val userList =listUsers.invoke()){
                is ResultData.Success -> {
                    _users.value = userList.data
                    _emptyList.value = userList.data.isEmpty()
                }
                is ResultData.Error -> {
                    _emptyList.value = true
                }
            }
            _loading.value = false
        }
    }

    fun searchUsersByName(name:String){
        viewModelScope.launch {
            when (val userSearchList =filterUsersByName.invoke(name)){
                is ResultData.Success -> {
                    _users.value = userSearchList.data
                    _emptyList.value = userSearchList.data.isEmpty()
                }
                is ResultData.Error -> {

                }
            }

        }
    }


}