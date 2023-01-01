package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

class GeoServiceImplWithMockitoLibTest {
    private static final String RUS_IP = "172.0.0.1";
    private static final String USA_IP = "96.0.0.1";
    private static GeoService geoService;

    @BeforeEach
    void setUp() {
        geoService = new GeoServiceImpl();
    }

    @Test
    @DisplayName("GeoServiceImplRusIp")
    void geoRus() {
        Location location = new Location("Moscow", Country.RUSSIA, null, 0);
        Assertions.assertEquals(location.getCity(), geoService.byIp(RUS_IP).getCity());
        Assertions.assertEquals(location.getCountry(), geoService.byIp(RUS_IP).getCountry());
        Assertions.assertEquals(location.getStreet(), geoService.byIp(RUS_IP).getStreet());
        Assertions.assertEquals(location.getBuiling(), geoService.byIp(RUS_IP).getBuiling());
    }

    @Test
    @DisplayName("GeoServiceImplUsaIp")
    void geoUsa() {
        Location location = new Location("New York", Country.USA, null, 0);
        Assertions.assertEquals(location.getCity(), geoService.byIp(USA_IP).getCity());
        Assertions.assertEquals(location.getCountry(), geoService.byIp(USA_IP).getCountry());
        Assertions.assertEquals(location.getStreet(), geoService.byIp(USA_IP).getStreet());
        Assertions.assertEquals(location.getBuiling(), geoService.byIp(USA_IP).getBuiling());
    }
}
