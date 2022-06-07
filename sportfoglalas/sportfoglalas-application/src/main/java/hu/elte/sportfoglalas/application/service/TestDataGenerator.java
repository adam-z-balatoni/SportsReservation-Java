package hu.elte.sportfoglalas.application.service;

import hu.elte.sportfoglalas.domain.*;
import hu.elte.sportfoglalas.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class TestDataGenerator {

    @Autowired
    private SportCategoryRepository sportCategoryRepository;

    @Autowired
    private CourtRepository courtRepository;

    @Autowired
    private CoachRepository coachRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PassRepository passRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Autowired UserRepository userRepository;


    @Transactional
    public void createTestData() {

        SportCategory badminton = createSportCategory("Badminton", 3000);
        SportCategory squash = createSportCategory("Squash", 4000);
        SportCategory tennis = createSportCategory("Tennis", 5000);
        sportCategoryRepository.save(badminton);
        sportCategoryRepository.save(squash);
        sportCategoryRepository.save(tennis);


        Court badminton1 = createCourt("Badminton 1", badminton);
        Court badminton2 = createCourt("Badminton 2", badminton);
        Court badminton3 = createCourt("Badminton 3", badminton);
        Court badminton4 = createCourt("Badminton 4", badminton);
        Court squash1 = createCourt("Squash 1", squash);
        Court squash2 = createCourt("Squash 2", squash);
        Court tennis1 = createCourt("Tennis 1", tennis);
        Court tennis2 = createCourt("Tennis 2", tennis);
        Court tennis3 = createCourt("Tennis 3", tennis);
        courtRepository.save(badminton1);
        courtRepository.save(badminton2);
        courtRepository.save(badminton3);
        courtRepository.save(badminton4);
        courtRepository.save(squash1);
        courtRepository.save(squash2);
        courtRepository.save(tennis1);
        courtRepository.save(tennis2);
        courtRepository.save(tennis3);


        Coach coach1 = createCoach("coach1", "c1p", "CoachName 1", 2000, true, UserType.COACH);
        Coach coach2 = createCoach("coach2", "c2p", "CoachName 2", 2000, true, UserType.COACH);
        Coach coach3 = createCoach("coach3", "c3p", "CoachName 3", 2000, true, UserType.COACH);
        Coach coach4 = createCoach("coach4", "c4p", "CoachName 4", 2000, true, UserType.COACH);
        Coach coach5 = createCoach("coach5", "c5p", "CoachName 5", 3000, true, UserType.COACH);
        Coach coach6 = createCoach("coach6", "c6p", "CoachName 6", 3000, true, UserType.COACH);
        Coach coach7 = createCoach("coach7", "c7p", "CoachName 7", 3000, false, UserType.COACH);
        coachRepository.save(coach1);
        coachRepository.save(coach2);
        coachRepository.save(coach3);
        coachRepository.save(coach4);
        coachRepository.save(coach5);
        coachRepository.save(coach6);
        coachRepository.save(coach7);


        Player player1 = createPlayer("player1", "p1p", "PlayerName 1",UserType.JATEKOS);
        Player player2 = createPlayer("player2", "p2p", "PlayerName 2",UserType.JATEKOS);
        Player player3 = createPlayer("player3", "p3p", "PlayerName 3",UserType.JATEKOS);
        Player player4 = createPlayer("player4", "p4p", "PlayerName 4",UserType.JATEKOS);
        Player player5 = createPlayer("player5", "p5p", "PlayerName 5",UserType.JATEKOS);
        playerRepository.save(player1);
        playerRepository.save(player2);
        playerRepository.save(player3);
        playerRepository.save(player4);
        playerRepository.save(player5);


        userRepository.save(createAdmin("admin", "admin", UserTypeAdmin.ADMIN));


        Pass pass1 = createPass(player1, LocalDate.parse("2021-11-22"), badminton, 0.9, 10);
        Pass pass2 = createPass(player1, LocalDate.parse("2021-11-22"), tennis, 0.75, 20);
        Pass pass3 = createPass(player2, LocalDate.parse("2021-11-22"), squash, 0.9, 10);
        Pass pass4 = createPass(player3, LocalDate.parse("2021-11-22"), badminton, 0.9, 10);
        passRepository.save(pass1);
        passRepository.save(pass2);
        passRepository.save(pass3);
        passRepository.save(pass4);


        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), badminton1, null, "2022-01-03 14:00", pass1));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), badminton1, null, "2022-01-05 14:00", pass1));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), badminton2, null, "2022-01-07 14:00", pass1));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), squash1, coach4, "2022-01-10 14:00", null));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), squash1, coach4, "2022-01-12 14:00", null));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), tennis1, coach5, "2022-01-17 14:00", pass2));
        reservationRepository.save(createReservation(player1, LocalDate.parse("2021-11-22"), tennis1, coach5, "2022-01-19 14:00", pass2));

        reservationRepository.save(createReservation(player2, LocalDate.parse("2021-11-22"), badminton2, coach1, "2022-01-03 14:00", null));
        reservationRepository.save(createReservation(player2, LocalDate.parse("2021-11-22"), badminton1, coach1, "2022-01-05 14:00", null));
        reservationRepository.save(createReservation(player2, LocalDate.parse("2021-11-22"), squash1, coach3, "2022-01-07 14:00", pass3));
        reservationRepository.save(createReservation(player2, LocalDate.parse("2021-11-22"), squash2, coach3, "2022-01-10 14:00", pass3));
        reservationRepository.save(createReservation(player2, LocalDate.parse("2021-11-22"), squash2, null, "2022-01-12 14:00", pass3));

        reservationRepository.save(createReservation(player3, LocalDate.parse("2021-11-22"), badminton3, coach2, "2022-01-04 14:00", pass4));
        reservationRepository.save(createReservation(player3, LocalDate.parse("2021-11-22"), badminton3, coach2, "2022-01-06 14:00", pass4));
        reservationRepository.save(createReservation(player3, LocalDate.parse("2021-11-22"), badminton3, null, "2022-01-08 14:00", pass4));
        reservationRepository.save(createReservation(player3, LocalDate.parse("2021-11-22"), badminton4, coach2, "2022-01-13 14:00", pass4));


        // Admin hardcoded login info
        // Generate Player User
        // Generate Coach User

        // Test print
