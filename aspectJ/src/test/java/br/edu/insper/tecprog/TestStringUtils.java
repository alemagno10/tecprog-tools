package br.edu.insper.tecprog;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
}
