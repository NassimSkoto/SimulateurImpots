package main;
public class CalculateurImpot {
    private ConfigurationImpot config;
    private FoyerFiscal foyerFiscal;

    public CalculateurImpot(FoyerFiscal foyerFiscal) {
        this.config = new ConfigurationImpot();
        this.foyerFiscal = foyerFiscal;
    }

    public double calculerAbattement() {
        long abt1 = Math.round(foyerFiscal.getRevenuNetDecl1() * ConfigurationImpot.TAUX_ABATTEMENT);
        long abt2 = Math.round(foyerFiscal.getRevenuNetDecl2() * ConfigurationImpot.TAUX_ABATTEMENT);

        abt1 = Math.min(abt1, ConfigurationImpot.ABATTEMENT_MAX);
        abt1 = Math.max(abt1, ConfigurationImpot.ABATTEMENT_MIN);

        if (foyerFiscal.getSituationFamiliale() == SituationFamiliale.MARIE || foyerFiscal.getSituationFamiliale() == SituationFamiliale.PACSE) {
            abt2 = Math.min(abt2, ConfigurationImpot.ABATTEMENT_MAX);
            abt2 = Math.max(abt2, ConfigurationImpot.ABATTEMENT_MIN);
        }

        return abt1 + abt2;
    }

    public double calculerRevenuFiscalReference() {
        return foyerFiscal.getRevenuNetDecl1() + foyerFiscal.getRevenuNetDecl2() - calculerAbattement();
    }

    public double calculerImpotsBrut(double revenuImposable, int[] limites, double[] taux) {
        double impots = 0;
        int i = 0;
        while (i < limites.length - 1) {
            if (revenuImposable >= limites[i] && revenuImposable < limites[i+1]) {
                impots += (revenuImposable - limites[i]) * taux[i];
                break;
            } else {
                impots += (limites[i+1] - limites[i]) * taux[i];
            }
            i++;
        }
        return impots;
    }

    public double calculerDecote(double impotsBrut, double nbParts) {
        double decote = 0;
        if (nbParts == 1 && impotsBrut < ConfigurationImpot.SEUIL_DECOTE_DECLARANT_SEUL) {
            decote = ConfigurationImpot.DECOTE_MAX_DECLARANT_SEUL - (impotsBrut * ConfigurationImpot.TAUX_DECOTE);
        }
        if (nbParts == 2 && impotsBrut < ConfigurationImpot.SEUIL_DECOTE_DECLARANT_COUPLE) {
            decote = ConfigurationImpot.DECOTE_MAX_DECLARANT_COUPLE - (impotsBrut * ConfigurationImpot.TAUX_DECOTE);
        }
        return Math.min(decote, impotsBrut);
    }

    // Méthode principale de calcul de l'impôt
    public double calculerImpot() {
        double revenuFiscalRef = calculerRevenuFiscalReference();
        double nbParts = calculerNbParts();

        double impotsBrut = calculerImpotsBrut(revenuFiscalRef / nbParts, ConfigurationImpot.LIMITE_IMPOT, ConfigurationImpot.TAUX_IMPOT);
        double decote = calculerDecote(impotsBrut, nbParts);

        return Math.round(impotsBrut - decote);
    }

    private double calculerNbParts() {
        double nbParts = 1; // Par défaut pour célibataire
        switch (foyerFiscal.getSituationFamiliale()) {
            case MARIE:
            case PACSE:
                nbParts = 2;
                break;
            case DIVORCE:
            case VEUF:
                nbParts = 1;
                break;
        }

        // Parts pour les enfants
        nbParts += Math.min(foyerFiscal.getNbEnfants(), 2) * 0.5;
        if (foyerFiscal.getNbEnfants() > 2) {
            nbParts += 1 + (foyerFiscal.getNbEnfants() - 2);
        }

        // Parts supplémentaires pour les enfants handicapés
        nbParts += foyerFiscal.getNbEnfantsHandicapes() * 0.5;

        // Bonus pour parent isolé ou veuf avec enfant
        if (foyerFiscal.isParentIsole() || (foyerFiscal.getSituationFamiliale() == SituationFamiliale.VEUF && foyerFiscal.getNbEnfants() > 0)) {
            nbParts += 0.5;
        }

        return nbParts;
    }
}
