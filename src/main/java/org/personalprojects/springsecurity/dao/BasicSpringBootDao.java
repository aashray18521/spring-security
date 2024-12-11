package org.personalprojects.springsecurity.dao;

import org.personalprojects.springsecurity.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasicSpringBootDao extends JpaRepository<Item, Integer> {


}
