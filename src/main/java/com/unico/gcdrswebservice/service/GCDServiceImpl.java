package com.unico.gcdrswebservice.service;

import javax.transaction.Transactional;

import com.unico.gcdrswebservice.domain.GCD;
import com.unico.gcdrswebservice.repository.GCDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class GCDServiceImpl implements GCDService {

	private GCDRepository gcdRepository;

	
	@Autowired
	public GCDServiceImpl(GCDRepository gcdRepository){
		this.gcdRepository = gcdRepository;

	}

	@Override
	public Iterable<GCD> fetchGCDList() {
		return gcdRepository.findAll();
	}



	@Override
	@Transactional
	public GCD pushGCD_DB_MQ(GCD gcd) {
		// save the new author
		gcdRepository.save(gcd);
		System.out.println("gcd saved to DB");
		return gcdRepository.save(gcd);
	}



}
