package com.ujianjuaracoding.main.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
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
import com.ujianjuaracoding.main.model.Karyawan;
import com.ujianjuaracoding.main.model.Karyawan;
import com.ujianjuaracoding.main.model.KaryawanRowMapper;
import com.ujianjuaracoding.main.model.Title;
import com.ujianjuaracoding.main.model.TitleRowMapper;

@RestController
@RequestMapping("/karyawan")
public class KaryawanController {

	@Autowired
	JdbcTemplate jdbc;

	// Karyawan
	public List<Karyawan> getKaryawan() {

		String sql = "Select * from worker";

		List<Karyawan> Karyawan = jdbc.query(sql, new KaryawanRowMapper());

		return Karyawan;

	}

	public String insertKaryawan(Karyawan karyawan) {
		int sukses = jdbc
				.update("INSERT INTO worker(worker_id,first_name,last_name,salary,joining_date,department) VALUES ("
						+ karyawan.getWorker_id() + ",'" + karyawan.getFirst_name() + "','" + karyawan.getLast_name()
						+ "'," + karyawan.getSalary() + ",'" + karyawan.getJoining_date() + "','"
						+ karyawan.getDepartment() + "')");
		String hasil;

		if (sukses == 1) {
			hasil = "Berhasil memasukan data";
		} else {
			hasil = "Gagal memasukan data";
		}
		return hasil;
	}

	public String deleteKaryawan(int worker_id) {
		int sukses = jdbc.update("DELETE FROM `worker` WHERE worker_id=" + worker_id);
		String hasil;

		if (sukses == 1) {
			hasil = "Berhasil menghapus data";
		} else {
			hasil = "Gagal menghapus data";
		}
		return hasil;
	}

	public String updateKaryawan(int worker_id, Karyawan karyawan) {
		int sukses = jdbc.update("UPDATE worker SET `first_name`='" + karyawan.getFirst_name() + "',`last_name`='"
				+ karyawan.getLast_name() + "',`salary`=" + karyawan.getSalary() + ",`joining_date`='"
				+ karyawan.getJoining_date() + "',`department`='" + karyawan.getDepartment() + "' WHERE worker_id = '"
				+ karyawan.getWorker_id() + "'");

		String hasil;

		if (sukses == 1) {
			hasil = "Berhasil mengupdate data";
		} else {
			hasil = "Gagal mengupdate data";
		}
		return hasil;
	}

	@GetMapping("/karyawan")
	public List<Karyawan> Karyawan() {
		return getKaryawan();
	}

	@PostMapping("/insertkaryawan")
	public String add(@RequestBody Karyawan karyawan) {
		return insertKaryawan(karyawan);
	}

	@DeleteMapping("/deletekaryawan/{worker_id}") //
	public String hapus1(@PathVariable int worker_id) {
		return deleteKaryawan(worker_id);
	}

	@PutMapping("/updatekaryawan/{worker_id}")
	public ResponseEntity<?> update(@RequestBody Karyawan karyawan, @PathVariable int worker_id) {
		try {
			updateKaryawan(worker_id, karyawan);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	public List<Karyawan> getKaryawantinggi() {
		String sql = "SELECT worker_id,salary,first_name,last_name,department,joining_date FROM worker ORDER BY salary ASC LIMIT 5";
		List<Karyawan> Karyawan = jdbc.query(sql, new KaryawanRowMapper());

		return Karyawan;

	}

	public List<Karyawan> getKaryawansama() {
		String sql = "SELECT * FROM worker where salary IN (SELECT salary  FROM worker GROUP BY salary HAVING count(*) > 1)";
		List<Karyawan> Karyawan = jdbc.query(sql, new KaryawanRowMapper());

		return Karyawan;

	}

	public List<Karyawan> getKaryawantampilan() {
		String sql = "CALL `coba`('5')";

		List<Karyawan> Karyawan = jdbc.query(sql, new KaryawanRowMapper());

		return Karyawan;

	}

	
	//Nomor 2
	@GetMapping("/karyawantertinggi")
 	public List<Karyawan> karyawan(){
	 return getKaryawantinggi();
	}
	//nomor 3
	@GetMapping("/karyawansama")
    public List<Karyawan> Karyawan1() {
        return getKaryawansama();
    }
	//nomor 4
	@GetMapping("/karyawanjumlah")
    public List<Karyawan> Karyawan2() {
        return getKaryawantampilan();
    }

}
