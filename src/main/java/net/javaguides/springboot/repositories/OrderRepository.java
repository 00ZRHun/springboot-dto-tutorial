package net.javaguides.springboot.repositories;

import net.javaguides.springboot.models.Customer;
import net.javaguides.springboot.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findAllByCustomer (Customer customer);
}
