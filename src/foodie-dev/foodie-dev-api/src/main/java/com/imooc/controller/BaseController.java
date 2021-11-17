package com.imooc.controller;

import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@RestController
public class BaseController {

    public static final Integer COMMENT_PAGE_SIZE = 10;
}
