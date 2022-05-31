package com.accesshq.webtests;

import com.accesshq.webtests.ui.Menu;
import com.accesshq.webtests.ui.PlanetsPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PlanetTestSuite extends BaseTestSuite {

    @Test
    public void FindDistanceToJupiter()
    {
        // arrange
        var myMenu = new Menu(driver);
        myMenu.navigateToPlanetsPage();

        // act - find Jupiter
        var planetsPage = new PlanetsPage(driver);
        var jupiter = planetsPage.getPlanetTileByName("jupiter");

        // assert - the distance of Jupiter from the sun is 778,500,000 km
        Assertions.assertEquals("778,500,000 km", jupiter.getDistance());

    }
}
