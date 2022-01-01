package com.example.easyrent.Repository;

import com.example.easyrent.Model.Deals;
import com.example.easyrent.Model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfileRepository extends JpaRepository<Profile,Integer> {
    @Override
    Optional<Profile> findById(Integer integer);
    @Query(value = "select * from profile where email=:email", nativeQuery = true)
    public List<Profile> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "UPDATE profile SET name=:name, primarynumber=:primarynumber, secondarynumber=:secondarynumber,  address=:address , city=:city, country=:country, postalcode=:postalcode, about=:about where email=:email", nativeQuery = true)
    public int updateByemail(String email,String name,String primarynumber,String secondarynumber,String address,String city,String country,String postalcode,String about );
}
