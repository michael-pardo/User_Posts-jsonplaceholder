package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository


class ListUsers(
        private val repository: Repository
) {
    suspend fun invoke() = repository.getUsers()
}