package com.ssm.service;

import com.ssm.pojo.Zbw_PosPay;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.util.*;

/**
 * csv 文件服务
 * Created by steadyjack
 */
@Service
public class CsvFileService {

    private static final Logger log= LoggerFactory.getLogger(CsvFileService.class);

    private static final String fileEncoding="gb2312";



    /**
     * 导出csv文件
     * 导出数据
     * @return
     */
    @SuppressWarnings("static-access")
	public byte[] exportCSVFile(List<Zbw_PosPay> zbw_posPays, String[] headers) {
        List<LinkedHashMap<String, Object>> exportData = new ArrayList<>(zbw_posPays.size());
        for (Zbw_PosPay data : zbw_posPays) {
            try {
            	//"MA_FMID","DE_FMID","MA_FSID","FPID","FSCODE","FFID","FCODE","FNAME","FSTATE","FAMOUNT_BASE","FAMOUNT_SALE","FAMOUNT_DISCRATE","FREMARK","FINDEX"

                LinkedHashMap<String, Object> rowData = new LinkedHashMap<>();
                rowData.put("1", (StringUtils.isNotEmpty(data.getMA_FMID())?data.getMA_FMID():""));
                rowData.put("2", (StringUtils.isNotEmpty(data.getDE_FMID())?data.getDE_FMID():""));
                rowData.put("3", (StringUtils.isNotEmpty(data.getMA_FSID())?data.getMA_FSID():""));
                rowData.put("4", (StringUtils.isNotEmpty(data.getFPID())?data.getFPID():""));
                rowData.put("5", (StringUtils.isNotEmpty(data.getFSCODE())?data.getFSCODE():""));
                rowData.put("6", data.getFFID());
                rowData.put("7", (StringUtils.isNotEmpty(data.getFCODE())?data.getFCODE():""));
                rowData.put("8", (StringUtils.isNotEmpty(data.getFNAME())?data.getFNAME():""));
                rowData.put("9", (StringUtils.isNotEmpty(data.getFSTATE())?data.getFSTATE():""));
                rowData.put("10", data.getFAMOUNT_BASE());
                rowData.put("11", data.getFAMOUNT_SALE());
                rowData.put("12", data.getFAMOUNT_DISCRATE());
                rowData.put("13", (StringUtils.isNotEmpty(data.getFREMARK())?data.getFREMARK():""));
                rowData.put("14", data.getFINDEX());
//                rowData.put("4", data.getStock());
//                rowData.put("5", (data.getPurchaseDate()!=null)? DateUtil.dateToString(data.getPurchaseDate(), "yyyy-MM-dd"):"");
//                rowData.put("6", (StringUtils.isNotEmpty(data.getRemark())?data.getRemark():""));

                    exportData.add(rowData);

            }catch (Exception e){
                log.error("导出发生异常：",e.fillInStackTrace());
            }
        }

        LinkedHashMap<String, String> header = new LinkedHashMap<>();
        for(int i=0;i<headers.length;i++){
        	header.put(String.valueOf(i+1), headers[i]);
        }

        log.info("头部信息： {} ",header);

        return this.exportCSV(header, exportData);
    }

    /**
     * 导出csv文件
     * @param headers    内容标题
     *                   注意：headers类型是LinkedHashMap，保证遍历输出顺序和添加顺序一致。
     *                   而HashMap的话不保证添加数据的顺序和遍历出来的数据顺序一致，这样就出现
     *                   数据的标题不搭的情况的
     * @param exportData 要导出的数据集合
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public static byte[] exportCSV(LinkedHashMap<String, String> headers, List<LinkedHashMap<String, Object>> exportData) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        BufferedWriter buffCvsWriter = null;

        try {
            buffCvsWriter = new BufferedWriter(new OutputStreamWriter(baos, fileEncoding));
            Map.Entry mapEntry = null;

            //TODO：构建csv文件头部信息-"MA_FMID","DE_FMID","MA_FSID","FPID","FSCODE","FFID","FCODE","FNAME","FSTATE","FAMOUNT_BASE","FAMOUNT_SALE","FAMOUNT_DISCRATE","FREMARK","FINDEX"
            for (Iterator<Map.Entry<String, String>> iterator = headers.entrySet().iterator(); iterator.hasNext(); ) {
                mapEntry = iterator.next();
                buffCvsWriter.write(mapEntry.getValue().toString());
                if (iterator.hasNext()) {
                    buffCvsWriter.write(",");
                }

            }

            //TODO：写完头部之后新启一行塞入真正的要导出的数据
            buffCvsWriter.newLine();

            //TODO：塞入真正的数据到csv文件
            LinkedHashMap row = null;
            for (Iterator<LinkedHashMap<String, Object>> iterator = exportData.iterator(); iterator.hasNext(); ) {
                row = iterator.next();
                for (Iterator<Map.Entry> pIterator = row.entrySet().iterator(); pIterator.hasNext(); ) {

                        mapEntry = pIterator.next();
                        buffCvsWriter.write(mapEntry.getValue().toString());
                        if (pIterator.hasNext()) {
                            buffCvsWriter.write(",");

                      // }
                    }
                }
                //TODO：写完一行要记得换行
                if (iterator.hasNext()) {
                    buffCvsWriter.newLine();
                }

            }

            //TODO：记得刷新缓冲区，不然数可能会不全的，当然close的话也会flush的，不加也没问题
            buffCvsWriter.flush();
        } catch (Exception e) {
            log.error("导出发生了异常： ",e.fillInStackTrace());
        } finally {
            //TODO：释放资源
            if (buffCvsWriter != null) {
                try {
                    buffCvsWriter.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return baos.toByteArray();
    }



    /**
     * 导入csv文件数据
     * @param csvFile
     * @throws Exception
     */
//    public List<Product> importCsvFile(InputStream is,String[] csvHeader) throws Exception{
//    	//TODO：导入采用format取决于你导出时用的format-在这里我导出时用的是 , 分割，故而用的是DEFAULT
//        CSVFormat format= CSVFormat.DEFAULT.withHeader(csvHeader).withSkipHeaderRecord();
//
//        try {
//            Reader reader=new InputStreamReader(is,fileEncoding);
//            Iterable<CSVRecord> records=format.parse(reader);
//
//            //TODO："名称","单位","单价","库存量","采购日期","备注信息"
//            List<Product> products=new LinkedList<Product>();
//            Product product;
//            for (CSVRecord record:records){
//                try {
//                	product=new Product();
//
//                	String name=record.get(0);
//					String unit=record.get(1);
//					String price=record.get(2);
//					String stock=record.get(3);
//					String purchaseDate=record.get(4);
//					String remark=record.get(5);
//
//					product.setName(name);
//					product.setUnit(unit);
//					product.setPrice(StringUtils.isNotEmpty(price)?Double.valueOf(price):0.00);
//					product.setStock(StringUtils.isNotEmpty(stock)?Double.valueOf(stock):0);
//					product.setPurchaseDate(StringUtils.isNotEmpty(purchaseDate)?DateUtil.strToDate(purchaseDate, "yyyy-MM-dd"):null);
//					product.setRemark(remark);
//					log.info("当前产品信息： {} ",product);
//
//					products.add(product);
//                }catch (Exception e){
//                    log.error("导入csv文件读取当前记录发生异常： ",e.fillInStackTrace());
//                }
//            }
//
//            return products;
//        }catch (Exception e){
//            log.error("导入csv文件读取数据发生异常：",e.fillInStackTrace());
//        }
//        return null;
//    }



//    public void saveData(List<Product> dataList){
//    	for(Product p:dataList){
//    		productMapper.insertSelective(p);p
    	//}
    //}
}


































