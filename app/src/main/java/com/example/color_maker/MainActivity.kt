package com.example.color_maker

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.SeekBar
import android.widget.Switch
import android.widget.Toast
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    // ColorValue will store the RGB value
    var ColorValue = intArrayOf(0, 0, 0)

    // tvColor will change the color
    var tvColor: TextView? = null

    // following variables will store the state of switch, initially will be false
    var sw1set: Boolean = false
    var sw2set: Boolean = false
    var sw3set: Boolean = false

    // following variables will store each value of Red Green & Blue
    var c1: Int = 0
    var c2: Int = 0
    var c3: Int = 0

    // if edittext block is clicked then textval will be set to true
    var textval = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // storing each id of switches to variables
        var sw1 = findViewById<Switch>(R.id.sw_One)
        var sw2 = findViewById<Switch>(R.id.sw_Two)
        var sw3 = findViewById<Switch>(R.id.sw_Three)
        // for edittext
        var txt1 = findViewById<EditText>(R.id.tv_0)
        var txt2 = findViewById<EditText>(R.id.tv_1)
        var txt3 = findViewById<EditText>(R.id.tv_2)
        // storing the id of reset button to rst variable
        var rst: Button = findViewById(R.id.button)
        // if reset button is clicked then switches state will be set to false
        rst.setOnClickListener(View.OnClickListener {
            sw1.isChecked = false
            sw2.isChecked = false
            sw3.isChecked = false
            sw1set = false
            sw2set = false
            sw3set = false
        })
        // adding text changed listener for first text block
        txt1.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                // if the value is null then the default value will be set to zero
                try{
                    lateinit var v: String
                    v = s.toString()
                    if (v == null){
                        c1 = 0
                        tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                        textval = true
                        val myID = "sb_0"
                        val resID = resources.getIdentifier(myID, "id", packageName)
                        val mySeekBar = findViewById<View>(resID) as SeekBar
                        mySeekBar.setProgress(c1)
                        mySeekBar.setOnSeekBarChangeListener(myListener)
                    }
                    else{
                        var cone = v.toFloat()
                        if (cone > 1.0){
                            val text = R.string.text
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(applicationContext,text,duration)
                            toast.show()
                        }
                        else{
                            cone *= 255
                            c1 = cone.toInt()
                            tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                            textval = true
                            val myID = "sb_0"
                            val resID = resources.getIdentifier(myID, "id", packageName)
                            val mySeekBar = findViewById<View>(resID) as SeekBar
                            mySeekBar.setProgress(c1)
                            mySeekBar.setOnSeekBarChangeListener(myListener)
                        }
                    }
                }
                catch (e: Exception){
                    // do nothing
                }
            }
        })
        // adding text changed listener for first text block
        txt2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                // if the value is null then the default value will be set to zero
                try{
                    lateinit var v: String
                    v = s.toString()
                    if (v == null){
                        c2 = 0
                        tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                        textval = true
                        val myID = "sb_1"
                        val resID = resources.getIdentifier(myID, "id", packageName)
                        val mySeekBar = findViewById<View>(resID) as SeekBar
                        mySeekBar.setProgress(c2)
                        mySeekBar.setOnSeekBarChangeListener(myListener)
                    }
                    else{
                        var cone = v.toFloat()
                        if (cone > 1.0){
                            val text = R.string.text
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(applicationContext,text,duration)
                            toast.show()
                        }
                        else{
                            cone *= 255
                            c2 = cone.toInt()
                            tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                            textval = true
                            val myID = "sb_1"
                            val resID = resources.getIdentifier(myID, "id", packageName)
                            val mySeekBar = findViewById<View>(resID) as SeekBar
                            mySeekBar.setProgress(c2)
                            mySeekBar.setOnSeekBarChangeListener(myListener)
                        }
                    }
                }
                catch (e: Exception){
                    // do nothing
                }
            }
        })
        // adding text changed listener for first text block
        txt3.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
            }
            override fun beforeTextChanged(
                s: CharSequence, start: Int,
                count: Int, after: Int
            ) {
            }
            override fun onTextChanged(
                s: CharSequence, start: Int,
                before: Int, count: Int
            ) {
                try{
                    // if the value is null then the default value will be set to zero
                    lateinit var v: String
                    v = s.toString()
                    if (v == null){
                        c3 = 0
                        tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                        textval = true
                        val myID = "sb_2"
                        val resID = resources.getIdentifier(myID, "id", packageName)
                        val mySeekBar = findViewById<View>(resID) as SeekBar
                        mySeekBar.setProgress(c3)
                        mySeekBar.setOnSeekBarChangeListener(myListener)
                    }
                    else{
                        var cone = v.toFloat()
                        if (cone > 1.0){
                            val text = R.string.text
                            val duration = Toast.LENGTH_LONG
                            val toast = Toast.makeText(applicationContext,text,duration)
                            toast.show()
                        }
                        else{
                            cone *= 255
                            c3 = cone.toInt()
                            tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
                            textval = true
                            val myID = "sb_2"
                            val resID = resources.getIdentifier(myID, "id", packageName)
                            val mySeekBar = findViewById<View>(resID) as SeekBar
                            mySeekBar.setProgress(c3)
                            mySeekBar.setOnSeekBarChangeListener(myListener)
                        }
                    }
                }
                catch (e: Exception){
                    // do nothing
                }
            }
        })
        // if switch one is set to false then red seekbar will be disabled
        if (!sw1set) {
            val myID = "sb_0"
            val resID = resources.getIdentifier(myID, "id", packageName)
            val mySeekBar = findViewById<View>(resID) as SeekBar
            mySeekBar.isEnabled = false
            txt1.isEnabled = false
        }
        // if switch two is set to false then green seekbar will be disabled
        if (!sw2set) {
            val myID = "sb_1"
            val resID = resources.getIdentifier(myID, "id", packageName)
            val mySeekBar = findViewById<View>(resID) as SeekBar
            mySeekBar.isEnabled = false
            txt2.isEnabled = false
        }
        // if switch one is set to false then blue seekbar will be disabled
        if (!sw3set) {
            val myID = "sb_2"
            val resID = resources.getIdentifier(myID, "id", packageName)
            val mySeekBar = findViewById<View>(resID) as SeekBar
            mySeekBar.isEnabled = false
            txt3.isEnabled = false
        }
        // setting change listener for switch 1
        sw1?.setOnCheckedChangeListener { _, isChecked ->
            // if switch 1 is on then red seekbar is enabled
            if (isChecked) {
                sw1set = true
                val myID = "sb_0"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = true
                txt1.isEnabled = true
                mySeekBar.setOnSeekBarChangeListener(myListener)
            }
            // else red seekbar is disabled and value will be set to 0
            else {
                sw1set = false
                val myID = "sb_0"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = false
                mySeekBar.progress = 0
                txt1.isEnabled = false
                val tv_name = "tv_0"
                val resId = resources.getIdentifier(tv_name, "id", packageName)
                val my_tv = findViewById(resId) as TextView
                my_tv.text = "" + 0
            }
        }
        // setting change listener for switch 2
        sw2?.setOnCheckedChangeListener { _, isChecked ->
            // if switch 2 is on then green seekbar is enabled
            if (isChecked) {
                sw2set = true
                val myID = "sb_1"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = true
                txt2.isEnabled = true
                mySeekBar.setOnSeekBarChangeListener(myListener)
            }
            // else green seekbar is disabled and value will be set to 0
            else {
                sw2set = false
                val myID = "sb_1"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = false
                mySeekBar.progress = 0
                txt2.isEnabled = false
                val tv_name = "tv_1"
                val resId = resources.getIdentifier(tv_name, "id", packageName)
                val my_tv = findViewById(resId) as TextView
                my_tv.text = "" + 0
            }
        }
        // setting change listener for switch 3
        sw3?.setOnCheckedChangeListener { _, isChecked ->
            // if switch 3 is on then blue seekbar is enabled
            if (isChecked) {
                sw3set = true
                val myID = "sb_2"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = true
                txt3.isEnabled = true
                mySeekBar.setOnSeekBarChangeListener(myListener)
            }
            // else blue seekbar is disabled and value will be set to 0
            else {
                sw3set = false
                val myID = "sb_2"
                val resID = resources.getIdentifier(myID, "id", packageName)
                val mySeekBar = findViewById<View>(resID) as SeekBar
                mySeekBar.isEnabled = false
                mySeekBar.progress = 0
                txt3.isEnabled = false
                val tv_name = "tv_2"
                val resId = resources.getIdentifier(tv_name, "id", packageName)
                val my_tv = findViewById(resId) as TextView
                my_tv.text = "" + 0
            }
        }
        // tvColor will store the id of TV color box
        tvColor = findViewById<TextView>(R.id.tv_ColorBox)

    }

    var myListener: SeekBar.OnSeekBarChangeListener = object : SeekBar.OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar, i: Int, b: Boolean) {
            if (textval == false){
                // sb_name will store the id of the seekbar which is changed
                val sb_name = resources.getResourceEntryName(seekBar.id)
                // split the sb_name to get the number of which the color to change
                val parts = sb_name.split("_".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
                ColorValue[Integer.parseInt(parts[parts.size - 1])] = i
                // if switch 1 state is true then c1 will store the intensity value of the red color
                if (sw1set) {
                    c1 = ColorValue[0]
                }
                // if switch 2 state is true then c2 will store the intensity value of the green color
                if (sw2set) {
                    c2 = ColorValue[1]
                }
                // if switch 3 state is true then c3 will store the intensity value of the blue color
                if (sw3set) {
                    c3 = ColorValue[2]
                }
                // if switch 1 state is false then c1 value will be 0
                if (!sw1set) {
                    c1 = 0
                }
                // if switch 2 state is false then c2 value will be 0
                if (!sw2set) {
                    c2 = 0
                }
                // if switch 3 state is false then c3 value will be 0
                if (!sw3set) {
                    c3 = 0
                }
                // tv_name will store the textview value for which we have to update intensity value
                val tv_name = "tv_" + parts[parts.size - 1]
                // get the resource id
                val resId = resources.getIdentifier(tv_name, "id", packageName)
                val my_tv = findViewById(resId) as TextView
                // convert the value to floating point number within the range 0 - 1
                my_tv.text = "" + (((i).toFloat() / 255 * 1000.0).roundToInt() / 1000.0)
                // change the color of the TextView
                tvColor?.setBackgroundColor(Color.argb(255, c1, c2, c3))
            }
           else
            {
                textval = false
            }
        }

        override fun onStartTrackingTouch(seekBar: SeekBar) {}

        // toast out which seekbar used
        override fun onStopTrackingTouch(seekBar: SeekBar) {}
    }  //end myListener
}