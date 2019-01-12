package kiosk;


import Exceptions.NullReceivedAsParameterException;
import data.Party;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

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
        Assert.equals(0,counter.getVotesFor(new Party("PP")));
        Assert.equals(0,counter.getVotesFor(new Party("ERC")));
        Assert.equals(0,counter.getVotesFor(new Party("Podemos")));
        Assert.equals(0,counter.getBlanks());
        Assert.equals(0,counter.getNulls());

    }
}
