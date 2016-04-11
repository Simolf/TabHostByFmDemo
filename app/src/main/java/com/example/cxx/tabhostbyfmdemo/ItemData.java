package com.example.cxx.tabhostbyfmdemo;

/**
 * Created by CXX on 2016/4/11.
 */
public class ItemData {
    private String title = "title";
    private String content = "content";
    public ItemData(String content, String title) {
        this.content = content;
        this.title = title;
    }
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
