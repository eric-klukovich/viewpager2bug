package com.eklukovich.viewpager2bug

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.DialogFragment

class DemoDialogFragment : DialogFragment() {

    companion object {
        fun newInstance() = DemoDialogFragment()
    }

    interface DemoListener {
        fun onListenerCalled()
    }

    private var listener: DemoListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("DemoDialogFragment", "Has Target Fragment: ${targetFragment != null}")
        listener = targetFragment as DemoListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_TITLE, R.style.AppTheme)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.demo_dialog_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        view.findViewById<Button>(R.id.call_listener_button).setOnClickListener {
            listener?.onListenerCalled()
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}