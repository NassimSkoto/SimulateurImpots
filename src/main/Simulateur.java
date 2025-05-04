package main;

public class Simulateur {

    private double revenuReference;
    private double abattement;
    private double impotAvantDecote;
    private double decote;
    private double impotNet;
    private double contribExceptionnelle;

    // Méthode qui fait réellement le calcul de l'impôt
    public double calculateurImpots(DeclarationFiscal declaration) {
        double revenusNetDecl1 = declaration.getRevenusNetDecl1();
        double revenusNetDecl2 = declaration.getRevenusNetDecl2();
        SituationFamiliale situationFamiliale = declaration.getSituationFamiliale();
        int nbEnfantsACharge = declaration.getNbEnfantsACharge();
        int nbEnfantsSituationHandicap = declaration.getNbEnfantsSituationHandicap();
        boolean parentIsole = declaration.isParentIsole();

        revenuReference = getRevenuReference(revenusNetDecl1, revenusNetDecl2);
        abattement = getAbattement(revenuReference);
        impotAvantDecote = getImpotAvantDecote(revenuReference, abattement);
        decote = getDecote(impotAvantDecote);
        impotNet = getImpotNet(impotAvantDecote, decote);
        contribExceptionnelle = getContribExceptionnelle(impotNet);

        return impotNet + contribExceptionnelle;
    }

    // EXG_IMPOT_01 : Le revenu fiscal de référence est la somme des revenus nets des deux déclarants
    public double getRevenuReference(double revenusNetDecl1, double revenusNetDecl2) {
        return revenusNetDecl1 + revenusNetDecl2;
    }

    // EXG_IMPOT_02 : Un abattement de 10% est appliqué sur le revenu de référence
    public double getAbattement(double revenuReference) {
        return revenuReference * 0.1;  // Abattement de 10%
    }

    // EXG_IMPOT_03 : Calcul de l'impôt avant décote selon un taux fixe
    public double getImpotAvantDecote(double revenuReference, double abattement) {
        double revenuImposable = revenuReference - abattement;
        return revenuImposable * 0.2;  // Impôt de 20% sur le revenu imposable
    }

    // EXG_IMPOT_04 : Application d'une décote si l'impôt est inférieur à 1000 €
    public double getDecote(double impotAvantDecote) {
        if (impotAvantDecote < 1000) {
            return impotAvantDecote * 0.1;  // Décote de 10% si l'impôt avant décote est inférieur à 1000 €
        }
        return 0.0;
    }

    // Méthode pour calculer l'impôt net
    public double getImpotNet(double impotAvantDecote, double decote) {
        return impotAvantDecote - decote;
    }

    // Méthode pour calculer la contribution exceptionnelle
    public double getContribExceptionnelle(double impotNet) {
        if (impotNet > 10000) {
            return impotNet * 0.03;  // 3% de contribution exceptionnelle si l'impôt net est supérieur à 10000 €
        }
        return 0.0;
    }

    // Méthode pour obtenir le nombre de parts fiscales
    public double getNbParts(SituationFamiliale situationFamiliale, int nbEnfantsACharge) {
        // Exemple simplifié : 1 part par personne
        // Cas simplifiés : si célibataire ou marié, ajustement en fonction des enfants
        double parts = 1.0;
        if (situationFamiliale == SituationFamiliale.MARIE) {
            parts += 1.0;  // Couple marié = 2 parts
        }
        parts += nbEnfantsACharge / 2.0;  // 0.5 part par enfant
        return parts;
    }
    public double getRevenuReference() { return revenuReference; }
    public double getAbattement() { return abattement; }
    public double getImpotAvantDecote() { return impotAvantDecote; }
    public double getDecote() { return decote; }
    public double getImpotNet() { return impotNet; }
    public double getContribExceptionnelle() { return contribExceptionnelle; }
}
