package com.paynexpay.juniortask.service;

import com.paynexpay.juniortask.util.PhoneCodeParser;
import com.paynexpay.juniortask.util.exceptions.WrongPhoneNumberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PhoneNumberServiceImpl implements PhoneNumberService {

    private String phoneNumberProcessed;

    @Autowired
    private PhoneCodeParser parser;

    public String getCountry(Optional<String> phoneNumber) {

        String country = null;

        try {
            if (isValidPhoneNumber(phoneNumber)) {
                country = parser.getCountry(phoneNumberProcessed);
            }
        } catch (WrongPhoneNumberException e) {
            return e.getMessage();
        }
        return country;
    }

    public boolean isValidPhoneNumber(Optional<String> phoneNumber) throws WrongPhoneNumberException {

        if (phoneNumber.isEmpty()) {
            throw new WrongPhoneNumberException("Phone number was not submitted.");
        }

        phoneNumberProcessed = phoneNumber.get().trim().replaceAll("\\s|-", "");

        if (!(phoneNumberProcessed.matches("^\\+?(?:\\d{1,3}(?:\\x20|\\(\\d{1,3}\\)|\\d{1,3}\\(\\d{1,3}\\))\\d+|\\(\\d{1,3}\\)\\s*\\d+)$"))) {
            throw new WrongPhoneNumberException("Please, enter valid phone number in " +
                    "international format like +0 (000) 000 00 00.");
        }

        if (phoneNumberProcessed.substring(phoneNumberProcessed.indexOf(')') + 1).length() > 7) {
            throw new WrongPhoneNumberException("Phone number is too long. Please, enter correct phone" +
                    " number in international format like +0 (000) 000 00 00.");
        }
        return true;
    }
}
