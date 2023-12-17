@Controller
public class OAuth2Controller {
    @Autowired
    private UserService userService;

    @GetMapping("/login/oauth2/code/google")
    public String googleCallback(@RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient authorizedClient,
                                 @AuthenticationPrincipal OAuth2User oauth2User) {
        String googleId = oauth2User.getName();
        User user = userService.findByGoogleId(googleId);
        if (user == null) {
            user = new User();
            user.setEmail(oauth2User.getAttribute("email"));
            user.setName(oauth2User.getAttribute("name"));
            userService.save(user);
        }
        return "redirect:/";
    }
}