package com.avisow.designpatterns.behavioralpatterns.command;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class App2 {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(10);

        Email email;
        EmailJob emailJob = new EmailJob();

        Sms sms;
        SmsJob smsJob = new SmsJob();

        FileIO fileIO;
        FileIOJob fileIOJob = new FileIOJob();

        Logging logging;
        LoggingJob logJob = new LoggingJob();

        for (int i = 0; i < 5; i++) {
            email = new Email();
            emailJob.setEmail(email);

            sms = new Sms();
            smsJob.setSms(sms);

            fileIO = new FileIO();
            fileIOJob.setFileIO(fileIO);

            logging = new Logging();
            logJob.setLogging(logging);

            service.submit(emailJob);
            service.submit(smsJob);
            service.submit(fileIOJob);
            service.submit(logJob);
        }

        System.out.println("Done submitting all jobs!");
    }
}

class Email {
    public void sendEmail() {
        System.out.println("Sending email.......");
    }
}

class EmailJob implements Runnable {
    private Email email;

    public void setEmail(Email email) {
        this.email = email;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId() + " executing email jobs.");
        if (email != null) {
            email.sendEmail();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

class FileIO {
    public void execute() {
        System.out.println("Executing File IO operations...");
    }
}

class FileIOJob implements Runnable {
    private FileIO fileIO;

    public void setFileIO(FileIO fileIO) {
        this.fileIO = fileIO;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId() + " executing fileIO jobs.");
        if (fileIO != null) {
            fileIO.execute();
        }

        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }
}

class Logging {
    public void log() {
        System.out.println("Logging...");
    }
}

class LoggingJob implements Runnable {
    private Logging logging;

    public void setLogging(Logging logging) {
        this.logging = logging;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId() + " executing logging jobs.");
        if (logging != null) {
            logging.log();
        }

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class Sms {
    public void sendSms() {
        System.out.println("Sending SMS...");
    }
}

class SmsJob implements Runnable {
    private Sms sms;

    public void setSms(Sms sms) {
        this.sms = sms;
    }

    @Override
    public void run() {
        System.out.println("Job ID: " + Thread.currentThread().getId() + " executing sms jobs.");
        if (sms != null) {
            sms.sendSms();
        }

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
