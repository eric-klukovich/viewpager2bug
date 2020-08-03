package com.eklukovich.viewpager2bug

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment

class DemoFragment : Fragment(R.layout.demo_fragment),
    DemoDialogFragment.DemoListener {

    companion object {
        private const val ARG_POSITION = "arg_position"

        fun newInstance(position: Int): DemoFragment {
            return DemoFragment().apply {
                arguments = bundleOf(ARG_POSITION to position)
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<TextView>(R.id.position_text).apply {
            text = "Position: ${requireArguments().getInt(ARG_POSITION)}"
        }

        view.findViewById<Button>(R.id.launch_dialog_fragment_button).setOnClickListener {
            val dialog = DemoDialogFragment.newInstance()
            dialog.setTargetFragment(this, 0)
            dialog.show(parentFragmentManager, "")
        }
    }

    override fun onListenerCalled() {
        Toast.makeText(requireContext(), "Listener Called", Toast.LENGTH_SHORT).show()
    }
}