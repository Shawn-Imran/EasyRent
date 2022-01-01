package com.example.easyrent.Repository;

import com.example.easyrent.Model.Services;
import com.example.easyrent.Model.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface SubServiceRepository extends JpaRepository<SubService,Integer> {
    @Override
    Optional<SubService> findById(Integer integer);
    @Query(value = "select * from subservices WHERE type=:type AND service=:service", nativeQuery = true)
    public List<SubService> findByTypeNService(String type,String service);
}
