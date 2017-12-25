package com.sponsored.ad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sponsored.ad.model.Campaign;
import com.sponsored.ad.repository.CampaignRepository;

@Service
public class CampaignServiceImpl implements CampaignService {
	@Autowired
	private CampaignRepository campaignRepository;

	@Override
	public Campaign create(Campaign campaign) {
		return campaignRepository.save(campaign);
	}
}
