package de.lolhens.resticui.ui.folders

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import de.lolhens.resticui.databinding.FragmentFoldersBinding

class FoldersFragment : Fragment() {

    private lateinit var foldersViewModel: FoldersViewModel
    private var _binding: FragmentFoldersBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        foldersViewModel =
            ViewModelProvider(this).get(FoldersViewModel::class.java)

        _binding = FragmentFoldersBinding.inflate(inflater, container, false)
        val root: View = binding.root

        //val textView = binding.listViewFolders
        val myArrayAdapter = ArrayAdapter<String>(
            requireContext(),
            R.layout.simple_list_item_1,
            (
                0..100
            ).map { it.toString() }.toTypedArray()
        )
        binding.listViewFolders.adapter = myArrayAdapter

        /*foldersViewModel.text.observe(viewLifecycleOwner, Observer {
            textView = it
        })*/
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}