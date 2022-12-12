package com.example.helpmeassignment.domain.use.presentation;

import com.example.helpmeassignment.domain.use.presentation.dto.request.SaveUseRequest;
import com.example.helpmeassignment.domain.use.presentation.dto.response.UseListResponse;
import com.example.helpmeassignment.domain.use.service.QueryUseListByUsedAtService;
import com.example.helpmeassignment.domain.use.service.QueryUseListService;
import com.example.helpmeassignment.domain.use.service.SaveUseService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RequiredArgsConstructor
@RequestMapping("use")
@RestController
public class UseController {

    private final SaveUseService saveUseService;
    private final QueryUseListService queryUseListService;
    private final QueryUseListByUsedAtService queryUseListByUsedAtService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void saveUse(@RequestBody @Valid SaveUseRequest request) {
        saveUseService.execute(request);
    }

    @GetMapping
    public UseListResponse queryAllUse(@RequestParam Integer page) {
        return queryUseListService.execute(page);
    }

    @GetMapping("/time")
    public UseListResponse queryAllUseByUsedAt(@RequestParam LocalDate startAt, @RequestParam LocalDate endAt, @RequestParam Integer page) {
        return queryUseListByUsedAtService.execute(startAt, endAt, page);
    }
}
