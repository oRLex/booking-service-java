package console;

import dao.Database;
import flight.Flight;
import flight.controller.FlightController;
import flight.service.FlightService;
import order.Order;
import order.controller.OrderController;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleApp {
    static Scanner scanner = new Scanner(System.in);
    static OrderController orderController = new OrderController();
    static FlightController flightController = new FlightController();

    public ConsoleApp() throws IOException, ClassNotFoundException {
    }

    public static Integer toInt(String a){
        return Integer.parseInt(a);
    }

    public static Optional<Integer> isInt(String a) {
        Pattern pattern = Pattern.compile("[1-9]");
        Matcher matcher  = pattern.matcher(a);
        if (matcher.matches()){
            toInt(a);
            return Optional.of(toInt(a));
        }
        return Optional.empty();
    }

    public static int expectInt(String str, int maxValue){
        System.out.printf(str);
        String value = expectString();
        Optional<Integer> userNum = isInt(value);
        if (!userNum.isPresent() || userNum.get()>maxValue) {
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
        Integer idFlight = printInt("Ведите айди рейса", 10000);
        Optional<Flight> flightByIndex = flightController.getFlightByIndex(idFlight);
        System.out.println(flightByIndex.get());
    }

    public static void searchAndBooking(){
        System.out.println("Ведите место назначения (город, например: Berlin)");
        String destination = expectString();
        System.out.println("Ведите дату (день/месяц/год, например: 11/03/2021)");
        String date = expectString();
        Integer ticketsNumber = expectInt("Количество человек числом (Например: 2)", 4);
        System.out.printf("Number of available flights \n %s", flightController.getFlight(destination,date,ticketsNumber));
        Integer numberFlight = expectInt("Ведите порядковый номер рейса", 100);
        Optional<Flight> flightByIndex = flightController.getFlightByIndex(numberFlight);

        if (numberFlight == 0) return;
        for (int i =0 ; i < ticketsNumber; i++){
            System.out.println("Ведите имя");
            String nameUser = expectString();
            System.out.println(nameUser);
            System.out.println("Ведите фамилию");
            String surnameUser = expectString();
            System.out.println(surnameUser);
            orderController.addOrder(nameUser, surnameUser, flightByIndex.get());
        }
        System.out.println(destination);
        System.out.println(date);
        System.out.println(ticketsNumber);
    }

    public static void deleteOrder(){
//        System.out.println();
        Integer idFlight = expectInt("Ведите айди рейса", 1000);
//        getFlight(idFlight);
//        if (Optional.empty()) return;
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
                "2.Посмотреть информацию о рейсе \n" +
                "3. Поиск и бронировка рейса. \n" +
                "4. Отменить бронирование. \n" +
                "5. Мои рейсы. \n" +
                "6. Выход.\n");
    }


    public static void main(String[] args) {

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
                    return;
            }
        } while (flag);
    }
}
