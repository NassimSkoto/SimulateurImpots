package main;

public class AdaptateurSimulateur implements ICalculateurImpot {

    private Simulateur simulateur = new Simulateur();
    private int revenusNetDecl1 = 0;
    private int revenusNetDecl2 = 0;
    private SituationFamiliale situationFamiliale;
    private int nbEnfantsACharge;
    private int nbEnfantsSituationHandicap;
    private boolean parentIsole;

    @Override
    public void setRevenusNetDeclarant1(int rn) {
        this.revenusNetDecl1 = rn;
    }

    @Override
    public void setRevenusNetDeclarant2(int rn) {
        this.revenusNetDecl2 = rn;
    }

    @Override
    public void setSituationFamiliale(SituationFamiliale sf) {
        this.situationFamiliale = sf;
    }

    @Override
    public void setNbEnfantsACharge(int nbe) {
        this.nbEnfantsACharge = nbe;
    }

    @Override
    public void setNbEnfantsSituationHandicap(int nbesh) {
        this.nbEnfantsSituationHandicap = nbesh;
    }

    @Override
    public void setParentIsole(boolean pi) {
        this.parentIsole = pi;
    }

    @Override
    public void calculImpotSurRevenuNet() {
        DeclarationFiscal declaration = new DeclarationFiscal(revenusNetDecl1, revenusNetDecl2, situationFamiliale, nbEnfantsACharge, nbEnfantsSituationHandicap, parentIsole);
        simulateur.calculateurImpots(declaration);
    }

    @Override
    public int getRevenuNetDeclatant1() {
        return revenusNetDecl1;
    }

    @Override
    public int getRevenuNetDeclatant2() {
        return revenusNetDecl2;
    }

    @Override
    public double getContribExceptionnelle() {
        return simulateur.getContribExceptionnelle(revenusNetDecl1 + revenusNetDecl2);
    }

    @Override
    public int getRevenuFiscalReference() {
        return (int) simulateur.getRevenuReference(revenusNetDecl1, revenusNetDecl2);
    }

    @Override
    public int getAbattement() {
        return (int) simulateur.getAbattement(revenusNetDecl1 + revenusNetDecl2);
    }

    @Override
    public double getNbPartsFoyerFiscal() {
        return simulateur.getNbParts(situationFamiliale, nbEnfantsACharge);
    }

    @Override
    public int getImpotAvantDecote() {
        return (int) simulateur.getImpotAvantDecote(revenusNetDecl1 + revenusNetDecl2, getAbattement());
    }

    @Override
    public int getDecote() {
        return (int) simulateur.getDecote(getImpotAvantDecote());
    }

    @Override
    public int getImpotSurRevenuNet() {
        return (int) simulateur.getImpotNet(getImpotAvantDecote(), getDecote());
    }
}
