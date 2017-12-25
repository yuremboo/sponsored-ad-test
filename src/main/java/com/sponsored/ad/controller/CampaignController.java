package com.sponsored.ad.controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sponsored.ad.model.Campaign;
import com.sponsored.ad.service.CampaignService;

@RestController
@RequestMapping(value = "/api/v1/campaign")
public class CampaignController {

	@Autowired
	private CampaignService campaignService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<Campaign> saveCampaign(@RequestParam String name, @RequestParam LocalDateTime startDate, @RequestParam String category, @RequestParam BigDecimal bid) {
		Campaign campaign = new Campaign();
		campaign.setCategory(category);
		campaign.setName(name);
		campaign.setStartDate(startDate);
		return ResponseEntity.ok(campaignService.create(campaign));
	}

}
