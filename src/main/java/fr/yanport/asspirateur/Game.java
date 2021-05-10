package fr.yanport.asspirateur;

import java.util.Scanner;

/**
 * Class Game implémente les actions possibles (Avancé, gauche droite).
 *
 * @author Bouldja Lounis
 */
public class Game implements IAction {

    /*Asspirateur*/
    private Asspirateur asspirateur;

    /*la grille*/
    private Grille grille;

    /**
     * Constructeur pour créer une partie.
     *
     * @param height       hauteur de la grille
     * @param width        largeur de la grille
     * @param posX         position X initial
     * @param posY         position Y initial
     * @param orientation  orientation initial
     * @param instructions les instructions
     * @throws GameConfigException déclencher une exception s'il y a un problème.
     */
    public Game(int height, int width, int posX, int posY,
                String orientation, String instructions) throws GameConfigException {

        this.initAndTest(height, width, posX, posY, orientation);
        for (int i = 0; i < instructions.length(); i++) {
            switch (instructions.charAt(i)) {
                case 'A':
                    this.avance();
                    break;
                case 'D':
                    this.droite();
                    break;
                case 'G':
                    this.gauche();
                    break;

                /* si l'indtruction saisi est invalide*/
                default:
                    /*Afficher un message d'erreur*/
                    System.out.println("l'instruction " + instructions.charAt(i) + "n'exite pas\n");
                    /*Affciher l'etat atctuel de l'aspirateur*/
                    printPosition();
                    /*quit*/
                    System.exit(0);
            }
        }
    }

    /**
     * Initialiser la grille et l'aspirateur et tester les valeurs en paramètres.
     *
     * @param height      longueur de la grille
     * @param width       largeur de la grille
     * @param posX        position X initial
     * @param posY        position Y initial
     * @param orientation orientation initial
     * @throws GameConfigException déclencher une exception s'il y a un problème.
     */
    public void initAndTest(int height, int width, int posX, int posY, String orientation) throws GameConfigException {

        if (height < 0 || width < 0)
            throw new GameConfigException
                    ("Taille invalide : la taille de la grille doit être positive");

        if (posX < 0 || posX > width || posY < 0 || posY > height)
            throw new GameConfigException
                    ("Position invalide : la position de l'aspirateur doit être dans la grille");

        if (!"NEWS".contains(orientation.toUpperCase()))
            throw new GameConfigException
                    ("Orientation invalide : orientation doit être soit N, W, E ou S");

        this.grille = new Grille(height, width);
        this.asspirateur = new Asspirateur(posX, posY, Orientation.valueOf(orientation));
    }

    @Override
    public void gauche() {
        this.asspirateur.aGauche();
    }

    @Override
    public void droite() {
        this.asspirateur.aDroite();
    }

    @Override
    public void avance() {
        switch (this.asspirateur.getOrientation()) {
            case N:
                /*tester si l'aspirateur peut se déplacer.*/
                if (this.asspirateur.getPositionY() == this.grille.getHeight()) {
                    if (cantMove("l'aspirateur ne peut pas avancer en Nord.\n")) {
                        /**/
                        this.printPosition();

                        /*Quitter le programme.*/
                        System.exit(0);
                    }
                    /* Sinon on passe à la prochaine indtructions.*/
                } else
                    /*Avancer en Haut*/
                    this.asspirateur.avanceY(+1);
                break;

            case S:
                /*tester si l'aspirateur peut se déplacer.*/
                if (this.asspirateur.getPositionY() == 0) {
                    if (cantMove("l'aspirateur ne peut pas avancer en Sud.\n")) {
                        this.printPosition();
                        /*Quitter le programme.*/
                        System.exit(0);
                    }
                    /* Sinon on passe à la prochaine indtructions.*/
                } else
                    /*avancer en bas*/
                    this.asspirateur.avanceY(-1);

                break;

            case E:
                /*tester si l'aspirateur peut se déplacer.*/
                if (this.asspirateur.getPositionX() == this.grille.getWidth()) {
                    if (cantMove("l'aspirateur ne peut pas avancer en Est.\n")) {
                        this.printPosition();
                        /*Quitter le programme.*/
                        System.exit(0);
                    }
                    /* Sinon on passe à la prochaine indtructions.*/
                } else
                    /*avancer a droite*/
                    this.asspirateur.avanceX(+1);

                break;
            case W:
                if (this.asspirateur.getPositionX() == 0) {
                    if (cantMove("l'aspirateur ne peut pas avancer en Ouest.\n")) {
                        this.printPosition();
                        /*Quitter le programme.*/
                        System.exit(0);
                    }
                    /* Sinon on passe à la prochaine indtructions.*/
                } else
                    /*avancer à gauche*/
                    this.asspirateur.avanceX(-1);

                break;
        }
    }

    /**
     * si l'aspirateur ne peut pas se deplacer.
     *
     * @param message  afficher un message.
     *
     * @return true : quitter le programme.
     *         false : si l'utilisateur veut ignorer cette instruction et passé à une autre.
     */
    private boolean cantMove(String message) {
        System.out.println("position Actuel : "); printPosition();
        System.out.println(message + "\nAppuyer sur q: pour quitter ou autre  pour continuer  : \n");
        Scanner scanner = new Scanner(System.in);
        return (scanner.nextLine().equals("q"));
    }

    /**
     * Affciher la position de l'asspirateur.
     */
    public void printPosition() {
        System.out.println(this.asspirateur);
    }

    public Asspirateur getAsspirateur() {
        return asspirateur;
    }
}