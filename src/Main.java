public class Main {
    public static void main(String[] args) {
        User first = new User("tamara2_", "hahah34efby5btrvrrwcrcrqrcrrca", "hahah34efby5btrvrrwcrcrqrcrrca");

        try {
            User.IsLogPassTrue(first.getLogin(), first.getPassword(), first.getConfirmPassword());
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }
}