package com.comcast.meme;

import java.util.Comparator;

/**
 * @author Jyothi Desu.
 */
public class MemeComparator implements Comparator<Meme> {

    public int compare(Meme meme1, Meme meme2) {
        if(meme1 == null && meme2 == null) {
            return 0;
        } else if(meme1 == null || meme1.getMemeName() == null) {
            return 1;
        } else if(meme2 == null || meme2.getMemeName() == null) {
            return -1;
        }
        return meme1.getMemeName().compareTo(meme2.getMemeName());
    }
}
