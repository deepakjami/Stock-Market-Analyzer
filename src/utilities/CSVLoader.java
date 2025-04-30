package src.utilities;

import java.util.*;
import java.io.*;
import java.time.LocalDate;
import src.models.StockData;

public class CSVLoader {
    public List<StockData> loadStockData(String filePath) {
        List<StockData> stockData = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // we are skipping the header, because it does not contain stock data
            while((line = br.readLine()) != null) {
                String[] values = line.split(",");
                LocalDate date = LocalDate.parse(values[0]);
                double open = Double.parseDouble(values[1]);
                double high = Double.parseDouble(values[2]);
                double low = Double.parseDouble(values[3]);
                double close = Double.parseDouble(values[4]);
                long volume = Long.parseLong(values[5]);

                // Now create a StockData object and add it to the list
                StockData stock = new StockData(date, open, high, low, close, volume);
                stockData.add(stock);
            }
        }
        catch (IOException e) {
            System.out.println("There was an error reading the file: " + e);
        }
        return stockData;
    }
}
