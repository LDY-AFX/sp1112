package cn.kgc.controller;

import cn.kgc.entity.User;


import cn.kgc.util.DownloadUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class InController {
    @RequestMapping("/index")
    public void index(HttpServletResponse response) throws IOException {
        List<User> list =  new ArrayList<User>();
        User u1 = new User(1, "袁宁", "13232", 444, "20110102");
        User u2 = new User(2, "田童童", "5454", 32, "20110202");
        User u3 = new User(3, "孙正华", "23232", 547, "20110302");
        User u4 = new User(4, "仲韩", "7565", 776, "20110402");
        list.add(u1);
        list.add(u2);
        list.add(u3);
        list.add(u4);


        //1.创建工作簿
        Workbook wb = new XSSFWorkbook();
        //2.构造sheet
        Sheet sheet = wb.createSheet();
        //3.创建行
        //标题
        String[] titles = "编号,姓名,手机号,密码,出生日期".split(",");
        Row row = sheet.createRow(0);
        int  titleIndex = 0;
        for(String title:titles){
            Cell cell = row.createCell(titleIndex++);
            cell.setCellValue(title);
        }

        int rowIndex = 1;
        //4.创建单元格
        for(User u:list){
            row = sheet.createRow(rowIndex++);
            Cell cell = row.createCell(0);
            cell.setCellValue(u.getId());

            cell = row.createCell(1);
            cell.setCellValue(u.getName());

            cell = row.createCell(2);
            cell.setCellValue(u.getPhone());

            cell = row.createCell(3);
            cell.setCellValue(u.getPwd());

            cell = row.createCell(4);
            cell.setCellValue(u.getBornDate());


        }

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            wb.write(os);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //思路3：导出
        new DownloadUtils().download(os,response,"人事报表.xlsx");
    }
}
