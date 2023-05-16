package com.courier.spring.repository;

import com.courier.spring.model.RegisterModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface RegisterRepository extends JpaRepository<RegisterModel,Integer> {
    Optional<RegisterModel>findUserById(Integer id);
//    @Query("SELECT p FROM RegisterModel p WHERE CONCAT(p.id,'',p.courier_id,'',p.cname,'',p.sname,'',p.sphone,'',p.email,'',p.rname,'',p.phone,'',p.route,'',p.transport) LIKE %?1%")
//    public List<RegisterModel>search(String keyword);
}
