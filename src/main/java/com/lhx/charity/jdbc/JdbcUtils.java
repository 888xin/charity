package com.lhx.charity.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcUtils {

    private static final Logger LOG = LoggerFactory.getLogger(JdbcUtils.class);


    /**
     * 获得数据
     * @param sql 查询语句
     * @return list里面的每个map集合是一条数据，map.get("字段名称")来获得数据
     */
    public static List<Map<String, Object>> getData(String sql) {
        List<Map<String, Object>> datas = new ArrayList<>();
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = ps.getMetaData();
            int columnCount = rsmd.getColumnCount();

            Map<String, Object> data ;
            while (rs.next()) {
                data = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    data.put(rsmd.getColumnLabel(i), rs.getObject(rsmd
                            .getColumnLabel(i)));
                }
                datas.add(data);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            free(rs, ps, connection);
        }
        return datas;

    }

    public static List<Map<String, Object>> getDataByIds(String tableName, List<String> ids) {
        String idsStr = String.join(",", ids);
        StringBuilder stringBuilder = new StringBuilder("select * from ").append(tableName);
        stringBuilder.append(" where check_master_id in").append(" (");
        stringBuilder.append(idsStr).append(")");
        List<Map<String, Object>> datas = new ArrayList<>();
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(stringBuilder.toString());
            rs = ps.executeQuery();
            ResultSetMetaData rsmd = ps.getMetaData();
            int columnCount = rsmd.getColumnCount();

            Map<String, Object> data ;
            while (rs.next()) {
                data = new HashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    data.put(rsmd.getColumnLabel(i), rs.getObject(rsmd
                            .getColumnLabel(i)));
                }
                datas.add(data);
            }

        } catch (SQLException e) {
            LOG.error(e.getMessage());
        } finally {
            free(rs, ps, connection);
        }
        return datas;

    }


    /**
     * 获取单值
     * @param sql
     * @return
     */
    public static Object getData(String sql, List<String> list){
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        PreparedStatement ps = null;
        Connection connection = null;
        ResultSet rs = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < list.size(); i++) {
                ps.setObject(i + 1, list.get(i));
            }
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getObject(1);
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null ;
        } finally {
            free(rs, ps, connection);
        }
    }


    /**
     * 更新单条记录
     * @param sql 有占位符的sql语句，有多少个问号，就要相应传入多少个condition
     * @param condition 对应sql语句中问号的参数
     * @return
     */
    public static boolean update(String sql, String...condition){
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        PreparedStatement ps = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            for (int i = 0; i < condition.length; i++) {
                ps.setObject(i + 1, condition[i]);
            }
            int i = ps.executeUpdate();
            if (i != 0){
                return true ;
            } else {
                return false ;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        } finally {
            free(null, ps, connection);
        }
    }

    /**
     * 调用存储过程
     */
    public static boolean call(String sql, String...condition){
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        CallableStatement cs = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            cs = connection.prepareCall(sql);
            for (int i = 0; i < condition.length; i++) {
                cs.setObject(i + 1, condition[i]);
            }
            //return cs.execute();
//            cs.registerOutParameter(6, Types.VARCHAR);
//            cs.execute();
//            String string=cs.getString("msg");
//            return "成功".equals(string);
            ResultSet resultSet=cs.executeQuery();
            while(resultSet.next()){
                String string=resultSet.getString(1);
                return "成功".equals(string);
            }
            return false;
        } catch (SQLException e) {
            LOG.error(e.getMessage(), e);
            return false ;
        } finally {
            free(null, cs, connection);
        }
    }

    public static boolean call2(String sql, String...condition){
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        CallableStatement cs = null;
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
            cs = connection.prepareCall(sql);
            for (int i = 0; i < condition.length; i++) {
                cs.setObject(i + 1, condition[i]);
            }
            return cs.execute();
        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        } finally {
            free(null, cs, connection);
        }
    }



    public static boolean insertOA(String sql)
    {
    	DataSourceContextHolder.setDBType(SourceEnum.OA);
    	DynamicDataSource dataSource = DynamicDataSource.getInstance();
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String msg="";
        try {
            connection = dataSource.getConnection();
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next())
            {
            	msg = rs.getString("msg");
            }
            if(msg.equals("成功"))
        		return true;
        	else
        		return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false ;
        } finally {
            free(null, ps, connection);
        }
    }








    /**
     * 获得数据库表列名和注释
     * @return
     * @throws Exception
     */
    public static Map<String,String> getCommentByTableName(String table) {


        Map<String,String> map = new HashMap<>();
        DynamicDataSource dataSource = DynamicDataSource.getInstance();
        ResultSet resultSet = null;
        Connection conn = null;
        DatabaseMetaData dbmd = null;
        try {

            conn = dataSource.getConnection();

            dbmd = conn.getMetaData();
            resultSet = dbmd.getTables(null, "%", table, new String[] { "TABLE" });

            while (resultSet.next()) {
                String tableName=resultSet.getString("TABLE_NAME");
                System.out.println(tableName);

                if(tableName.equals(table)){
                    //其他数据库不需要这个方法的,直接传null,这个是oracle和db2这么用
                    //ResultSet rs = conn.getMetaData().getColumns(null, getSchema(conn),tableName.toUpperCase(), "%");
                    ResultSet rs = dbmd.getColumns(null,"%", tableName,"%");
                    while(rs.next()){
                        //System.out.println("字段名："+rs.getString("COLUMN_NAME")+"--字段注释："+rs.getString("REMARKS")+"--字段数据类型："+rs.getString("TYPE_NAME"));
                        String colName = rs.getString("COLUMN_NAME");
                        map.put("code", colName);

                        String remarks = rs.getString("REMARKS");
                        if(remarks == null || remarks.equals("")){
                            remarks = colName;
                        }
                        map.put("name",remarks);

                        String dbType = rs.getString("TYPE_NAME");
                        map.put("dbType",dbType);

                        map.put("valueType", changeDbType(dbType));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return map ;
        } finally {
            free(resultSet, null, conn);
        }
        return null ;
    }




    //其他数据库不需要这个方法 oracle和db2需要
    private static String getSchema(Connection conn) throws Exception {
        String schema;
        schema = conn.getMetaData().getUserName();
        if ((schema == null) || (schema.length() == 0)) {
            throw new Exception("ORACLE数据库模式不允许为空");
        }
        return schema.toUpperCase().toString();

    }

    private static String changeDbType(String dbType) {
        dbType = dbType.toUpperCase();
        switch(dbType){
            case "VARCHAR":
            case "VARCHAR2":
            case "CHAR":
                return "1";
            case "NUMBER":
            case "DECIMAL":
                return "4";
            case "INT":
            case "SMALLINT":
            case "INTEGER":
                return "2";
            case "BIGINT":
                return "6";
            case "DATETIME":
            case "TIMESTAMP":
            case "DATE":
                return "7";
            default:
                return "1";
        }
    }



    // 释放连接
    private static void free(ResultSet rs, Statement st, Connection conn) {
        try {
            if (rs != null) {
                rs.close(); // 关闭结果集
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (st != null) {
                    st.close(); // 关闭Statement
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (conn != null) {
                        conn.close(); // 关闭连接
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }
    }

}
