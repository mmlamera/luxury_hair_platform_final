package za.ac.cput.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.cput.services.IShippingService;
import za.ac.cput.services.ShippingService;


@Component
public class ShippingApi {

    private ShippingService service;

    private IShippingService iShippingService;

    @Autowired
    ShippingApi(ShippingService service, IShippingService iShippingService){
        this.service = service;
        this.iShippingService = iShippingService;
    }



}
