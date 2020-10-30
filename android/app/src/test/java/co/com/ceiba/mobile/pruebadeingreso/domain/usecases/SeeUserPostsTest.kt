package co.com.ceiba.mobile.pruebadeingreso.domain.usecases

import co.com.ceiba.mobile.pruebadeingreso.domain.ResultData
import co.com.ceiba.mobile.pruebadeingreso.domain.fakes.*
import co.com.ceiba.mobile.pruebadeingreso.data.local.model.UserWithPostsEntity
import co.com.ceiba.mobile.pruebadeingreso.domain.repository.Repository
import com.nhaarman.mockitokotlin2.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class SeeUserPostsTest {

    @Mock
    lateinit var repository: Repository

    lateinit var seeUserPosts: SeeUserPosts

    @Before
    fun setUp() {
        seeUserPosts = SeeUserPosts(repository)
    }

    @Test
    fun `invoke calls repository`(){
        runBlocking {
            val userWithPosts = UserWithPostsEntity(
                    user = mockedUser.copy(id=1),
                    posts = listOf(mockedPost.copy(id = 1))
            )
            val userId = mockedUserId
            whenever(repository.getUserWithPosts(userId)).thenReturn(ResultData.Success(userWithPosts))
            when (val result = seeUserPosts.invoke(userId)){
                is ResultData.Success ->{
                    Assert.assertEquals(userWithPosts, result.data)
                }
            }
        }
    }

    @Test
    fun `invoke calls repository error`(){
        runBlocking {
            val error = mockedErrorUserWithPosts
            val userId = mockedUserIdError
            whenever(repository.getUserWithPosts(userId)).thenReturn(ResultData.Error(error))
            when (val result = seeUserPosts.invoke(userId)){
                is ResultData.Error ->{
                    Assert.assertEquals(error, result.exception)
                }
            }
        }
    }
}


