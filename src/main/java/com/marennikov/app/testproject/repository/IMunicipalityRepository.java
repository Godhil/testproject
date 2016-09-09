package com.marennikov.app.testproject.repository;

import com.marennikov.app.testproject.entity.Municipality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IMunicipalityRepository extends JpaRepository<Municipality, Integer> {

//    @Modifying
//    @Query("update Municipality mun " +
//            "set mun.actualStatus = 'delete' " +
//            "where mun.id =:id")
//    void setStatus(@Param("id") Integer id);

    List<Municipality> findAllByActiveStatus(String activeStatus);


}
