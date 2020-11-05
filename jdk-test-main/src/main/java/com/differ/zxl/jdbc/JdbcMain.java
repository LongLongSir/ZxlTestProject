package com.differ.zxl.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class JdbcMain {

    public static void main(String[] args) throws Exception {

        //耗时：8710
        /**
         * 使用jdbc的问题
         * （1）数据库连接频繁开启和关闭，会严重影响数据库的性能。
         * （2）代码中存在硬编码，分别是数据库部分的硬编码和SQL执行部分的硬编码。
         **/
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            //1、加载数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");

            //2、通过驱动管理类获取数据库链接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/local?serverTimezone=UTC", "root", "123456");
            connection.setAutoCommit(false);
            //3、定义sql语句，?表示占位符
            String sql = "INSERT INTO big_table_test (`field1`, `field2`, `field3`, `field4`, `field5`, `field6`, `field7`, `field8`, `field9`, `field10`, `field11`) \n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            //4、获取预处理statement
            preparedStatement = connection.prepareStatement(sql);

            //5、设置参数，第一个参数为sql语句中参数的序号（从1开始），第二个参数为设置的参数值
            long s = System.currentTimeMillis();
            for(int j=0;j<10;j++){
                for (int i = 0; i < 10000; i++) {
                    preparedStatement.setString(1, "lijun" + i);
                    preparedStatement.setString(2, "lijun" + i);
                    preparedStatement.setString(3, "lijun" + i);
                    preparedStatement.setString(4, "lijun" + i);
                    preparedStatement.setString(5, "lijun" + i);
                    preparedStatement.setString(6, "lijun" + i);
                    preparedStatement.setString(7, "lijun" + i);
                    preparedStatement.setString(8, "lijun" + i);
                    preparedStatement.setInt(9, i);
                    preparedStatement.setString(10, "lijun" + i);
                    preparedStatement.setString(11, "lijun" + i);

                    preparedStatement.addBatch();
                }
                preparedStatement.executeBatch();
                connection.commit();
                preparedStatement.clearBatch();
            }
            long e = System.currentTimeMillis();
            System.out.println("耗时：" + (e - s));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            preparedStatement.close();
            connection.close();
        }

    }


}

