package com.example.salonbooking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.salonbooking.entity.Service;

@Repository
public interface ServiceRepository extends JpaRepository<Service, Long> {
	List<Service> findByServiceNameContaining(String serviceName);
}
