package com.udacity.shoestore.screens.shoeList
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.ActivityViewModel
import com.udacity.shoestore.MainActivity
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoelistBinding
import com.udacity.shoestore.databinding.ShoeLayoutBinding

class ShoelistFragment : Fragment() {

    private val viewModel by activityViewModels<ActivityViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding : FragmentShoelistBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_shoelist, container, false)

        binding.addItemButton.setOnClickListener{view: View ->
            Navigation.findNavController(view).navigate(ShoelistFragmentDirections.actionShoelistFragmentToDetailsFragment())
        }

        setHasOptionsMenu(true)
        binding.activityViewModel = viewModel


        viewModel.shoeList.observe(viewLifecycleOwner, Observer{ shoe_list ->
            if (shoe_list.size > 0) {
                shoe_list.forEach{latest_item->
                    val new_shoe_layout: ShoeLayoutBinding =
                        DataBindingUtil.inflate(
                            inflater, R.layout.shoe_layout, container, false)

                    new_shoe_layout.newItemShoeName.text = latest_item.name
                    new_shoe_layout.newItemCompany.text = latest_item.company
                    new_shoe_layout.newItemShoeSize.text = latest_item.size.toString()
                    new_shoe_layout.newItemDescription.text = latest_item.description

                    binding.mainLinearLayout.addView(new_shoe_layout.root)

              }
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }
}