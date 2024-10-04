package edu.sunmoon.address;

import edu.sunmoon.dto.Address;
import edu.sunmoon.service.AddressService;

public class AddressUpdate {
    public static void main(String[] args) {
        AddressService service = new AddressService();
        Address address = Address.builder()
                .id(290)
                .type("집")
                .name("정연균")
                .phone("010-5213-0917")
                .address1("경기도 성남시 분당구 정자동")
                .address2("정자동 178-1")
                .zipCode("13509")
                .isDefault(true)
                .build();
        try {
            service.modify(address);
            System.out.println("Updated: " + service.get(290));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}