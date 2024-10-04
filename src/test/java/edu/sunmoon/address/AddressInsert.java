package edu.sunmoon.address;

import edu.sunmoon.dto.Address;
import edu.sunmoon.service.AddressService;

public class AddressInsert {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        Address address = Address.builder()
                .customerId("customer999")
                .type("집")
                .name("정연균")
                .phone("010-5213-0917")
                .address1("경기도 성남시 분당구 정자동")
                .address2("정자동 178-2")
                .zipCode("135090")
                .isDefault(true)
                .build();
        try {
            Address result = service.add(address);
            System.out.println("Inserted: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
