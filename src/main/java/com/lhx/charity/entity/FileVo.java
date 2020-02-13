package com.lhx.charity.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;


@ApiModel(value="文件")
@Data
public class FileVo implements Serializable {

	@ApiModelProperty(value = "文件，类型 MultipartFile")
	private MultipartFile file;

}
