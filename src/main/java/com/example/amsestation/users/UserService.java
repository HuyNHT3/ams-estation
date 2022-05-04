package com.example.amsestation.users;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    public List<User> getUsers(){
        List<User> user = new ArrayList<User>();
        user.add(new User(
                1L,
                "Huy",
                "Thanhhuy@gmail",
                "110 Leduan",
                "0393863417",
                29));
        return user;
    }
}
