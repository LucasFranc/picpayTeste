package franco.lucas.testepicpay.repository

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.picpay.desafio.android.dataset.UsersLocalDataSet
import com.picpay.desafio.android.dataset.UsersRemoteDataSet
import com.picpay.desafio.android.model.UserModel
import com.picpay.desafio.android.repository.UsersRepository
import com.picpay.desafio.android.repository.UsersRepositoryImpl
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class UsersRepositoryTest {

    private lateinit var usersRepository: UsersRepository

    @Mock
    lateinit var remoteDataset: UsersRemoteDataSet

    @Mock
    lateinit var localDataset: UsersLocalDataSet

    @Before
    fun setup() {
        usersRepository = UsersRepositoryImpl(
            localDataset,
            remoteDataset
        )
    }

    @Test
    fun `on get users remote`() {
        runBlocking {
            val mockReturn = ArrayList<UserModel>().apply {
                add(UserModel("mock", "mock", 12, "mock"))
            }

            whenever(remoteDataset.getUsersByRemote()).doReturn(mockReturn)

            val result = remoteDataset.getUsersByRemote()

            Assert.assertEquals(result, mockReturn)

            verify(remoteDataset, times(1)).getUsersByRemote()
        }
    }

    @Test
    fun `on get users local`() {
        val mockReturn: List<UserModel>? = null

        whenever(localDataset.getUsersByLocal()).doReturn(mockReturn)

        val result = localDataset.getUsersByLocal()

        Assert.assertEquals(result, mockReturn)

        verify(localDataset, times(1)).getUsersByLocal()

    }


}