//        Iterable<Reservation> testDATA;
//        testDATA = reservationRepository.findAllByPlayerId(20);
//
//        System.out.println("\n****************************************");
//
//        for (Reservation r : testDATA) {
//            System.out.println(r.toStringRaw());
//        }
//
//        System.out.println();
//
//        for (Reservation r : testDATA) {
//            System.out.println(r.toString());
//        }
//
//        System.out.println("****************************************");

//        LocalDateTime now = LocalDateTime.now();
//        System.out.println("\nBefore: " + now);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH");
//        String formatDateTime = now.format(formatter) + ":00";
//        System.out.println("After: " + formatDateTime + "\n");


//        ReservationDTO-ból LocalDateTime-nak megfelelő formátumba
//        LocalDateTime startTime = LocalDateTime.parse(formatDateTime);
//        System.out.println(startTime);
//        System.out.println();


    }

    private SportCategory createSportCategory(String name, int price) {
        SportCategory sportCategory = new SportCategory();
        sportCategory.setName(name);
        sportCategory.setPrice(price);
        return sportCategory;
    }

    public Court createCourt(String name, SportCategory sportCategory) {
        Court court = new Court();
        court.setName(name);
        court.setSportCategory(sportCategory);
        return court;
    }

    private User createAdmin(String username, String password, UserTypeAdmin userType) {
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setUserTypeAdmin(userType);
        return user;
    }

    private Coach createCoach(String username, String password,
                              String name, double price, boolean available, UserType userType) {
        Coach coach = new Coach();
        coach.setUsername(username);
        coach.setPassword(passwordEncoder.encode(password));
        coach.setName(name);
        coach.setPrice(price);
        coach.setAvailable(available);
        coach.setUserType(userType);
        return coach;
    }

    private Player createPlayer(String username, String password, String name, UserType userType) {
        Player player = new Player();
        player.setUsername(username);
        player.setPassword(passwordEncoder.encode(password));
        player.setName(name);
        player.setUserType(userType);
        return player;
    }

    private Pass createPass(Player player, LocalDate purchaseDate, SportCategory sportCategory,
                            double discount, int remainingReservations) {
        Pass pass = new Pass();
        pass.setPlayer(player);
        pass.setPurchaseDate(purchaseDate);
        pass.setSportCategory(sportCategory);
        pass.setDiscount(discount);
        pass.setRemainingReservations(remainingReservations);
        return pass;
    }

    private Reservation createReservation
            (Player player,LocalDate purchaseDate, Court court, Coach coach, String startTime, Pass pass) {
        Reservation reservation = new Reservation();
        reservation.setPlayer(player);
        reservation.setPurchaseDate(purchaseDate);
        reservation.setCourt(court);
        reservation.setCoach(coach);
        reservation.setStartTime(startTime);
        reservation.setPass(pass);

        if (pass != null) reducePass(pass);

        return reservation;
    }

    public void reducePass(Pass pass) {
        pass.setRemainingReservations(pass.getRemainingReservations() - 1);
    }
}

//SELECT * FROM SPORT_CATEGORY ;
//SELECT * FROM COURT ;
//SELECT * FROM USER;
//SELECT * FROM PASS;
//SELECT * FROM RESERVATION;


