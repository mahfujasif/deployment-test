package com.practise.users;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllers {
  

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<User> get() {
    log.info("Fetching details of all user");
    User user = new User();
    log.info("Fetched users: {}", user);
    return new ResponseEntity<User>(user, HttpStatus.OK);
  }

}
