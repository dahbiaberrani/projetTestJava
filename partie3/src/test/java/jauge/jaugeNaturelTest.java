package jauge;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tec.jaugeNaturel;

import static org.junit.jupiter.api.Assertions.*;

class jaugeNaturelTest {
    jaugeNaturel jauge1, jauge2, jauge3, jauge4;

    @BeforeEach
    void setUp() {
        jauge1 = new jaugeNaturel(1, 100, 100);
        jauge2 = new jaugeNaturel(1, 100, 50);
        jauge3 = new jaugeNaturel(1, 100, 1);
        jauge4 = new jaugeNaturel(1, 100, 101);

    }

    @AfterEach
    void tearDown() {
        jauge1 = null;
    }

    @Test
    void estRouge() {
        assertTrue(jauge1.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge2.estRouge(), "estRouge() devrait renvoyer false");
        assertFalse(jauge3.estRouge(), "estRouge() devrait renvoyer false");
        assertTrue(jauge4.estRouge(), "estRouge() devrait renvoyer true");

    }

    @Test
    void estVert() {
        assertFalse(jauge1.estVert(), "estVert() devrait renvoyer false");
        assertTrue(jauge2.estVert(), "estVert() devrait renvoyer true");
        assertFalse(jauge3.estVert(), "estVert() devrait renvoyer false");

    }

    @Test
    void estBleu() {
        assertFalse(jauge1.estBleu(), "estBleu() devrait renvoyer false");
        assertFalse(jauge2.estBleu(), "estBleu() devrait renvoyer false");
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        assertFalse(jauge4.estBleu(), "estBleu() devrait renvoyer false");

    }

    @Test
    void incrementer() {
        assertTrue(jauge3.estBleu(), "estBleu() devrait renvoyer true");
        jauge3.incrementer();
        assertFalse(jauge3.estBleu(), "estBleu() devrait renvoyer false si la valeur est incrementer ");
    }

    @Test
    void decrementer() {
        assertTrue(jauge1.estRouge(), "estRouge() devrait renvoyer false");
        jauge1.decrementer();
        assertFalse(jauge1.estRouge(), "estRouge() devrait renvoyer false si la valeur est decrementer");
    }



    @Test
    void testToString() {
    }
}