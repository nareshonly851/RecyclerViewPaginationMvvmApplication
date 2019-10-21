package com.demomvvmapplication.gif


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.demomvvmapplication.R
import com.demomvvmapplication.data.network.model.Result
import com.demomvvmapplication.util.PaginationScrollListener
import com.mvvmdemo.util.Coroutines
import com.mvvmdemo.util.hide
import com.mvvmdemo.util.show
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.ViewHolder
import kotlinx.android.synthetic.main.activity_main.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.kodein
import org.kodein.di.generic.instance

class MainActivity : AppCompatActivity(), KodeinAware {


    override val kodein by kodein()

    private val fact: GifViewModelFactory by instance()
    private lateinit var viewModel: GifViewModel

    var isLastPage: Boolean = false
    var isLoading: Boolean = false

    val arrayList = ArrayList<Result>()

    var mAdapter = GroupAdapter<ViewHolder>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        viewModel = ViewModelProviders.of(this, fact).get(GifViewModel::class.java)



        mAdapter.apply {
            addAll(arrayList.toQuoteItem())
        }

        rv_quotes.apply {
            layoutManager = LinearLayoutManager(context)
            setHasFixedSize(true)
            adapter = mAdapter
        }




        bindUI()

        initRecycleview()


    }


    private fun bindUI() = Coroutines.main {
        pb_loading.show()
        viewModel.gif.await()?.observe(this, Observer {
            pb_loading.hide()

            addData(it)



        })

    }

    private fun initRecycleview() {


        rv_quotes?.addOnScrollListener(object :
            PaginationScrollListener(rv_quotes.layoutManager as LinearLayoutManager) {
            override fun isLastPage(): Boolean {
                return isLastPage
            }

            override fun isLoading(): Boolean {
                return isLoading
            }

            override fun loadMoreItems() {
                isLoading = true
                //you have to call loadmore items to get more data
                viewModel.pagging()
                bindUI()


            }
        })

    }

    private fun List<Result>.toQuoteItem(): List<GifItem> {
        return this.map {
            GifItem(it)
        }
    }

    fun addData(listItems:  List<Result>) {
        var size = this.arrayList.size
        this.arrayList.addAll(listItems)
        var sizeNew = this.arrayList.size

        mAdapter.apply {
            addAll(arrayList.toQuoteItem())
        }

        mAdapter.notifyItemRangeChanged(size, sizeNew)
    }


}
