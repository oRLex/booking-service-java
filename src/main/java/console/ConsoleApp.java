package console;

import flight.Flight;
import flight.controller.FlightController;
import order.controller.OrderController;
import Database.Database;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;

public class ConsoleApp {
    static Scanner scanner = new Scanner(System.in);
    static OrderController orderController = new OrderController();
    static FlightController flightController = new FlightController();


    public static Integer toInt(String a){
        return Integer.parseInt(a);
    }

    public static Optional<Integer> isInt(String a) {
        try {
            int value = toInt(a);
            return Optional.of(value);
        } catch (NumberFormatException x) {
            return Optional.empty();
        }
    }

    public static int expectInt(String str, int maxValue){
        System.out.printf(str);
        String value = expectString();
        Optional<Integer> userNum = isInt(value);
        if (!userNum.isPresent() || userNum.get() > maxValue) {
            System.out.println("Веели неправильное значение");
            return printInt(str, maxValue);
        }
        return userNum.get();
    }

    public static int printInt(String str, int maxValue){
        int userNum = expectInt(str, maxValue);
        return userNum;
    }

    public static String expectString() {
        return scanner.nextLine();
    }

    public static void showAllFlight(){
        Set<Flight> all = flightController.getAll();
        StringBuilder strb = new StringBuilder();
        for(Flight f: all){
            strb.append(f);
            strb.append("\n");
        }
        System.out.println(strb);
    }

    public static void informationAboutFlight(){
        Integer idFlight = printInt("Ведите айди рейса\n", 1000);
        Optional<Flight> flightByIndex = flightController.getFlightByIndex(idFlight);
        if (!flightByIndex.isPresent()) {
            System.out.println("Рейс не найден");
            informationAboutFlight();
        }
        System.out.println(flightByIndex.get());
        return;
    }

    public static void searchAndBooking(){
        System.out.println("Ведите место назначения (город, например: Berlin)");
        String destination = expectString();
        System.out.println("Ведите дату (день/месяц/год, например: 11/03/2021)");
        String date = expectString();
        Integer ticketsNumber = expectInt("Количество человек числом (Например: 2)", 4);
        Optional<String> allFligth = flightController.getFlight(destination,date,ticketsNumber);
        if (!allFligth.isPresent()) return;
        System.out.printf("Number of available flights \n %s", allFligth.get());
        Integer numberFlight = expectInt("Ведите id рейса\n", 100);
        Optional<Flight> flightByIndex = flightController.getFlightByIndex(numberFlight);

        if (numberFlight == 0) return;
        for (int i =0 ; i < ticketsNumber; i++){
            System.out.println("Ведите имя");
            String nameUser = expectString();
            System.out.println("Ведите фамилию");
            String surnameUser = expectString();
            orderController.addOrder(nameUser, surnameUser, flightByIndex.get());
        }
    }

    public static void deleteOrder(){
        if(orderController.getAll()==null) {
            System.out.println("no items");
            return;
        }
        else System.out.println(orderController.getAll());
        Integer idFlight = expectInt("Ведите порядковій номер", 99999);
        orderController.cancelOrder(idFlight);
    }

    public static void myFlights(){
        System.out.println("Ведите имя");
        String nameUser = expectString();
        System.out.println("Ведите фамилию");
        String surnameUser = expectString();
        System.out.println(orderController.searchOrderUser(nameUser, surnameUser));
    }

    public static String showMenu(){
       return String.format("1. Онлайн-табло.\n" +
                "2. Посмотреть информацию о рейсе \n" +
                "3. Поиск и бронировка рейса. \n" +
                "4. Отменить бронирование. \n" +
                "5. Мои рейсы. \n" +
                "6. Выход.\n");
    }


    public void startApp() {
        boolean flag = true;
        do {
            System.out.println(showMenu());
            Integer numberMenu = printInt("Ведите цифру от 1 до 6 \n", 6);
            switch (numberMenu) {
                case 1:
                    showAllFlight();
                    break;
                case 2:
                    informationAboutFlight();
                    break;
                case 3:
                    searchAndBooking();
                    break;
                case 4:
                    deleteOrder();
                    break;
                case 5:
                    myFlights();
                    break;
                case 6:
                    flag = false;
                    Database.close();
                    return;
            }
        } while (flag);
    }
}
