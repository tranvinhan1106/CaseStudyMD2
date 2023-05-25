package src.utils;

import src.models.Booking;

import java.io.*;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.TreeSet;

public class RAndWBooking {
    public TreeSet<Booking> treeSet;

    {
        try {
            treeSet = readBooking();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static final String FILE_BOOKING = "D:\\V.An\\FuramaResort\\src\\data\\booking.csv";

    public static void writeBooking(TreeSet<Booking> treeSet) throws IOException {
        FileWriter fileWriter = new FileWriter(FILE_BOOKING);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Booking booking : treeSet) {
            bufferedWriter.write(booking.getBookingCode() + "," + booking.getStartDay() + "," + booking.getEndDate() + ","
                    + booking.getBookingCode() + "," + booking.getServiceName() + "," + booking.getTypeService() + "\n");
        }
        bufferedWriter.close();
    }

    public static TreeSet<Booking> readBooking() throws IOException {
        FileReader fileReader = new FileReader(FILE_BOOKING);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        TreeSet<Booking> list = new TreeSet<>((Comparator) new BookingComparator());
        String line;
        String[] temp;
        Booking booking;
        while ((line = bufferedReader.readLine()) != null) {
            temp = line.split(",");
            String id = temp[0];
            LocalDate startDate = LocalDate.parse(temp[1]);
            LocalDate endDate = LocalDate.parse(temp[2]);
            String idCustomer = temp[3];
            String nameService = temp[4];
            String typeOfService = temp[5];
            booking = new Booking(id, startDate, endDate, idCustomer, nameService, typeOfService);
            list.add(booking);
        }
        bufferedReader.close();
        return list;
    }
}
