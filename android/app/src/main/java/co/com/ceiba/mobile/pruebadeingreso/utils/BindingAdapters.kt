package co.com.ceiba.mobile.pruebadeingreso.utils

import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import co.com.ceiba.mobile.pruebadeingreso.domain.model.Post
import co.com.ceiba.mobile.pruebadeingreso.domain.model.User
import co.com.ceiba.mobile.pruebadeingreso.view.main.MainAdapter
import co.com.ceiba.mobile.pruebadeingreso.view.post.PostAdapter

@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<User>?) {
    val adapter = recyclerView.adapter as MainAdapter
    data?.let {
        adapter.submitList(data.toMutableList())
        recyclerView.smoothSnapToPosition(0)
    }

}

@BindingAdapter("listData")
fun bindRecyclerViewPost(recyclerView: RecyclerView, data: List<Post>?) {
    val adapter = recyclerView.adapter as PostAdapter
    data?.let {
        adapter.submitList(data.toMutableList())
    }
}

@BindingAdapter("isVisible")
fun bindProgressBarView(progressBar: ProgressBar, visible:Boolean) {
    progressBar.isVisible = visible
}