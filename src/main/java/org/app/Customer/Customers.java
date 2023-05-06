package org.app.Customer;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.app.DataStore.DataHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter @Setter
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Customers extends DataHolder {
    private List<Customer> customerList;
    public Customers() {
        customerList = new ArrayList<>();
    }
    public List<Customer> getNotRegisteredCustomers() {
        return customerList.stream().filter(x -> x.getClass()
                .equals(Customer.class)).collect(Collectors.toList());
    }
    public Customer getCustomerFromID(int id) {
        return customerList.stream()
                .filter(customer -> customer.getId() == id)
                .findAny().get();
    }
    public void turnToMember(int id, String name, String telephoneNumber) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setMember()
                .build());
    }

    public void turnToVIP(int id, String name, String telephoneNumber) {
        Customer customer = getCustomerFromID(id);
        customerList.remove(customer);
        customerList.add(new CustomerBuilder(customer)
                .name(name)
                .telephoneNumber(telephoneNumber)
                .setVIP()
                .build());
    }
}
