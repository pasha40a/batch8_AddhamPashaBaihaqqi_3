package com.ujianjuaracoding.main.model;

public class Bonus {
	private int worker_ref_id;
	private String bonus_date;
	private int bonus_amount;	
	
	public Bonus() {
		
	}
	

	public Bonus(int worker_ref_id, String bonus_date, int bonus_amount) {
		super();
		this.worker_ref_id = worker_ref_id;
		this.bonus_date = bonus_date;
		this.bonus_amount = bonus_amount;
	}


	public int getWorker_ref_id() {
		return worker_ref_id;
	}

	public void setWorker_ref_id(int worker_ref_id) {
		this.worker_ref_id = worker_ref_id;
	}

	public String getBonus_date() {
		return bonus_date;
	}

	public void setBonus_date(String bonus_date) {
		this.bonus_date = bonus_date;
	}

	public int getBonus_amount() {
		return bonus_amount;
	}

	public void setBonus_amount(int bonus_amount) {
		this.bonus_amount = bonus_amount;
	}
	
	

}
