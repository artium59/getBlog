package com.web.blog.model;

import io.swagger.annotations.ApiModelProperty;

public class BasicResponse {
    @ApiModelProperty(value = "status", position = 1)
    public boolean status;
    @ApiModelProperty(value = "data", position = 2)
    public String data;
    @ApiModelProperty(value = "object", position = 3)
    public Object object;
    @ApiModelProperty(value = "accessToken", position = 4)
    public Object accessToken;
    @ApiModelProperty(value = "message", position = 5)
    public String message;
}
