package com.accesshq.webtests.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PlanetTile {

    private WebElement element;

    public PlanetTile(WebElement el)
    {
        this.element = el;
    }

    public String getPlanetName()
    {
        return element.findElement(By.tagName("h2")).getText();
    }

    public String getDistance()
    {
        return element.findElement(By.className("distance")).getText();
    }

    public String getRadius()
    {
        return element.findElement(By.className("radius")).getText();
    }
}
