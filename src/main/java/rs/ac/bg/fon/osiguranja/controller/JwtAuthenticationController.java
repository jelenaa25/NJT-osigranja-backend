package rs.ac.bg.fon.osiguranja.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.bg.fon.osiguranja.security.config.JwtTokenUtil;
import rs.ac.bg.fon.osiguranja.dto.AgentDto;
import rs.ac.bg.fon.osiguranja.model.Agent;
import rs.ac.bg.fon.osiguranja.model.JwtRequest;
import rs.ac.bg.fon.osiguranja.model.JwtResponse;
import rs.ac.bg.fon.osiguranja.service.AgentService;
import rs.ac.bg.fon.osiguranja.service.JwtAgentService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {
    
    @Autowired
    private AuthenticationProvider authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtAgentService userDetailsService;

    @Autowired
    private AgentService userService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        System.out.println("USERNAME:"+authenticationRequest.getUsername());
        System.out.println("PASSWORD:"+authenticationRequest.getPassword());
        
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        //String pass = passwordEncoder.encode(authenticationRequest.getPassword());
        //System.out.println("passss:"+pass);
        authenticate(authenticationRequest.getUsername(),authenticationRequest.getPassword());
        System.out.println("PROSLOOOOOOOOOOOOOOOOO");
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        System.out.println("USRDTLS:"+userDetails);
        Agent user = userService.loadUserByUsername(authenticationRequest.getUsername());
        System.out.println("Agent:"+user);
        final String token = jwtTokenUtil.generateToken(userDetails);
        //System.out.println("ROLE: "+user.getRole());
        AgentDto userDto = new AgentDto(user.getAgentID(), user.getUsername(), user.getIme(),user.getPrezime(), token);


        return ResponseEntity.ok(userDto); 
    
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            System.out.println("username: "+username+" password "+password);
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            
            throw new Exception("INVALID_CREDENTIALS: "+e.getMessage(), e);
        }
    }
    
    
    
    @PostMapping("/login")
    public ResponseEntity<Agent> login(@RequestBody Agent userForLogin) {

        //provera da li postoji user sa prosledjenim podacima za username i password
        try {
            Agent user = userService.loadUserByUsername(userForLogin.getUsername());
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            if (user != null && encoder.matches(userForLogin.getPassword(), user.getPassword())) {
                System.out.println("User " + user.getUsername() + " logged.");
                
                return new ResponseEntity<>(user, HttpStatus.OK);
            }
        } catch (Exception e) {
            //user ne postoji -> baca se izuzetak
            System.out.println(e.getMessage());
            throw new IllegalStateException("Bad credentials for login");

        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

}
 
