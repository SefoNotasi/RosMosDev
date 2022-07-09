package ru.notasi.rosmosdev

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import ru.notasi.rosmosdev.utils.Debugger

/**
 * https://stackoverflow.com/questions/31297246/activity-appcompatactivity-fragmentactivity-and-actionbaractivity-when-to-us
 *
 * https://stackoverflow.com/a/31297559
 * So basically, using AppCompatActivity is always the right choice.
 * The differences between them are:
 * • Activity is the basic one.
 * • Based on Activity, FragmentActivity provides the ability to use Fragment.
 * • Based on FragmentActivity, AppCompatActivity provides features to ActionBar.
 *
 * https://stackoverflow.com/a/39302338
 * Android Documentation recommends using AppCompatActivity if you are using an App Bar.
 */

abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

    /**
     * Activity lifecycle callbacks.
     *
     * Launch app:
     * onCreate > onStart > onResume
     *
     * Press home / tasks:
     * onPause > onSaveInstanceState > onStop
     *
     * Back from tasks:
     * onRestart > onStart > onResume
     *
     * Rotate device:
     * onConfigurationChanged > onPause > onSaveInstanceState > onStop > onDestroy > onCreate > onStart > onRestoreInstanceState > onResume
     *
     * Back press (on last (main) activity):
     * onBackPressed > onPause > onStop > onDestroy
     */

    private companion object {
        private val className = MainActivity::class.java.simpleName
    }

    /**
     * https://stackoverflow.com/a/68338728
     * How using ViewBinding with an abstract base class.
     */

    protected lateinit var binding: VB

    abstract fun inflateLayout(inflater: LayoutInflater): VB

    /**
     * Called when the activity is first created.
     * This is where you should do all of your normal static set up: create views, bind data to lists, etc.
     * This method also provides you with a Bundle containing the activity's previously frozen state,
     * if there was one. Always followed by onStart().
     *
     * onCreate
     */

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )

        binding = inflateLayout(inflater = layoutInflater)
        setContentView(binding.root)
    }

    /**
     * This hook is called whenever the content view of the screen changes
     * (due to a call to Window.setContentView or Window.addContentView).
     */

    override fun onContentChanged() {
        super.onContentChanged()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called after your activity has been stopped, prior to it being started again.
     * Always followed by onStart()
     *
     * onCreate > onRestart (> onStart)
     */

    override fun onRestart() {
        super.onRestart()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called when the activity is becoming visible to the user.
     * Followed by onResume() if the activity comes to the foreground.
     *
     * onCreate (> onRestart) > onStart
     */

    override fun onStart() {
        super.onStart()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * This method is called after onStart() when the activity is being re-initialized from a previously saved state,
     * given here in savedInstanceState.
     */

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called when the activity will start interacting with the user.
     * At this point your activity is at the top of the activity stack, with user input going to it.
     * Always followed by onPause().
     *
     * onCreate (> onRestart) > onStart > onResume
     */

    override fun onResume() {
        super.onResume()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
        return super.onCreateOptionsMenu(menu)
    }

    override fun onPrepareOptionsMenu(menu: Menu): Boolean {
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
        return super.onPrepareOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
        return super.onOptionsItemSelected(item)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called as part of the activity lifecycle when an activity is going into the background, but has not (yet) been killed.
     * The counterpart to onResume(). When activity B is launched in front of activity A, this callback will be invoked on A.
     * B will not be created until A's onPause() returns, so be sure to not do anything lengthy here.
     *
     * onCreate (> onRestart) > onStart > onResume > onPause
     */

    override fun onPause() {
        super.onPause()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called to retrieve per-instance state from an activity before being killed
     * so that the state can be restored in onCreate(Bundle) or onRestoreInstanceState(Bundle)
     * (the Bundle populated by this method will be passed to both).
     *
     * This method is called before an activity may be killed
     * so that when it comes back some time in the future it can restore its state.
     * For example, if activity B is launched in front of activity A,
     * and at some point activity A is killed to reclaim resources,
     * activity A will have a chance to save the current state of its user interface via this method
     * so that when the user returns to activity A,
     * the state of the user interface can be restored via onCreate(Bundle) or onRestoreInstanceState(Bundle).
     */

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * Called when you are no longer visible to the user.
     * You will next receive either onRestart(), onDestroy(), or nothing, depending on later user activity.
     * Note that this method may never be called,
     * in low memory situations where the system does not have enough memory to keep your activity's
     * process running after its onPause() method is called.
     *
     * onCrate (> onRestart) > onStart > onResume > onPause > onStop
     */

    override fun onStop() {
        super.onStop()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    /**
     * The final call you receive before your activity is destroyed.
     * This can happen either because the activity is finishing (someone called finish() on it,
     * or because the system is temporarily destroying this instance of the activity to save space.
     * You can distinguish between> these two scenarios with the isFinishing() method.
     *
     * onCreate (> onRestart) > onStart > onResume > onPause > onStop > onDestroy
     */

    override fun onDestroy() {
        super.onDestroy()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Debugger.log(
            threadName = Thread.currentThread().name,
            className = className,
            methodName = object {}.javaClass.enclosingMethod?.name
        )
    }

}