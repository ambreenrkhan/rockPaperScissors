package com.game;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder( MethodSorters.NAME_ASCENDING )
public class PlayerNameProviderTest {

    private PlayerNameProvider playerNameProvider;

    @Before
    public void init() {
        playerNameProvider = PlayerNameProvider.getInstance();
    }

    @Test
    public void testProvidedNameForComputerAndRealPlayers() {
        List<String> expectedProvidedNames = Arrays.asList("Player1", "Player2", "Computer1",
            "Player3", "Computer2");
        List<String> actualProvidedNames = new ArrayList<>();
        actualProvidedNames.add(playerNameProvider.provideName(PlayerType.REAL_PLAYER));
        actualProvidedNames.add(playerNameProvider.provideName(PlayerType.REAL_PLAYER));
        actualProvidedNames.add(playerNameProvider.provideName(PlayerType.COMPUTER_PLAYER));
        actualProvidedNames.add(playerNameProvider.provideName(PlayerType.REAL_PLAYER));
        actualProvidedNames.add(playerNameProvider.provideName(PlayerType.COMPUTER_PLAYER));
        assertEquals(expectedProvidedNames, actualProvidedNames);
    }

    @Test
    public void testProvidedNameForComputerPlayer() {
        String expected = "Computer3";
        String actual = playerNameProvider.provideName(PlayerType.COMPUTER_PLAYER);
        assertEquals(expected, actual);
    }

    @Test
    public void testProvidedNameForRealPlayer() {
        String expected = "Player4";
        String actual = playerNameProvider.provideName(PlayerType.REAL_PLAYER);
        assertEquals(expected, actual);
    }
}
