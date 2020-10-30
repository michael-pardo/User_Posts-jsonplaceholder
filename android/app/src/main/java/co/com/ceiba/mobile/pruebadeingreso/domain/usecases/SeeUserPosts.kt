package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository


class SeeUserPosts(
        private val repository: Repository
) {
    suspend fun invoke(id:Int) = repository.getUserWithPosts(id)
}