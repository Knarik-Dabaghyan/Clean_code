import Planes.ExperimentalPlane;
import Planes.MilitaryPlane;
import Planes.PassengerPlane;
import Planes.Plane;
import models.ClassificationLevel;
import models.ExperimentalTypes;
import models.MilitaryType;
import models.Planes;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.*;

public class AirportTest {
    private static final List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane(Planes.B_1B_LANCER, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.B_2_SPIRIT, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.B_52_STRATOFORTRESS, MilitaryType.BOMBER),
            new MilitaryPlane(Planes.F_15, MilitaryType.FIGHTER),
            new MilitaryPlane(Planes.F_22, MilitaryType.FIGHTER),
            new MilitaryPlane(Planes.C_130_HERCULES, MilitaryType.TRANSPORT),
            new ExperimentalPlane(Planes.BELL_X_14, ExperimentalTypes.HIGH_ALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane(Planes.RYAN_X_13_VERTIJET, ExperimentalTypes.VTOL, ClassificationLevel.TOP_SECRET)
    );

    SoftAssert softAssert = new SoftAssert();
    Airport airport;

    @BeforeMethod
    public void testSetUp() {
        airport = new Airport(planes);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
        for (MilitaryPlane militaryPlane : transportMilitaryPlanes) {
            assertEquals(militaryPlane.getType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {
        PassengerPlane planeWithMaxPassengerCapacity =
                new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        assertEquals(expectedPlaneWithMaxPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortedByMaxLoadCapacity() {
        airport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            assertTrue(currentPlane.getMaxLoadCapacity() <= nextPlane.getMaxLoadCapacity());
        }
    }

    @Test
    public void testGetBomberInMilitaryPlanes() {
        for (MilitaryPlane militaryPlane : airport.getBomberMilitaryPlanes()) {
            assertEquals(militaryPlane.getType(), MilitaryType.BOMBER);
        }
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified() {
        for (ExperimentalPlane experimentalPlane : airport.getExperimentalPlanes()) {
            assertFalse(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED);
        }
    }
}