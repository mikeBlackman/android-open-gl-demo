
package opengltest.opengltest

import android.app.Activity
import android.os.Bundle

class MainActivity : Activity() {

    private lateinit var mGLView: MyGLSurfaceView

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create a GLSurfaceView instance and set it
        // as the ContentView for this Activity.
        mGLView = MyGLSurfaceView(this)
        setContentView(mGLView)
    }

}
