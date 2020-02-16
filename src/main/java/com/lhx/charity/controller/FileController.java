package com.lhx.charity.controller;//package com.lhx.charity.controller;
//
//import com.lhx.charity.entity.FileVo;
//import com.lhx.charity.utils.Constants;
//import com.lhx.charity.utils.Result;
//import com.lhx.charity.utils.SaveFileUtil;
//import io.swagger.annotations.Api;
//import io.swagger.annotations.ApiOperation;
//import org.springframework.web.bind.annotation.*;
//
///**
// * 文件上传
// */
//@RestController
//@RequestMapping(value="/files",method={RequestMethod.GET, RequestMethod.POST})
//@CrossOrigin(value = "*")
//public class FileController {
//
//	@PostMapping("/save")
//	public Result save(FileVo fileVo){
//		String pathName = SaveFileUtil.saveOneFile(fileVo.getFile());
//		return new Result("成功返回文件路径", Constants.OK, pathName);
//	}
//
//}
