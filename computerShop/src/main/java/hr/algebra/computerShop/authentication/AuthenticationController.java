package hr.algebra.computerShop.authentication;

import hr.algebra.computerShop.feature.user.request.LoginRequest;
import hr.algebra.computerShop.feature.user.request.RegisterRequest;
import hr.algebra.computerShop.feature.user.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

  @Autowired private AuthenticationService authenticationService;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest loginRequest) {
    return authenticationService.login(loginRequest);
  }

  @PostMapping("/register")
  public void register(@RequestBody RegisterRequest registerRequest) {
    authenticationService.register(registerRequest);
  }

  @GetMapping("/logout")
  public void logout(@RequestHeader("Authorization") String bearer) {
    authenticationService.logout(bearer.substring(7));
  }
}
