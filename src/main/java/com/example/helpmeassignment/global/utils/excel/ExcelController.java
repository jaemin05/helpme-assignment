package com.example.helpmeassignment.global.utils.excel;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("/excel")
@RestController
public class ExcelController {
    private final ExcelService excelService;

    @GetMapping("/deposit")
    public void getDeposit(HttpServletResponse response, @RequestParam Integer page) {
        excelService.getDeposit(response, page);
    }

    @GetMapping("/deposit/{member-id}")
    public void getDepositByMember(HttpServletResponse response, @PathVariable("member-id") Integer memberId, @RequestParam Integer page) {
        excelService.getDepositByMember(response, memberId, page);
    }

    @GetMapping("/deposit/time")
    public void getDepositByDepositedAt(HttpServletResponse response, @RequestParam LocalDate startAt, @RequestParam LocalDate endAt, @RequestParam Integer page) {
        excelService.getDepositByDepositedAt(response, startAt, endAt, page);
    }

    @GetMapping("/use")
    public void getUse(HttpServletResponse response, @RequestParam Integer page) {
        excelService.getUse(response, page);
    }

    @GetMapping("/use/time")
    public void getUseByUsedAt(HttpServletResponse response, @RequestParam LocalDate startAt, @RequestParam LocalDate endAt, @RequestParam Integer page) {
        excelService.getUseByUsedAt(response, startAt, endAt, page);
    }
}
