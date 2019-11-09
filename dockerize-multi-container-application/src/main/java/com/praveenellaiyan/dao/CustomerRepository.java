/**
 * 
 */
package com.praveenellaiyan.dao;

import org.springframework.data.repository.CrudRepository;

import com.praveenellaiyan.model.Customer;

/**
 * @author praveenellaiyan
 *
 */
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
