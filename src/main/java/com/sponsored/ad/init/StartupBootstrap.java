package com.sponsored.ad.init;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sponsored.ad.model.Campaign;
import com.sponsored.ad.model.Product;
import com.sponsored.ad.repository.CampaignRepository;
import com.sponsored.ad.repository.ProductRepository;

@Component
public class StartupBootstrap {

	@Autowired
	private CampaignRepository campaignRepository;

	@Autowired
	private ProductRepository productRepository;

	@PostConstruct
	private void onInit(){

		Campaign campaign = new Campaign();
		campaign.setName("Campaign #1");
		campaign.setStartDate(LocalDateTime.now());
		campaign.setCategory("Shoes");
		campaign = campaignRepository.save(campaign);

		Set<Campaign> campaigns = new HashSet<>();
		campaigns.add(campaign);

		Product product = new Product();
		product.setTitle("Abibas");
		product.setCategory("Shoes");
		product.setPrice(BigDecimal.valueOf(100));
		product.setCampaigns(campaigns);
		product.setSerialNumber(UUID.randomUUID().toString());

		productRepository.save(product);

	}
}
