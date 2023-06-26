package com.paynexpay.juniortask.web;

import com.paynexpay.juniortask.service.PhoneNumberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping(value = "/api" , produces = MediaType.APPLICATION_JSON_VALUE)
public class JuniorTaskAppController {

    public final PhoneNumberService phoneNumberService;

    @GetMapping(value ="/country")
    @ResponseBody
    public ResponseEntity<String> getCountry(@RequestParam (name="phone") Optional<String> phoneNumber) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(phoneNumberService.getCountry(phoneNumber),
                headers, HttpStatus.OK);
    }
}

