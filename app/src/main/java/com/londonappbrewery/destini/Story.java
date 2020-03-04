package com.londonappbrewery.destini;

public class Story {
    private final int story;
    private final int firstChoice;
    private final int secondChoice;
    private Story firstStoryLine;
    private Story secondStoryLine;

    public Story(int ending) {
        this.story = ending;
        this.firstChoice = -1;
        this.secondChoice = -1;
    }

    public Story(int story, int firstChoice, int secondChoice) {
        this.story = story;
        this.firstChoice = firstChoice;
        this.secondChoice = secondChoice;
    }

    public int getStory() {
        return story;
    }

    public int getFirstChoice() {
        return firstChoice;
    }

    public int getSecondChoice() {
        return secondChoice;
    }

    public Story getFirstStoryLine() {
        return firstStoryLine;
    }

    public Story setFirstStoryLine(Story firstStoryLine) {
        this.firstStoryLine = firstStoryLine;
        return this;
    }

    public Story getSecondStoryLine() {
        return secondStoryLine;
    }

    public Story setSecondStoryLine(Story secondStoryLine) {
        this.secondStoryLine = secondStoryLine;
        return this;
    }

    public boolean hasFirstChoice() {
        return firstChoice > -1;
    }

    public boolean hasSecondChoice() {
        return secondChoice > -1;
    }
}
