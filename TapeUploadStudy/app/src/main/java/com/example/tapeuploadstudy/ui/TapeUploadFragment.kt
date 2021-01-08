package com.example.tapeuploadstudy.ui

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.example.tapeuploadstudy.ui.base.BaseFragment


/**
 * A simple [Fragment] subclass.
 * Use the [TapeUploadFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TapeUploadFragment : BaseFragment() {
    @LayoutRes
    override fun getLayoutResourceId() = R.layout.fragment_tape_upload
}