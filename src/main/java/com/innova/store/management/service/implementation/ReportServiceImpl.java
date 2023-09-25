package com.innova.store.management.service.implementation;

import com.innova.store.management.model.StoreEntity;
import com.innova.store.management.model.dto.StoreDto;
import com.innova.store.management.service.ReportService;
import com.innova.store.management.service.StoreService;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private StoreService storeService;

    @Override
    public String exportReport(String reportFormat,List<StoreDto> stores,Map<String,Object> parameters) throws FileNotFoundException, JRException {
        String path = "C:\\Users\\eayar\\IdeaProjects\\store.management\\src\\main\\resources\\reports";
        File file = ResourceUtils.getFile("classpath:StoreReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
        JRBeanCollectionDataSource dataSource =  new JRBeanCollectionDataSource(stores);
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,parameters,dataSource);
        if(reportFormat.equalsIgnoreCase("html")){
            JasperExportManager.exportReportToHtmlFile(jasperPrint,path+"\\stores.html");
        }
        if(reportFormat.equalsIgnoreCase("pdf")){
            JasperExportManager.exportReportToPdfFile(jasperPrint,path+"\\stores.pdf");
        }
        return "report generated in path: "+ path;
    }

    @Override
    public Map<String, Object> generateParams(String city, String district) {
        Map<String,Object> parameters= new HashMap<>();
        if(city!=null){
            parameters.put("CITY",city);
        }
        else{
            parameters.remove("CITY");
        }
        if(district!=null){
            parameters.put("DISTRICT",district);
        }
        else{
            parameters.remove("DISTRICT");
        }
        return parameters;

    }
}
