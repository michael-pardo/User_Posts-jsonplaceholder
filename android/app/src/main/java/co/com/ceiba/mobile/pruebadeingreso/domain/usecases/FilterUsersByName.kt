package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository


class FilterUsersByName(
        private val repository: Repository
) {
    suspend fun invoke(name:String) = repository.getUsersByName(name)
}