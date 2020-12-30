package com.springbootcrudfullstackwithmaven.rooms.repository;

import com.springbootcrudfullstackwithmaven.rooms.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OwnRepository extends JpaRepository<Owner, Integer> {

    @Modifying
    @Query("update Owner o set o.ownerName = :ownerName, o.ownerContact = :ownerContact, o.ownerMail = :ownerMail, o.location = :location, o.noOfVacancy = :noOfVacancy where o.ownerId = :ownerId")
    int updateOwner(@Param("ownerId") int ownerId, @Param("ownerName") String ownerName, @Param("ownerContact") String ownerContact, @Param("ownerMail") String ownerMail, @Param("location") String location, @Param("noOfVacancy") int noOfVacancy);

    @Modifying
    @Query("delete from Owner o where o.ownerId = :ownerId")
    int deleteOwner(@Param("ownerId") int ownerId);

}
