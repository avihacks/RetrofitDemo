package com.example.mytestapplication.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinroomdemo.Utils.CommonMethods
import com.example.mytestapplication.R
import com.example.mytestapplication.databinding.FragmentHomeBinding
import com.example.mytestapplication.model.response.issues_response.IssuesResponseAll
import com.example.mytestapplication.utils.CustomProgressDialog
import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*


class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private lateinit var homeViewModel:HomeViewModel
    var listAdapter: ListAdapter? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

       // val textView: TextView = binding.textHome
      /*  homeViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }*/
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (CommonMethods.isOnline(requireContext())) {
            CustomProgressDialog.show(requireContext(), getString(R.string.loading))
            homeViewModel.getIssuesList()
            setobserver()
        }else{
            CommonMethods.showToast(requireContext(),"NO Internet Connection.")
        }
   
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setobserver() {
        homeViewModel.getList_MutableLiveResponse.observe(
            viewLifecycleOwner,
            Observer { response: List<IssuesResponseAll> ->
                CustomProgressDialog.dismissDialog()

               // AppLogger.errorLogs("ForgotPass Message", "" + response.issuesResponseAll?.get(0)?.body)

                listAdapter = ListAdapter(((response)))
                binding.recyclerview.layoutManager = LinearLayoutManager(context)
                binding.recyclerview.adapter = listAdapter
                listAdapter!!.notifyDataSetChanged()


            })

        homeViewModel.getErrorStringLiveData.observe(
            viewLifecycleOwner,
            Observer { errorString: String ->
                try {
                    CustomProgressDialog.dismissDialog()
                    Toast.makeText(context, "" + errorString, Toast.LENGTH_SHORT).show()
                }catch (e: Exception){

                }

            })
    }

}