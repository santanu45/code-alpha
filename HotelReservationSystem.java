import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    double price;
    boolean isAvailable;

    Room(int roomNumber, String category, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.price = price;
        this.isAvailable = true;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Category: " + category + ", Price: $" + price + ", Available: " + isAvailable;
    }
}

class Reservation {
    String guestName;
    Room room;
    String checkInDate;
    String checkOutDate;

    Reservation(String guestName, Room room, String checkInDate, String checkOutDate) {
        this.guestName = guestName;
        this.room = room;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        room.isAvailable = false; // Mark room as reserved
    }

    @Override
    public String toString() {
        return "Guest Name: " + guestName + ", Room Number: " + room.roomNumber + ", Check-in: " + checkInDate + ", Check-out: " + checkOutDate;
    }
}

public class HotelReservationSystem {
    private static ArrayList<Room> rooms = new ArrayList<>();
    private static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeRooms();

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\nSelect an option:");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View booking details");
            System.out.println("4. Exit");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    searchRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewBookings();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", 100.0));
        rooms.add(new Room(102, "Double", 150.0));
        rooms.add(new Room(103, "Suite", 250.0));
        rooms.add(new Room(104, "Single", 100.0));
        rooms.add(new Room(105, "Double", 150.0));
    }

    private static void searchRooms() {
        System.out.println("Available Rooms:");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();

        System.out.print("Enter check-in date : ");
        String checkInDate = scanner.nextLine();

        System.out.print("Enter check-out date : ");
        String checkOutDate = scanner.nextLine();

        System.out.println("Select a room category (Single, Double, Suite): ");
        String category = scanner.nextLine();

        Room selectedRoom = null;
        for (Room room : rooms) {
            if (room.isAvailable && room.category.equalsIgnoreCase(category)) {
                selectedRoom = room;
                break;
            }
        }

        if (selectedRoom != null) {
            Reservation reservation = new Reservation(guestName, selectedRoom, checkInDate, checkOutDate);
            reservations.add(reservation);
            System.out.println("Reservation successful!");
            System.out.println(reservation);
        } else {
            System.out.println("No available rooms in the selected category.");
        }
    }

    private static void viewBookings() {
        System.out.println("All Bookings:");
        for (Reservation reservation : reservations) {
            System.out.println(reservation);
        }
    }
}