package com.company.Task1;

import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Time {
    private long start;
    private long end;

    public void setStart() {
        this.start = System.nanoTime();
    }

    public void setEnd() {
        this.end = System.nanoTime();
    }

    public String stringFormat(long time){
        NumberFormat numberFormat = new DecimalFormat("#0.000000000");
        return numberFormat.format(time/1000000000d);
    }
    public long getExpiredTime(){

        return end - start;
    }
}
