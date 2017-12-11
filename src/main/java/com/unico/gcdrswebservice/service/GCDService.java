package com.unico.gcdrswebservice.service;


import com.unico.gcdrswebservice.domain.GCD;

public interface GCDService {
	
	Iterable<GCD> fetchGCDList();

	GCD pushGCD_DB_MQ(GCD gcd);

}
