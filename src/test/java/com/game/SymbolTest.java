package com.game;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SymbolTest {

    @Test
    public void testSymbolBeats() {
        assertTrue(Symbol.PAPER.beats(Symbol.ROCK));
        assertTrue(Symbol.ROCK.beats(Symbol.SCISSORS));
        assertTrue(Symbol.SCISSORS.beats(Symbol.PAPER));
    }

    @Test
    public void testSymbolNotBeats() {
        assertFalse(Symbol.ROCK.beats(Symbol.PAPER));
        assertFalse(Symbol.SCISSORS.beats(Symbol.ROCK));
        assertFalse(Symbol.PAPER.beats(Symbol.SCISSORS));
    }
}
