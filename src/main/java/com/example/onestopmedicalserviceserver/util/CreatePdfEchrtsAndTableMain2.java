package com.example.onestopmedicalserviceserver.util;


import com.example.onestopmedicalserviceserver.domain.PrescriptionInfo;
import com.example.onestopmedicalserviceserver.entry.prescription.PrescriptionForm;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 根据模板填充数据及图片，动态生成数据列表
 */
@Component
public class CreatePdfEchrtsAndTableMain2 {
    @Value("${LocalAddress}")
    String localAddress;
    public void createPdfFile(HttpServletResponse response, PrescriptionForm pf) throws IOException, DocumentException, TemplateException {

        //设置请求返回类型
        response.setHeader("Content-Disposition", "attachment; filename="+pf.getId()+".pdf");

        OutputStream outputStream = response.getOutputStream();

        //模板路径，放到项目里用这个ClassPathResource
        ClassPathResource classPathResource = new ClassPathResource("templates/处方单.pdf");
        InputStream inputStream = classPathResource.getInputStream();
        PdfReader reader = new PdfReader(inputStream);

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        //pdf流
        PdfStamper ps = new PdfStamper(reader, bos);

        //设置字体
        final BaseFont font = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        ArrayList<BaseFont> fontList = new ArrayList<>();
        fontList.add(font);

        //提取表单,这个是模板画好的文本框
        AcroFields s = ps.getAcroFields();
        s.setSubstitutionFonts(fontList);

        //医院名称
        s.setField("hospital", pf.getHospital());

        //编号
        BaseFont fontByID = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        s.setField("id", pf.getId());
        //开具时间
        s.setField("time", pf.getCreateTime());
        //用户名
        s.setField("name", pf.getName());
        s.setField("sex", pf.getSex());
        s.setField("age", pf.getAge().toString());
        //科别
        s.setField("category", pf.getDepartment());
        //诊断
        s.setField("diagnose", pf.getDiagnose());

        //末尾
        s.setField("doctor", pf.getDoctor());
        s.setField("money", pf.getMoney().toString());
        s.setField("pharmacist", pf.getPharmacist());


        //仿宋体+处方信息展示
        BaseFont bfComic = BaseFont.createFont("STSong-Light", "UniGB-UCS2-H", BaseFont.NOT_EMBEDDED);
        addTextToPdfCenter(s, ps, pf.getInfos(), "context", bfComic);

        //图片编辑
        PdfContentByte cb = ps.getOverContent(1);
        //添加logo
        Rectangle logo = s.getFieldPositions("seal_af_image").get(0).position;

        Image logoImage = Image.getInstance( "src/main/resources/images/image/印章.png");
        //根据域的大小缩放图片，我这里宽度在原有的域基础上加了100，你们可以自己调节
        logoImage.scaleToFit(logo.getWidth() + 100, logo.getHeight());
        logoImage.setAlignment(Image.MIDDLE);
        logoImage.setAbsolutePosition(logo.getLeft(), logo.getBottom());
        cb.addImage(logoImage);

        ps.setFormFlattening(true);
        ps.close();

        //*******************填充编辑好后的pdf**************
        reader = new PdfReader(bos.toByteArray());
        Rectangle pageSize = reader.getPageSize(1);

        Document document = new Document(pageSize);
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        // 打开文档
        document.open();
        PdfContentByte cbUnder = writer.getDirectContentUnder();
        PdfImportedPage pageTemplate = writer.getImportedPage(reader, 1);
        cbUnder.addTemplate(pageTemplate, 0, 0);

        document.close();
        outputStream.close();

    }

    /**
     * 处方信息展示
     *
     * @param form
     * @param stamper
     * @param infos
     * @param fieldName
     * @param baseFont
     */
    void addTextToPdfCenter(AcroFields form, PdfStamper stamper, List<PrescriptionInfo> infos, String fieldName, BaseFont baseFont) {
        // 通过模板表单单元格名获取所在页和坐标，左下角为起点
        int pageNo = form.getFieldPositions(fieldName).get(0).page;
        Rectangle signRect = form.getFieldPositions(fieldName).get(0).position;
        // 获取操作的页面
        PdfContentByte contentByte = stamper.getOverContent(pageNo);
        //创建表单
        PdfPTable table = new PdfPTable(1);
        //获取当前模板表单宽度
        float totalWidth = signRect.getRight() - signRect.getLeft() - 1;
        //设置新表单宽度
        table.setTotalWidth(totalWidth);
        //设置中文格式
        Font font = new Font(baseFont);
        for (PrescriptionInfo info : infos){
            String text ="           "+info.getName()+"\n";
            text = text +"           "+ "数量：              x"+info.getNum()+"\n";
            text = text +"           "+ "规格：              " + info.getSpecifications()+"\n";
            text = text +"           "+ "用法用量:              " + info.getUsageDosage();
            //设置单元格格式
            PdfPCell cell = new PdfPCell(new Phrase(text, font));
            //设置单元格高度
            float height = (signRect.getTop() - signRect.getBottom() - 1) / infos.size();
            cell.setFixedHeight(height);
            cell.setBorderWidth(0);
            //设置垂直居中
            cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
            //设置水平居中
//            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            //添加到表单中
            table.addCell(cell);
        }
        //写入pdf
        table.writeSelectedRows(0, -1, signRect.getLeft(), signRect.getTop(), contentByte);
    }

}

