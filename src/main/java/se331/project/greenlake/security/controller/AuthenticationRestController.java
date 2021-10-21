package se331.project.greenlake.security.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class AuthenticationRestController {
//
//    @Value("${jwt.header}")
//    private String tokenHeader;
//
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JwtTokenUtil jwtTokenUtil;
//
//    @Autowired
//    private UserDetailsService userDetailsService;
//
//    @Autowired
//    UserRepository userRepository;
//
//
//
//    @PostMapping("${jwt.route.authentication.path}")
//    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
//
//        // Perform the security
//        final Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(
//                        authenticationRequest.getUsername(),
//                        authenticationRequest.getPassword()
//                )
//        );
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//
//        // Reload password post-security so we can generate token
//        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
//        final String token = jwtTokenUtil.generateToken(userDetails, device);
//        Map result = new HashMap();
//        result.put("token", token);
//        User user = userRepository.findById(((JwtUser) userDetails).getId()).orElse(null);
//                if (user.getOrganizer() != null) {
//                    result.put("user", LabMapper.INSTANCE.getOrganizerAuthDTO( user.getOrganizer()));
//                    }
//
//        return ResponseEntity.ok(result);
//    }
//
//
//    @GetMapping(value = "${jwt.route.authentication.refresh}")
//    public ResponseEntity<?> refreshAndGetAuthenticationToken(HttpServletRequest request) {
//        String token = request.getHeader(tokenHeader);
//        String username = jwtTokenUtil.getUsernameFromToken(token);
//        JwtUser user = (JwtUser) userDetailsService.loadUserByUsername(username);
//
//        if (jwtTokenUtil.canTokenBeRefreshed(token, user.getLastPasswordResetDate())) {
//            String refreshedToken = jwtTokenUtil.refreshToken(token);
//            return ResponseEntity.ok(new JwtAuthenticationResponse(refreshedToken));
//        } else {
//            return ResponseEntity.badRequest().body(null);
//        }
//    }
//
//    @PostMapping("${jwt.route.register.path}")
//    public ResponseEntity<?> registerAuthentication(@RequestBody JwtAuthenticationRequest authenticationRequest, Device device) throws AuthenticationException {
//        PasswordEncoder encoder = new BCryptPasswordEncoder();
//        if (userRepository.findByUsername(authenticationRequest.getUsername()) == null ){
//            userRepository.save(User.builder()
//                    .firstname(authenticationRequest.getUsername())
//                    .lastname(authenticationRequest.getUsername())
//                    .username(authenticationRequest.getUsername())
//                    .password(encoder.encode(authenticationRequest.getPassword()))
//                    .enabled(true)
//                    .lastPasswordResetDate(new Date(System.currentTimeMillis()))
//                    .email(authenticationRequest.getEmail())
//                    .organizer(Organizer.builder().id(1l).build())
//                    .build());
//            return ResponseEntity.ok("Registration successful");
//        }else {
//            return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_GATEWAY);
//        }
//    }


}
