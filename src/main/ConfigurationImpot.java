package main;
public class ConfigurationImpot {
    // Tranches de revenus imposables
    public static final int[] LIMITE_IMPOT = {0, 11294, 28797, 82341, 177106, Integer.MAX_VALUE};
    public static final double[] TAUX_IMPOT = {0.0, 0.11, 0.3, 0.41, 0.45};

    // Tranches de contribution exceptionnelle sur les hauts revenus
    public static final int[] LIMITE_CEHR = {0, 250000, 500000, 1000000, Integer.MAX_VALUE};
    public static final double[] TAUX_CEHR_CELIBATAIRE = {0.0, 0.03, 0.04, 0.04};
    public static final double[] TAUX_CEHR_COUPLE = {0.0, 0.0, 0.03, 0.04};

    // Abattement
    public static final int ABATTEMENT_MAX = 14171;
    public static final int ABATTEMENT_MIN = 495;
    public static final double TAUX_ABATTEMENT = 0.1;

    // Plafond de baisse par demi-part
    public static final double PLAFOND_DEMI_PART = 1759;

    // Seuil et montant de la décote
    public static final double SEUIL_DECOTE_DECLARANT_SEUL = 1929;
    public static final double SEUIL_DECOTE_DECLARANT_COUPLE = 3191;
    public static final double DECOTE_MAX_DECLARANT_SEUL = 873;
    public static final double DECOTE_MAX_DECLARANT_COUPLE = 1444;
    public static final double TAUX_DECOTE = 0.4525;
}