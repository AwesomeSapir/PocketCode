package com.bearsandflags.pocketcode;

import android.content.Context;
import android.graphics.Color;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Sapir on 15/09/05.
 */
public class Note {

    String title;
    String code;
    int lang;
    ImageButton btn;

    public ImageButton getBtn() {
        return btn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getLang() {
        return lang;
    }

    public void setLang(int lang) {
        this.lang = lang;
    }

    public Note(Context context) {
        this.title = "Title";
        this.code = "Insert code here.";
        this.lang = 0;
        btn =new ImageButton(context);
        btn.setImageResource(R.drawable.note_def);
        btn.setScaleType(ImageView.ScaleType.FIT_XY);
        btn.setBackgroundColor(Color.TRANSPARENT);
    }
}
