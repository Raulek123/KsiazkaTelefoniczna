package KsiazkaTelefoniczna.enums;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class AppOptionsTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4})
    void shouldConvertNumberToCorrespondingOption(final int value) {
        //when
       final AppOptions result = AppOptions.convertNumberToOption(value);

        //then
        assertThat(result.getOptionIndex()).isEqualTo(value);
    }
}