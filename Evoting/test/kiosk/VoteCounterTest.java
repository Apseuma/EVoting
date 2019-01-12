package kiosk;


import Exceptions.NullReceivedAsParameterException;
import data.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class VoteCounterTest {

    private VoteCounter counter;
    Set<Party> votables;

    @BeforeEach
    public void SetUp() throws NullReceivedAsParameterException {
        votables= new HashSet<>(Arrays.asList(new Party ("PP"),new Party ("PSOE"),
                  new Party ("Podemos"),new Party ("Cs"),new Party ("ERC")));

        counter = new VoteCounter(votables);
    }

    @Test
    void InitCounterToZero() throws NullReceivedAsParameterException{
        assertEquals(0,counter.getVotesFor(new Party("PP")));
        assertEquals(0,counter.getVotesFor(new Party("ERC")));
        assertEquals(0,counter.getVotesFor(new Party("Podemos")));
        assertEquals(0,counter.getBlanks());
        assertEquals(0,counter.getNulls());

    }
}
