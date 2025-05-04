package main;

public class DeclarationFiscal {

    private double revenusNetDecl1;
    private double revenusNetDecl2;
    private SituationFamiliale situationFamiliale;
    private int nbEnfantsACharge;
    private int nbEnfantsSituationHandicap;
    private boolean parentIsole;

    // Constructeur
    public DeclarationFiscal(double revenusNetDecl1, double revenusNetDecl2, SituationFamiliale situationFamiliale,
                             int nbEnfantsACharge, int nbEnfantsSituationHandicap, boolean parentIsole) {
        this.revenusNetDecl1 = revenusNetDecl1;
        this.revenusNetDecl2 = revenusNetDecl2;
        this.situationFamiliale = situationFamiliale;
        this.nbEnfantsACharge = nbEnfantsACharge;
        this.nbEnfantsSituationHandicap = nbEnfantsSituationHandicap;
        this.parentIsole = parentIsole;
    }

    // Getters et Setters
    public double getRevenusNetDecl1() {
        return revenusNetDecl1;
    }

    public void setRevenusNetDecl1(double revenusNetDecl1) {
        this.revenusNetDecl1 = revenusNetDecl1;
    }

    public double getRevenusNetDecl2() {
        return revenusNetDecl2;
    }

    public void setRevenusNetDecl2(double revenusNetDecl2) {
        this.revenusNetDecl2 = revenusNetDecl2;
    }

    public SituationFamiliale getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public int getNbEnfantsACharge() {
        return nbEnfantsACharge;
    }

    public void setNbEnfantsACharge(int nbEnfantsACharge) {
        this.nbEnfantsACharge = nbEnfantsACharge;
    }

    public int getNbEnfantsSituationHandicap() {
        return nbEnfantsSituationHandicap;
    }

    public void setNbEnfantsSituationHandicap(int nbEnfantsSituationHandicap) {
        this.nbEnfantsSituationHandicap = nbEnfantsSituationHandicap;
    }

    public boolean isParentIsole() {
        return parentIsole;
    }

    public void setParentIsole(boolean parentIsole) {
        this.parentIsole = parentIsole;
    }
}
