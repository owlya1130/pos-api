package com.example.dal.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.dal.store.entity.Store;

@Repository
public interface StoreDao extends JpaRepository<Store, Integer> {
}
