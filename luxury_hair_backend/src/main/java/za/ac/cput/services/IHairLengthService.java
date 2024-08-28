package za.ac.cput.services;

import za.ac.cput.domain.HairLength;

import java.util.List;

public interface IHairLengthService extends IService<HairLength,Integer>{
    List<HairLength> getall();
}
