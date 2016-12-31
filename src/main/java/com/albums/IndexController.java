package com.albums;

import com.albums.Entity.Album;
import com.albums.Entity.User;
import com.albums.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.Random;

import static java.lang.Math.abs;

/**
 * Created by Вова on 30.12.2016.
 */
@Controller
@ComponentScan("com.albums")
public class IndexController {
    @Autowired
    AlbumDAO albumDAO;
    @Autowired
    UserService userService;

    @PostConstruct
    public void postConstruct(){
        User u = userService.getUserByLogin("admin");
        albumDAO.save(new Album(u,"Album 1","assets/img/photo/photo1.jpg", "Description: Some text"));
        albumDAO.save(new Album(u,"Album 2","assets/img/photo/photo2.jpg", "Description: Some text"));
        albumDAO.save(new Album(u,"Album 3","assets/img/photo/photo3.jpg", "Description: Some text"));
        albumDAO.save(new Album(u,"Album 4","assets/img/photo/photo4.jpg", "Description: Some text"));
        albumDAO.save(new Album(u,"Album 5","assets/img/photo/photo5.jpg", "Description: Some text"));
        albumDAO.save(new Album(u,"Album 6","assets/img/photo/photo6.jpg", "Description: Some text"));

    }

    @RequestMapping("/")
    public String  indexController(Model model){
        model.addAttribute("albums",albumDAO.findAll());
        return "index";
    }
    @RequestMapping(value = "/viewers", method = RequestMethod.GET)
    public @ResponseBody
    String getViewers(){
        Random rand = new Random();
        int view = abs(rand.nextInt())%100;
        String result = "Now you have "+view+" viewers <br/> At time: "+new Date();
        return result;
    }
}
