import dao.PhoneDAO;
import entity.*;
import service.ClientService;
import service.BookService;
import service.CompanyService;
import service.PhoneService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        //manageBooks();

        ClientService clientService = new ClientService();
        CompanyService companyService=new CompanyService();

        Client client = new Client();
        client.setName("Jan");
        client.setSurname("Kowalski");

        Client client2 = new Client();
        client2.setName("Marcin");
        client2.setSurname("Nowak");

        Client client3 = new Client();
        client3.setName("Michał");
        client3.setSurname("Wiśniewski");

        ClientAddress clientAddress = new ClientAddress();
        clientAddress.setStreet("Grunwaldzka");
        clientAddress.setHouseNo(55);
        clientAddress.setCity("Gdańsk");
        clientAddress.setCountry("Polska");

        ClientAddress clientAddress2 = new ClientAddress();
        clientAddress2.setStreet("3 maja");
        clientAddress2.setHouseNo(3);
        clientAddress2.setCity("Sopot");
        clientAddress2.setCountry("Polska");

        ClientAddress clientAddress3 = new ClientAddress();
        clientAddress3.setStreet("3 maja");
        clientAddress3.setHouseNo(33);
        clientAddress3.setCity("Sopot");
        clientAddress3.setCountry("Polska");

        client.setClientAddress(clientAddress);
        client2.setClientAddress(clientAddress2);
        client3.setClientAddress(clientAddress3);

        clientService.addClientWithAddress(client);
        clientService.addClientWithAddress(client2);
        clientService.addClientWithAddress(client3);

        clientService.listClientsFromCity("Sopot");
        PhoneService phoneService=new PhoneService();

        Phone phone1 = new Phone();
        phone1.setNumber("123");
        Phone phone2 = new Phone();
        phone2.setNumber("456");
        Phone phone3 = new Phone();
        phone3.setNumber("789");

        clientService.addPhoneToClient(client2, phone1);

        Company company1=new Company();
        company1.setName("Philips");

        Company company2=new Company();
        company2.setName("Amica");

        Company company3=new Company();
        company3.setName("Bosch");
        companyService.addingClientsToCompany(company1, client2);
      //  companyService.addingClientsToCompany(company2, client);
      //  companyService.addingClientsToCompany(company3, client3);

    }

    private static void manageBooks() {
        BookService bookService = new BookService();
        Book book1 = new Book();
        book1.setTitle("Hobbit");
        book1.setAuthor("Tolkien");
        book1.setBookType(BookType.FANTASY);
        book1.setPublished(LocalDate.of(1950, 1 ,12));

        Book book2 = new Book();
        book2.setTitle("Krzyżacy");
        book2.setAuthor("Sienkiewicz");
        book2.setBookType(BookType.THRILLER);
        book2.setPublished(LocalDate.of(1892, 4,12));

        Book book3 = new Book();
        book3.setTitle("Harry Potter");
        book3.setAuthor("Rowling");
        book3.setBookType(BookType.FANTASY);
        book3.setPublished(LocalDate.of(2002, 12 ,1));


        Book book4 = new Book();
        book4.setAuthor("Sienkiewicz");
        book4.setTitle("Krzyżacy 3");
        book4.setBookType(BookType.FANTASY);
        book4.setPublished(LocalDate.of(1950, 1 ,12));

        Book book5 = new Book();
        book5.setTitle("Krzyżacy 2");
        book5.setAuthor("Sienkiewicz");
        book5.setBookType(BookType.THRILLER);
        book5.setPublished(LocalDate.of(1892, 4,12));

        Book book6 = new Book();
        book6.setTitle("Harry Potter 2");
        book6.setAuthor("Rowling");
        book6.setBookType(BookType.FANTASY);
        book6.setPublished(LocalDate.of(2002, 12 ,1));

        bookService.addBook(book1);
        bookService.addBook(book2);
        bookService.addBook(book3);
        bookService.addBook(book4);
        bookService.addBook(book5);
        bookService.addBook(book6);
        book3.setTitle("Harry Potter i Kamień");
        bookService.editBook(book3);

       /* Book bookToDelete = new Book();
        bookToDelete.setId(2L);
        bookService.deleteBook(bookToDelete);*/

        //bookService.listAllBooks();

        // bookService.findAndDeleteBooksAfter(2000);

        bookService.listAllAuthorsWithManyBooks();
        bookService.listAllBooksByAuthor("Rowling");
        bookService.listAllBooksByTitle("Krzyżacy");
    }
}
