package com.club.clubweb;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


public record NoticeCreateRequest (
    @NotBlank @Size(max=100) String title,
    @NotBlank @Size(max=3000) String content){

}
