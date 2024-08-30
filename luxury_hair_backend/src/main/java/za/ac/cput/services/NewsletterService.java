package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Newsletter;
import za.ac.cput.repository.NewsletterRepository;

import java.util.List;

@Service
public class NewsletterService {
    private NewsletterRepository repo;
    @Autowired
    NewsletterService(NewsletterRepository repository){
        this.repo = repository;
    }

    public Newsletter read(Long aLong) {
        return repo.findById(aLong).orElse(null);
    }
    public Newsletter findByEmail(String email) {
        return repo.findByEmail(email);
    }
    public Newsletter create(Newsletter newsletter) {
        return repo.save(newsletter);
    }
    public boolean checkEmailExists(String email) {
        Newsletter user = repo.findByEmail(email);
        return user != null;
    }
    public List<Newsletter> getall() {
        return repo.findAll();
    }
    public Newsletter update(Newsletter newsletter) {
        return repo.save(newsletter);
    }

}