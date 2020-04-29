package franco.lucas.testepicpay.viewModel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.*
import franco.lucas.testepicpay.interactor.UsersInteractor
import franco.lucas.testepicpay.model.UserModel
import franco.lucas.testepicpay.model.UserPM
import kotlinx.coroutines.*
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @ObsoleteCoroutinesApi
    private val mainThreadSurrogate = newSingleThreadContext("UI thread")

    @Mock
    lateinit var interactor: UsersInteractor

    lateinit var viewModel: MainViewModel

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @Before
    fun setup() {
        Dispatchers.setMain(mainThreadSurrogate)
        viewModel = spy(MainViewModel(interactor))
    }

    @ExperimentalCoroutinesApi
    @ObsoleteCoroutinesApi
    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()
    }

    @Test
    fun `on get users success`() {
        runBlocking {
            val observableShowLoading: Observer<Boolean> = mock()
            val observableFinish: Observer<List<UserModel>> = mock()
            val mockList = ArrayList<UserModel>()
            mockList.add(UserModel("mock","mock",12,"mock"))
            val responseSuccess = UserPM(mockList)

            whenever(interactor.execute(Unit)).thenReturn(responseSuccess)
            viewModel.showLoading.observeForever(observableShowLoading)
            viewModel.users.observeForever(observableFinish)

            viewModel.init()

            delay(1000L)
            verify(observableShowLoading, times(1)).onChanged(true)
            verify(interactor, times(1)).execute(Unit)
            verify(observableFinish, times(1)).onChanged(mockList)
            verify(observableShowLoading, times(2)).onChanged(false)
        }
    }

    @Test
    fun `on get users error`() {
        runBlocking {
            val observableShowLoading: Observer<Boolean> = mock()
            val observableFinish: Observer<String> = mock()
            val responseError = "Error"

            whenever(interactor.execute(Unit)).doThrow(RuntimeException(responseError))
            viewModel.showLoading.observeForever(observableShowLoading)
            viewModel.errorMessage.observeForever(observableFinish)
            viewModel.init()

            delay(1000L)
            verify(observableShowLoading, times(1)).onChanged(true)
            verify(interactor, times(1)).execute(Unit)
            verify(observableFinish, times(1)).onChanged(responseError)
            verify(observableShowLoading, times(2)).onChanged(false)
        }
    }

}