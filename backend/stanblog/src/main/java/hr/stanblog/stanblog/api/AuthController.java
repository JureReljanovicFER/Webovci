package hr.stanblog.stanblog.api;
import hr.stanblog.stanblog.dao.UserRepository;
import hr.stanblog.stanblog.model.AppUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import hr.stanblog.stanblog.service.AuthService;
import org.springframework.web.client.RestTemplate;
import org.json.*;

import java.util.List;


@CrossOrigin(origins = {"http://localhost:5173", "https://jazzy-madeleine-64561a.netlify.app", "https://webovci-1.onrender.com"})
@RequestMapping("/oauth")
@RestController
public class AuthController {
    private final UserRepository userRepository;
    private AuthService userService;

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;

    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;

    @Autowired
    public AuthController(AuthService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @GetMapping("/getcode")
    public void getCode() {
        System.out.println("get code");
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject("https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=http://localhost:8080/api/oauth/login&response_type=code&client_id=860876392172-7ft3es30lvo02gc4dh1b0apcsoa5oijc.apps.googleusercontent.com&scope=https://googleapis.com/auth/userinfo.email&access_type=offline", String.class);
    }

    @GetMapping("/login")
    public ResponseEntity<AppUser> userLogin(@RequestParam ("token") String accessToken) throws JSONException {
        String data = this.getProfileDetailsGoogle(accessToken);
        System.out.println(data);
        JSONObject obj = new JSONObject(data);
        String email = String.valueOf(obj.get("email"));

        List<AppUser> user = userRepository.findByEmail(email);
        if (user.size() > 0) {
            return new ResponseEntity<>(user.get(0), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/accessEmail")
    public ResponseEntity<String> accessEmail(@RequestParam("token") String accessToken){
        System.out.println("accessEmail");

        String data = this.getProfileDetailsGoogle(accessToken);

        return new ResponseEntity<>(data, HttpStatus.CREATED);
    }

    private String getOauthAccessTokenGoogle(String code) {
        System.out.println("getOauthAccessTokenGoogle");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("code", code);
        params.add("redirect_uri", "http://localhost:8080/api/oauth/accessEmail");
        params.add("client_id", clientId);
        params.add("client_secret", clientSecret);
        params.add("scope", "https://googleapis.com/auth/userinfo.email");
        params.add("grant_type", "authorization_code");

        HttpEntity<MultiValueMap<String, String>> requestEntity = new HttpEntity<>(params, httpHeaders);

        String url = "https://www.googleapis.com/oauth2/v4/token";
        String response = restTemplate.postForObject(url, requestEntity, String.class);
        return response;
    }

    private String getProfileDetailsGoogle(String accessToken) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(accessToken);

        HttpEntity<String> requestEntity = new HttpEntity<>(httpHeaders);

        String url = "https://www.googleapis.com/oauth2/v2/userinfo";
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return response.getBody();
    }
}
