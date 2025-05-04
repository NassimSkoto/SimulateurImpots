package main;
public class FoyerFiscal {
    private int revenuNetDecl1;
    private int revenuNetDecl2;
    private int nbEnfants;
    private int nbEnfantsHandicapes;
    private SituationFamiliale situationFamiliale;
    private boolean parentIsole;

    public FoyerFiscal(int revenuNetDecl1, int revenuNetDecl2, SituationFamiliale situationFamiliale, int nbEnfants, int nbEnfantsHandicapes, boolean parentIsole) {
        this.revenuNetDecl1 = revenuNetDecl1;
        this.revenuNetDecl2 = revenuNetDecl2;
        this.situationFamiliale = situationFamiliale;
        this.nbEnfants = nbEnfants;
        this.nbEnfantsHandicapes = nbEnfantsHandicapes;
        this.parentIsole = parentIsole;
    }

    public int getRevenuNetDecl1() {
        return revenuNetDecl1;
    }

    public int getRevenuNetDecl2() {
        return revenuNetDecl2;
    }

    public int getNbEnfants() {
        return nbEnfants;
    }

    public int getNbEnfantsHandicapes() {
        return nbEnfantsHandicapes;
    }

    public SituationFamiliale getSituationFamiliale() {
        return situationFamiliale;
    }

    public boolean isParentIsole() {
        return parentIsole;
    }
}
