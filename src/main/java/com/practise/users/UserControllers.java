package com.practise.users;

import java.util.HashMap;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserControllers {

  private final String HEALTH_MESSAGE = "Current API version for deployment-test: 1";

  @RequestMapping(path = "health-check", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ResponseEntity<Map<String, String>> healthCheck() {
    Map<String, String> map = new HashMap<>();
    map.put("message", HEALTH_MESSAGE);
    System.out.println("health check ok");
    return new ResponseEntity<Map<String, String>>(map , HttpStatus.OK);
  }

  @RequestMapping(value = "/user", method = RequestMethod.GET)
  public ResponseEntity<User> get() {
    log.info("Fetching details of all user");
    User user = new User();
    log.info("Fetched users: {}", user);
    return new ResponseEntity<User>(user, HttpStatus.OK);
  }

}
