package com.example.miwok;

public class Word {

    /** Default translation for the word */
    private String mDefaultTranslation;

    /** Miwok translation for the word */
    private String mTranslation;

    private int mImageResourceId;

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
        mImageResourceId = -1;
    }

    public Word(String defaultTranslation, String translation, int imageId) {
        mDefaultTranslation = defaultTranslation;
        mTranslation = translation;
        mImageResourceId = imageId;
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

    public int getImageResourceId() { return mImageResourceId; }

    public boolean hasImage() { return mImageResourceId > 0; }
}
