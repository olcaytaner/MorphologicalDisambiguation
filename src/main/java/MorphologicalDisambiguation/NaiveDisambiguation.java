package MorphologicalDisambiguation;

import Dictionary.Word;
import Ngram.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public abstract class NaiveDisambiguation implements MorphologicalDisambiguator {
    protected NGram<Word> wordUniGramModel;
    protected NGram<Word> igUniGramModel;

    /**
     * The saveModel method writes the specified objects i.e wordUniGramModel and igUniGramModel to the {@link java.io.ObjectOutputStream}
     * words.1gram and igs.1gram.
     */
    public void saveModel() {
        wordUniGramModel.save("words.1gram");
        igUniGramModel.save("igs.1gram");
    }

    /**
     * The loadModel method reads objects at the {@link ObjectInputStream} words.1gram and igs.1gram to the wordUniGramModel and igUniGramModel.
     */
    public void loadModel() {
        ObjectInputStream inObject;
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            inObject = new ObjectInputStream(classLoader.getResourceAsStream("words.1gram"));
            wordUniGramModel = (NGram<Word>) inObject.readObject();
            inObject = new ObjectInputStream(classLoader.getResourceAsStream("igs.1gram"));
            igUniGramModel = (NGram<Word>) inObject.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
