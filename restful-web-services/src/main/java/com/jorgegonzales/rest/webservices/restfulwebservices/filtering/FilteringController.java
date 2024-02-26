package com.jorgegonzales.rest.webservices.restfulwebservices.filtering;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class FilteringController {
	@GetMapping("/filtering")
	public MappingJacksonValue filtering() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1","field2");
		SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter );
		mappingJacksonValue.setFilters(filters); 
		return mappingJacksonValue;
	}
	
	@GetMapping("/filtering-list")
	public MappingJacksonValue filteringList() {
		SomeBean someBean = new SomeBean("value1","value2","value3");
		SomeBean someBean2 = new SomeBean("value1","value2","value3");
		List<SomeBean> list = Arrays.asList(someBean,someBean2);
		MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter", filter  );
		mappingJacksonValue.setFilters(filters); 
		return mappingJacksonValue;
	}
	
	@GetMapping("/no-filtering")
    public MappingJacksonValue noFiltering() {
        List<SomeBean> someBeans = new ArrayList<>();
        someBeans.add(new SomeBean("value1", "value2", "value3"));
        someBeans.add(new SomeBean("value4", "value5", "value6"));
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBeans);
        mappingJacksonValue.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        return mappingJacksonValue;
    }
}
