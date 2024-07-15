import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preferences;

    Destination(String name, String date, String preferences) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
    }

    @Override
    public String toString() {
        return "Destination: " + name + ", Date: " + date + ", Preferences: " + preferences;
    }
}

public class TravelItineraryPlanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();
        
        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.print("Enter destination (or type 'done' to finish): ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }

            System.out.print("Enter date : ");
            String date = scanner.nextLine();

            System.out.print("Enter preferences : ");
            String preferences = scanner.nextLine();

            itinerary.add(new Destination(name, date, preferences));
        }

        System.out.println("\nYour Travel Itinerary:");
        for (Destination destination : itinerary) {
            System.out.println(destination);
        }

        System.out.println("\nFetching additional information...");
        
        for (Destination destination : itinerary) {
            System.out.println("\n" + destination);
            
            fetchMapInfo(destination.name);
            fetchWeatherInfo(destination.name);
            calculateBudget(destination.name);
        }

        scanner.close();
    }

    private static void fetchMapInfo(String location) {

        System.out.println("Map information for " + location + " (integration required)");
    }

    private static void fetchWeatherInfo(String location) {
    
        System.out.println("Weather information for " + location + " (integration required)");
    }

    private static void calculateBudget(String location) {
        
        System.out.println("Budget calculations for " + location + " (integration required)");
    }
}
