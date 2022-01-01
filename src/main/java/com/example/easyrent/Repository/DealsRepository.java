package com.example.easyrent.Repository;

import com.example.easyrent.Model.Deals;
import com.example.easyrent.Model.Services;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface DealsRepository extends JpaRepository<Deals,Integer> {
    @Override
    Optional<Deals> findById(Integer integer);
    @Query(value = "select * from deals where email=:email", nativeQuery = true)
    public List<Deals> findByEmail(String email);
    @Query(value = "select * from deals where email=:email AND sid=:sid", nativeQuery = true)
    public List<Deals> findByEmailNsid(String email,String sid);
    @Modifying
    @Transactional
    @Query(value = "DELETE from deals where email=:email AND sid=:sid", nativeQuery = true)
    public int deleteByEmailNsid(String email,String sid);

    @Modifying
    @Transactional
    @Query(value = "UPDATE deals SET number=:number, address=:address where email=:email AND sid=:sid", nativeQuery = true)
    public int setByAddressNnumber(String email,String sid,String number,String address);

}
