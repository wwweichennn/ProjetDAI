package dao;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class semaineJour {
	
	public static List<String> getDatesOfThisWeek() {
	    List<String> dates = new ArrayList<>();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	    LocalDate today = LocalDate.now();
	    DayOfWeek dayOfWeek = today.getDayOfWeek();
	    LocalDate start = today.minusDays(dayOfWeek.getValue() - 1);
	    LocalDate end = today.plusDays(7 - dayOfWeek.getValue());
	    while (!start.isAfter(end)) {
	        dates.add(start.format(formatter));
	        start = start.plusDays(1);
	    }
	    return dates;
	}
	
	public  static List<String> getnomJours(){
		List<String> nomdates = new ArrayList<>();
		nomdates.add("Lundi");
		nomdates.add("Mardi");
		nomdates.add("Mercredi");
		nomdates.add("Jeudi");
		nomdates.add("Vendredi");
		nomdates.add("Samedi");
		nomdates.add("Dimanche");
		return nomdates;
	}

}
