package com.intuit.assignment.application;

import java.text.ParseException;

import com.intuit.assignment.daolayer.exception.AppException;
import com.intuit.assignment.daolayer.managers.AuditoriumManager;
import com.intuit.assignment.daolayer.managers.MovieManager;
import com.intuit.assignment.daolayer.managers.ScreeningManager;
import com.intuit.assignment.daolayer.managers.SeatManager;
import com.intuit.assignment.daolayer.managers.TheaterManager;
import com.intuit.assignment.daolayer.managers.UserManager;
import com.intuit.assignment.entities.Auditorium;
import com.intuit.assignment.entities.Movie;
import com.intuit.assignment.entities.Screening;
import com.intuit.assignment.entities.Seat;
import com.intuit.assignment.entities.Theater;
import com.intuit.assignment.entities.User;
import com.intuit.assignment.util.DateTimeUtil;
import com.intuit.assignment.util.DisplayUtil;

public class DummyMasterDataInitializer {

	static void init() throws ParseException, AppException {

		// DAO Managers
		TheaterManager theaterManager = TheaterManager.getInstance();
		AuditoriumManager auditoriumManager = AuditoriumManager.getInstance();
		MovieManager movieManager = MovieManager.getInstance();
		SeatManager seatManager = SeatManager.getInstance();
		UserManager userManager = UserManager.getInstance();
		ScreeningManager screeningManager = ScreeningManager.getInstance();

		// Creating theaters
		DisplayUtil.printDelimitedStart("Creating Theaters");
		Theater theater1 = initializeTheaters(theaterManager, "PVR Soul Space");
		Theater theater2 = initializeTheaters(theaterManager, "PVR Forum");

		// Creating auditoriums in both theaters
		DisplayUtil.printDelimitedStart("Creating Auditoriums");
		Auditorium the1audi1 = initializeAuditoriums(auditoriumManager, "Audi 1", theater1.getId(), 50);
		Auditorium the1audi2 = initializeAuditoriums(auditoriumManager, "Audi 2", theater1.getId(), 60);
		Auditorium the2audi1 = initializeAuditoriums(auditoriumManager, "Audi 1", theater2.getId(), 30);
		Auditorium the2audi2 = initializeAuditoriums(auditoriumManager, "Audi 2", theater2.getId(), 50);

		// Creating 50 seats in all auditoriums
		DisplayUtil.printDelimitedStart("Creating Seats");
		initializeSeats(the1audi1, seatManager);
		initializeSeats(the1audi2, seatManager);
		initializeSeats(the2audi1, seatManager);
		initializeSeats(the2audi2, seatManager);

		// Creating Users with access to Ticket Booking, Availability, and
		// Cancellation
		DisplayUtil.printDelimitedStart("Creating Users");
		initializeUsers(userManager, "user1", "pass1");
		initializeUsers(userManager, "user2", "pass2");

		// Creating movies
		DisplayUtil.printDelimitedStart("Creating Movies");
		Movie movie1 = initializeMovies(movieManager, "Golmaal Again!", "Rohit Shetty", "Ajay Devgn", "Comedy", 200);
		Movie movie2 = initializeMovies(movieManager, "Newton", "Someone", "Rajkumar", "Comedy", 210);

		// Creating screenings
		DisplayUtil.printDelimitedStart("Creating Screenings");
		// Theater 1 - Day 1
		initializeScreenings(screeningManager, movie1.getId(), the1audi1.getId(), "2017-11-01 07:40");
		initializeScreenings(screeningManager, movie1.getId(), the1audi1.getId(), "2017-11-01 10:20");
		initializeScreenings(screeningManager, movie1.getId(), the1audi2.getId(), "2017-11-01 09:00");
		initializeScreenings(screeningManager, movie1.getId(), the1audi2.getId(), "2017-11-01 12:00");
		initializeScreenings(screeningManager, movie2.getId(), the1audi1.getId(), "2017-11-01 12:40");
		initializeScreenings(screeningManager, movie2.getId(), the1audi1.getId(), "2017-11-01 15:00");
		initializeScreenings(screeningManager, movie2.getId(), the1audi2.getId(), "2017-11-01 16:50");
		initializeScreenings(screeningManager, movie2.getId(), the1audi2.getId(), "2017-11-01 20:00");
		// Theater 2 - Day 1
		initializeScreenings(screeningManager, movie1.getId(), the2audi1.getId(), "2017-11-01 08:40");
		initializeScreenings(screeningManager, movie1.getId(), the2audi1.getId(), "2017-11-01 11:20");
		initializeScreenings(screeningManager, movie1.getId(), the2audi2.getId(), "2017-11-01 10:00");
		initializeScreenings(screeningManager, movie1.getId(), the2audi2.getId(), "2017-11-01 13:00");
		initializeScreenings(screeningManager, movie2.getId(), the2audi1.getId(), "2017-11-01 13:40");
		initializeScreenings(screeningManager, movie2.getId(), the2audi1.getId(), "2017-11-01 16:00");
		initializeScreenings(screeningManager, movie2.getId(), the2audi2.getId(), "2017-11-01 17:50");
		initializeScreenings(screeningManager, movie2.getId(), the2audi2.getId(), "2017-11-01 21:00");
		// Theater 1 - Day 2
		initializeScreenings(screeningManager, movie1.getId(), the1audi1.getId(), "2017-11-02 07:40");
		initializeScreenings(screeningManager, movie1.getId(), the1audi1.getId(), "2017-11-02 10:20");
		initializeScreenings(screeningManager, movie1.getId(), the1audi2.getId(), "2017-11-02 09:00");
		initializeScreenings(screeningManager, movie1.getId(), the1audi2.getId(), "2017-11-02 12:00");
		initializeScreenings(screeningManager, movie2.getId(), the1audi1.getId(), "2017-11-02 12:40");
		initializeScreenings(screeningManager, movie2.getId(), the1audi1.getId(), "2017-11-02 15:00");
		initializeScreenings(screeningManager, movie2.getId(), the1audi2.getId(), "2017-11-02 16:50");
		initializeScreenings(screeningManager, movie2.getId(), the1audi2.getId(), "2017-11-02 20:00");
		// Theater 2 - Day 2
		initializeScreenings(screeningManager, movie1.getId(), the2audi1.getId(), "2017-11-02 08:40");
		initializeScreenings(screeningManager, movie1.getId(), the2audi1.getId(), "2017-11-02 11:20");
		initializeScreenings(screeningManager, movie1.getId(), the2audi2.getId(), "2017-11-02 10:00");
		initializeScreenings(screeningManager, movie1.getId(), the2audi2.getId(), "2017-11-02 13:00");
		initializeScreenings(screeningManager, movie2.getId(), the2audi1.getId(), "2017-11-02 13:40");
		initializeScreenings(screeningManager, movie2.getId(), the2audi1.getId(), "2017-11-02 16:00");
		initializeScreenings(screeningManager, movie2.getId(), the2audi2.getId(), "2017-11-02 17:50");
		initializeScreenings(screeningManager, movie2.getId(), the2audi2.getId(), "2017-11-02 21:00");

	}

