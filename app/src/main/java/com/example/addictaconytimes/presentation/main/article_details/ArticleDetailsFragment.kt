package com.example.addictaconytimes.presentation.main.article_details

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.addictaconytimes.databinding.FragmentArticleDetailsBinding
import com.example.addictaconytimes.ViewModelProviderFactory
import com.example.addictaconytimes.BR
import com.example.addictaconytimes.R
import com.example.addictaconytimes.presentation.base.BaseFragment
import com.example.addictaconytimes.presentation.base.BaseFragmentWitOutViewModel
import com.example.addictaconytimes.presentation.main.MainActivity
import com.example.addictaconytimes.presentation.main.article.ArticleDataItem
import com.example.addictaconytimes.utils.AppConstants
import com.example.addictaconytimes.utils.BindingUtils.setImageUrl
import javax.inject.Inject

class ArticleDetailsFragment :
    BaseFragmentWitOutViewModel<FragmentArticleDetailsBinding>(R.layout.fragment_article_details) {
    private var articleDataItem: ArticleDataItem? = null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (arguments != null) {
            articleDataItem = arguments?.getParcelable(AppConstants.ARTICLE)
            setImageUrl(dataBinding.coverImageView, articleDataItem?.imageUrl)
            dataBinding.titleTextView.text = articleDataItem?.title
            dataBinding.authorTextView.text = articleDataItem?.byline
            dataBinding.contentTextView.text = articleDataItem?.abstractX
            dataBinding.dateTextView.text = articleDataItem?.publishedDate
            dataBinding.urlTextView.text = articleDataItem?.url


        }
    }


}