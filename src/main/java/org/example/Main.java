package org.example;

import org.example.notifications.EmailNotification;
import org.example.notifications.PushNotification;
import org.example.notifications.SMSNotification;
import org.example.users.FinancialAnalyst;
import org.example.users.PrivateInvestor;
import org.example.users.ProfessionalInvestor;

public class Main {
    public static void main(String[] args) {

        // Создание акций
        Stock apple = new Stock("AAPL");
        Stock tesla = new Stock("TSLA");

        // Создание пользователей и каналов уведомлений
        PrivateInvestor john = new PrivateInvestor("John");
        john.addChannel(new SMSNotification());
        john.addChannel(new PushNotification());

        ProfessionalInvestor anna = new ProfessionalInvestor("Anna");
        anna.addChannel(new EmailNotification());

        FinancialAnalyst bob = new FinancialAnalyst("Bob");
        bob.addChannel(new EmailNotification());
        bob.addChannel(new PushNotification());

        // Подписка на акции
        apple.attach(john);
        apple.attach(anna);
        apple.attach(bob);

        tesla.attach(anna);
        tesla.attach(bob);

        // Генерация событий
        apple.changePrice(150.0);
        apple.reachThreshold(155.0);
        apple.dividendPaid(2.5);

        tesla.changePrice(700.0);
        tesla.marketAlert("Tesla stock dropped 5%");

        // Вывод истории уведомлений
        System.out.println("\nJohn history: " + john.getHistory());
        System.out.println("Anna history: " + anna.getHistory());
        System.out.println("Bob history: " + bob.getHistory());
    }
}