package com.baeldung.drools;

import com.baeldung.drools.config.DroolsBeanFactory;
import com.baeldung.drools.model.Customer;
import org.kie.api.runtime.KieSession;

public class DroolsApplication {

    public static void main(String[] args) {
        DroolsBeanFactory dbf = new DroolsBeanFactory();

        KieSession kieSession = dbf.getKieSession();

//        System.out.println(dbf.getDrlFromExcel("com/baeldung/drools/rules/Discount.xls"));

        Customer customer = new Customer(Customer.CustomerType.INDIVIDUAL, 5);

        kieSession.insert(customer);

        kieSession.fireAllRules();

        System.out.println(customer.getDiscount());

    }
}
