package za.ac.cput.services;

import za.ac.cput.domain.Shipping;

import java.util.List;

public interface IShippingService extends IService<Shipping, String>{
    List<Shipping> getall();
}
