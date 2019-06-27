package com.practise.users;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllers {
  
  private final UserRepository userRepository;

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<List<User>> get() {
    log.info("Fetching details of all users");
    List<User> users = userRepository.findAll();
    log.info("Fetched users: {}", users);
    return new ResponseEntity<List<User>>(users, HttpStatus.OK);
  }

  @RequestMapping(value = "/user", method = RequestMethod.POST)
  public ResponseEntity<?> create(@RequestBody User user) {
    log.info("Creating user: {}", user);
    userRepository.save(user);
    return new ResponseEntity<>(HttpStatus.OK);
  }

}
