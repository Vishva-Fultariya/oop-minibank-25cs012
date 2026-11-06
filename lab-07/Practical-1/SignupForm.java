
public class SignupForm {

    @NotBlank
    @MaxLength(20)
    private String name;

    @NotBlank
    @MaxLength(30)
    private String email;

    @NotBlank
    @MaxLength(15)
    private String password;

    public SignupForm(String name, String email, String password) {

        this.name = name;
        this.email = email;
        this.password = password;
    }
}
