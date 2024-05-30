package com.coding.coforge;

public class Dress {
    private String color;

    public Dress ( String color , String size ) {
        this.color=color;
        this.size=size;
    }

    public String getColor () {
        return color;
    }

    public void setColor ( String color ) {
        this.color = color;
    }

    public String getSize () {
        return size;
    }

    public void setSize ( String size ) {
        this.size = size;
    }

    private String size;


}
