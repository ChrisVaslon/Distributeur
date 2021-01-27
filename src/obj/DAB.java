package obj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DAB {

    Compte[] compte;

    public DAB() {
    }

    public DAB(Compte[] compte) {
        this.compte = compte;
    }

    public void activer() throws IOException {

        int n = 0;
        int j = 0;
        Boolean compteChoisi = false;
        int[] choix = {1, 2, 3, 4, 5};
        String saisi = "";

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        do {

            do {

                System.out.println("Opérations possibles :");
                System.out.println("    0- Selectionner un compte");
                System.out.println("    1- Retrait");
                System.out.println("    2 - Dépot");
                System.out.println("    3 - Solde");
                System.out.println("    4 - Quit");
                System.out.println("    5 - Virement");
                System.out.println("");
                System.out.println("Saisissez votre choix");

                saisi = br.readLine();
                n = Integer.valueOf(saisi);
                System.out.println("--------------------------");

                if (n != 0 && compteChoisi == false) {
                    System.out.println("Choisissez un compte d'abord !");
                    System.out.println("");
                }

                if (n == 0) {
                    System.out.println("Choisissez un compte : ");
                    for (int i = 0; i < compte.length; i++) {
                        System.out.println(i + " - Compte numéro " + compte[i].getNumero());
                    }
                    String saisi2 = br.readLine();
                    for (int i = 0; i < compte.length; i++) {
                        if (saisi2.equals(compte[i].getNumero())) {
                            j = Integer.valueOf(i);
                        }
                    }
                    if (j < compte.length) {
                        compteChoisi = true;
                    } else {
                        System.out.println("Choix impossible !");
                    }
                }
            } while (compteChoisi == false);

            if (n < 6 && n != choix[3] && n != 0) {
                System.out.println("Vous avez fait le choix" + choix[n - 1]);

            } else if (n != choix[3] && n != 0) {
                System.out.println("Faites un choix valide!");
            }

            switch (n) {
                case 1: {
                    System.out.println("Quel montant voulez-vous retirer ?");
                    saisi = br.readLine();
                    n = Integer.valueOf(saisi);
                    if (n > compte[j].getSolde()) {
                        System.out.println("Montant trop élevé !");
                    } else {
                        compte[j].retirer(n);
                        System.out.println("Opération effectuée!");
                    }
                    break;
                }

                case 2: {
                    System.out.println("Quel montant voulez-vous déposer ?");
                    saisi = br.readLine();
                    n = Integer.valueOf(saisi);
                    compte[j].deposer(n);
                    System.out.println("Opération effectuée!");
                    break;
                }

                case 3: {
                    System.out.println("Votre solde est de " + compte[j].getSolde() + " euros");
                    break;
                }

                case 4: {
                    System.out.println("Bonne journée !");
                    break;
                }

                case 5: {
                    System.out.println("Quel montant voulez-vous virer ?");
                    saisi = br.readLine();
                    n = Integer.valueOf(saisi);
                    if (n > compte[j].getSolde()) {
                        System.out.println("Montant trop élevé !");
                    } else {

                        System.out.println("Sur quel compte ?");
                        for (int i = 0; i < compte.length; i++) {
                            System.out.println(i + " - Compte numéro " + compte[i].getNumero());
                        }
                        String saisi2 = br.readLine();
                        int k = Integer.valueOf(saisi2);
                        if (k > compte.length) {
                            System.out.println("Ce compte n'existe pas !");

                        } else {
                            compte[j].virement(compte[k], n);
                        }
                        break;
                    }
                }
            }

        } while (n != 4);
    }
}
