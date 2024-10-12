package za.ac.cput.services;

import za.ac.cput.domain.HairServices;

import java.util.List;

public interface IHairServices extends IService<HairServices,Integer> {
    List<HairServices>getall();
}