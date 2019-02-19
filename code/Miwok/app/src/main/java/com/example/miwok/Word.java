package com.example.miwok;

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mTranslation;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param translation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String translation) {
        mDefaultTranslation = defaultTranslation;
        mTranslation = translation;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getTranslation() {
        return mTranslation;
    }
}
