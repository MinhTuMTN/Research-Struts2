package com.example.basic.config;


import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.JdbcLogger;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MssqlDialect;
import org.seasar.doma.jdbc.tx.LocalTransaction;
import org.seasar.doma.jdbc.tx.LocalTransactionDataSource;
import org.seasar.doma.jdbc.tx.LocalTransactionManager;
import org.seasar.doma.jdbc.tx.TransactionManager;

import javax.sql.DataSource;

public class DbConfig implements Config {

    private static final DbConfig CONFIG = new DbConfig();
    private final Dialect dialect;
    private final LocalTransactionDataSource dataSource;
    private final TransactionManager transactionManager;

    public DbConfig()  {
        this.dialect = new MssqlDialect();
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        this.dataSource = new LocalTransactionDataSource(
                "jdbc:sqlserver://localhost:1433;databaseName=DemoStruts2;encrypt=true;trustServerCertificate=true",
                "sa",
                "0703"
        );
        LocalTransaction localTransaction = dataSource.getLocalTransaction(getJdbcLogger());
        this.transactionManager = new LocalTransactionManager(
                localTransaction
        );
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public Dialect getDialect() {
        return dialect;
    }

    @Override
    public TransactionManager getTransactionManager() {
        return transactionManager;
    }

    public static DbConfig singleton() {
        return CONFIG;
    }

}
