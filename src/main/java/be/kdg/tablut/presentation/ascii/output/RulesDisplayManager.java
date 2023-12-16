package be.kdg.tablut.presentation.ascii.output;

public class RulesDisplayManager {

    public static void displayRules() {
        System.out.println(
                "  ________                        __________      .__                 \n" +
                " /  _____/_____    _____   ____   \\______   \\__ __|  |   ____   ______\n" +
                "/   \\  ___\\__  \\  /     \\_/ __ \\   |       _/  |  \\  | _/ __ \\ /  ___/\n" +
                "\\    \\_\\  \\/ __ \\|  Y Y  \\  ___/   |    |   \\  |  /  |_\\  ___/ \\___ \\ \n" +
                " \\______  (____  /__|_|  /\\___  >  |____|_  /____/|____/\\___  >____  >\n" +
                "        \\/     \\/      \\/     \\/          \\/                \\/     \\/ \n \n \n" +

                        " ".repeat(32) +"GAME CONCEPT\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n" +
                        " ".repeat(11) +"|Tablut is a game of black and white teams           |\n" +
                        " ".repeat(11) +"|in which players take turns moving their            |\n" +
                        " ".repeat(11) +"|teams pieces around the board.                      |\n" +
                        " ".repeat(11) +"|White consists of the King and guards.              |\n" +
                        " ".repeat(11) +"|While black consists of the mercenaries             |\n" +
                        " ".repeat(11) +"|Black wins by surrounding the king.                 |\n" +
                        " ".repeat(11) +"|and white wins if the king reaches the edge         |\n" +
                        " ".repeat(11) +"|of the board.                                       |\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n\n" +

                        " ".repeat(29) +"TECHNICAL RULES\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n" +
                        " ".repeat(11) +"|All game pieces can move horizontally               |\n" +
                        " ".repeat(11) +"|or vertically for any number of spaces,             |\n" +
                        " ".repeat(11) +"|however they may be blocked by other pieces.        |\n" +
                        " ".repeat(11) +"|The king starts on a star space located in          |\n" +
                        " ".repeat(11) +"|the centre of the board. Once the king leaves       |\n" +
                        " ".repeat(11) +"|that space, no piece can pass through or land on it.|\n" +
                        " ".repeat(11) +"|Mercenaries or guards are captured by surrounding   |\n" +
                        " ".repeat(11) +"|them on two opposing sides.\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n\n" +

                        " ".repeat(30) +"WIN CONDITIONS\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n" +
                        " ".repeat(11) +"|White wins by getting its king to the edge of the   |\n" +
                        " ".repeat(11) +"|board without being captured.                       |\n" +
                        " ".repeat(11) +"|Black wins by surrounding the king on all four sides|\n" +
                        " ".repeat(11) +"|which prevents the king from moving anywhere.       |\n" +
                        " ".repeat(11) +"-".repeat(54) + "\n\n"


);
    }

}
