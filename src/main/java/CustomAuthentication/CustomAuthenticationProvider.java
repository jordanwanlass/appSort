//package CustomAuthentication;
//
//import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.stereotype.Component;
//
///**
// * Created by jordanwanlass on 5/30/17.
// */
//@Component
//public class CustomAuthenticationProvider implements AuthenticationProvider {
//    /**
//     * Authenticates the user when they attempt to login
//     * @param authentication Object containing the users inputs
//     * @return
//     * @throws AuthenticationException
//     */
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
////        RestTemplate restTemplate = new RestTemplate();
////        String username = authentication.getName();
////        String password = authentication.getCredentials().toString();
////        HttpHeaders headers = new HttpHeaders();
////        headers.setContentType(MediaType.APPLICATION_JSON);
////        try {
////            String encodedName = URLEncoder.encode(username,"UTF-8");
////            String encodedPassword = URLEncoder.encode(password, "UTF-8");
////            String body = "grant_type=password&username=" + encodedName + "&password=" + encodedPassword;
////            ResponseEntity responseEntity = null;
////            try {
////                responseEntity = restTemplate.exchange("https://api.greenreceipt.net/Token", HttpMethod.POST, new HttpEntity<Object>(body, headers), String.class);
////            } catch (Exception e) {
////                return null;
////            }
////            if (responseEntity != null && responseEntity.getStatusCode().value() == 200) {
////                Gson gson = new Gson();
////                UserInfo userInfo = gson.fromJson((String) responseEntity.getBody(), new TypeToken<UserInfo>(){}.getType());// Save the users information
////                List<GrantedAuthority> grantedAuths = new ArrayList<GrantedAuthority>();
////                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));// Give them the role of user
////                Authentication auth = new UsernamePasswordAuthenticationToken(userInfo, password, grantedAuths);
////                return auth;
////            } else {
////                return null;
////            }
////        } catch (UnsupportedEncodingException e) {
////            e.printStackTrace();
////        }
//
//        return null;
//    }
//
//    public boolean supports(Class<?> authentication) {
//        return authentication.equals(UsernamePasswordAuthenticationToken.class);
//    }
//}