package com.lhx.charity.respository;

import com.lhx.charity.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User,Integer>, JpaSpecificationExecutor<User> {


//    @Modifying
//    @Query(value = "update product set status = :status where id =:id",nativeQuery = true)
//    int updateStatus(@Param("id") Integer id, @Param("status") Integer status);
}
