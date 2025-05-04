
package main;

public class Main {
    public static void main(String[] args) {
        // Création de l'objet DeclarationFiscal
        DeclarationFiscal declaration = new DeclarationFiscal(
                35000, 0, SituationFamiliale.CELIBATAIRE,
                1, 0, true
        );

        // Création du simulateur
        Simulateur simulateur = new Simulateur();

        // Calcul de l'impôt
        double impot = simulateur.calculateurImpots(declaration);
        // Affichage du résultat
        System.out.println("L'impôt calculé est : " + impot);
    }
}
