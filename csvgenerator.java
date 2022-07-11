
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 创建CSV文件
 */
public class csvgenerator {

    /**
     * 创建CSV文件
     */
    public static void createCSV(ArrayList<Map> filedifference) {

        // // 表格头
        // Object[] head = { "Customer ID#", "Account No.", "Currency", "Type","Balance"};
        // List<Object> headList = Arrays.asList(head);

        //数据
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        List<Object> rowList = null;
        for (int i = 0; i < filedifference.size(); i++) {
            Map<String, String> rowdata = filedifference.get(i);
            rowList = new ArrayList<Object>();
            rowList.add(rowdata.get("Customer ID"));
            rowList.add(rowdata.get("Account No."));
            rowList.add(rowdata.get("Currency"));
            rowList.add(rowdata.get("Type"));
            rowList.add(rowdata.get("Balance"));
            dataList.add(rowList);
        }

        String fileName = "result.csv";//文件名称
        String filePath = "./result/"; //文件路径

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(filePath + fileName);
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(csvFile), "GB2312"), 1024);

            // int num = headList.size() / 2;
            // StringBuffer buffer = new StringBuffer();
            // for (int i = 0; i < num; i++) {
            //     buffer.append(" ,");
            // }
            // csvWtriter.write(buffer.toString() + fileName + buffer.toString());
            // csvWtriter.newLine();

            // // 写入文件头部
            // writeRow(headList, csvWtriter);

            // 写入文件内容
            for (List<Object> row : dataList) {
                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 写一行数据
     * @param row 数据列表
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(List<Object> row, BufferedWriter csvWriter) throws IOException {
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append(data).append(",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }
}