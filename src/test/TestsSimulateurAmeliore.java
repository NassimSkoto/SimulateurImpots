package test;

import main.AdaptateurSimulateur;
import main.ICalculateurImpot;
import main.SituationFamiliale;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestsSimulateurAmeliore {

    private static ICalculateurImpot simulateur;

    @BeforeAll
    public static void setUp() {
        simulateur = new AdaptateurSimulateur();

    }

    static Stream<Arguments> donneesCombiTranches() {
        return Stream.of(
                Arguments.of(15000, 0, "CELIBATAIRE", 0, 0, false, 104),
                Arguments.of(40000, 10000, "MARIE", 2, 0, false, 2210),
                Arguments.of(90000, 10000, "MARIE", 3, 0, false, 10564),
                Arguments.of(250000, 100000, "PACSE", 1, 1, true, 63900),
                Arguments.of(50000, 0, "DIVORCE", 1, 0, true, 2431)
        );
    }

    @DisplayName("Tests avancés de calcul d'impôt pour des combinaisons variées")
    @ParameterizedTest(name = "revenu1={0}, revenu2={1}, situation={2}, enfants={3}, handicap={4}, isolement={5} => impot={6}")
    @MethodSource("donneesCombiTranches")
    void testCasComplexes(int revenu1, int revenu2, String situation, int enfants, int handicap, boolean isolement, int impotAttendu) {
        simulateur.setRevenusNetDeclarant1(revenu1);
        simulateur.setRevenusNetDeclarant2(revenu2);
        simulateur.setSituationFamiliale(SituationFamiliale.valueOf(situation));
        simulateur.setNbEnfantsACharge(enfants);
        simulateur.setNbEnfantsSituationHandicap(handicap);
        simulateur.setParentIsole(isolement);

        simulateur.calculImpotSurRevenuNet();
        assertEquals(impotAttendu, simulateur.getImpotSurRevenuNet());
    }

    static Stream<Arguments> donneesExtremes() {
        return Stream.of(
                Arguments.of(0, 0, "CELIBATAIRE", 0, 0, false),
                Arguments.of(Integer.MAX_VALUE, 0, "VEUF", 0, 0, false)
        );
    }

    @DisplayName("Tests des cas limites (revenus extrêmes)")
    @ParameterizedTest(name = "revenu1={0}, revenu2={1}, situation={2}, enfants={3}, handicap={4}, isolement={5}")
    @MethodSource("donneesExtremes")
    void testCasLimites(int revenu1, int revenu2, String situation, int enfants, int handicap, boolean isolement) {
        simulateur.setRevenusNetDeclarant1(revenu1);
        simulateur.setRevenusNetDeclarant2(revenu2);
        simulateur.setSituationFamiliale(SituationFamiliale.valueOf(situation));
        simulateur.setNbEnfantsACharge(enfants);
        simulateur.setNbEnfantsSituationHandicap(handicap);
        simulateur.setParentIsole(isolement);

        simulateur.calculImpotSurRevenuNet();
    }

    static Stream<Arguments> donneesInvalides() {
        return Stream.of(
                Arguments.of(-100, 0, "CELIBATAIRE", 0, 0, false),
                Arguments.of(30000, 0, null, 0, 0, false),
                Arguments.of(30000, 0, "CELIBATAIRE", -2, 0, false),
                Arguments.of(30000, 0, "CELIBATAIRE", 0, -1, false)
        );
    }

    @DisplayName("Tests de robustesse avec des entrées invalides")
    @ParameterizedTest
    @MethodSource("donneesInvalides")
    void testErreursDonnees(int revenu1, int revenu2, String situation, int enfants, int handicap, boolean isolement) {
        simulateur.setRevenusNetDeclarant1(revenu1);
        simulateur.setRevenusNetDeclarant2(revenu2);
        if (situation != null) {
            simulateur.setSituationFamiliale(SituationFamiliale.valueOf(situation));
        }
        simulateur.setNbEnfantsACharge(enfants);
        simulateur.setNbEnfantsSituationHandicap(handicap);
        simulateur.setParentIsole(isolement);

        assertThrows(IllegalArgumentException.class, simulateur::calculImpotSurRevenuNet);
    }
}
