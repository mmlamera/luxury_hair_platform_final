package za.ac.cput.factory;

import za.ac.cput.domain.HairServices;
import za.ac.cput.util.Helper;

import java.time.LocalDate;
import java.time.LocalTime;

public class HairServicesFactory {

    public static HairServices buildHairServices(int hairServicesId, byte[] image, LocalDate date, LocalTime time, String additionalNotes) {
        if (hairServicesId <= 0 || Helper.isArrayNullOrEmpty(image) || date == null || time == null) {
            return null;
        }

        return new HairServices.Builder()
                .setHairServicesId(hairServicesId)
                .setImage(image)
                .setDate(date)
                .setTime(time)
                .setAdditionalNotes(additionalNotes)
                .build();
    }
}