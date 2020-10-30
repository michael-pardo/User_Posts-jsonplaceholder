package co.com.ceiba.mobile.pruebadeingreso.view.main

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener
import androidx.databinding.DataBindingUtil
import co.com.ceiba.mobile.pruebadeingreso.R
import co.com.ceiba.mobile.pruebadeingreso.databinding.ActivityMainBinding
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.utils.NavargId
import co.com.ceiba.mobile.pruebadeingreso.view.post.PostActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        val adapter = MainAdapter{
            goToDetail(it)
        }

        binding.recyclerViewSearchResults.adapter = adapter
        binding.editTextSearch.addTextChangedListener {
            if (!it.isNullOrEmpty()){
                viewModel.searchUsersByName(it.toString())
            }

        }


        val emptyView = LayoutInflater.from(this).inflate(R.layout.empty_view, null, false)
        binding.constraint.addView(emptyView)
        viewModel.emptyList.observe(this,{
            emptyList(it, emptyView)
        })


    }


    fun emptyList(isEmptyList: Boolean, emptyView:View){
        if (isEmptyList){
            emptyView.visibility = View.VISIBLE
        }else emptyView.visibility = View.GONE
    }

    fun goToDetail(user: User){
        val intent = Intent(this, PostActivity::class.java)
        intent.putExtra(NavargId.userId.name, user.id)
        startActivity(intent)
    }

    override fun onStart() {
        super.onStart()
    }
}