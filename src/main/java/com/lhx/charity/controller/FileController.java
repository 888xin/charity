package com.lhx.charity.controller;

import com.lhx.charity.utils.Constants;
import com.lhx.charity.utils.Result;
import com.lhx.charity.utils.SaveFileUtil;
import com.lhx.charity.entity.FileVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

/**
 * 文件上传
 */
@RestController
@RequestMapping(value="/files",method={RequestMethod.GET, RequestMethod.POST})
@Api(description="文件上传")
@CrossOrigin(value = "*")
public class FileController {

	@PostMapping("/save")
	@ApiOperation(value = "文件上传", notes = "文件上传，塞值到file里面，每请求一次传一张，返回图片相对路径，塞到对象的相应值中，多张用英文逗号隔开",httpMethod="POST")
	public Result save(FileVo fileVo){
		String pathName = SaveFileUtil.saveOneFile(fileVo.getFile());
		return new Result("成功返回文件路径", Constants.OK, pathName);
	}

}
