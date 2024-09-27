package org.freecode.demo.springboot3hibernate;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

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
			
			// getAnAlbum(albumDAO);
			
			// listAllAlbums(albumDAO);
			
			// updateAnAlbum(albumDAO);
			
			// changeAlbumFormat(albumDAO);
			
			// deleteAnAlbum(albumDAO);
			
			// deleteAlbumsByName(albumDAO);
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
	
	private void getAnAlbum(AlbumDAO albumDAO) {
		int id = 1;
		System.out.println(albumDAO.findById(id));
	}
	
	private void listAllAlbums(AlbumDAO albumDAO) {
		List<Album> albums = albumDAO.findAll();
//		for(Album album : albums) {
//			System.out.println(album);
//		}
		// replace the above loop with Lambda Expression
		albums.forEach(album -> System.out.println(album));
	}
	
	private void updateAnAlbum(AlbumDAO albumDAO) {
		Album oldAlbum = albumDAO.findById(7);
		System.out.println(oldAlbum);
		if (oldAlbum != null) {
			oldAlbum.setFormat("MP3");
			Album updatedAlbum = albumDAO.updateAnAlbum(oldAlbum);
			System.out.println(updatedAlbum);
		}
	}
	
	private void changeAlbumFormat(AlbumDAO albumDAO) {
		String newFormat = "CD";
		System.out.println(albumDAO.updateFormatOfAlbums(newFormat) + " album(s) updated to " + newFormat + " format.");
	}
	
	private void deleteAnAlbum(AlbumDAO albumDAO) {
		int id = 7;
		Album album = albumDAO.deleteById(id);
		System.out.println((album == null ? "nothing" : album.getName()) + " deleted");
	}
	
	private void deleteAlbumsByName(AlbumDAO albumDAO) {
		String name = "Appetite for Destruction";
		System.out.println(albumDAO.deleteByName(name) + " album(s) deleted");
	}
}
