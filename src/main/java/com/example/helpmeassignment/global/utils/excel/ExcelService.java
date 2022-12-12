package com.example.helpmeassignment.global.utils.excel;

import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositListResponse;
import com.example.helpmeassignment.domain.deposit.presentation.dto.response.DepositResponse;
import com.example.helpmeassignment.domain.deposit.service.QueryDepositListByDepositedAtService;
import com.example.helpmeassignment.domain.deposit.service.QueryDepositListByMemberService;
import com.example.helpmeassignment.domain.deposit.service.QueryDepositListService;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseListResponse;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseResponse;
import com.example.helpmeassignment.domain.use.service.QueryUseListByUsedAtService;
import com.example.helpmeassignment.domain.use.service.QueryUseListService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ExcelService {

    private final QueryDepositListService queryDepositListService;
    private final QueryDepositListByMemberService queryDepositListByMemberService;
    private final QueryDepositListByDepositedAtService queryDepositListByDepositedAtService;
    private final QueryUseListService queryUseListService;
    private final QueryUseListByUsedAtService queryUseListByUsedAtService;

    public void getDeposit(HttpServletResponse response, Integer page) {
        DepositListResponse list = queryDepositListService.execute(page);
        createDepositExcelDownload(response, list.getDepositResponseList());
    }

    public void getDepositByMember(HttpServletResponse response, Integer memberId, Integer page) {
        DepositListResponse list = queryDepositListByMemberService.execute(memberId, page);
        createDepositExcelDownload(response, list.getDepositResponseList());
    }

    public void getDepositByDepositedAt(HttpServletResponse response, LocalDate startAt, LocalDate endAt, Integer page) {
        DepositListResponse list = queryDepositListByDepositedAtService.execute(startAt, endAt, page);
        createDepositExcelDownload(response, list.getDepositResponseList());
    }

    public void getUse(HttpServletResponse response, Integer page) {
        UseListResponse list = queryUseListService.execute(page);
        createUseExcelDownload(response, list.getUseResponseList());
    }

    public void getUseByUsedAt(HttpServletResponse response, LocalDate startAt, LocalDate endAt, Integer page) {
        UseListResponse list = queryUseListByUsedAtService.execute(startAt, endAt, page);
        createUseExcelDownload(response, list.getUseResponseList());
    }

    private void createDepositExcelDownload(HttpServletResponse response, List<DepositResponse> depositList) {

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("회비 입금내역 조회");

            CellStyle numberCellStyle = workbook.createCellStyle();
            numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

            //파일명
            final String fileName = "회비_입금내역_조회";

            //헤더
            final String[] header = {"사원번호", "이름", "부서명", "금액", "입금일"};
            Row row = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(header[i]);
            }

            //바디
            for (int i = 0; i < depositList.size(); i++) {
                row = sheet.createRow(i + 1);  //헤더 이후로 데이터가 출력되어야하니 +1

                DepositResponse depositResponse = depositList.get(i);

                Cell cell = null;
                cell = row.createCell(0);
                cell.setCellValue(depositResponse.getMemberNumber());

                cell = row.createCell(1);
                cell.setCellValue(depositResponse.getMemberName());

                cell = row.createCell(2);
                cell.setCellValue(depositResponse.getDepartmentName());

                cell = row.createCell(3);
                cell.setCellValue(depositResponse.getDepositAmount());

                cell = row.createCell(4);
                LocalDate date = depositResponse.getDepositedAt();
                cell.setCellValue(date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth());
            }

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void createUseExcelDownload(HttpServletResponse response, List<UseResponse> useList) {

        try {
            Workbook workbook = new XSSFWorkbook();
            Sheet sheet = workbook.createSheet("회비 사용내역 조회");

            CellStyle numberCellStyle = workbook.createCellStyle();
            numberCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("#,##0"));

            //파일명
            final String fileName = "회비_사용내역_조회";

            //헤더
            final String[] header = {"사용내역", "사용금액", "사용 일시"};
            Row row = sheet.createRow(0);
            for (int i = 0; i < header.length; i++) {
                Cell cell = row.createCell(i);
                cell.setCellValue(header[i]);
            }

            //바디
            for (int i = 0; i < useList.size(); i++) {
                row = sheet.createRow(i + 1);  //헤더 이후로 데이터가 출력되어야하니 +1

                UseResponse useResponse = useList.get(i);

                Cell cell = null;
                cell = row.createCell(0);
                cell.setCellValue(useResponse.getReason());

                cell = row.createCell(1);
                cell.setCellValue(useResponse.getUseAmount());

                cell = row.createCell(2);
                LocalDate date = useResponse.getUsedAt();
                cell.setCellValue(date.getYear() + "-" + date.getMonth() + "-" + date.getDayOfMonth());
            }

            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");

            workbook.write(response.getOutputStream());
            workbook.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
