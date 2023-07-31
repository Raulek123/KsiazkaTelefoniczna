package KsiazkaTelefoniczna.Services;

import KsiazkaTelefoniczna.Exception.NoContactFoundException;
import KsiazkaTelefoniczna.Model.Contact;
import org.assertj.core.api.ThrowableAssert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TelephoneBookTest {

    @ParameterizedTest
    @ArgumentsSource(MyProvider.class)
    void shouldPrintAddedContactAfterAdding(final String name, final int number) {
        // given
        final TelephoneBook telephoneBook = new TelephoneBook();
        final Contact contact = new Contact(name, number);
        telephoneBook.addNewContact(name, number);

        //when
        final List<Contact> result = telephoneBook.printContact();

        //then
        assertThat(result).containsExactlyInAnyOrder(contact);
    }

    @Test
    void shouldThrowNoContactFoundExceptionWhenDeletingNonExistentContact() {
        // given
        final TelephoneBook telephoneBook = new TelephoneBook();

        //when
        final ThrowableAssert.ThrowingCallable callable = () -> telephoneBook.deletingContactByName("abc");

        //then
        assertThatThrownBy(callable)
                .isInstanceOf(NoContactFoundException.class)
                .hasMessage("Nie odnaleziono podanego kontaktu: abc");
    }

    @ParameterizedTest
    @ArgumentsSource(MyProvider.class)
    void shouldFindContactByName(final String name, final int number) {
        // given
        final TelephoneBook telephoneBook = new TelephoneBook();
        final Contact contact = new Contact(name, number);

        //when
        telephoneBook.addNewContact(name, number);
        final List<Contact> result = telephoneBook.searchContactByNameOrPhoneNumber(name);

        //then
        assertThat(result).containsExactlyInAnyOrder(contact);
    }


    @ParameterizedTest
    @ArgumentsSource(MyProvider.class)
    void shouldFindContactByPhoneNumber(final String name, final int number) {
        // given
        final TelephoneBook telephoneBook = new TelephoneBook();
        final Contact contact = new Contact(name, number);

        //when
        telephoneBook.addNewContact(name, number);
        final List<Contact> result = telephoneBook.searchContactByNameOrPhoneNumber(Integer.toString(number));

        //then
        assertThat(result).containsExactlyInAnyOrder(contact);
    }

    private static class MyProvider implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) {
            return Stream.of(
                    Arguments.of("Kowalska", 500568248),
                    Arguments.of("Zbrojowski", 624354879),
                    Arguments.of("Włuczykij", 12312312)
            );
        }
    }
}