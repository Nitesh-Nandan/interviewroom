package com.practice.iroom.tester;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListStringConverterTester {

    public static String convertListToString(List<String> attributeValues) throws JsonProcessingException {
        if (CollectionUtils.isEmpty(attributeValues)) {
            return "[]";
        }
        String databaseColumn;
        try {
            databaseColumn = new ObjectMapper().writeValueAsString(attributeValues);
        } catch (JsonProcessingException e) {
//            log.error("Error in converting attributes list to string for: {}", attributeValues, e);
            throw new RuntimeException("error in converting list to string " + attributeValues.toString());
        }
        return databaseColumn;
    }

    public static List<String> convertStringToList(String attributeValues) {
        if (StringUtils.isEmpty(attributeValues) || "[]".equals(attributeValues)) {
            return Collections.emptyList();
        }
        List<String> databaseColumn;
        try {
            databaseColumn = new ObjectMapper().readValue(attributeValues, new TypeReference<List<String>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException("error in converting string to list " + attributeValues);
        }
        return databaseColumn;
    }

    public static void main(String[] args) throws JsonProcessingException {
        List<String> list = new ArrayList<>();
        list.add("catalogs::catalog_product_map::%s::%s");
        list.add("catalogs::catalog_product_map::100::111");
        list.add("catalogs::catalog_product_map::222::222");
        System.out.println(list);

        String val = convertListToString(list);
        System.out.println(val);

        List<String> list2 = convertStringToList(val);

        System.out.println(list2);
    }
}
