package com.example.practicum20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.practicum20.databinding.FragmentPostsBinding
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch

private const val TAG = "PostsFragment"
class PostsFragment : Fragment() {
    private var _binding: FragmentPostsBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null."
        }

    private val postViewModel: PostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPostsBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Set up the toolbar and menu
        binding.toolbar.inflateMenu(R.menu.posts_menu)
        binding.toolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.action_logout -> {
                    FirebaseAuth.getInstance().signOut()
                    goToLoginScreen()
                    true
                }
                else -> false
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                postViewModel.posts.collect { posts ->
                    binding.rvPosts.adapter = PostsAdapter(posts)
                }
            }
        }

        val auth = FirebaseAuth.getInstance()
        if (auth.currentUser == null) {
            goToLoginScreen()
        }

        binding.fabCreate.setOnClickListener {
            this.findNavController().navigate(R.id.navigate_to_createFragment)
        }
    }
    private fun goToLoginScreen() {
        this.findNavController().navigate(R.id.navigateToLogin)
    }
}