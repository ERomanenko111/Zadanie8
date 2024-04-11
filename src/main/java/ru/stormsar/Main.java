package ru.stormsar;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Map<Integer, List<User>> usersMap = new HashMap<>();
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            System.out.println("Введите имя пользователя: ");
            String name = scanner.nextLine();

            System.out.println("Введите возраст пользователя: ");
            Integer age = Integer.parseInt(scanner.nextLine());

            User user = new User(name, age);

            if (usersMap.containsKey(age)) {
                usersMap.get(age).add(user);
            } else {
                List<User> usersList = new ArrayList<>();
                usersList.add(user);
                usersMap.put(age, usersList);
            }
        }

        System.out.println("Введите требуемый возраст: ");
        Integer requestedAge = Integer.parseInt(scanner.nextLine());

        List<User> requestedUsers = usersMap.get(requestedAge);
        if (requestedUsers != null) {
            Collections.sort(requestedUsers, Comparator.comparing(User::getName));

            for (User user : requestedUsers) {
                System.out.println(user.toString());
            }
        } else {
            System.out.println("Пользователь(и) с таким возрастом не найден(ы).");
        }
    }
}