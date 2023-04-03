import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class AviaSoulsTest {

    @Test
    public void ShouldSearchByPriceSeveral() {
        Ticket ticketOne = new Ticket("Казань", "Москва", 15000, 5, 8);
        Ticket ticketTwo = new Ticket("Казань", "Москва", 11000, 13, 17);
        Ticket ticketThree = new Ticket("Казань", "Москва", 13000, 17, 23);

        AviaSouls avi = new AviaSouls();
        avi.add(ticketOne);
        avi.add(ticketTwo);
        avi.add(ticketThree);

        Ticket[] expected = {ticketTwo, ticketThree, ticketOne};
        Ticket[] actual = avi.search("Казань", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByPriceOne() {
        Ticket ticketOne = new Ticket("Казань", "Москва", 15000, 5, 8);
        Ticket ticketTwo = new Ticket("Казань", "Санкт-Петербург", 11000, 13, 17);
        Ticket ticketThree = new Ticket("Казань", "Иркутск", 13000, 17, 23);

        AviaSouls avi = new AviaSouls();
        avi.add(ticketOne);
        avi.add(ticketTwo);
        avi.add(ticketThree);

        Ticket[] expected = {ticketOne};
        Ticket[] actual = avi.search("Казань", "Москва");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByPriceNone() {
        Ticket ticketOne = new Ticket("Казань", "Москва", 15000, 5, 8);
        Ticket ticketTwo = new Ticket("Казань", "Санкт-Петербург", 11000, 13, 17);
        Ticket ticketThree = new Ticket("Казань", "Иркутск", 13000, 17, 23);

        AviaSouls avi = new AviaSouls();
        avi.add(ticketOne);
        avi.add(ticketTwo);
        avi.add(ticketThree);

        Ticket[] expected = {};
        Ticket[] actual = avi.search("Москва", "Бангкок");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchByTime() {
        Ticket ticketOne = new Ticket("Казань", "Москва", 15000, 13, 17);
        Ticket ticketTwo = new Ticket("Казань", "Москва", 11000, 5, 8);
        Ticket ticketThree = new Ticket("Казань", "Москва", 13000, 17, 23);

        AviaSouls avi = new AviaSouls();
        avi.add(ticketOne);
        avi.add(ticketTwo);
        avi.add(ticketThree);

        Ticket[] expected = {ticketTwo, ticketOne, ticketThree};
        Ticket[] actual = avi.searchAndSortBy("Казань", "Москва", Ticket::compareTo);

        Assertions.assertArrayEquals(expected, actual);
    }
}
