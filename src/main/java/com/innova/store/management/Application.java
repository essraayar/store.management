package com.innova.store.management;

import com.innova.store.management.service.implementation.ReportServiceImpl;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.FileNotFoundException;

@SpringBootApplication
public class Application {

	@Autowired
	private ReportServiceImpl service;

	/*@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws JRException, FileNotFoundException {
		return service.exportReport(format);
	}*/
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}

