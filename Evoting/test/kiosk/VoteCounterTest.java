package kiosk;


import Exceptions.NullReceivedAsParameterException;
import data.Party;
import org.junit.jupiter.api.BeforeEach;

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
}
