package interfaces;

public interface IPay {
    public void pay();

    default void defaultMethod() {
       System.out.println("Here you pay");
    }
}
