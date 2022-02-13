package com.techelevator;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Log implements Closeable {

    private File logFile;
    private PrintWriter writer;
    static Log logger = new Log("Log.txt");

    public Log(String File){
        this.logFile = new File("Log.txt");

        if(!logFile.exists()){
            try {
                this.writer = new PrintWriter(this.logFile);
            } catch (FileNotFoundException e) {
                e.getMessage();
            }
        } else {
            try {
                this.writer = new PrintWriter(new FileWriter(this.logFile, true));
            } catch (IOException e) {
                e.getMessage();
            }
        }
    }
    public void write(String logMessage) {
        this.writer.println(logMessage);
        this.writer.flush();
    }
    @Override
    public void close() {
        this.writer.close();
    }

    public static String insertDate() {

        DateFormat dateFormat2 = new SimpleDateFormat("MM/dd/yyyy hh:mm:ss aa");
        String dateString2 = dateFormat2.format(new Date()).toString();
        return dateString2;
    }
}
