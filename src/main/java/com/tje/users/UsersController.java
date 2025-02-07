package com.tje.users;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class UsersController {

    @GetMapping("/")
    public String home(Model model) throws ParseException {
        String startDateString = "20/05/2007 07:32";
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        Date startDate = df.parse(startDateString);
        LocalDateTime converted = startDate.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
        long daysSinceRegistration = ChronoUnit.DAYS.between(converted, LocalDateTime.now());
        User user = new User(2, "Artur", 36, User.UserType.ADMIN,LocalDateTime.of(2008, 11, 21, 12, 21));
        model.addAttribute("user", user);
        model.addAttribute("daysSinceRegistration", daysSinceRegistration);
        String userTypePolish;
        switch (user.getUserType()) {
            case ADMIN: userTypePolish = "Administrator"; break;
            case GUEST: userTypePolish = "Gość"; break;
            case REGISTERED: userTypePolish = "Zarejestrowany"; break;
            default: userTypePolish = "Nieznany"; break;
        }
        model.addAttribute("userTypePolish", userTypePolish);
        return "home";
    }
    @GetMapping("/list")
    public String list(Model model) throws ParseException {
        List<User> users = Arrays.asList(
                new User(1, "kox", 11,  User.UserType.ADMIN, LocalDateTime.of(2008, 10, 21, 12, 21)),
                new User(2, "test", 40,   User.UserType.REGISTERED,LocalDateTime.of(2008, 11, 21, 12, 21)),
                new User(3, "cthulhu", 34,  User.UserType.ADMIN,LocalDateTime.of(2008, 11, 23, 12, 21)),
                new User(4, "robert", 39, User.UserType.REGISTERED,LocalDateTime.of(2008, 11, 26, 12, 21) ),
                new User(5, "lewandowski", 28, User.UserType.REGISTERED,LocalDateTime.of(2008, 11, 29, 12, 21) )
        );
        model.addAttribute("users", users);
        return "list";
    }
}

