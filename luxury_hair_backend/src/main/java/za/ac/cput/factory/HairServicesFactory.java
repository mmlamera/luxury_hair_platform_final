package za.ac.cput.factory;

import za.ac.cput.domain.Customer;
import za.ac.cput.domain.HairServices;

import java.time.LocalDate;
import java.time.LocalTime;

public class HairServicesFactory {
    public static HairServices buildHairServices(int id, byte[] image, LocalDate date, LocalTime time, String notes, Customer customer) {
        return new HairServices.Builder()
                .setHairServicesId(id)
                .setImage(image)
                .setDate(date)
                .setTime(time)
                .setAdditionalNotes(notes)
                .setCustomer(customer)
                .build();
    }
}