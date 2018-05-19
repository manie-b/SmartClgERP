package com.smart.DemoClassIncharge;

/**
 * Created by systemO on 14/11/2017.
 */
public class SpinnerItem {

    int drawableResID;
    String name;
    String Userid;

    public SpinnerItem(int drawableResID, String name, String Userid) {
        super();
        this.drawableResID = drawableResID;
        this.name = name;
        this.Userid = Userid;
    }

    public int getDrawableResID() {
        return drawableResID;
    }
    public void setDrawableResID(int drawableResID) {
        this.drawableResID = drawableResID;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUserid() {
        return Userid;
    }
    public void setUserid(String Userid) {
        this.Userid = Userid;
    }

}