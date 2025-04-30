import src.models.*;
import src.services.StockAnalyzer;
import src.utilities.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filePath = "data/stock_data.csv";
        List<StockData> stockData = new CSVLoader().loadStockData(filePath);
        boolean exit = false;
        while(!exit) {
            System.out.println("\n---- Stock Market Analyzer Menu ----");
            System.out.println("1. Display Stock Data");
            System.out.println("2. Calculate Maximum Profit");
            System.out.println("3. Calculate Moving Averages");
            System.out.println("4. Analyze Market Trend");
            System.out.println("5. Exit");
            System.out.println("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    // Display each StockData record
                    System.out.println("\nLoaded Stock Data:");
                    for (StockData data : stockData) {
                        System.out.println(data);
                    }
                    break;
                case 2:
                    // Calculate and display the maximum profit from a single buy/sell transaction
                    double maxProfit = StockAnalyzer.calculateMaxProfit(stockData);
                    System.out.println("\nMaximum Profit: $" + maxProfit);
                    break;
                case 3:
                    System.out.print("Enter the moving average period: ");
                    int period = scanner.nextInt();
                    List<Double> movingAverages = StockAnalyzer.calculateMovingAverages(stockData, period);
                    System.out.println("\n" + period + "-Day Moving Averages:");
                    for (Double avg : movingAverages) {
                        System.out.println(avg);
                    }
                    break;
                case 4:
                    List<Double> defaultMovingAverages = StockAnalyzer.calculateMovingAverages(stockData, 3);
                    String trend = StockAnalyzer.analyzeTrend(defaultMovingAverages);
                    System.out.println("\nMarket Trend (based on 3-day moving average): " + trend);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Stock Market Analyzer...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        // Close the scanner resource
        scanner.close();
    }
}

