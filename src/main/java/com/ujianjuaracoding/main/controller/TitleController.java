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

import com.ujianjuaracoding.main.model.Title;
import com.ujianjuaracoding.main.model.TitleRowMapper;

@RestController
@RequestMapping("/title")
public class TitleController {
	@Autowired
	JdbcTemplate jdbc;

	// Title
		public List<Title> getTitle() {

			String sql = "Select * from title";

			List<Title> title = jdbc.query(sql, new TitleRowMapper());

			return title;

		}

		public String insertTitle(Title title) {
			int sukses = jdbc.update("INSERT INTO title(worker_ref_id,worker_title,affected_from) VALUES ("
					+ title.getWorker_ref_id() + ",'" + title.getWorker_title() + "','" + title.getAffected_from() + "')");
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil memasukan data";
			} else {
				hasil = "Gagal memasukan data";
			}
			return hasil;
		}

		public String deleteTitle(int worker_ref_id) {
			int sukses = jdbc.update("DELETE FROM `title` WHERE worker_ref_id=" + worker_ref_id);
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil menghapus data";
			} else {
				hasil = "Gagal menghapus data";
			}
			return hasil;
		}

		public String updateTitle(int worker_ref_id, Title title) {
			int sukses = jdbc.update("UPDATE title SET `worker_title`='" + title.getWorker_title() + "',`affected_from`='"
					+ title.getAffected_from() + "' WHERE worker_ref_id = " + title.getWorker_ref_id() + "");
			String hasil;

			if (sukses == 1) {
				hasil = "Berhasil mengupdate data";
			} else {
				hasil = "Gagal mengupdate data";
			}
			return hasil;
		}

		@GetMapping("/")
		public List<Title> title() {
			return getTitle();
		}

		@PostMapping("/insert")
		public String add(@RequestBody Title title) {
			return insertTitle(title);
		}

		@DeleteMapping("/delete/{worker_ref_id}") //
		public String hapus2(@PathVariable int worker_ref_id) {
			return deleteTitle(worker_ref_id);
		}

		@PutMapping("/update/{worker_ref_id}")
		public ResponseEntity<?> update(@RequestBody Title title, @PathVariable int worker_ref_id) {
			try {
				updateTitle(worker_ref_id, title);
				return new ResponseEntity<>(HttpStatus.OK);
			} catch (NoSuchElementException e) {
				// TODO: handle exception
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}

}
