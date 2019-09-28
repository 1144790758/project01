package Hbase_homework;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.*;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;

import java.io.IOException;

public class HbaseApi {

    public static void main(String[] args) throws IOException {

        get_client();
        create_table("emp001", "member_id", "address", "info");

        insert_data("emp001", "Rain", "info", "age", "28");
        insert_data("emp001", "Rain", "info", "birthday", "1990-05-01");
        insert_data("emp001", "Rain", "info", "industry", "architect");
        insert_data("emp001", "Rain", "address", "city", "ShenZhen");
        insert_data("emp001", "Rain", "address", "country", "China");

        get_data("emp001", "Rain", "info");

        System.out.println("-----------分割线-----------");

        scan_column("emp001", "Rain", "info", "birthday");

        //资源关闭
        admin.close();
        connection.close();

    }

    private static Connection connection = null;
    private static Admin admin = null;

    public static void get_client() throws IOException {
        Configuration conf = new Configuration();

        //设置zk集群位置,默认端口2181
        conf.set("hbase.zookeeper.quorum", "hadoop101", "2181");

        //获取连接
        connection = ConnectionFactory.createConnection(conf);

        admin = connection.getAdmin();
    }



    public static void create_table(String tname, String... family) throws IOException {

        //获取表描述器
        HTableDescriptor hTableDescriptor = new HTableDescriptor(TableName.valueOf(tname));

        for (String str : family) {
            //创建列族描述器
            HColumnDescriptor hColumnDescriptor = new HColumnDescriptor(str);

            hTableDescriptor.addFamily(hColumnDescriptor);
        }

        admin.createTable(hTableDescriptor);
    }

    public static void insert_data(String tname, String rowKey, String family, String column, String value) throws IOException {

        Table table = connection.getTable(TableName.valueOf(tname));

        //先定义行键作为唯一标识
        Put put = new Put(Bytes.toBytes(rowKey));

        put.addColumn(Bytes.toBytes(family), Bytes.toBytes(column), Bytes.toBytes(value));

        table.put(put);
    }

    public static void get_data(String tname, String rowKey, String famliy) throws IOException {

        Table table = connection.getTable(TableName.valueOf(tname));

        Get get = new Get(Bytes.toBytes(rowKey));

        //具体获取到某列族
        get.addFamily(Bytes.toBytes(famliy));

        Result result = table.get(get);

        //获取里面的单元格
        Cell[] rawCells = result.rawCells();
        for (Cell rawCell : rawCells) {
            byte[] cloneRow = CellUtil.cloneRow(rawCell);// 行键
            byte[] cloneFamily = CellUtil.cloneFamily(rawCell);// 列族
            byte[] cloneQualifier = CellUtil.cloneQualifier(rawCell);// 列名
            byte[] cloneValue = CellUtil.cloneValue(rawCell);// 列值

            System.out.println("rowKey:" + Bytes.toString(cloneRow) + "  " + "Family:" + Bytes.toString(cloneFamily)
                    + "  " + "Qualifier:" + Bytes.toString(cloneQualifier) + "  " + "value:"
                    + Bytes.toString(cloneValue));
        }
    }

    public static void scan_column(String tname, String rowKey, String famliy, String column) throws IOException {

        Table table = connection.getTable(TableName.valueOf(tname));

        //构建扫描器
        Scan scan = new Scan();

        scan.addColumn(Bytes.toBytes(famliy), Bytes.toBytes(column));

        ResultScanner results = table.getScanner(scan);

        for (Result result : results) {

            Cell[] rawCells = result.rawCells();

            for (Cell rawCell : rawCells) {
                byte[] cloneRow = CellUtil.cloneRow(rawCell);// 行键
                byte[] cloneFamily = CellUtil.cloneFamily(rawCell);// 列族
                byte[] cloneQualifier = CellUtil.cloneQualifier(rawCell);// 列名
                byte[] cloneValue = CellUtil.cloneValue(rawCell);// 列值

                System.out.println("rowKey:" + Bytes.toString(cloneRow) + "  " + "Family:" + Bytes.toString(cloneFamily)
                        + "  " + "Qualifier:" + Bytes.toString(cloneQualifier) + "  " + "value:"
                        + Bytes.toString(cloneValue));
            }
        }
    }
}
