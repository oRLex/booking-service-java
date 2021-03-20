package console;

import flight.service.FlightService;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ConsoleApp {
    static FlightService service = new FlightService();
    static Scanner scanner = new Scanner(System.in);

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
        String value = expectString();
        Optional<Integer> userNum = isInt(value);
        if (!userNum.isPresent() || userNum.get()>maxValue) {
            System.out.println("Веели неправильное значение");
            return printInt(str, maxValue);
        }
        return userNum.get();
    }

    public static int printInt(String str, int maxValue){
        System.out.printf(str);
        int userNum = expectInt(str, maxValue);
        return userNum;
    }

    public static String expectString() {
        return scanner.next();
    }

    public static void showAllFlight(){
        System.out.println("getAll");
//        service.getAll();
    }

    public static void informationAboutFlight(){
        Integer idFlight = printInt("Ведите айди рейса", 10000);
        System.out.println(idFlight);
//        if (idFlight)
//        getFlight(idFlight);
    }

    public static void searchAndBooking(){
        System.out.println("Ведите место назначения (город, например: Berlin)");
        String townTo = expectString();
        System.out.println("Ведите дату (день/месяц/год, например: 11/03/2021)");
        String date = expectString();
        System.out.println();
//        тут должно быть вот это
//        Integer ticketsNumber = toInt(expectStri  ng(), getFreeSteats());
        Integer ticketsNumber = expectInt("Количество человек числом (Например: 2)", 4);
//        List<Flight> f = getFlight(townTo, date, ticketsNumber)
//        if (f)

        Integer numberFlight = expectInt("Ведите порядковый номер рейса", 100);
        if (numberFlight == 0) return;
        for (int i =0 ; i < ticketsNumber; i++){
            System.out.println("Ведите имя");
            String nameUser = expectString();
            System.out.println(nameUser);
            System.out.println("Ведите фамилию");
            String surnameUser = expectString();
            System.out.println(surnameUser);
//            saveOrder()
        }
        System.out.println(townTo);
        System.out.println(date);
        System.out.println(ticketsNumber);
    }

    public static void deleteOrder(){
//        System.out.println();
        Integer idFlight = expectInt("Ведите айди рейса", 1000);
//        getFlight(idFlight);
//        if (Optional.empty()) return;
//        cancelOrder()
    }

    public static void myFlights(){
        System.out.println("Ведите имя");
        String nameUser = expectString();
        System.out.println("Ведите фамилию");
        String surnameUser = expectString();
//        searchOrder(nameUser, surnameUser);
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
