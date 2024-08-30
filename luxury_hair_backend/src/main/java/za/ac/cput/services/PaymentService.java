package za.ac.cput.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Payment;
import za.ac.cput.repository.PaymentRepository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PaymentService implements IPaymentService{

    private PaymentRepository paymentRepository;
    private Long cardNumber;

    @Autowired
    PaymentService(PaymentRepository paymentRepository){ this.paymentRepository = paymentRepository;}

    private PaymentService(){

    }
    @Override
    public Set<Payment> getall(){return paymentRepository.findAll().stream().collect(Collectors.toSet()); }

    @Override
    public Payment create(Payment payment){return paymentRepository.save(payment);}

    @Override
    public Payment read(String cardNumber) {
        return null;
    }

    @Override
    public Payment read(Payment payment){return paymentRepository.findById(cardNumber).orElse(null);}

    @Override
    public Payment update(Payment payment){return paymentRepository.save(payment);}

    @Override
    public List<Payment> getAll() {
        return List.of();
    }
}
