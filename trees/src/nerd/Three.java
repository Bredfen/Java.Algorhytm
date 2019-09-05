package nerd;

import java.util.ArrayList;
import java.util.Scanner;

public class Three {
    /*
    классы для выполнения следующих операций над двоичным деревом:
1. добавление элемента;
2. удаление элемента;
3. выполнение запроса;
4. просмотр коллекции.

где
x – вариант задания;
s – вид запроса;
p –вид просмотра (1- по возрастанию, 2 – по убыванию)
     */

    private static Scanner in;
    private static BinaryTree three = new BinaryTree();

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

//        in = new Scanner(System.in);
//        Abiturient a1 = new Abiturient("name-one", "male", "address", "fac", 1, 5, 5, 5);
//        three.add(a1);
//        three.add(new Abiturient("name-two", "male", "address", "fac", 3, 5, 5, 5));;
//        three.add(new Abiturient("name-three", "male", "address", "fac", 4, 5, 5, 5));
//        three.add(new Abiturient("name-four", "male", "address", "fac", 6, 5, 5, 5));
//        three.add(new Abiturient("name-five", "male", "address", "fac", 1, 5, 5, 5));
//        three.add(new Abiturient("name-six", "male", "address", "fac", 2, 5, 5, 5));
//        three.add(new Abiturient("name-seven", "male", "address", "fac", 3, 5, 5, 5));
//        three.add(new Abiturient("name-eight", "male", "address", "fac", 4, 5, 5, 5));
//        three.add(new Abiturient("name-nine", "male", "address", "fac", 1, 5, 5, 5));
//        three.add(new Abiturient("name-ten", "male", "address", "fac", 3, 5, 5, 5));
//
//
//        while (true) {
//            System.out.println("<--------------------------------------------------------->");
//            System.out.println("Введите команду");
//            System.out.println("add для добавления элемента");
//            System.out.println("delete для удаления элемента по ключу");
//            System.out.println("find для выполнения запроса (определение количества абитуриентов, закончивших определенную школу");
//            System.out.println("output для просмотра списка");
//            System.out.println("<--------------------------------------------------------->");
//            String command = "";
//            command = in.nextLine();
//            switch (command) {
//                case "add":
//                    add();
//                    break;
//                case "delete":
//                    if (!three.isEmpty()) delete();
//                    else System.out.println("Бинарное дерево не содержит элементов");
//                    break;
//                case "find":
//                    Object[] temp = three.toArray();
//                    if (temp.length == 0) {
//                        System.out.println("Бинарное дерево не содержит элементов");
//                        break;
//                    }
//                    int numSch;
//                    while (true) {
//                        System.out.println("Введите номер школы");
//                        try {
//                            numSch = Integer.parseInt(in.nextLine());
//                            if (numSch > 0) break;
//                        } catch (NumberFormatException e) {
//                            System.out.println("Некорректное число");
//                        }
//                    }
//                    final int num = numSch;
//                    ArrayList<Abiturient> abiturients = new ArrayList<Abiturient>();
//
//                    for (int i = 0; i < temp.length; i++) abiturients.add((Abiturient) temp[i]);
//
//                    abiturients.forEach((Abiturient a) -> {
//                        if (a.getNumSchool() == num)
//                            System.out.println(a);
//                    });
//                    //list.forEach(System.out::println);
//                    break;
//                case "output":
//                    Object[] string = three.output();
//                    for (Object s : string) {
//                        System.out.println(s);
//                    }
//                    break;
//                default:
//                    System.out.println("Команда не распознана. Повторите ввод");
//                    break;
//            }
//        }
    }

    private static void add() {
        String name, gender, address, facultet, temp;
        int numSch;
        int[] bal = new int[3];
        do {
            System.out.println("Введите имя абитуриента");
            name = in.nextLine();
        } while (!correctString(name) || containsNum(name));

        do {
            System.out.println("Введите пол абитуриента");
            gender = in.nextLine();
        } while (!correctGender(gender) || containsNum(gender));

        do {
            System.out.println("Введите адрес абитуриента");
            address = in.nextLine();
        } while (!correctString(address));

        do {
            System.out.println("Введите факультет абитуриента");
            facultet = in.nextLine();
        } while (!correctString(facultet));

        while (true) {
            System.out.println("Введите номер школы абитуриента");
            temp = in.nextLine();
            try {
                numSch = Integer.parseInt(temp);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Некорректное число");
            }
        }

        while (true) {
            System.out.println("Введите оценки по трем экзаменам через пробел");
            try {
                bal[0] = in.nextInt();
                bal[1] = in.nextInt();
                bal[2] = in.nextInt();
                in.nextLine();
                break;
            } catch (Exception e) {
                System.out.println("Некорректное число");
                in.nextLine();
            }
        }
        while (true) {
            Abiturient a = null;
            System.out.println("Абитуриент учится на коммерческой основе? y/n");
            temp = in.nextLine();
            if (equals(temp, "true", "y")) {
                int cost_learn;
                while (true) {
                    System.out.println("Введите стоимость обучения");
                    temp = in.nextLine();
                    try {
                        cost_learn = Integer.parseInt(temp);
                        break;
                    } catch (NumberFormatException ex) {
                        System.out.println("Некорректное число");
                    }
                }
                a = new Abiturient(name, gender, address, facultet, numSch, bal[0], bal[1], bal[2], true, cost_learn);
            } else a = new Abiturient(name, gender, address, facultet, numSch, bal[0], bal[1], bal[2]);
            three.add(a);
            break;
        }
    }

    private static void delete() {
        int n = 0;
        while (true) {
            System.out.println("Введите индекс элемента в коллекции для его удаления");
            try {
                n = Integer.parseInt(in.nextLine());
                System.out.println("удален элемент " + three.delete(n));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число");
            } catch (NullPointerException e) {
                System.out.println("Элемента в таким индексом не существует в коллекции");
            }
        }
    }

    private static ArrayList<Abiturient> find() {
        ArrayList<Abiturient> result = new ArrayList<>();
        /*int numSch;
        while (true) {
            System.out.println("Введите номер школы");
            try {
                numSch = Integer.parseInt(in.nextLine());
                if (numSch > 0) break;
            } catch (NumberFormatException e) {
                System.out.println("Некорректное число");
            }
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getNumSchool() == numSch) result.add(list.get(i));
        }
        System.out.println("Найдено " + result.size() + " абитуриентов, закончивших школу №" + numSch);*/
        return result;
    }

    public static boolean correctString(String s) {
        return (!s.equals("") && !s.equals(" "));
    }

    public static boolean containsNum(String s) {
        for (int i = 0; i < s.length(); i++) {
            try {
                Integer.parseInt(String.valueOf(s.charAt(i)));
                return true;
            } catch (NumberFormatException ex) {
                continue;
            }
        }
        return false;
    }

    public static boolean correctGender(String s) {
        return (s.equals("male") || s.equals("female"));
    }

    public static boolean equals(String string, String... answers) {
        for (int i = 0; i < answers.length; i++) {
            if (string.equals(answers[i])) return true;
        }
        return false;
    }
}