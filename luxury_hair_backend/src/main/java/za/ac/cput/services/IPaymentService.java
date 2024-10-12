package za.ac.cput.services;

import za.ac.cput.domain.Payment;

import java.util.List;
import java.util.Set;

public interface IPaymentService {
    Set<Payment> getall();

    Payment create(Payment payment);

    Payment read(String cardNumber);

    Payment read(Payment payment);

    Payment update(Payment payment);

    List<Payment> getAll();
}
