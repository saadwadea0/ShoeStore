package com.example.shoestore

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.shoestore.databinding.FragmentShoeListBinding
import com.example.shoestore.databinding.ItemShoeBinding
import com.example.shoestore.models.Shoe

class ShoeListFragment : Fragment() {


    private val viewModel by activityViewModels<ShoeListViewModel>()

    private lateinit var binding: FragmentShoeListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        setHasOptionsMenu(true)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.shoeList.observe(viewLifecycleOwner) {
            if (it.isNotEmpty()) {
                for (shoe in it) {
                    addShoe(shoe)
                }
            } else {
                Toast.makeText(requireContext(), "Empty List!", Toast.LENGTH_SHORT).show()
            }


        }
        binding.fabDetail.setOnClickListener {
            navigateTodDetailsFragment()

        }
    }

    // navigate from ShoeList to shoe details screen
    private fun navigateTodDetailsFragment() {
        findNavController().navigate(ShoeListFragmentDirections.actionShoeListFragmentToShoeDetailsFragment(null))
    }

    private fun addShoe(shoe: Shoe) {
        val itemBinding = ItemShoeBinding.inflate(LayoutInflater.from(context))
        itemBinding.apply {
            tvName.text = shoe.name
            tvSize.text = shoe.size
            tvCompany.text = shoe.company
            tvDescription.text = shoe.description
        }
        binding.linearLayout.addView(itemBinding.root)
    }

    /**
     * used to inflating menu to the activity and show it on the action bar
     * */
    @Deprecated("Deprecated in Java")
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.logout_menu, menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }


    /**
     * used to perform menu item on click listener
     */
    @Deprecated("Deprecated in Java")
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logout_item -> {
                val action = ShoeListFragmentDirections.actionShoeListFragmentToLoginFragment()
                findNavController().navigate(action)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}