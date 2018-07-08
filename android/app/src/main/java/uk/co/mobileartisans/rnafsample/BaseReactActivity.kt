package uk.co.mobileartisans.rnafsample

import android.app.Application
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.react.ReactInstanceManager
import com.facebook.react.common.LifecycleState
import com.facebook.react.shell.MainReactPackage

abstract class BaseReactActivity : AppCompatActivity() {
    lateinit var reactInstanceManager: ReactInstanceManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initReactInstanceManager()
    }

    private fun initReactInstanceManager() {
        reactInstanceManager = ReactInstanceManager.builder()
                .setApplication(applicationContext as Application)
                .setBundleAssetName("index.android.js")
                .setJSMainModulePath("index.android")
                .addPackage(MainReactPackage())
                .setInitialLifecycleState(LifecycleState.RESUMED)
                .setUseDeveloperSupport(BuildConfig.DEBUG)
                .build()
    }

    override fun onResume() {
        super.onResume()
        reactInstanceManager.onHostResume(this)
    }

    override fun onPause() {
        super.onPause()
        reactInstanceManager.onHostPause(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        reactInstanceManager.onHostDestroy(this)
    }
}
