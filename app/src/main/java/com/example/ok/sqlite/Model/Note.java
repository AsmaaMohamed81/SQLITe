package com.example.ok.sqlite.Model;

/**
 * Created by ok on 12/11/2017.
 */

public class Note {
    public String title;
    public String Detail;

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {

        return ID;
    }

    public String ID;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }



    public String getDetail() {
        return Detail;

    }
}
