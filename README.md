# Simulateur d'impôt 2024

## Auteurs
- **Nassim Ramdane**
- **Tom Lemarchand Cholot**

## 🎯 Objectif

Ce projet simule le calcul de l’impôt sur le revenu en France selon les règles fiscales en vigueur en 2024. Il prend en compte :

- les **revenus nets** des deux déclarants,
- la **situation familiale** (célibataire, marié, etc.),
- le **nombre d’enfants à charge**,
- un éventuel **abattement** pour frais professionnels,
- une éventuelle **décote** en cas d’impôt faible,
- une **contribution exceptionnelle** pour les hauts revenus.

---

## 🏗️ Structure du code

- `Simulateur.java` + `CalculateurImpot` : contiennent toute la **logique métier** du calcul de l’impôt.
- `AdaptateurSimulateur.java` : fait le lien entre le simulateur et l’interface `ICalculateurImpot`, facilitant les **tests unitaires** et l’intégration.
- `DeclarationFiscal.java` : encapsule toutes les **données d’entrée** nécessaires au calcul.
- `TestsSimulateur.java` : classe de **tests JUnit 5** assurant la couverture complète du code métier.

---

## ✅ Lancement des tests

1. Ouvrir le projet dans **IntelliJ IDEA** (ou un IDE compatible).
2. Aller dans la classe `TestsSimulateur`.
3. Clic droit → **Run 'TestsSimulateur' with Coverage**.
4. Vérifiez que **100 % du code est couvert** (lignes rouges = non couvertes).

> 📌 Les tests sont écrits avec **JUnit 5** et couvrent l'ensemble des cas définis dans le cahier des charges.

---

## 📌 Traçabilité des exigences

Chaque exigence fonctionnelle est identifiée dans le code source par un **commentaire normé**, sous la forme `// EXG_IMPOT_XX`.

### Exemple :
```java
// EXG_IMPOT_04 : Application d'une décote si l'impôt est inférieur à 1000 €
public double getDecote(double impotAvantDecote) {
    ...
}
