package de.Rechnungen.Rechnungenbackend;

import org.hibernate.dialect.MySQLDialect;

public class LocalMysqlDialect extends MySQLDialect {
    @Override
    public String getTableTypeString() {
        return " ENGINE=InnoDB DEFAULT CHARSET=utf8";
    }
}