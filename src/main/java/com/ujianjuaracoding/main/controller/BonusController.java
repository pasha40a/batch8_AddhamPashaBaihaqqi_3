package com.ujianjuaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ujianjuaracoding.main.model.Bonus;
import com.ujianjuaracoding.main.model.BonusRowMapper;

@RestController
@RequestMapping("/bonus")
public class BonusController {
	@Autowired
	JdbcTemplate jdbc;
	// Bonus
		public List<Bonus> getBonus() {

			String sql = "Select * from bonus";

			List<Bonus> bonus = jdbc.query(sql, new BonusRowMapper());

			return bonus;

		}

		public String insertBonus(Bonus bonus) {
			int sukses = jdbc.update("INSERT INTO bonus(worker_ref_id,bonus_date,bonus_amount) VALUES ("
					+ bonus.getWorker_ref_id() + ",'" + bonus.getBonus_date() + "'," + bonus.getBonus_amount() + ")");
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil memasukan data";
			} else {
				hasil = "Gagal memasukan data";
			}
			return hasil;
		}

		public String deleteBonus(int worker_ref_id) {
			int sukses = jdbc.update("DELETE FROM `bonus` WHERE worker_ref_id=" + worker_ref_id);
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil menghapus data";
			} else {
				hasil = "Gagal menghapus data";
			}
			return hasil;
		}

		public String updateBonus(int worker_ref_id, Bonus bonus) {
			int sukses = jdbc.update("UPDATE bonus SET `bonus_date`='" + bonus.getBonus_date() + "',`bonus_amount`="
					+ bonus.getBonus_amount() + " WHERE worker_ref_id = " + bonus.getWorker_ref_id() + "");
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil mengupdate data";
			} else {
				hasil = "Gagal mengupdate data";
			}
			return hasil;
		}

		@GetMapping("/")
		public List<Bonus> bonus() {
			return getBonus();
		}

		@PostMapping("/insertbonus")
		public String add(@RequestBody Bonus bonus) {
			return insertBonus(bonus);
		}

		@DeleteMapping("/deletebonus/{worker_ref_id}") //
		public String hapus(@PathVariable int worker_ref_id) {
			return deleteBonus(worker_ref_id);
		}

		@PutMapping("/updatebonus/{worker_ref_id}")
		public ResponseEntity<?> update(@RequestBody Bonus bonus, @PathVariable int worker_ref_id) {
			try {
				updateBonus(worker_ref_id, bonus);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
