package com.example.nikeassessment.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.nikeassessment.model.ListItem
import com.example.nikeassessment.repository.SearchRepository
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@ExperimentalCoroutinesApi
@RunWith(MockitoJUnitRunner::class)
class SearchViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @MockK
    lateinit var searchRepository: SearchRepository

    lateinit var viewModel: SearchViewModel

    @Mock
    private lateinit var searchObserver: Observer<List<ListItem>>


    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = SearchViewModel(searchRepository)
        viewModel.searchResults.observeForever(searchObserver)

        coEvery { searchRepository.getServiceResponse("") } returns listOf(
            TEST_LIST_ITEM_1,
            TEST_LIST_ITEM_2,
            TEST_LIST_ITEM_3
        )
    }

    @Test
    fun `when api call is made it should call the response of list of items in the repository`() =
        runBlockingTest {

            viewModel.getSearchResults("")
            searchObserver.onChanged(listOf(TEST_LIST_ITEM_1, TEST_LIST_ITEM_2, TEST_LIST_ITEM_3))

        }


    @Test
    fun `when sortByThumbsUp in the SearchViewModel is called it should retrun the list of items in descending order of thumbsUp count`() =
        runBlockingTest {
            viewModel.getSearchResults("")
            viewModel.sortByThumbsUp()
            searchObserver.onChanged(listOf(TEST_LIST_ITEM_3, TEST_LIST_ITEM_1, TEST_LIST_ITEM_2))

        }

    @Test
    fun `when sortByThumbsDown in the SearchViewModel is called it should retrun the list of items in descending order of thumbsDown count`() =
        runBlockingTest {
            viewModel.getSearchResults("")
            viewModel.sortByThumbsDown()
            searchObserver.onChanged(listOf(TEST_LIST_ITEM_3, TEST_LIST_ITEM_2, TEST_LIST_ITEM_1))

        }


    companion object {
        private val TEST_LIST_ITEM_1 = ListItem(
            0, "", 12
        )

        private val TEST_LIST_ITEM_2 = ListItem(
            1, "", 10
        )

        private val TEST_LIST_ITEM_3 = ListItem(
            2, "", 13
        )
    }

}