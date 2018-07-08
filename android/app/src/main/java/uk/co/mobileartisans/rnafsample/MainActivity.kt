package uk.co.mobileartisans.rnafsample

import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseReactActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        reactRootView.startReactApplication(reactInstanceManager, "Home")
    }
}
