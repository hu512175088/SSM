package com.ssm.controller;

import com.ssm.service.CsvFileService;
import com.ssm.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Controller
public class CSVController {

	private static final Logger log = LoggerFactory.getLogger(CSVController.class);

	private static final String Prefix = "csv";

//
	//private Zbw_PosPayService zbw_posPayService;

	@Autowired
	private CsvFileService csvFileService;

	@Value("${csv.file.name}")
	private String csvFileName;

	private static final String[] headers = new String[]{"FFID","FCODE","FNAME","FSTATE","FAMOUNT_BASE","FAMOUNT_SALE","FAMOUNT_DISCRATE","FREMARK","FINDEX"};

	private static final String CsvSuffix = "csv";


	/**
	 * 导出csv文件
	 *
	 * @param response
	 * @param request
	 */
	@RequestMapping(value = Prefix + "/system/export", method = RequestMethod.GET)
	@ResponseBody
	public void csvExport(HttpServletResponse response, HttpServletRequest request) {
		try {

			//List<Zbw_PosPay> posPays = zbw_posPayService.getData();

			String fileName = csvFileName + DateUtil.dateToString(new Date(), "yyyy-MM-dd") + ".csv";
			fileName = URLEncoder.encode(fileName, StandardCharsets.UTF_8.toString());
			response.setContentType(MediaType.APPLICATION_OCTET_STREAM.toString());
			response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"; filename*=utf-8''" + fileName);

			//byte[] data = csvFileService.exportCSVFile(posPays, headers);
			//FileCopyUtils.copy(data, response.getOutputStream());
		} catch (Exception e) {
			log.error("发生异常：", e.fillInStackTrace());
		}
	}
}
    
    /**
	 * 上传csv导入数据
	 * @param request
	 * @return
	 */
//	@SuppressWarnings("rawtypes")
//	@RequestMapping(value=Prefix+"/file/upload",method=RequestMethod.POST,consumes=MediaType.MULTIPART_FORM_DATA_VALUE)
//	@ResponseBody
//	public BaseResponse uploadExcel(MultipartHttpServletRequest request){
//		BaseResponse response=new BaseResponse<>(StatusCode.Success);
//		try {
//			MultipartFile file=request.getFile("csvFile");
//			if (file==null || file.getName()==null) {
//				return new BaseResponse<>(StatusCode.Invalid_Param);
//			}
//			String fileName=file.getOriginalFilename();
//			String suffix=StringUtils.substring(fileName, fileName.lastIndexOf(".")+1);
//			if (!CsvSuffix.equalsIgnoreCase(suffix)) {
//				return new BaseResponse<>(StatusCode.Csv_File_Suffix_Invalid);
//			}
//
//			InputStream is=file.getInputStream();
//			List<Zbw_PosPay> dataList=csvFileService.importCsvFile(is, headers);
//
//			log.info("导入的数据列表: {} ",dataList);
//			csvFileService.saveData(dataList);
//		} catch (Exception e) {
//			log.error("上传csv导入数据 发生异常：",e.fillInStackTrace());
//			return new BaseResponse<>(StatusCode.System_Error);
//		}
//		return response;
//	}
//
//
//}












