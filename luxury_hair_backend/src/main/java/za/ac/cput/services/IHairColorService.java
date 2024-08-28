package za.ac.cput.services;

import za.ac.cput.domain.HairColor;

import java.util.List;
import java.util.Set;

public interface IHairColorService extends IService<HairColor,String> {
    List<HairColor> getall();
}
