package com.training.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.training.springboot.model.Karyawan;
import com.training.springboot.services.KaryawanManagerImpl;


@RestController
public class KaryawanController {
	
	private final KaryawanManagerImpl karyawanManager;

	@Autowired
	public KaryawanController(KaryawanManagerImpl karyawanManager) {
		super();
		this.karyawanManager = karyawanManager;
	}
	
//	@RequestMapping("/")
//	public String dashboard() {
//		return "index";
//	}
	
	@RequestMapping("index_karyawan")
	public List<Karyawan> dashboardPage(Model model) {
		return karyawanManager.getListKaryawan();
	}

	@RequestMapping(value="save_karyawan", method=RequestMethod.POST)
	public void addDataKaryawan(@RequestBody Karyawan karyawan) {
		karyawanManager.insertKaryawan(karyawan);
	}
	
	@RequestMapping("index_karyawan/{kode_karyawan}")
	public Karyawan findKaryawanById(@PathVariable(name = "kode_karyawan") String kode_karyawan) {
		return karyawanManager.getKaryawanByKode(kode_karyawan);
	}
	
	@RequestMapping("delete_karyawan/{kode_karyawan}")
	public void deleteKaryawan(@PathVariable(name = "kode_karyawan") String kode_karyawan) {
		karyawanManager.deleteKaryawanByKode(kode_karyawan);
	}
}
