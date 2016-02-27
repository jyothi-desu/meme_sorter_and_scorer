package com.comcast.meme;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @author Jyothi Desu.
 */

public class MemeSorterScorer {

    private Gson gson;
    Random randomGenerator;

    public MemeSorterScorer() {
        gson = new Gson();
        randomGenerator = new Random();
    }

    /*
     * Reads memes from input file. And constructs meme object using gson.
     */
    protected List<Meme> readMemes() {
        List<Meme> memes = new ArrayList<Meme>();
        try {
            BufferedReader reader = new BufferedReader(
                    new FileReader(new File(MemeConstants.MEME_FILE_PATH)));
            String memeStr;
            while((memeStr = reader.readLine()) != null) {
              Meme meme = gson.fromJson(memeStr, Meme.class);
              memes.add(meme);
            }
        }
        catch(FileNotFoundException fe) {
            System.out.println(String.format(
                    "Unable to find input file for meme. Message: %s:", fe.getMessage()));
            System.exit(-1);
        }
        catch(IOException io) {
            System.out.println(String.format(
                    "IO exception raised while reading memes from input file. Message: %s:", io.getMessage()));
            System.exit(-1);
        }
        return memes;
    }

    /*
     * Uses named based comparator for Memes.
     */
    protected void sortMemes(List<Meme> memes) {
        Collections.sort(memes, new MemeComparator());
    }

    /*
     * Lulz score is generated using random number generator between range 1 - 10.
     * Range is configurable through MemeConstants.
     */
    protected void addLulzScore(List<Meme> memes) {
        for(Meme meme: memes) {
            int randomLuluScore = randomGenerator.nextInt(
                    (MemeConstants.MEME_LULZ_MAX_SCORE - MemeConstants.MEME_LULZ_MIN_SCORE) +1) +1;
            meme.setLulzScore(randomLuluScore);
        }
    }

    /*
     * Writes to memes file with lulz score.
     */
    protected void writeMemes(Collection<Meme> memes) {
        try {
            BufferedWriter writer = new BufferedWriter
                    (new FileWriter(new File(MemeConstants.MEME_FILE_PATH)));
            for(Meme meme: memes) {
                String memeStr = gson.toJson(meme);
                System.out.println(memeStr);
                writer.write(memeStr);
            }
            writer.close();
        }
        catch(FileNotFoundException fe) {
            System.out.println(String.format(
                    "Unable to find output file to write memes with lulz score. Message: %s:", fe.getMessage()));
            System.exit(-1);
        }
        catch(IOException io) {
            System.out.println(String.format(
                    "IOException raised while writing lulz score to memes file. Message: %s:", io.getMessage()));
            System.exit(-1);
        }
    }

    public static void main(String[] args) {
        MemeSorterScorer memeSorter = new MemeSorterScorer();
        List<Meme> memes = memeSorter.readMemes();
        memeSorter.sortMemes(memes);
        memeSorter.addLulzScore(memes);
        memeSorter.writeMemes(memes);
    }
}
