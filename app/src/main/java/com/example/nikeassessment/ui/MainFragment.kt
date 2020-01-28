package com.example.nikeassessment.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.SearchView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.nikeassessment.R
import com.example.nikeassessment.model.ListItem
import com.example.nikeassessment.ui.adapter.SearchResultsAdapter
import com.example.nikeassessment.viewmodel.SearchViewModel

class MainFragment : Fragment(),SearchView.OnQueryTextListener {

    lateinit var recyclerView: RecyclerView

    lateinit var searchView:SearchView

    lateinit var viewModel: SearchViewModel

    lateinit var searchAdapter: SearchResultsAdapter

    lateinit var progressContainer : ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        searchView =  view.findViewById(R.id.searchView)
        progressContainer = view.findViewById(R.id.progressContainer)
        searchView.setOnQueryTextListener(this)
        recyclerView = view.findViewById(R.id.recyclerView)
        searchAdapter = SearchResultsAdapter(ArrayList())
        recyclerView.adapter = searchAdapter
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)

        setHasOptionsMenu(true)

        setUpObservers()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.sorting_menu_options,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.sortByThumbsUp -> {viewModel.sortByThumbsUp()}
            R.id.sortByThumbsDown ->{viewModel.sortByThumbsDown()}
        }
        return super.onOptionsItemSelected(item)
    }


    fun setUpObservers(){
       viewModel.searchResults.observe(this, Observer {
           showResult()
           it?.let {
              searchAdapter.updateSearchList(it)
           }
       })
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrBlank()){
            showProgress()
            viewModel.getSearchResults(query)
        }else{
            recyclerView.removeAllViewsInLayout()
        }
        return false
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        if (!newText.isNullOrBlank()){
            showProgress()
            viewModel.getSearchResults(newText)
        }else{
            recyclerView.removeAllViewsInLayout()
        }
        return false
    }

    fun showProgress(){
        recyclerView.isVisible = false
        progressContainer.isVisible = true
    }

    fun showResult(){
        recyclerView.isVisible = true
        progressContainer.isVisible = false
    }

}
