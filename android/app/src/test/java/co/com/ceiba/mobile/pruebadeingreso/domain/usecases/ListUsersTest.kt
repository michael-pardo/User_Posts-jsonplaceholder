package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.fakes.*
import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class ListUsersTest{
    @Mock
    lateinit var repository: Repository

    lateinit var listUsers: ListUsers

    @Before
    fun setUp() {
        listUsers = ListUsers(repository)
    }

    @Test
    fun `invoke calls repository`(){
        runBlocking {
            val users = listOf(mockedUser.copy(id = 1))
            whenever(repository.getUsers()).thenReturn(ResultData.Success(users))
            when (val result = listUsers.invoke()){
                is ResultData.Success ->{
                    assertEquals(users, result.data)
                }
            }
        }
    }

    @Test
    fun `invoke calls repository error`(){
        runBlocking {
            val error = mockedErrorUserList
            whenever(repository.getUsers()).thenReturn(ResultData.Error(error))
            when (val result = listUsers.invoke()){
                is ResultData.Error ->{
                    assertEquals(error, result.exception)
                }
            }
        }
    }
}