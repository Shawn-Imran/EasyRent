package com.example.easyrent.Repository;

import com.example.easyrent.Model.SingleService;
import com.example.easyrent.Model.SubService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SingleServiceRepository extends JpaRepository<SingleService,Integer> {
    @Override
    Optional<SingleService> findById(Integer integer);
    @Query(value = "select * from single_services WHERE type=:type AND subservice=:subservice", nativeQuery = true)
    public List<SingleService> findByTypeNSub(String type, String subservice);
    @Query(value = "select * from single_services WHERE subservice=:subservice", nativeQuery = true)
    public List<SingleService> findBySub(String subservice);
    @Query(value = "select * from single_services WHERE sid=:sid", nativeQuery = true)
    public List<SingleService> findBysid(String sid);
}
