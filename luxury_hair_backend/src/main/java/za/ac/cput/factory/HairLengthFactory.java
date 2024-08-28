package za.ac.cput.factory;


import za.ac.cput.domain.HairLength;
import za.ac.cput.util.Helper;

public class HairLengthFactory {
    public static HairLength buildHairlength(int hairlengthID, int hairLengthValue, String lengthDescription) {
        if (Helper.isIntNullOrEmpty(hairlengthID) || Helper.isIntNullOrEmpty(hairLengthValue) ||
                Helper.isNullOrEmpty(lengthDescription)) {

            return null;
        }

        return new HairLength.Builder()
                .setHairlengthID(hairlengthID)
                .setHairLengthValue(hairLengthValue)
                .setLengthDescription(lengthDescription)
                .build();
    }
}

