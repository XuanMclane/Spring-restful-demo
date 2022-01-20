package com.minxuan.rest.webservices.restfulwebservices.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue retrieveBean() {
        FilterBean filterBean = new FilterBean("value1", "value2", "value3");
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
        MappingJacksonValue mapping = new MappingJacksonValue(filterBean);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue retrieveBeans() {
        List<FilterBean> list = Arrays.asList(new FilterBean("value1", "value2", "value3"), new FilterBean("value4", "value5", "value6"));
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        MappingJacksonValue mapping = new MappingJacksonValue(list);
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
        mapping.setFilters(filters);
        return mapping;
    }
}
