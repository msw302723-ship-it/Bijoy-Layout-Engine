package com.bijoy.engine;

import android.inputmethodservice.InputMethodService;
import android.view.KeyEvent;
import android.view.inputmethod.InputConnection;

public class BijoyService extends InputMethodService {

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        InputConnection ic = getCurrentInputConnection();
        if (ic == null) return super.onKeyDown(keyCode, event);

        int unicode = event.getUnicodeChar();
        if (unicode == 0) return super.onKeyDown(keyCode, event);

        char c = (char) unicode;

        // বিজয় ৫২ এর কি-ম্যাপিং লজিক
        switch (c) {
            case 'j': ic.commitText("ক", 1); return true;
            case 'd': ic.commitText("ি", 1); return true;
            case 'g': ic.commitText("্", 1); return true;
            case 'a': ic.commitText("ৃ", 1); return true;
            case 'r': ic.commitText("ত", 1); return true;
            case 's': ic.commitText("ব", 1); return true;
            case 'n': ic.commitText("স", 1); return true;
            case 'k': ic.commitText("ল", 1); return true;
            case 'i': ic.commitText("হ", 1); return true;
            case 'f': ic.commitText("অ", 1); return true;
            // আপনি চাইলে পরে এখানে আরও অক্ষর যোগ করতে পারবেন
        }

        // যদি উপরের অক্ষরের সাথে না মেলে, তবে সাধারণ টাইপিং হবে
        return super.onKeyDown(keyCode, event);
    }
}
