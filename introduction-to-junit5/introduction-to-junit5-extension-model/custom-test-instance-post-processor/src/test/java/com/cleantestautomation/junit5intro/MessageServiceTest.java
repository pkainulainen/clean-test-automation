package com.cleantestautomation.junit5intro;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.fail;

/**
 * This test class demonstrates how you can:
 * <ul>
 *     <li>Register your custom JUnit 5 extension.</li>
 *     <li>Identify the fields which contain injected dependencies.</li>
 *     <li>
 *         Configure your extension by using the <code>@SystemUnderTest</code>
 *         annotation.
 *     </li>
 * </ul>
 */
@DisplayName("Tests for message service")
@ExtendWith(MessageServiceExtension.class)
class MessageServiceTest {

    @SysterUnderTest(message = "Terve maailma!")
    private MessageService finnishMessageService;

    @SysterUnderTest(message = "Hola mundo!")
    private MessageService spanishMessageService;

    @Test
    @DisplayName("Finnish message service should return the correct message")
    void finnishMessageServiceShouldReturnCorrectMessage() {
        assertThat(finnishMessageService.getMessage()).isEqualTo("Terve maailma!");
    }

    @Test
    @DisplayName("Spanish message service should return the correct message")
    void spanishMessageServiceShouldReturnCorrectMessage() {
        assertThat(spanishMessageService.getMessage()).isEqualTo("Hola mundo!");
    }
}
