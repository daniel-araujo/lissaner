package com.daniel_araujo.always_recording_microphone.android.ui

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.drawable.Drawable
import android.text.TextPaint
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.TextView
import androidx.core.content.res.use
import com.daniel_araujo.always_recording_microphone.DateFormatUtils
import com.daniel_araujo.always_recording_microphone.R

/**
 * TODO: document your custom view class.
 */
class ItemFileView : FrameLayout {

    private var _exampleColor: Int = Color.RED // TODO: use a default from R.color...
    private var _exampleDimension: Float = 0f // TODO: use a default from R.dimen...

    private var textPaint: TextPaint? = null
    private var textWidth: Float = 0f
    private var textHeight: Float = 0f

    /**
     * The name of the file.
     */
    var fileName: String? = "filename.wav"
        set(value) {
            field = value
            updateFilename()
        }

    /**
     * The timestamp of the file.
     */
    var fileTimestamp: Long? = null
        set(value) {
            field = value
            updateFileTimestamp()
        }

    constructor(context: Context) : super(context) {
        init(null, 0)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init(attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    ) {
        init(attrs, defStyle)
    }

    private fun init(attrs: AttributeSet?, defStyle: Int) {
        inflate(context, R.layout.view_item_file, this)

        // Load attributes
        context.obtainStyledAttributes(attrs, R.styleable.ItemFileView, defStyle, 0).use {
            fileName = it.getString(R.styleable.ItemFileView_fileName)

            if (it.hasValue(R.styleable.ItemFileView_fileTimestamp)) {
                fileTimestamp = it.getInteger(R.styleable.ItemFileView_fileTimestamp, 0).toLong()
            }
        }
    }

    fun updateFilename() {
        if (fileName != null) {
            findViewById<TextView>(R.id.file_name).text = fileName
        } else {
            findViewById<TextView>(R.id.file_name).text = "?"
        }
    }

    fun updateFileTimestamp() {
        if (fileTimestamp != null) {
            findViewById<TextView>(R.id.file_timestamp).text = DateFormatUtils.localeDateAndTime(fileTimestamp!!)
        } else {
            findViewById<TextView>(R.id.file_timestamp).text = ""
        }
    }
}
