package com.innova.store.management.service;

import com.innova.store.management.model.dto.StoreDto;
import net.sf.jasperreports.engine.JRException;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ReportService {
    String exportReport(String reportFormat, List<StoreDto> stores,Map<String,Object> parameters) throws FileNotFoundException, JRException;
    Map<String,Object> generateParams(String city, String district);
}


