package com.example.mytestapplication.ui.gallery

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mytestapplication.databinding.FragmentGalleryBinding
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Observer
import io.reactivex.rxjava3.disposables.Disposable
import java.util.*
import java.util.Objects as Objects1

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    var mList = mutableListOf<Int>(1,2,3,4,5,6,7,8,9,10,11,12,13)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val galleryViewModel =
            ViewModelProvider(this).get(GalleryViewModel::class.java)

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.textGallery
        galleryViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val observable = Observable.just(1,2,3,4) // max 10 items can observe

        var observer = object : Observer<Int>{
            override fun onSubscribe(d: Disposable) {

                Log.e("onSubscribe","$d")
            }

            override fun onNext(t: Int) {
                Log.e("onNext","$t")
            }

            override fun onError(e: Throwable) {
                Log.e("onError","$e")
            }

            override fun onComplete() {
                Log.e("onComplete","")
            }

        }

        observable.subscribe(observer)

        var listObservable = Observable.just(mList)
        var listObserver = object : Observer<List<Int>>{
            override fun onSubscribe(d: Disposable) {

            }

            override fun onNext(t: List<Int>) {
                Log.e("onNextList","$t")
            }

            override fun onError(e: Throwable) {

            }

            override fun onComplete() {
                Log.e("onCompleteList","")

            }

        }

        listObservable.subscribe(listObserver)


        var operators = Operators()
        operators.fromOperator()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}