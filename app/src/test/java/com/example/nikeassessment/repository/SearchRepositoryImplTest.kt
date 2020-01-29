package com.example.nikeassessment.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.nikeassessment.model.ListItem
import com.example.nikeassessment.model.SearchResponse
import com.example.nikeassessment.service.SearchService
import com.google.common.truth.Truth
import io.mockk.MockKAnnotations
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Response

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class SearchRepositoryImplTest {


    @get:Rule
    var instatTaskExecutorRule = InstantTaskExecutorRule()

    @MockK
    lateinit var searchService: SearchService

    lateinit var searchRepository: SearchRepository

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        searchRepository = SearchRepositoryImpl(searchService)
    }

    @After
    fun cleanUp() {
        clearAllMocks()
    }

    @Test
    fun `getServiceResponse should return return list of items when api call is successfull`() =
        runBlockingTest {

            coEvery { searchService.getSearchResults("") } returns Response.success(
                TEST_SEARCH_RESPONSE
            )
            searchRepository.getServiceResponse("")
            Truth.assertThat(TEST_SEARCH_RESPONSE)
        }

    companion object {
        private val TEST_LIST_ITEM_1 = ListItem(
            0, listOf(), 12, "james", "12-09-1992", "", "", 11, "", "", ""
        )

        private val TEST_LIST_ITEM_2 = ListItem(
            1, listOf(), 10, "aurthur", "12-09-1992", "", "", 16, "", "", ""
        )

        private val TEST_SEARCH_RESPONSE =
            SearchResponse(listOf(TEST_LIST_ITEM_1, TEST_LIST_ITEM_2))
    }

}