package com.sponsored.ad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sponsored.ad.model.Campaign;

@Repository
public interface CampaignRepository extends JpaRepository<Integer, Campaign> {
}
