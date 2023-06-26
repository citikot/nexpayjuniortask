package com.paynexpay.juniortask.service;

import java.util.Optional;

public interface PhoneNumberService {

    String getCountry(Optional<String> phoneNumber);

    boolean isValidPhoneNumber(Optional<String> phoneNumber);

}
