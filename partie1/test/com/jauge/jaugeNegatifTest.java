package com.jauge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class jaugeNegatifTest {
    jaugeNegatif jauge1, jauge2, jauge3, jauge4, jauge5,jaugeEgal,jaugeSup,jaugeSupInter;

    @BeforeEach
    void setUp() {
        jauge1 = new jaugeNegatif(1, -100, 100);
        jauge2 = new jaugeNegatif(1, 100, 50);
        jauge3 = new jaugeNegatif(1, 100, 1);
        jauge4 = new jaugeNegatif(1, 100, 0);
        jauge5 = new jaugeNegatif(50, 25, 30);
        jaugeEgal = new jaugeNegatif(20, 20, 20);
        jaugeSup = new jaugeNegatif(20, 20, 30);
        jaugeSupInter = new jaugeNegatif(1, 40, 41);

    }

    @AfterEach
    void tearDown() {
        jauge1 = null;
        jauge2 = null;
        jauge3 = null;
        jauge4 = null;
        jauge5 = null;
        jaugeEgal = null;
        jaugeSup = null;
        jaugeSupInter = null;
    }

    @Test
    void testDansIntervalle() {
        assertFalse(jauge2.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge2.estVert(), "estVert() devrait renvoyer true");
        assertFalse(jauge2.estBleu(), "estBleu() devrait renvoyer false");
    }

    @Test
    void testDeplacer() {
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");
        jauge3.incrementer();
        assertFalse(jauge3.estBleu(), "estBleu() devrait renvoyer false");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge3.estVert(), "estVert() devrait renvoyer true");
    }

    @Test
    void testInferieurIntervalle() {
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");

        assertTrue(jauge4.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge4.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge4.estVert(), "estVert() devrait renvoyer false");

    }

    @Test
    public void testLimiteVigieMaxInferieurVigieMin() {
        assertTrue(jauge5.estBleu() && jauge5.estRouge() && !jauge5.estVert(), "La vigie max est inferieure a la vigie min");
    }

    @Test
    public void testMaxEgaleMin(){
        assertTrue(jaugeSup.estRouge(), "Vigie max égal à vigie min < départ");
        assertTrue(jaugeEgal.estBleu() && jaugeEgal.estRouge(), "Vigie max égal à vigie min égal au départ");

    }

    @Test
    void testSuperieurIntervalle() {
        assertTrue(jaugeSupInter.estRouge(), "estRouge() devrait renvoyer true");
        jaugeSupInter.decrementer();
        assertTrue(jaugeSupInter.estRouge(), "estRouge() devrait renvoyer true");

    }
}