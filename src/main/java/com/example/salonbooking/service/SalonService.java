package com.example.salonbooking.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.salonbooking.entity.Service;
import com.example.salonbooking.repository.ServiceRepository;

@org.springframework.stereotype.Service
public class SalonService {
	
	@Autowired
    private ServiceRepository serviceRepository;
    
    public List<Service> getAllServices() {
        return serviceRepository.findAll();
    }
    
    public Optional<Service> getServiceById(Long id) {
        return serviceRepository.findById(id);
    }
    
    public Service addService(Service service) {
        return serviceRepository.save(service);
    }
    
    public Service updateService(Long id, Service serviceDetails) {
        Service service = serviceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Service not found with id: " + id));
        
        service.setServiceName(serviceDetails.getServiceName());
        service.setDescription(serviceDetails.getDescription());
        service.setDurationMinutes(serviceDetails.getDurationMinutes());
        service.setPrice(serviceDetails.getPrice());
        
        return serviceRepository.save(service);
    }
    
    public void deleteService(Long id) {
        serviceRepository.deleteById(id);
    }

}
