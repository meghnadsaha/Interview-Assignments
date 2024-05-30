package com.coding.coforge;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

// Observable class
class MyObservable {
    private int data;
    private PropertyChangeSupport propertyChangeSupport;

    public MyObservable () {
        propertyChangeSupport = new PropertyChangeSupport(this);
    }

    public void addPropertyChangeListener ( PropertyChangeListener listener ) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener ( PropertyChangeListener listener ) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }

    public int getData () {
        return data;
    }

    public void setData ( int data ) {
        int oldData = this.data;
        this.data = data;
        propertyChangeSupport.firePropertyChange("data" , oldData , data);
    }
}

// Observer class
class MyObserver implements PropertyChangeListener {
    @Override
    public void propertyChange ( PropertyChangeEvent evt ) {
        if ("data".equals(evt.getPropertyName())) {
            System.out.println("Data updated: " + evt.getNewValue());
        }
    }


}


public final class CoforgeL2 {

    public static void main ( String[] args ) {
        MyObservable observable = new MyObservable();
        MyObserver observer = new MyObserver();

        observable.addPropertyChangeListener(observer);

        observable.setData(10); // Output: Data updated: 10
        observable.setData(20); // Output: Data updated: 20
    }

//
//    private final String name;
//    private final Dress dress;
//
//    public CoforgeL2(String name,Dress dress){
//        this.name=name;
//        this.dress=new Dress(dress.getColor(),dress.getSize());
//    }
//
//
//    public Dress getDress(){
//        return   new Dress(dress.getColor(),dress.getSize());
//    }
//


}
