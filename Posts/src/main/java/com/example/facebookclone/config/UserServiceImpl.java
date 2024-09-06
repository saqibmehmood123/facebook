package com.example.facebookclone.config;



import com.example.facebookclone.repos.PostJPARepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
//@RequiredArgsConstructor
public class UserServiceImpl {
    @Autowired
    ///private final
    PostJPARepo playerRepository;
//    @Autowired
//    TokenLogout logout;
//
//    @Autowired
//    LogoutService logout;
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                return playerRepository.findById(1L).get();
                     ///   .orElseThrow(() -> new Exception("User not found"));
            }
        };
    }

//    public void setTimeLimit(String email, long timeLimit) {
//        Optional<Player> playerOpt = playerRepository.findByEmail(email);
//        if (playerOpt.isPresent()) {
//            Player player = playerOpt.get();
//            if (player.isActive()) {
//                player.setDailyTimeLimit(timeLimit);
//                playerRepository.save(player);
//
//            } else {
//                throw new IllegalStateException("Cannot set time limit for an inactive player.");
//            }
//        } else {
//            throw new UsernameNotFoundException("Player not found.");
//        }
//    }
//
//    @Scheduled(fixedRate = 90000) // check every minute
//    public void checkTimeLimits() {
//        List<Player> players = playerRepository.findAll();
//
//        long now = System.currentTimeMillis();
//        for (Player player : players) {
//
//            if (player.isActive() && player.getSessionStartTime() > 0) {
//
//                long sessionDuration = now - player.getSessionStartTime();
//                if (sessionDuration > player.getDailyTimeLimit()) {
//                    player.setSessionStartTime(0);
//                    logout.logout(player.getToken());
//                    playerRepository.save(player);
//                }
//            }
//        }
//    }
}
