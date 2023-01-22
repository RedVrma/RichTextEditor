package com.vrma.richtexteditor

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout
import androidx.fragment.app.FragmentManager
import com.vrma.krichtexteditor.fragments.KRichEditorFragment
import com.vrma.krichtexteditor.fragments.kRichEditorFragment
import com.vrma.krichtexteditor.ui.widgets.EditorButton
import com.esafirm.imagepicker.features.ImagePicker
import io.paperdb.Paper

class RichTextEditor(context: Context, attrs: AttributeSet?) : FrameLayout(context, attrs) {

    private lateinit var editorFragment: KRichEditorFragment

    private lateinit var supportFragmentManager:FragmentManager

    fun initializeRt(fragmentManager: FragmentManager, activity: Activity) {
        this.supportFragmentManager = fragmentManager

        editorFragment = supportFragmentManager.findFragmentByTag("EDITOR") as KRichEditorFragment? ?:
                kRichEditorFragment {
                    // This is just a demo for image action
                    imageButtonAction = { ImagePicker.create(activity).start() }
                    placeHolder = "Write something cool..."

                    // Un-comment this line and comment out the layout below to disable the toolbar
                    // showToolbar = false

                    // This is relevant to the default layout (full mode)
                    // Customize to your needs
                    buttonsLayout = listOf(
                        EditorButton.UNDO,
                        EditorButton.REDO,
                        EditorButton.IMAGE,
                        EditorButton.LINK,
                        EditorButton.BOLD,
                        EditorButton.ITALIC,
                        EditorButton.UNDERLINE,
                        EditorButton.SUBSCRIPT,
                        EditorButton.SUPERSCRIPT,
                        EditorButton.STRIKETHROUGH,
                        EditorButton.JUSTIFY_LEFT,
                        EditorButton.JUSTIFY_CENTER,
                        EditorButton.JUSTIFY_RIGHT,
                        EditorButton.JUSTIFY_FULL,
                        EditorButton.ORDERED,
                        EditorButton.UNORDERED,
                        EditorButton.CHECK,
                        EditorButton.NORMAL,
                        EditorButton.H1,
                        EditorButton.H2,
                        EditorButton.H3,
                        EditorButton.H4,
                        EditorButton.H5,
                        EditorButton.H6,
                        EditorButton.INDENT,
                        EditorButton.OUTDENT,
                        EditorButton.BLOCK_QUOTE,
                        EditorButton.BLOCK_CODE,
                        EditorButton.CODE_VIEW
                    )
                    onInitialized = {
                        // Simulate loading saved contents action
                        editorFragment.editor.setContents(
                            Paper.book("demo").read("content", "")
                        )
                    }
                }

        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragment_holder, editorFragment, "EDITOR")
                .commit()
    }

    init {
        View.inflate(context,R.layout.rich_text_editor,this)
    }


}