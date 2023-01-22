package com.vrma.richtexteditor

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.vrma.krichtexteditor.fragments.KRichEditorFragment

class MainActivity : AppCompatActivity() {
    private lateinit var editorFragment: KRichEditorFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var rt = findViewById<RichTextEditor>(R.id.viewer)

        rt.initializeRt(supportFragmentManager, this)


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        Toast.makeText(applicationContext, resultCode, Toast.LENGTH_SHORT).show()
    }


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.content_java)
//
//        editorFragment = supportFragmentManager.findFragmentByTag("EDITOR") as KRichEditorFragment? ?:
//        kRichEditorFragment {
//            // This is just a demo for image action
//            imageButtonAction = { ImagePicker.create(this@MainActivity).start() }
//            placeHolder = "Write something cool..."
//
//            // Un-comment this line and comment out the layout below to disable the toolbar
//            // showToolbar = false
//
//            // This is relevant to the default layout (full mode)
//            // Customize to your needs
//            buttonsLayout = listOf(
//                    EditorButton.UNDO,
//                    EditorButton.REDO,
//                    EditorButton.IMAGE,
//                    EditorButton.LINK,
//                    EditorButton.BOLD,
//                    EditorButton.ITALIC,
//                    EditorButton.UNDERLINE,
//                    EditorButton.SUBSCRIPT,
//                    EditorButton.SUPERSCRIPT,
//                    EditorButton.STRIKETHROUGH,
//                    EditorButton.JUSTIFY_LEFT,
//                    EditorButton.JUSTIFY_CENTER,
//                    EditorButton.JUSTIFY_RIGHT,
//                    EditorButton.JUSTIFY_FULL,
//                    EditorButton.ORDERED,
//                    EditorButton.UNORDERED,
//                    EditorButton.CHECK,
//                    EditorButton.NORMAL,
//                    EditorButton.H1,
//                    EditorButton.H2,
//                    EditorButton.H3,
//                    EditorButton.H4,
//                    EditorButton.H5,
//                    EditorButton.H6,
//                    EditorButton.INDENT,
//                    EditorButton.OUTDENT,
//                    EditorButton.BLOCK_QUOTE,
//                    EditorButton.BLOCK_CODE,
//                    EditorButton.CODE_VIEW
//            )
//            onInitialized = {
//                // Simulate loading saved contents action
//                editorFragment.editor.setContents(
//                        Paper.book("demo").read("content", "")
//                )
//            }
//        }
//
//
//        supportFragmentManager
//                .beginTransaction()
//                .replace(R.id.fragment_holder, editorFragment, "EDITOR")
//                .commit()
//
//
//
//
//    }




//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        if (ImagePicker.shouldHandle(requestCode, resultCode, data)) {
//            val image = ImagePicker.getFirstImageOrNull(data)
//            if (image != null) {
//                // The second param (true/false) would not reflect BASE64 mode or not
//                // Normal URL mode would pass the URL
//                /*editorFragment.editor.command(IMAGE, false, "https://" +
//                        "beebom-redkapmedia.netdna-ssl.com/wp-content/uploads/2016/01/" +
//                        "Reverse-Image-Search-Engines-Apps-And-Its-Uses-2016.jpg")*/
//
//                // For BASE64, image file path would be passed instead
//                editorFragment.editor.command(IMAGE, true, image.path)
//            }
//        }
//        super.onActivityResult(requestCode, resultCode, data)
//    }

//    override fun onPause() {
//        // Simulate saving action
//        editorFragment.editor.getContents { content -> Paper.book("demo").write("content", content) }
//        super.onPause()
//    }

}
