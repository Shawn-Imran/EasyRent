package com.example.easyrent.Repository;

import com.example.easyrent.Model.Services;
import com.example.easyrent.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServicesRepository extends JpaRepository<Services,Integer> {
    @Override
    Optional<Services> findById(Integer integer);
    @Query(value = "select * from services where type=:type", nativeQuery = true)
    public List<Services> findByType(String type);
}
