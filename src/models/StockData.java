package src.models;

import java.time.LocalDate;

public class StockData {
    private LocalDate date;
    private double open;
    private double high;
    private double low;
    private double close;
    private long volume;

    // Constructor
    public StockData(LocalDate date, double open, double high, double low, double close, long volume) {
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.volume = volume;
    }

    // Getters
    public LocalDate getDate() { return date; }
    public double getOpen() { return open; }
    public double getHigh() { return high; }
    public double getLow() { return low; }
    public double getClose() { return close; }
    public long getVolume() { return volume; }

    // Print the stock data in a readable format (Strings)
    public String toString() {
        return "Date: " + date + ", Open: " + open + ", High: " + high + ", Low: " + low + ", Close: " + close + ", Volume: " + volume;
    }
}
