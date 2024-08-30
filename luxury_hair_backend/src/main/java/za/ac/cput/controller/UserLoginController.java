package za.ac.cput.controller;

//import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
//import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
//import com.google.api.client.http.javanet.NetHttpTransport;
//import com.google.api.client.json.gson.GsonFactory;
//import za.ac.cput.domain.GoogleLoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import za.ac.cput.domain.UserLogin;
import za.ac.cput.services.UserLoginService;
import java.util.HashMap;
import java.util.Map;
@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/userlogin")
//@CrossOrigin(origins = "http://localhost:5173")

public class UserLoginController {
    private static final String CLIENT_ID = "116310698020-3tjps2m44tu1vgl6nh6phvt91l0l1mf8.apps.googleusercontent.com";

    @Autowired
    private UserLoginService userLoginService;

    // Create a new AdminLogin
    @PostMapping("/create")
    public UserLogin createUser(@RequestBody UserLogin request) {
        return userLoginService.create(request);
    }


    @PostMapping("/read")
    public ResponseEntity<String> loginUser(@RequestBody UserLogin loginDetails) {
        try {
            boolean isAuthenticated = userLoginService.authenticateUser(loginDetails.getEmail(), loginDetails.getPassword());

            if (isAuthenticated) {
                return ResponseEntity.ok("Login successful!");
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login. Please try again.");
        }
    }

    @GetMapping("/email-exists")
    public ResponseEntity<Map<String, Boolean>> checkEmailExists(@RequestParam String email) {
        boolean exists = userLoginService.checkEmailExists(email);
        Map<String, Boolean> response = new HashMap<>();
        response.put("exists", exists);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/update")
    public UserLogin update(@RequestBody UserLogin userLogin){
        return userLoginService.update(userLogin);
    }


//    @PostMapping("/google-login")
//    public ResponseEntity<String> googleLogin(@RequestBody GoogleLoginRequest googleLoginRequest) {
//        String token = googleLoginRequest.getToken();
//
//        try {
//            // Set up Google Public Key Manager and Token Verifier with GsonFactory
//            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(
//                    new NetHttpTransport(),
//                    new GsonFactory() // Use GsonFactory instead of JacksonFactory
//            ).setAudience(Collections.singletonList(CLIENT_ID))
//                    .build();
//
//            // Verify the ID Token
//            GoogleIdToken idToken = verifier.verify(token);
//
//            if (idToken == null) {
//                return ResponseEntity.status(401).body("Invalid Google token.");
//            }
//
//            GoogleIdToken.Payload payload = idToken.getPayload();
//            String email = payload.getEmail();
//
//            UserLogin user = userLoginService.findByEmail(email);
//            if (user == null) {
//                // Optionally create a new user if not found
//                return ResponseEntity.status(401).body("User not found.");
//            }
//
//            return ResponseEntity.ok("Google login successful!");
//        } catch (IOException | GeneralSecurityException e) {
//            return ResponseEntity.status(500).body("Internal server error.");
//        }

//            try {
//                boolean isAuthenticated = userLoginService.authenticateUser(request);
//                if (isAuthenticated) {
//                    return ResponseEntity.ok("Login successful!");
//                } else {
//                    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password.");
//                }
//            } catch (Exception e) {
//                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred during login.");
//            }


}