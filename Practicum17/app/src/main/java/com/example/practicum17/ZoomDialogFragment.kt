package com.example.practicum17

import android.app.Dialog
import android.graphics.Bitmap
import android.graphics.Matrix
import android.os.Bundle
import androidx.fragment.app.DialogFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.practicum17.databinding.FragmentZoomDialogBinding
import java.io.File

class ZoomDialogFragment : DialogFragment() {

    private var _binding: FragmentZoomDialogBinding? = null
    private val binding get() = _binding!!

    private var photoFileName: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentZoomDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val photoFile = photoFileName?.let {
            File(requireContext().applicationContext.filesDir, it)
        }

        if (photoFile?.exists() == true) {
            val originalBitmap = getScaledBitmap(photoFile.path, binding.zoomedPhoto.width, binding.zoomedPhoto.height)
            val zoomedBitmap = zoomBitmap(originalBitmap, 2f) // Zoom by 2x
            binding.zoomedPhoto.setImageBitmap(zoomedBitmap)
        }

        binding.closeButton.setOnClickListener {
            dismiss()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val ARG_PHOTO_FILE_NAME = "photo_file_name"

        fun newInstance(photoFileName: String): ZoomDialogFragment {
            val args = Bundle().apply {
                putString(ARG_PHOTO_FILE_NAME, photoFileName)
            }
            return ZoomDialogFragment().apply {
                arguments = args
            }
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        photoFileName = arguments?.getString(ARG_PHOTO_FILE_NAME)
        return super.onCreateDialog(savedInstanceState)
    }

    private fun zoomBitmap(bitmap: Bitmap, scaleFactor: Float): Bitmap {
        val width = bitmap.width
        val height = bitmap.height
        val matrix = Matrix().apply {
            postScale(scaleFactor, scaleFactor)
        }
        return Bitmap.createBitmap(bitmap, 0, 0, width, height, matrix, true)
    }
}
