package com.intuit.assignment.receivers;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.intuit.assignment.application.ServiceContext;
import com.intuit.assignment.entities.Auditorium;
import com.intuit.assignment.entities.Movie;
import com.intuit.assignment.entities.Screening;
import com.intuit.assignment.entities.Theater;
import com.intuit.assignment.services.AuditoriumService;
import com.intuit.assignment.services.MovieService;
import com.intuit.assignment.services.ScreeningService;
import com.intuit.assignment.services.TheaterService;
import com.intuit.assignment.util.DateTimeUtil;
import com.intuit.assignment.util.ScannerUtil;

public class CommonMethodsReceiver {

	private static ScannerUtil sc = ScannerUtil.getInstance();

	protected static void showBookTicketOptions(ServiceContext serviceContext) throws Exception {
		boolean tryAgain = true;
		while (tryAgain) {
			System.out.println("Select one of the options mentioned below :");
			System.out.println("Search by Movie (a)");
			System.out.println("Search by Theater (b)");
			System.out.println("Search by Date (c)");
			char ch = sc.getFirstChar();
			switch (ch) {
			case 'a':
				showSearchByMovieFlow(serviceContext);
				tryAgain = false;
				break;
			case 'b':
				showSearchByTheaterFlow(serviceContext);
				tryAgain = false;
				break;
			case 'c':
				showSearchByDateFlow(serviceContext);
				tryAgain = false;
				break;
			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}

	protected static void showSearchByMovieFlow(ServiceContext serviceContext) throws Exception {
		boolean tryAgain = true;
		while (tryAgain) {
			List<Integer> availableMoviesId = showAvailableMovies();
			System.out.println("The following movies are available");
			System.out.format("%-3s%-15s\n", "ID", "Movie");
			for (Integer movieId : availableMoviesId) {
				Movie movie = MovieService.retrieveMovies(movieId);
				System.out.format("%-3s%-15s\n", movie.getId(), movie.getTitle());
			}
			System.out.println("Enter the ID of the movie.");
			int id = sc.getNextInt();
			if (availableMoviesId.contains(id)) {
				tryAgain = false;
			}
			if (tryAgain)
				System.out.println("Invalid input or invalid id");
			else {
				showAndSelectScreeningId(serviceContext, id, "movie");
				if (serviceContext.getScreeningId() == -1)
					tryAgain = true;
			}
		}
	}

	protected static void showSearchByTheaterFlow(ServiceContext serviceContext) throws Exception {
		boolean tryAgain = true;
		while (tryAgain) {
			List<Integer> availableTheaterIds = showAvailableTheaters();
			System.out.println("The following theaters are available");
			System.out.format("%-3s%-15s\n", "ID", "Theater");
			for (Integer theaterId : availableTheaterIds) {
				Theater theater = TheaterService.retrieveTheater(theaterId);
				System.out.format("%-3s%-15s\n", theater.getId(), theater.getName());
			}
			System.out.println("Enter the ID of the theater.");
			int id = sc.getNextInt();
			if (availableTheaterIds.contains(id)) {
				tryAgain = false;
			}
			if (tryAgain)
				System.out.println("Invalid input or invalid id");
			else {
				showAndSelectScreeningId(serviceContext, id, "theater");
				if (serviceContext.getScreeningId() == -1)
					tryAgain = true;
			}
		}
	}

	protected static List<Integer> showAvailableTheaters() {
		List<Integer> lstTheaterIds = TheaterService.retrieveAllTheaters().stream().map(x -> x.getId())
				.collect(Collectors.toList());
		return lstTheaterIds;
	}

	protected static void showAndSelectScreeningId(ServiceContext serviceContext, int id, String type)
			throws Exception {
		List<Screening> lstScreening = null;
		if ("movie".equalsIgnoreCase(type)) {
			lstScreening = ScreeningService.retrieveScreenings(x -> x.getMovieId() == id);
		}
		if ("theater".equalsIgnoreCase(type)) {
			List<Integer> lstAuditoriumId = AuditoriumService.retrieveAuditoriums(x -> x.getTheaterId() == id).stream()
					.map(x -> x.getId()).collect(Collectors.toList());
			lstScreening = ScreeningService.retrieveScreenings(x -> lstAuditoriumId.contains(x.getAuditoriumId()));
		}
		selectScreeningId(serviceContext, lstScreening, "movie id");
	}

	protected static void selectScreeningId(ServiceContext serviceContext, List<Screening> lstScreening,
			String errorText) throws Exception {
		if (lstScreening != null && !lstScreening.isEmpty()) {
			boolean tryAgain = true;
			while (tryAgain) {
				System.out.println("All screenings");
				showScreenings(lstScreening);
				System.out.println("Enter the ID of the screening which you wish to see");
				int id = sc.getNextInt();
				if (lstScreening.stream().anyMatch(x -> x.getId() == id)) {
					tryAgain = false;
					serviceContext.setScreeningId(id);
				} else
					System.out.println("Please enter any ID present on the screen.");
			}
		} else {
			System.out.println("There are no shows with selected " + errorText);
		}
	}

	protected static List<Integer> showAvailableMovies() {
		List<Integer> lstMovieIds = new ArrayList<>();
		List<Screening> lstScreenings = ScreeningService
				.retrieveScreenings(x -> x.getScreenigStart().compareTo(new Date()) > 0);
		for (Screening screening : lstScreenings) {
			if (!lstMovieIds.contains(screening.getMovieId()))
				lstMovieIds.add(screening.getMovieId());
		}
		return lstMovieIds;
	}

	protected static void showSearchByDateFlow(ServiceContext serviceContext) throws Exception {
		boolean tryAgain = true;
		while (tryAgain) {
			List<Date> availableDates = showAvailableDates();
			System.out.println("The movies are available on following dates");
			for (Date dt : availableDates) {
				System.out.println(DateTimeUtil.format2.format(dt));
			}
			System.out.println("Enter the date in \"yyyy-MM-dd\"");
			String dateString = sc.getNextString();
			Date date = null;
			try {
				date = DateTimeUtil.getDate(dateString + " 00:00");
				if (date.compareTo(new Date()) > 0 && isDateinAvailableDates(availableDates, date))
					tryAgain = false;
			} catch (ParseException e) {
				System.err.println("Faced issue while parsing date");
			}

			if (tryAgain)
				System.out.println("Invalid input or invalid date");
			else {
				showAndSelectScreeningId(serviceContext, date);
				if (serviceContext.getScreeningId() == -1)
					tryAgain = true;
			}
		}
	}

	protected static boolean isDateinAvailableDates(List<Date> availableDates, Date date) {
		return availableDates.stream().anyMatch(x -> x.compareTo(date) == 0);
	}

	protected static List<Date> showAvailableDates() {
		List<Date> lstDate = new ArrayList<>();
		List<Screening> lst = ScreeningService.retrieveScreenings(x -> x.getScreenigStart().compareTo(new Date()) > 0);
		for (Screening screening : lst) {
			Date extractedDate = DateTimeUtil.date(screening.getScreenigStart());
			if (!lstDate.stream().anyMatch(x -> x.compareTo(extractedDate) == 0)) {
				lstDate.add(extractedDate);
			}
		}
		return lstDate;
	}

	protected static void showAndSelectScreeningId(ServiceContext serviceContext, Date screeningDate) throws Exception {
		List<Screening> lstScreening = ScreeningService.retrieveScreenings(screeningDate);
		selectScreeningId(serviceContext, lstScreening, "date");
	}

	protected static void showScreenings(List<Screening> lst) {
		System.out.format("%-3s%-15s%-15s%-12s\n", "ID", "Movie", "Theater", "Time");
		for (Screening screening : lst) {
			Movie movie = MovieService.retrieveMovies(screening.getMovieId());
			Auditorium auditorium = AuditoriumService.retrieveAuditoriums(screening.getAuditoriumId());
			Theater theater = TheaterService.retrieveTheater(auditorium.getTheaterId());
			System.out.format("%-3s%-15s%-15s%-12s\n", screening.getId(), movie.getTitle(), theater.getName(),
					screening.getScreenigStart());
		}
	}

}
