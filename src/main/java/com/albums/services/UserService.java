package com.albums.services;

import com.albums.Entity.User;
import com.albums.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Вова on 30.12.2016.
 */
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    private List<User> users = new ArrayList<User>();

    @PostConstruct
    @Transactional
    public void createAdminUser(){
        User userAdmin = userDao.findByLogin("admin");
        if(userAdmin==null){
            register("admin", "admin@mail.com", "qwerty");
        }
    }

    public List<User> getUsers(){
        return (List<User>)userDao.findAll();
    }

    @Transactional
    public Boolean register(String login, String email, String pass){
        String passHash = new BCryptPasswordEncoder().encode(pass);
        User u = new User(login, email.toLowerCase(), passHash);
        User saved = userDao.save(u);
        if(saved!=null){
            return true;
        }
        return false;
    }

    public User getUserByLogin(String login){
        User u = userDao.findByLogin(login);
        if(u!=null){return u;}

        return null;
    }

}
