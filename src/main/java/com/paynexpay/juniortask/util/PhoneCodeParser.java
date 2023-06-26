package com.paynexpay.juniortask.util;

import com.paynexpay.juniortask.util.exceptions.CodeTableParseErrorException;
import com.paynexpay.juniortask.util.exceptions.WrongPhoneNumberException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class PhoneCodeParser {

    private Map<String, String> codeMap = new HashMap<>();

    List<String> exceptionCodes = List.of("1", "255", "262", "290",
            "358", "372", "374", "39", "44", "47", "599", "61", "7", "881",
            "882", "90", "995");

    String PHONE_CODE_TABLE_URL = "https://en.wikipedia.org/wiki/List_of_country_calling_codes";

    public String getCountry(String phone) {

        String country;

        try {
            Document document = Jsoup.connect(PHONE_CODE_TABLE_URL).get();
            Element codeTable = document.select("table").get(1);
            Elements rows = codeTable.select("tr");
            for (int i = 1; i < rows.size(); i++) {
                Elements cells = rows.get(i).select("td");
                String countryName = cells.get(0).text();
                List<String> countryCodes = getListOfCountryCodes(cells.get(1).text());
                for (int j = 0; j < countryCodes.size(); j++) {
                    codeMap.put(countryCodes.get(j), countryName);
                }
            }
        } catch (RuntimeException | IOException e) {
            e.printStackTrace();
            throw new CodeTableParseErrorException("Phone code table parse error.");
        }

        String code = phone.substring(0, phone.indexOf('('));
        if (exceptionCodes.contains(code)) {
            code = phone.substring(0, phone.indexOf(')') + 1);
            if (!(codeMap.containsKey(code))) {
                code = phone.substring(0, phone.indexOf('('));
            }
        }

        if (codeMap.containsKey(code)) {
            country = codeMap.get(code);
        } else {
            throw new WrongPhoneNumberException("Invalid country code: " + code);
        }
        return country;
    }

    public List<String> getListOfCountryCodes(String s) {
        String workingString = s.replaceAll("\\s", "").trim();
        List<String> countryCodes = new ArrayList<>();

        if (workingString.contains("(")) {
            String code = workingString.substring(0, workingString.indexOf("("));
            if (exceptionCodes.contains(code)) {

                String[] subcodes = (workingString.substring(s.indexOf('('), workingString.indexOf(')'))).split(",");
                for (int i = 0; i < subcodes.length; i++) {
                    countryCodes.add(code + "(" + subcodes[i] + ")");
                }
            }
        } else {
            countryCodes.add(workingString);
        }
        return countryCodes;
    }

}
