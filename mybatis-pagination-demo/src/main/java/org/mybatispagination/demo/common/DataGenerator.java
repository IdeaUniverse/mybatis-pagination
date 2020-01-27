package org.mybatispagination.demo.common;

import org.mybatispagination.demo.entity.User;
import org.mybatispagination.demo.dao.UserDao;
import org.mybatispagination.demo.entity.UserOrder;
import org.mybatispagination.demo.dao.UserOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class DataGenerator implements CommandLineRunner {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserOrderDao orderDao;

    @Override
    public void run(String... args) throws Exception {
        generateData();
    }

    public void generateData(){
        orderDao.clear();
        userDao.clear();

        System.out.println("===============================");
        System.out.println("generating test data for database...");
        System.out.println("===============================");
        for(int i = 0; i < 20; i++){
            User user = new User();
            String name = generateRandomString(6);
            user.setName(name);
            user.setStatus(1);
            userDao.save(user);
            List<UserOrder> orders = new ArrayList<>();
            for(int j = 0; j < 3; j++){
                UserOrder order = new UserOrder();
                order.setUserId(user.getId());
                order.setName(name);
                orders.add(order);
                orderDao.save(order);
            }
            user.setOrders(orders);
            System.out.println(user);
        }
        System.out.println("=========================");
        System.out.println("Data generation completed");
        System.out.println("=========================");
    }


    public String generateRandomString(int size){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < size; i++){
            int number=random.nextInt(str.length());
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }
}
