package br.edu.insper.tecprog;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class TestStringUtils {

    @Test
    void testSumarioMarkdown() {
        System.out.println("sajfdhsdfhdksj12");
        var res = StringUtils.sumario("""
# teste 1

bla bla bla

# teste 2

## esse não vale

blalksadk

* sf;dj
* sdfk

    ;l;l;;

    # Aqui não vale, pois está indentado

# Aqui vale!
                        """);

        assertEquals(3, res.size());
        assertEquals("teste 1", res.get(0));
        assertEquals("teste 2", res.get(1));
        assertEquals("Aqui vale!", res.get(2));
    }

    @Test
    void testSumarioMarkdownRegex() {
        System.out.println("sajfdhsdfhdksj12");
        var res = StringUtils.sumarioRegex("""
# teste 1

bla bla bla

# teste 2

## esse não vale
blalksadk

* sf;dj
* sdfk

    ;l;l;;

    # Aqui não vale, pois está indentado

# Aqui vale!
                        """);

        assertEquals(3, res.size());
        assertEquals("teste 1", res.get(0));
        assertEquals("teste 2", res.get(1));
        assertEquals("Aqui vale!", res.get(2));
    }

    @Test
    void testPrefixoAllowed() {
        assertTrue(StringUtils.prefixoAllowed("abc", "a"));
        assertTrue(StringUtils.prefixoAllowed("abc", ""));
        assertTrue(StringUtils.prefixoAllowed("abc saafsd", "abc "));
        assertTrue(StringUtils.prefixoAllowed("DGRT234f", "DGRT2"));

        assertFalse(StringUtils.prefixoAllowed("a", "abc"));
        assertFalse(StringUtils.prefixoAllowed("abc", "Ab"));
        assertFalse(StringUtils.prefixoAllowed("DGRT234f", "DGRT3"));
        assertFalse(StringUtils.prefixoAllowed("DGRT234f", "dGRT2"));
    }

    @Test
    void testPrefixoBlocked() {
        assertTrue(StringUtils.prefixoBlocked("abc", "a"));
        assertTrue(StringUtils.prefixoBlocked("abc", ""));
        assertTrue(StringUtils.prefixoBlocked("abc saafsd", "abc "));
        assertTrue(StringUtils.prefixoBlocked("DGRT234f", "DGRT2"));

        assertFalse(StringUtils.prefixoBlocked("a", "abc"));
        assertFalse(StringUtils.prefixoBlocked("abc", "Ab"));
        assertFalse(StringUtils.prefixoBlocked("DGRT234f", "DGRT3"));
        assertFalse(StringUtils.prefixoBlocked("DGRT234f", "dGRT2"));
    }
}



