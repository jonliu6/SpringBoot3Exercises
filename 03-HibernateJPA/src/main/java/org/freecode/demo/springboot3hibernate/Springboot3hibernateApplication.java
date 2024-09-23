package org.freecode.demo.springboot3hibernate;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.freecode.demo.springboot3hibernate.dao.AlbumDAO;
import org.freecode.demo.springboot3hibernate.entity.Album;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Springboot3hibernateApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springboot3hibernateApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AlbumDAO albumDAO) {
		return runner -> {
			createNewAlbum(albumDAO);
		};
	}

	private void createNewAlbum(AlbumDAO albumDAO) {
		// create an Album object
		Date albumPublishedDate = new GregorianCalendar(1987, Calendar.JULY, 21).getTime();
		Album newAlbum = new Album("Appetite for Destruction", "Guns N' Roses", "Heavy Metal", albumPublishedDate, "CD");
		
		// persist the Album object
		albumDAO.save(newAlbum);
		
		System.out.println("New album " + newAlbum.getId() + " persisted.");
	}
	
}
