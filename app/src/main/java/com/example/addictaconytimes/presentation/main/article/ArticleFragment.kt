package com.example.addictaconytimes.presentation.main.article

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.addictaconytimes.ViewModelProviderFactory
import com.example.addictaconytimes.BR
import com.example.addictaconytimes.R
import com.example.addictaconytimes.databinding.FragmentArticleBinding
import com.example.addictaconytimes.presentation.base.BaseFragment
import com.example.addictaconytimes.presentation.base.NavigationCommand
import com.example.addictaconytimes.presentation.main.MainActivity
import javax.inject.Inject

class ArticleFragment : BaseFragment<FragmentArticleBinding, ArticleViewModel>(),
    ArticleAdapterListener {
    @Inject
    lateinit var factory: ViewModelProviderFactory
    private lateinit var articleAdapter: ArticleAdapter

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_article

    override val viewModel: ArticleViewModel
        get() = ViewModelProvider(
            this,
            factory
        ).get(ArticleViewModel::class.java)

    override fun onRetryClick() {
        viewModel.fetchArticles(7)
    }

    override fun onItemClick(item: ArticleDataItem) {
        navigate(
            NavigationCommand.To(
                ArticleFragmentDirections.toArticleDetailsFragment(
                    item
                )
            )
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        articleAdapter = ArticleAdapter(arrayListOf(), this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUp()
    }

    private fun setUp() {
        if (activity != null) (activity as MainActivity).setSupportActionBar(
            getViewDataBinding().toolbar
        )
        setHasOptionsMenu(true)
        setUpRecyclerView()
    }

    private fun setUpRecyclerView() {
        getViewDataBinding().resultsBeanRecyclerView.layoutManager = LinearLayoutManager(activity)
        getViewDataBinding().resultsBeanRecyclerView.itemAnimator = DefaultItemAnimator()
        getViewDataBinding().resultsBeanRecyclerView.adapter = articleAdapter
    }

}