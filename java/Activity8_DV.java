package fst;

class CustomException extends Exception {

    private String message;

    CustomException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

public class Activity8 {

    public static void exceptionTest(String str) throws CustomException {
        if (str == null) {
            throw new CustomException("This method does not accept null strings");
        } else {
            System.out.println("Got Correct String -> " + str);
        }
    }

    public static void main(String[] args) {
        try {
            exceptionTest("Not an exception");
            exceptionTest(null);
        } catch (Exception exception) {
            System.out.println("Got exception with message -> " + exception.getMessage());
        }
    }
}
