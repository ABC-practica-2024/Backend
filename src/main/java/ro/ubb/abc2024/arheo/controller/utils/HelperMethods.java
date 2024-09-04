package ro.ubb.abc2024.arheo.controller.utils;

import org.springframework.data.domain.Page;
import ro.ubb.abc2024.utils.converter.Converter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelperMethods {

    public static <E, D> Map<String, Object> makeResponse(Page<E> page, Converter<E, D> converter) {
        List<E> objects = page.getContent();
        Map<String, Object> response = new HashMap<>();
        response.put("items", objects.stream()
                .map(converter::createFromEntity)
                .toList());
        response.put("currentPage", page.getNumber());
        response.put("totalItems", page.getTotalElements());
        response.put("totalPages", page.getTotalPages());

        return response;

    }
}
