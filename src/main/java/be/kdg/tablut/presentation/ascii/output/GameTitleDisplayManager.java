package be.kdg.tablut.presentation.ascii.output;

public class GameTitleDisplayManager {

    static void printGameTitle() {

        System.out.print("\n".repeat(3));

        System.out.println(
         """
                             ___________     ___.   .__          __   \s
                            \\__    ___/____ \\_ |__ |  |  __ ___/  |_ \s
                              |    |  \\__  \\ | __ \\|  | |  |  \\   __\\\s
                              |    |   / __ \\| \\_\\ \\  |_|  |  /|  |  \s
                              |____|  (____  /___  /____/____/ |__|  \s
                                           \\/    \\/                  \s
         """);

        System.out.print("\n".repeat(3));
    }

}
