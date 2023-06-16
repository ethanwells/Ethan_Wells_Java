package com.company;

import java.util.*;
import java.util.stream.Collectors; // import collectors

public class Main {

    private static List<String[]> customerData = Arrays.asList(
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","-7500","01-10-2022"},
            new String[] {"1","Wayne Enterprises","18000","12-22-2021"},
            new String[] {"3","Ace Chemical","-48000","01-10-2022"},
            new String[] {"3","Ace Chemical","-95000","12-15-2021"},
            new String[] {"1","Wayne Enterprises","175000","01-01-2022"},
            new String[] {"1","Wayne Enterprises","-35000","12-09-2021"},
            new String[] {"1","Wayne Enterprises","-64000","01-17-2022"},
            new String[] {"3","Ace Chemical","70000","12-29-2022"},
            new String[] {"2","Daily Planet","56000","12-13-2022"},
            new String[] {"2","Daily Planet","-33000","01-07-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"},
            new String[] {"2","Daily Planet","33000","01-17-2022"},
            new String[] {"3","Ace Chemical","140000","01-25-2022"},
            new String[] {"2","Daily Planet","5000","12-12-2022"},
            new String[] {"3","Ace Chemical","-82000","01-03-2022"},
            new String[] {"1","Wayne Enterprises","10000","12-01-2021"}
    );

    public static void main(String[] args) {
        // Update this | updated
        // Convert List<String[]> -> List<Customer[]>
        Dictionary<Integer, Customer> dict = new Hashtable<>();
        List<Customer> customerObjects = customerData.stream()
                .map(data -> {
                    if (dict.get(Integer.parseInt(data[0])) != null) {
                        List<AccountRecord> charges = dict.get(Integer.parseInt(data[0])).getCharges();
                        AccountRecord accountRecord = new AccountRecord();
                        accountRecord.setCharge(Integer.parseInt(data[2]));
                        accountRecord.setChargeDate(data[3]);
                        charges.add(accountRecord);
                        return null;
                    }
                    Customer customer = new Customer();
                    dict.put(Integer.parseInt(data[0]), customer);
                    customer.setId(Integer.parseInt(data[0]));
                    customer.setName(data[1]);
                    List<AccountRecord> charges = customer.getCharges();
                    AccountRecord accountRecord = new AccountRecord();
                    accountRecord.setCharge(Integer.parseInt(data[2]));
                    accountRecord.setChargeDate(data[3]);
                    charges.add(accountRecord);
                    return customer;
                })
                .collect(Collectors.toList());
        customerObjects.removeAll(Collections.singleton(null));

        // +/- Accounts
        System.out.println("Positive accounts:");
        customerObjects.stream().forEach(customer -> {
            if (customer.getBalance() > 0) {
                System.out.println(customer.toString());
            }
        });

        System.out.println("Negative accounts:");
        customerObjects.stream().forEach(customer -> {
            if (customer.getBalance() < 0) {
                System.out.println(customer.toString());
            }
        });
    }
}
