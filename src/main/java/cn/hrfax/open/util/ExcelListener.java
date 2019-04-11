package cn.hrfax.open.util;


import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelListener extends AnalysisEventListener {


    private List<Object>  data = new ArrayList<Object>();

    @Override
    public void invoke(Object object, AnalysisContext context) {
//        System.out.println(context.getCurrentSheet());
        if(data.size()>=100){
            doSomething();
            data = new ArrayList<Object>();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext context) {
        doSomething();
//
//        OutputStream out = null;
//        try {
//            out = new FileOutputStream("C:\\Users\\user\\Desktop\\东莞授信拒绝订单2.xlsx");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        ExcelWriter writer = EasyExcelFactory.getWriter(out);
//        List<List<Object>> conatiner=new ArrayList<List<Object>>();
//        for (Object o:data){
//            List temp=new ArrayList<>();
//            JSONArray array=JSON.parseArray(JSON.toJSONString(o));
//            for(int i=0;i<array.size();i++){
//                Object o1 = array.get(i);
//                temp.add(String.valueOf(o1));
//                if(i==array.size()-1){
//                    String score = JSON.parseObject(String.valueOf(o1)).getString("ruleReasonText");
//                    temp.add(score);
//                }
//            }
//            conatiner.add(temp);
//        }
//        System.out.println(JSON);
//        writer.write1(conatiner, new Sheet(2));

    }
    public void doSomething(){
        for (Object o:data) {
            System.out.println("这一条信息:"+JSON.toJSONString(o));
        }
    }
}
