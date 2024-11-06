package com.avisow.designpatterns.behavioralpatterns.templatemethod;

import java.util.Date;

public class App2 {
    public static void main(String[] args) {
        System.out.println("For MYSQL....");
        ConnectionTemplate template = new MySqLCSVCon();
        template.run();

        System.out.println("\nFor Oracle...");
        template = new OracleTxtCon();
        template.run();
    }
}

abstract class ConnectionTemplate {
    private boolean isLoggingEnable = true;

    public ConnectionTemplate(){
        isLoggingEnable = disableLogging();
    }

    public final void run(){
        setDBDriver();
        logging("Drivers set ["+new Date()+"]");
        setCredentials();
        logging("Credentials set ["+new Date()+"]");
        connect();
        logging("Connected");
        prepareStatement();
        logging("Statement prepared ["+new Date()+"]");
        setData();
        logging("Data set ["+new Date()+"]");
        insert();
        logging("Inserted ["+new Date()+"]");
        close();
        logging("Connections closed ["+new Date()+"]");
        destroy();
        logging("Object destroyed ["+new Date()+"]");
    }

    public abstract void setDBDriver();

    public abstract void setCredentials();

    public void connect(){
        System.out.println("Setting connection...");
    }

    public void prepareStatement(){
        System.out.println("Preparing insert statement...");
    }

    public abstract void setData();

    public void insert(){
        System.out.println("Inserting data...");
    }

    public void close(){
        System.out.println("Closing connections...");
    }

    public void destroy(){
        System.out.println("Destroying connection objects...");
    }

    public boolean disableLogging(){
        return true;
    }

    private void logging(String msg){
        if(isLoggingEnable){
            System.out.println("Logging....: "+msg);
        }
    }
}

class MySqLCSVCon extends ConnectionTemplate{
    @Override
    public void setDBDriver() {
        System.out.println("Setting MySQL DB drivers...");
    }

    @Override
    public void setCredentials() {
        System.out.println("Setting credentials for MySQL DB...");
    }

    @Override
    public void setData() {
        System.out.println("Setting up data from csv file....");
    }

    @Override
    public boolean disableLogging() {
        return false;
    }
}

class OracleTxtCon extends ConnectionTemplate{
    @Override
    public void setDBDriver() {
        System.out.println("Setting Oracle DB drivers...");
    }

    @Override
    public void setCredentials() {
        System.out.println("Setting credentials for Oracle DB...");
    }

    @Override
    public void setData() {
        System.out.println("Setting up data from txt file....");
    }
}