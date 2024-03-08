package csc366.jpademo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.repository.query.Param;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    // Query inferred from method name, code generated by Spring Framework
    Supplier findByName(String name);

    // JPQL query
    @Query("from Supplier s where s.name = :name")
    Supplier findByNameJpql(@Param("name") String name);

    // JPQL query with join (assuming there is an 'addresses' field in the Customer entity)
    @Query("select s from Supplier s join s.contracts ctr where c.name = :name")
    Supplier findByNameWithJpql(@Param("name") String name);

    // Native SQL query (validity not checked, invalid SQL will cause runtime exception)
    @Query(value = "select * from supplier as s where c.name = :name ", nativeQuery = true)
    Supplier findByNameSql(@Param("name") String name);

    @Modifying
    @Query("update Supplier s set s.name = :newName where c.name = :oldName")
    void updateName(@Param("oldName") String oldName, @Param("newName") String newName);

    // Add more custom queries based on your requirements

}
