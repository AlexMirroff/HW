package com.ithillel.pages;

import org.openqa.selenium.WebDriver;

public abstract class CoursePage extends Page {

    public CoursePage(WebDriver driver) {
        super(driver);
    }

    public abstract void open();

    public abstract void ensureOpen();

    public abstract String getCourseTitle();

    public abstract String getCourseRate();

    public abstract String getCourseDescription();

    public abstract String[] getCourseGoals();
}
