package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
class MessageSenderImplWithMockitoLibTest {
    private static MessageSenderImpl messageSender;
    private static final String RUS_IP = "172.0.0.1";
    private static final String USA_IP = "96.0.0.1";

    @Mock
    private GeoServiceImpl geoService;
    @Mock
    private LocalizationServiceImpl localizationService;

    @BeforeEach
    void setUp() {
        messageSender = new MessageSenderImpl(geoService, localizationService);
    }

    @Test
    @DisplayName("MessageSenderImplRusIp")
    void sendRus() {
        Mockito.when(geoService.byIp(RUS_IP)).thenReturn(new Location(null, Country.RUSSIA, null, 0));
        Mockito.when(localizationService.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");
        Assertions.assertEquals("Добро пожаловать",
                messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, RUS_IP)));
    }

    @Test
    @DisplayName("MessageSenderImplUsaIp")
    void sendUsa() {
        Mockito.when(geoService.byIp(USA_IP)).thenReturn(new Location(null, Country.USA, null, 0));
        Mockito.when(localizationService.locale(Country.USA)).thenReturn("Welcome");
        Assertions.assertEquals("Welcome",
                messageSender.send(Map.of(MessageSenderImpl.IP_ADDRESS_HEADER, USA_IP)));
    }
}
