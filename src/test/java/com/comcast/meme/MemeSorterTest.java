package com.comcast.meme;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jyothi Desu.
 */
public class MemeSorterTest {

    private MemeSorterScorer memeSorterScorer;

    @BeforeClass
    public void setUp() {
        memeSorterScorer = new MemeSorterScorer();
    }

    /*
     * Verifies sorting memes based on name.
     */
    @Test
    public void testMemeSorter() throws Exception {

        List<Meme> memes = new ArrayList<Meme>();

        Meme meme1 = new Meme();
        meme1.setMemeName("test_bcd");
        meme1.setMemeImageUrl("http://test_url");
        memes.add(meme1);

        Meme meme2 = new Meme();
        meme2.setMemeName("test_abc");
        meme2.setMemeImageUrl("http://test_url");
        memes.add(meme2);

        memeSorterScorer.sortMemes(memes);
        Assert.assertEquals(memes.size(), 2,
                "Mismatch in size after sorting using MemeSorterScorer.sortMemes");
        Assert.assertEquals(memes.get(0).getMemeName(), "test_abc",
                "Failed to sort using MemeSorterScorer.sortMemes");
        Assert.assertEquals(memes.get(1).getMemeName(), "test_bcd",
                "Failed to sort using MemeSorterScorer.sortMemes");
    }
}
