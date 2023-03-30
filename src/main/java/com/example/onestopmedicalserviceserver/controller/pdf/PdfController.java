package com.example.onestopmedicalserviceserver.controller.pdf;

import com.example.onestopmedicalserviceserver.entry.prescription.PrescriptionForm;
import com.example.onestopmedicalserviceserver.service.PrescriptionService;
import com.example.onestopmedicalserviceserver.util.CreatePdfEchrtsAndTableMain2;
import com.itextpdf.text.DocumentException;
import freemarker.template.TemplateException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Api(tags = "pdf生成器")
@RestController
@RequestMapping("pdf")
public class PdfController {

    @Autowired
    PrescriptionService prescriptionService;
    @Autowired
    CreatePdfEchrtsAndTableMain2 pdfEchrtsAndTableMain2;

    @ApiOperation("根据处方单id生成处方单.pdf")
    @GetMapping("prescriptionDownload")
    public void prescriptionDownload(HttpServletResponse response, String id) throws TemplateException, DocumentException, IOException {
        PrescriptionForm pf = prescriptionService.selectOneById(id);
        if (pf==null)
            return;
        pdfEchrtsAndTableMain2.createPdfFile(response,pf);
    }
}
