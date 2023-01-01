package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;

class LocalizationServiceImplWithMockitoLibTest {
    private static LocalizationService localizationService;

    @BeforeEach
    void setUp() {
        localizationService = new LocalizationServiceImpl();
    }

    @Test
    @DisplayName("LocalizationServiceRus")
    void localeRus() {
        Assertions.assertEquals("Добро пожаловать",
                localizationService.locale(Country.RUSSIA));
    }

    @Test
    @DisplayName("LocalizationServiceUsa")
    void localeUSA() {
        Assertions.assertEquals("Welcome",
                localizationService.locale(Country.USA));
    }
}
