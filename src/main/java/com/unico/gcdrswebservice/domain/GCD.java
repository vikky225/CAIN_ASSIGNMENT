package com.unico.gcdrswebservice.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


/**
 * This class contains GCD model which contains two property firstOperand & secondOperand
 * @Operations: N/A
 * @Developer: Vikas Malviya
 */

@Entity
public class GCD implements Serializable {
	private static final long serialVersionUID = 3370367844977691546L;



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@GeneratedValue
	@Id
	private Long id;
	private int firstOperand;
	private int secondOperand;

	private GCD() {

	}

	public GCD(int firstOperand, int secondOperand) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
	}

	public int getFirstOperand(){
		return firstOperand;
	}

	public void setFirstOperand(int firstOperand){
		this.firstOperand = firstOperand;
	}

	public int getSecondOperand(){
		return secondOperand;
	}
	public void setSecondOperand(int secondOperand){
		this.secondOperand = secondOperand;
	}


	@Override
	public String toString() {
		return "GCD{" +
				"id=" + id +
				", firstOperand=" + firstOperand +
				", secondOperand=" + secondOperand +
				'}';
	}
}
