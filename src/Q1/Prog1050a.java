package Q1;
import java.io.*;
import java.util.*;
import java.text.*;

class SalesRecord {
    public String[] fields;

    public SalesRecord(String[] data) { fields = data; }

    public double getProfit() { return Double.parseDouble(fields[13]); }
    public double getUnitsSold() { return Double.parseDouble(fields[8]); }

}
//
public class Prog1050a {
    public static double profitLost = 0;
    public static List<SalesRecord> loadSalesData(String filepath) {
        var records = new ArrayList<SalesRecord>();
        try {
            var file = new Scanner(new File(filepath));
            file.nextLine();
            while (file.hasNextLine()) {
                String line = file.nextLine();
                String[] data = line.split(",");
                records.add(new SalesRecord(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return records;
    }


    public static void main(String[] args) {
        var records = loadSalesData("Langdat/Lang1050.csv");
        if (records != null) {
            var moneyFormat = new DecimalFormat("$#,###.00");
            System.out.println("Sales to Europe: " + computeCount(records, 0, "Europe"));
            System.out.println("Cereal bought by Cambodia: " + computeUnitsSold(records, 1,"Cambodia", 2, "Cereal"));
            System.out.println("Total profit on Meat: " +moneyFormat.format(computeSum(records, 2, "Meat", 13)));
            System.out.println("High priority sales percentage: " + computePercentage(records, 4, "H") + "%");
            System.out.println("Fruits profit lost in 2012: " + moneyFormat.format(computeProfitLostIn2012(records, "Fruits")));
            System.out.println("High priority sales shipped more than 3 days late: " + computeHighPriorityLateSales(records));
            System.out.println("Country with highest profit on personal care items: " + computeHighestProfit(records, 2, "Personal Care"));
            System.out.println("Region that bought the most snacks: " + computeMaxByField(records, 2, "Snacks", 0));
            System.out.println("Total records of sales to african nations: " + computeSalesToAfrican(records, 0, "Sub-Saharan Africa"));
            System.out.println("Removing all sales to kuwait.");
            removeSalesToKuwait(records, 1, "Kuwait");
            limitSalesCosmetics(records);
            removeSalesToAfrica(records);
            System.out.println("The company lost " + moneyFormat.format(profitLost) + " with the trade war with africa.");


        }
    }

    public static int computeCount(List<SalesRecord> records, int fIndex, String value) {

        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(value))
                count++;
        }
        return count;
    }
    public static int computeCount(List<SalesRecord> records, int fIndex1, String value1, int fIndex2, String value2) {

        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2))
                count++;
        }
        return count;
    }

    public static double computePercentage(List<SalesRecord> records, int fIndex, String value) {
        return ((double) computeCount(records, fIndex, value) / records.size()) * 100;
    }
    public static int computeUnitsSold(List<SalesRecord> records, int fIndex1, String value1, int fIndex2, String value2) {
        int total = 0;
        for (var record : records) {
            if (record.fields[fIndex1].equalsIgnoreCase(value1) && record.fields[fIndex2].equalsIgnoreCase(value2))
                total+= (int) record.getUnitsSold();
        }
        return total;
    }

    public static double computePercentage(List<SalesRecord> records, int fIndex, String value, int sumfIndex) {

        double sum = 0;
        for (var record : records)
            if (record.fields[fIndex].equalsIgnoreCase(value))
                sum += Double.parseDouble(record.fields[sumfIndex]);
        return sum;

    }
    public static double computeSum(List<SalesRecord> records, int fIndex, String value, int sumfIndex) {
        double sum = 0;
        for (var record : records)
            if (record.fields[fIndex].equalsIgnoreCase(value))
                sum += Double.parseDouble(record.fields[sumfIndex]);
        return sum;
    }

    public static double computeProfitLostIn2012(List<SalesRecord> records, String itemType) {
        double lostProfit = 0;
        for (var record : records)
            if (record.fields[2].equalsIgnoreCase(itemType) && record.fields[5].endsWith("2012"))
                lostProfit += Double.parseDouble((record.fields[13]));
        return lostProfit;
    }

    public static int computeHighPriorityLateSales(List<SalesRecord> records) {
        int count = 0;
        var dateFormat = new SimpleDateFormat("M/d/yyyy");
        for (var record : records) {
            if (record.fields[4].equalsIgnoreCase("H")) {
                try {
                    Date orderDate = dateFormat.parse(record.fields[5]);
                    Date shipDate = dateFormat.parse(record.fields[7]);

                    //Calculate the difference in days between order/ship dates
                    long diffInMs = Math.abs(shipDate.getTime()-orderDate.getTime());
                    long diffInDays = diffInMs / (1000 * 60 * 60 * 24);

                    if (diffInDays > 3) count++;
                } catch (ParseException e) {e.printStackTrace(); }
            }
        }
        return count;
    }

    public static String computeHighestProfit(List<SalesRecord> records, int fIndex, String itemType) {
        String highestCountry = "N/A";
        double highestProfit = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                double profit = Double.parseDouble(record.fields[13]);
                if (profit > highestProfit) {
                    highestProfit = profit;
                    highestCountry = record.fields[1];
                }
            }
        }
        return highestCountry;
    }

    public static String computeMaxByField(List<SalesRecord> records, int fIndex, String itemType, int resultFindex) {
        String topRegion = "N/A";
        int maxCount = 0;
        var regions = new ArrayList<String>();

        // Get a list of all the unique regions in the dataset
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                String region = record.fields[resultFindex];
                if (!regions.contains(region)) regions.add(region);
            }
        }

        // Count occurrences of each unique region
        for (var region : regions) {
            int count = 0;
            for (var record : records)
                if (record.fields[fIndex].equalsIgnoreCase(itemType) && record.fields[resultFindex].equalsIgnoreCase(region))
                    count++;
            if (count > maxCount) {
                maxCount = count;
                topRegion = region;
            }
        }

        return topRegion;
    }

    public static int computeSalesToAfrican(List<SalesRecord> records, int fIndex, String itemType) {
        int count = 0;
        for (var record : records) {
            if (record.fields[fIndex].equalsIgnoreCase(itemType)) {
                count++;
            }
        }
        return count;
    }

    public static void removeSalesToKuwait(List<SalesRecord> records, int fIndex, String itemType) {
        for (int lcv = 0; lcv < records.size()-1; lcv++) {
            if (records.get(lcv).fields[fIndex].equalsIgnoreCase(itemType)) {
                records.remove(lcv);
                lcv--;
            }
        }

    }

    public static void limitSalesCosmetics(List<SalesRecord> records) {
        double temp = 0;
        for (var record : records) {
            if (record.fields[2].equalsIgnoreCase("Cosmetics")) {
                temp = Double.parseDouble(record.fields[13]);
                record.fields[8] = "100";
                record.fields[11] = Double.toString(Double.parseDouble(record.fields[9]) * 100);
                record.fields[12] = Double.toString(Double.parseDouble(record.fields[10]) * 100);
                record.fields[13] = Double.toString(Double.parseDouble(record.fields[11]) - Double.parseDouble(record.fields[12]));
                profitLost += temp - Double.parseDouble(record.fields[13]);
            }

        }
    }

    public static void removeSalesToAfrica(List<SalesRecord> records) {
        for (int lcv = 0; lcv < records.size()-1; lcv++) {
            if (records.get(lcv).fields[0].equalsIgnoreCase("Sub-Saharan Africa") && records.get(lcv).fields[4].equalsIgnoreCase("L")) {
                profitLost += Double.parseDouble(records.get(lcv).fields[13]);
                records.remove(lcv);
                lcv--;
            }
        }
    }




}
