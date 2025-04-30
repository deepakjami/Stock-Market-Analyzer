package src.services;
import src.models.StockData;

import java.util.ArrayList;
import java.util.List;

public class StockAnalyzer {
    // Calculate the maximum profit
    public static double calculateMaxProfit(List<StockData> stockData) {
        if(stockData == null || stockData.size() < 2)   return 0;
        double maxProfit = 0.0;
        double minPrice = stockData.get(0).getOpen(); // Initialize the minimum price to the first day's opening price
        for(StockData data : stockData) {
            if(data.getOpen() < minPrice)  minPrice = data.getOpen();
            double currProfit = data.getClose() - minPrice;
            if(currProfit > maxProfit)  maxProfit = currProfit;
        }
        return maxProfit;
    }

    // Calculate moving averages over a given period
    public static List<Double> calculateMovingAverages(List<StockData> data, int period) {
        List<Double> movingAverages = new ArrayList<>();

        if (data == null || data.size() < period) {
            return movingAverages; 
        }

        for (int i = period - 1; i < data.size(); i++) {
            double sum = 0.0;
            // Sum the close prices for the given period
            for (int j = i - period + 1; j <= i; j++) {
                sum += data.get(j).getClose();
            }
            double average = sum / period;
            movingAverages.add(average);
        }
        return movingAverages;
    }

    public static String analyzeTrend(List<Double> movingAverages) {
        if (movingAverages == null || movingAverages.size() < 2) {
            return "Not enough data to determine trend";
        }

        double last = movingAverages.get(movingAverages.size() - 1);
        double previous = movingAverages.get(movingAverages.size() - 2);

        if (last > previous) {
            return "Bullish trend";
        } else if (last < previous) {
            return "Bearish trend";
        } else {
            return "Sideways trend";
        }
    }
}
