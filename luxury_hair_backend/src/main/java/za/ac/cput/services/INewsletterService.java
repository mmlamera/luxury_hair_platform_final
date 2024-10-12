package za.ac.cput.services;

import za.ac.cput.domain.Newsletter;

import java.util.List;

public interface INewsletterService extends IService<Newsletter,Long>{
    List<Newsletter> getall();
}