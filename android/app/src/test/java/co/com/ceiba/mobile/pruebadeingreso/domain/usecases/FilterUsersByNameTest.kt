package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.fakes.mockedName
import co.com.ceiba.mobile.pruebadeingreso.domain.fakes.mockedUser
import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before

import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FilterUsersByNameTest {
    @Mock
    lateinit var repository: Repository

    lateinit var filterUsersByName: FilterUsersByName

    @Before
    fun setUp() {
        filterUsersByName = FilterUsersByName(repository)
    }

    @Test
    fun `invoke calls repository`(){
        runBlocking {
            val users = listOf(mockedUser.copy(id = 1))
            val name = mockedName
            whenever(repository.getUsersByName(name)).thenReturn(ResultData.Success(users))
            when (val result = filterUsersByName.invoke(name)){
                is ResultData.Success ->{
                    assertEquals(users, result.data)
                }
            }
        }
    }
}