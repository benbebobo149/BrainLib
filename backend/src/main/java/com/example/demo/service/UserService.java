@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User findByGoogleId(String googleId) {
        return userRepository.findByGoogleId(googleId);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}