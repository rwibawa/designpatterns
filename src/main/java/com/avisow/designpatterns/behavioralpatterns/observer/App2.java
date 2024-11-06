package com.avisow.designpatterns.behavioralpatterns.observer;

import java.util.Observable;
import java.util.Observer;

public class App2 {
    public static void main(String[] args) {
        CommentaryObjectObservable obj = new CommentaryObjectObservable("Soccer Match [2014AUG24]");

        SMSUsersObserver observer = new SMSUsersObserver(obj, "Adam Warner [New York]");
        SMSUsersObserver observer2 = new SMSUsersObserver(obj, "Tim Ronney [London]");
        observer.subscribe();
        observer2.subscribe();

        obj.setDesc("Welcome to live Soccer match");
        obj.setDesc("Current score 0-0");
        observer.unSubscribe();

        obj.setDesc("It’s a goal!!");
        obj.setDesc("Current score 1-0");
    }
}

interface Commentary {
    void setDesc(String desc);
}

class CommentaryObjectObservable extends Observable implements Commentary {
    private String desc;
    private final String subjectDetails;

    public CommentaryObjectObservable(String subjectDetails) {
        this.subjectDetails = subjectDetails;
    }

    @Override
    public void setDesc(String desc) {
        this.desc = desc;
        setChanged();
        notifyObservers(desc);
    }

    public String subjectDetails() {
        return subjectDetails;
    }
}

class SMSUsersObserver implements Observer {
    private String desc;
    private final String userInfo;
    private final Observable observable;

    public SMSUsersObserver(Observable observable, String userInfo) {
        this.observable = observable;
        this.userInfo = userInfo;
    }

    public void subscribe() {
        System.out.println("Subscribing " + userInfo + " to " + ((CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.addObserver(this);
        System.out.println("Subscribed successfully.");
    }

    public void unSubscribe() {
        System.out.println("Unsubscribing " + userInfo + " to " + ((CommentaryObjectObservable) (observable)).subjectDetails() + " ...");
        this.observable.deleteObserver(this);
        System.out.println("Unsubscribed successfully.");
    }

    @Override
    public void update(Observable o, Object arg) {
        desc = (String) arg;
        display();
    }

    private void display() {
        System.out.println("[" + userInfo + "]: " + desc);
    }
}

