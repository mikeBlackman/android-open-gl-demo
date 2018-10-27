package opengltest.opengltest

import android.content.Context
import android.opengl.GLSurfaceView
import android.view.MotionEvent

/**
 * Created by Mike Blackman on 25/10/18.
 */

private const val TOUCH_SCALE_FACTOR: Float = 180.0f / 320f

class MyGLSurfaceView(context: Context) : GLSurfaceView(context) {

    private var mPreviousX: Float = 0f
    private var mPreviousY: Float = 0f

    private val mRenderer: MyGLRenderer

    init {

        // Create an OpenGL ES 2.0 context.
        setEGLContextClientVersion(2)
        //fix for error No Config chosen, but I don't know what this does.
        //super.setEGLConfigChooser(8, 8, 8, 8, 16, 0)
        // Set the Renderer for drawing on the GLSurfaceView
        mRenderer = MyGLRenderer()
        setRenderer(mRenderer)

        // Render the view only when there is a change in the drawing data
        renderMode = GLSurfaceView.RENDERMODE_WHEN_DIRTY
    }


    override fun onTouchEvent(e: MotionEvent): Boolean {

        // MotionEvent reports input details from the touch screen
        // and other input controls. In this case, you are only
        // interested in events where the touch position changed.

        val x: Float = e.x
        val y: Float = e.y

        when (e.action) {
            MotionEvent.ACTION_MOVE -> {

                var dx: Float = x - mPreviousX
                var dy: Float = y - mPreviousY

                // reverse direction of rotation above the mid-line
                if (y > height / 2) {
                    dx *= -1
                }

                // reverse direction of rotation to left of the mid-line
                if (x < width / 2) {
                    dy *= -1
                }

                mRenderer.angle += (dx + dy) * TOUCH_SCALE_FACTOR
                requestRender()
            }
        }

        mPreviousX = x
        mPreviousY = y
        return true

    }

}
