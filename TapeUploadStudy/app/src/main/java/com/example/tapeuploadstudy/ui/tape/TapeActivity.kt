package com.example.tapeuploadstudy.ui.tape

import android.app.Activity
import android.content.Intent
import com.example.tapeuploadstudy.ui.TapeUploadFragment
import com.example.tapeuploadstudy.ui.base.BaseActivity

class TapeActivity: BaseActivity(){
    private var mTapeUploadFragment: TapeUploadFragment? = null

    private fun goToUpload() {
        mTapeUploadFragment = findOrCreateFragment(TapeUploadFragment::class.java)
    }


}