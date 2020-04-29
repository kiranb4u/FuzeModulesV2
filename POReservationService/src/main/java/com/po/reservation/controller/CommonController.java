package com.po.reservation.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.po.reservation.info.MarketInfo;
import com.po.reservation.info.SubMarketInfo;
import com.po.reservation.info.TerritoryInfo;
import com.po.reservation.service.CommonService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CommonController {

	private static Logger logger = LoggerFactory.getLogger(CommonController.class);

	@Autowired
	private CommonService commonService;

	@GetMapping("/territories")
	public ResponseEntity<List<TerritoryInfo>> getTerritories() {
		List<TerritoryInfo> territoryInfoList = new ArrayList<TerritoryInfo>(0);
		territoryInfoList = commonService.getTerritories();
		return new ResponseEntity<List<TerritoryInfo>>(territoryInfoList, HttpStatus.OK);
	}

	@GetMapping("/territory/{territoryId}")
	public ResponseEntity<TerritoryInfo> getTerritoryById(@PathVariable("territoryId") final int territoryId) {
		TerritoryInfo territoryInfo = null;
		territoryInfo = commonService.getTerritoryById(territoryId);
		return new ResponseEntity<TerritoryInfo>(territoryInfo, HttpStatus.OK);
	}

	@GetMapping("/markets")
	public ResponseEntity<List<MarketInfo>> getMarkets() {
		List<MarketInfo> marketInfoList = new ArrayList<MarketInfo>(0);
		marketInfoList = commonService.getMarkets();
		return new ResponseEntity<List<MarketInfo>>(marketInfoList, HttpStatus.OK);
	}

	@GetMapping("/market/{marketId}")
	public ResponseEntity<MarketInfo> getMarketById(@PathVariable("marketId") final int marketId) {
		MarketInfo marketInfo = null;
		marketInfo = commonService.getMarketById(marketId);
		return new ResponseEntity<MarketInfo>(marketInfo, HttpStatus.OK);
	}

	@GetMapping("/subMarkets")
	public ResponseEntity<List<SubMarketInfo>> getSubMarkets() {
		List<SubMarketInfo> subMarketInfoList = new ArrayList<SubMarketInfo>(0);
		subMarketInfoList = commonService.getSubMarkets();
		return new ResponseEntity<List<SubMarketInfo>>(subMarketInfoList, HttpStatus.OK);
	}

	@GetMapping("/subMarket/{subMarketId}")
	public ResponseEntity<SubMarketInfo> getSubMarketById(@PathVariable("subMarketId") final int subMarketId) {
		SubMarketInfo subMarketInfo = null;
		subMarketInfo = commonService.getSubMarketById(subMarketId);
		return new ResponseEntity<SubMarketInfo>(subMarketInfo, HttpStatus.OK);
	}
}
