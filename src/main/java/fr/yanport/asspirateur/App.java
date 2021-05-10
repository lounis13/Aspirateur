package fr.yanport.asspirateur;

/**
 * Classe App pour lancé le programme.
 *
 * @author Lounis Bouldja
 */
public class App
{

    /**
     * Methode main pour tester l' application.
     *
     * @param args arguments
     */
    public static void main( String[] args )
    {

        try {
            /* Lancer un partie*/
            Game game = new Game(10, 10, 5, 5, "N", "DADADADAA");
            /* Affciher l'etat final de l'asspirateur*/
            System.out.println("\n -- ETAT FINAL --");
            game.printPosition();

        } catch (GameConfigException e) {
            System.out.println(e.getMessage());
        }
    }
}