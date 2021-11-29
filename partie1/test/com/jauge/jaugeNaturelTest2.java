package com.jauge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class jaugeNaturelTest2 {
    jaugeNaturel jauge1, jauge2, jauge3, jauge4;

    @BeforeEach
    void setUp() {
        jauge1 = new jaugeNaturel(1, 100, 100);
        jauge2 = new jaugeNaturel(1, 100, 50);
        jauge3 = new jaugeNaturel(1, 100, 1);
        jauge4 = new jaugeNaturel(1, 100, 0);

    }

    @AfterEach
    void tearDown() {
        jauge1 = null;
        jauge2 = null;
        jauge3 = null;
        jauge4 = null;
    }

    @Test
    void testDansIntervalle() {
        assertFalse(jauge2.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge2.estVert(), "estVert() devrait renvoyer true");
        assertFalse(jauge2.estBleu(), "estBleu() devrait renvoyer false");
    }
    @Test
    void testDeplacer(){
        assertTrue(jauge3.estBleu(),"estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");
        jauge3.incrementer();
        assertFalse(jauge3.estBleu(),"estBleu() devrait renvoyer false");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge3.estVert(), "estVert() devrait renvoyer true");
    }
    @Test
    void testInferieurIntervalle(){
        assertTrue(jauge3.estBleu(),"estBleu() devrait renvoyer true");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");

        assertTrue(jauge4.estBleu(),"estBleu() devrait renvoyer true");
        assertFalse(jauge4.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge4.estVert(), "estVert() devrait renvoyer false");

    }
    @Test
    void testSuperieurIntervalle(){

    }
}
