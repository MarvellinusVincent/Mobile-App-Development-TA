package com.example.practicum20

import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.practicum20.databinding.FragmentCreateBinding
import com.example.practicum20.model.Post
import com.example.practicum20.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.runBlocking


private const val TAG = "CreateFragment"
class CreateFragment : Fragment() {
    private var _binding: FragmentCreateBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access binding because it is null."
        }
    private var photoUri: Uri? = null
    private var signedInUser: User? = null
    private lateinit var firestoreDb: FirebaseFirestore

    private val createPostViewModel: CreatePostViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentCreateBinding.inflate(inflater, container, false)
        firestoreDb = FirebaseFirestore.getInstance()
        val pickMedia = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
            if (uri != null) {
                Log.d(TAG, "Selected URI: $uri")
                photoUri = uri
                binding.imageView.setImageURI(uri)
            } else {
                Log.d(TAG, "No media selected")
            }
        }
        binding.btnPickImage.setOnClickListener {
            Log.i(TAG, "Open up image picker on device")
            pickMedia.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }
        binding.btnSubmit.setOnClickListener {
            Log.d(TAG, "Button clicked")
            saveThePost()
        }
        getTheCurrentUser()
        return binding.root
    }
    private fun getTheCurrentUser() {
        firestoreDb.collection("users")
            .document(FirebaseAuth.getInstance().currentUser?.uid as String)
            .get()
            .addOnSuccessListener { userSnapshot ->
                signedInUser = userSnapshot.toObject(User::class.java)
                Log.i(TAG, "signed in user: $signedInUser")
            }
            .addOnFailureListener { exception ->
                Log.i(TAG, "Failure fetching signed in user", exception)
            }
    }

    fun convertUriToBase64(uri: Uri?): String {
        val inputStream = context?.contentResolver?.openInputStream(uri!!)
        val bytes = inputStream?.readBytes()
        return Base64.encodeToString(bytes, Base64.DEFAULT)
    }

    private fun saveThePost() {
        val imageAsString = convertUriToBase64(photoUri)
        val fileName = "${System.currentTimeMillis()}-photo.jpg"

        val job = runBlocking {
            createPostViewModel
                .uploadImageToGitHub(imageAsString, fileName)
        }
        val imageUrl = PhotoRepository.get().getImageUrl(fileName)
        val post = Post(
            binding.etDescription.text.toString(),
            imageUrl,
            System.currentTimeMillis(),
            signedInUser
        )
        firestoreDb.collection("posts").add(post).addOnCompleteListener {
            this.findNavController().navigate(R.id.navigate_to_postsFragment)
        }
    }
}