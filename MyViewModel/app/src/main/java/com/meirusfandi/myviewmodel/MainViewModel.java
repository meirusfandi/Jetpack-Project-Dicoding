package com.meirusfandi.myviewmodel;

import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {

    int result = 0;

    void calculate (String w, String l, String h) {
        result = Integer.parseInt(w) * Integer.parseInt(l) * Integer.parseInt(h);
    }

}
