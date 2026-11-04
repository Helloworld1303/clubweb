package com.club.clubweb.activity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

public record ActivityRequest(
        @NotBlank(message = "제목을 입력해주세요.") @Size(max = 100, message = "제목은 100자 이하로 입력해주세요.") String title,

        @Size(max = 3000, message = "내용은 3000자 이하로 입력해주세요.") String content,
        @NotNull(message = "활동 날짜를 입력해주세요.")@PastOrPresent(message="활동 날짜는 오늘이나 과거여야합니다.") LocalDate activityDate) {

}
