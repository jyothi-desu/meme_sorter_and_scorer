# meme_sorter_and_scorer

Problem Description. 

Read in a list of internet memes from a json file on the classpath (you choose the memes!). 
Create one method which takes the list of memes and sorts them by name. 
Create a second method which associates a "lulz" score (from 1-10) with each meme and writes the updated values to the same json file.

Features in Project:
  1. MemeSorterScorer -- Main program to read internet memes json file, sorts them based on name, adds lulz score and writes to same file. 
  2. Gson -- Used Google Gson features to convert JSON string from file to Java Object and vice versa. 
  3. Maven project with assembly plugin to bundle dependecy jars. 
  4. MemeComparator - Provides capability to sort memes based on name. 
  5. MemeSorterTest - To test sort functionality of memes. 

Steps to execute program:
1. Using maven assembly plugin assembled all dependency jars together to create an executable jar "meme-bundle-jar-with-dependencies.jar"
   Copied this jar to root level directory for easy access. <br>
2. If you would like to execute program in /tmp/meme.<br>
      a. Copy "sample_input_meme.json" from root level project ("jyothi-desu/meme_sorter_and_scorer") to /tmp/meme/meme.json<br>
      b. Copy "meme-bundle-jar-with-dependencies.jar" to /tmp/meme<br>
3. CD to /tmp/meme.<br>
4. Run command "java -cp meme-bundle-jar-with-dependencies.jar:meme.json com.comcast.meme.MemeSorterScorer"<br>
5. Verify content in /tmp/meme/meme.json has lulz score for each internet meme record.<br> 