	private static Screening initializeScreenings(ScreeningManager screeningManager, int movieId, int auditoriumId,
			String dateString) throws ParseException, AppException {
		Screening screening = new Screening(movieId, auditoriumId, DateTimeUtil.getDate(dateString));
		System.out.println(screening.toString());
		screeningManager.insert(screening, Screening.Column.ID.getCode());
		return screening;
	}

	private static Movie initializeMovies(MovieManager movieManager, String title, String director, String cast,
			String description, int durationMin) throws AppException {
		Movie movie = new Movie(title, director, cast, description, durationMin);
		System.out.println(movie.toString());
		movieManager.insert(movie, Movie.Column.ID.getCode());
		return movie;

	}

	private static Theater initializeTheaters(TheaterManager theaterManager, String name) throws AppException {
		Theater theater = new Theater(name);
		System.out.println(theater.toString());
		theaterManager.insert(theater, Theater.Column.ID.getCode());
		return theater;
	}

	private static Auditorium initializeAuditoriums(AuditoriumManager auditoriumManager, String name, int id,
			int maxCap) throws AppException {
		Auditorium auditorium = new Auditorium(name, id, maxCap);
		System.out.println(auditorium.toString());
		auditoriumManager.insert(auditorium, Auditorium.Column.ID.getCode());
		return auditorium;
	}

	private static void initializeSeats(Auditorium auditorium, SeatManager seatManager) throws AppException {
		int seatsPerRow = 10;
		int noOfRows = auditorium.getmaxCapacity() / seatsPerRow;
		Seat seat;
		for (int i = 0; i < noOfRows; i++) {
			for (int j = 0; j < seatsPerRow; j++) {
				seat = new Seat(i + 1, j + 1, auditorium.getId());
				seatManager.insert(seat, Seat.Column.ID.getCode());
				// System.out.println(seat.toString());
			}
		}
	}

	private static void initializeUsers(UserManager userManager, String username, String password) throws AppException {
		User user = new User(username, password);
		userManager.insert(user, User.Column.USERNAME.getCode());
		System.out.println(user.toString());
	}

}
