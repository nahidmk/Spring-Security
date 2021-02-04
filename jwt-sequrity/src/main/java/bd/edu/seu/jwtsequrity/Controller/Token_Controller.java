package bd.edu.seu.jwtsequrity.Controller;

import bd.edu.seu.jwtsequrity.Model.Login_Credential;
import bd.edu.seu.jwtsequrity.Model.Token;
import bd.edu.seu.jwtsequrity.Service.CustomUserDetailsService;
import bd.edu.seu.jwtsequrity.Util.Jwt_Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/token")
public class Token_Controller {

    @Autowired
    private Jwt_Util jwtUtil;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping("/get-token")
//@RequestMapping(value = "/token", method = RequestMethod.POST)
    public ResponseEntity<?> getToken(@RequestBody Login_Credential loginCredential) throws Exception {


        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginCredential.getName(),loginCredential.getPass()));
        }catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        UserDetails userDetails = customUserDetailsService.loadUserByUsername(loginCredential.getName());
        String token = this.jwtUtil.generateToken(userDetails);
        System.out.println("Token: "+token);
        return ResponseEntity.ok(new Token(token));
    }
}
