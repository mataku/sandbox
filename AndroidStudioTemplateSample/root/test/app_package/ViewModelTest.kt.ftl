package ${packageName}

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.mockito.MockitoAnnotations
import kotlin.test.BeforeTest
import kotlin.test.Test

class ${className}Test {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    lateinit var viewModel: ${className}

    @BeforeTest
    fun setup() {
        MockitoAnnotations.initMocks(this)

        viewModel = ${className}()
    }

	  @Test
    fun testMyFunction() = runBlocking {
        // TODO
    }
}
