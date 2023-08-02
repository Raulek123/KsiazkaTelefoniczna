package KsiazkaTelefoniczna.enums;

import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AppOptionsTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 0})
    void shouldConvertNumberToCorrespondingOption(final int value) {
        //when
       final AppOptions result = AppOptions.convertNumberToOption(value);

        //then
        assertThat(result.getOptionIndex()).isEqualTo(value);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, -154, -5, -10, -2, -1, 6, 10, 100, 1000, 154})
    void shouldThrowNoSuchElementExceptionForInvalidNumber(final int value){
        //when
        final ThrowableAssert.ThrowingCallable callable = () -> AppOptions.convertNumberToOption(value);

        //then
        assertThatThrownBy(callable)
                .isInstanceOf(NoSuchElementException.class)
                .hasMessage("Brak opcji o numerze: " + value + ", wprowadź prawidłową wartość");
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void shouldReturnToStringForAppOptions(final int value) {
        //when
        final AppOptions result = AppOptions.convertNumberToOption(value);

        //then
        assertThat(result.toString()).isEqualTo(result.getOptionIndex() + " - " + result.getDescription());
    }
}