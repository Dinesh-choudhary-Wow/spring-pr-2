package com.springAndBoot2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springAndBoot2.entity.Delicacy;

@Repository
public interface DelicacyRepository extends JpaRepository<Delicacy, Long> {
}
