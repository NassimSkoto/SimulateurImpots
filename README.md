
auteur : Nassim ramdane / Tom Lemarchand Cholot
Nom du projet : Simulateur d'impôt 2024
Objectif
Simuler le calcul de l’impôt sur le revenu en France selon les règles de 2024, en tenant compte :

-des revenus nets des déclarants,
-de la situation familiale,
-des enfants à charge,
-d’un éventuel abattement,
-d’une éventuelle décote,
-d’une contribution exceptionnelle.

Structure du code
Simulateur.java + CalculateurImpot : contiennent toute la logique métier du calcul de l’impôt.
AdaptateurSimulateur.java : permet de connecter le simulateur à une interface ICalculateurImpot, facilitant ainsi les tests unitaires et l’intégration.
DeclarationFiscal.java : encapsule les données nécessaires au calcul.
TestsSimulateur.java : classe de tests unitaires avec JUnit 5, couvrant 100% du code :
        1) Clique droit sur la classe de test (ex. TestsSimulateur) ou le dossier test.
        2) Choisis "Run 'TestsSimulateur' with Coverage"

Traçabilité des exigences
Chaque exigence est identifiable dans le code par un commentaire // EXG_IMPOT_XX, placé avant la méthode concernée. Cela permet de vérifier rapidement si le code respecte bien toutes les règles définies par le cahier des charges.

Exemple :
// EXG_IMPOT_04 : Application d'une décote si l'impôt est inférieur à 1000 €


Lancement des tests
1) Les tests sont écrits avec JUnit 5. Pour les lancer :

2) Ouvrir le projet dans IntelliJ ou un autre IDE compatible.

3) Lancer la classe TestsSimulateur en tant que test JUnit.
